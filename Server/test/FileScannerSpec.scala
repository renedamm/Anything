import akka.actor.{ Props, Actor, ActorSystem }
import akka.testkit.{ TestKit, TestActorRef, ImplicitSender }
import org.scalatest.{ WordSpecLike, BeforeAndAfterAll }
import org.scalatest.Matchers
import models._
import actors.{ FileScanner, DatabaseUpdater }

object FileScannerSpec
{
	import FileScanner._

	def createScanMessage( contents : String ) =
	{
		val project = new Project(
			  name = "TestProject"
			, path = "C:/test"
		)
		val file = new File(
			  project = project
			, relativePath = "test/test.xx"
		)
		val fileType = new FileType(
			  name = "test"
		)
		ScanFile( file, fileType, contents )
	}
}

class FileScannerSpec
	extends TestKit( ActorSystem( "FileScannerSpec" ) )
	with WordSpecLike
	with Matchers
	with BeforeAndAfterAll
{
	import FileScannerSpec._
	import DatabaseUpdater._

	override def afterAll()
	{
		system.shutdown
	}
	
	"FileScanner" should
	{
		"detect plain token occurrences" in
		{
			val actor = TestActorRef[ FileScanner ]( Props( new FileScanner( testActor ) ) ).underlyingActor
			var message = createScanMessage( "test" )

			actor.receive( message )

			expectMsg(
			{
				msg : Any => msg match
				{
					case SetTokenOccurrencesForFile( file1,
						Seq( TokenOccurrence(
								  Token( "test" )
								, TokenUsageTag.default
								, file2
								, 1
								, 0
								, 0) ) ) if file1 == file2 == message.file =>
						true
				}
			} )
		}

		"ignore whitespace" in
		{
		}

		"ignore tokens from ignore list" in
		{
		}
	}
}

