package actors

import akka.actor.{ Actor, ActorRef, ActorLogging }
import models.{ File, TokenOccurrence }

object DatabaseUpdater
{
	case class SetTokenOccurrencesForFile( file : File, tokenOccurrences : Seq[ TokenOccurrence ] )
}

class DatabaseUpdater
	extends Actor
	with ActorLogging
{
	import DatabaseUpdater._

	def receive =
	{
		case SetTokenOccurrencesForFile( file, tokenOccurrences ) =>
			log info( "SetTokenOccurrencesForFile" )
	}
}

