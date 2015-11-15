package actors

import akka.actor.{ Actor, ActorRef, ActorLogging }
import models.{ File, FileType }

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
	}
}

