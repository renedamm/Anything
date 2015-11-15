package actors

import akka.actor.{ Actor, ActorRef, ActorLogging }
import models.{ File, FileType, Token, TokenOccurrence, TokenUsageTag }

object FileScanner
{
	case class ScanFile( file : File, fileType : FileType, contents : String )
}

class FileScanner( dbUpdater : ActorRef )
	extends Actor
	with ActorLogging
{
	import FileScanner._

	def receive =
	{
		case ScanFile( file, fileType, contents ) =>
			log info( s"Scanning file '${file.relativePath}' in project '${file.project.name}'" )
			val tokenCurrences = Seq(
				TokenOccurrence( Token( "test" ), TokenUsageTag.default, file, 1, 0, 0 )
			)
			dbUpdater ! DatabaseUpdater.SetTokenOccurrencesForFile( file, tokenCurrences )
	}
}

