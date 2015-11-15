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
			var file = message.file

			actor.receive( message )

			expectMsgPF() {
				case msg : SetTokenOccurrencesForFile =>
					msg.file should be( file )
					msg.tokenOccurrences should have length( 1 )
					msg.tokenOccurrences( 0 ).token should be( Token( "test" ) )
					msg.tokenOccurrences( 0 ).file should be( file )
					msg.tokenOccurrences( 0 ).line should be( 1 )
					msg.tokenOccurrences( 0 ).column should be( 0 )
					msg.tokenOccurrences( 0 ).position should be( 0 )
			}
		}

		"ignore whitespace" in
		{
		}

		"ignore tokens from ignore list" in
		{
		}
	}
}

