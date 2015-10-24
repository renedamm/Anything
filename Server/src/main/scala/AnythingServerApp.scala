package anything.server

import akka.actor.ActorSystem
import spray.routing.SimpleRoutingApp

object AnythingServerApp
    extends App
    with SimpleRoutingApp
{
    implicit val system = ActorSystem( "anything-system" )

    startServer( interface = "localhost", port = 44321 )
    {
        path( "hello" )
        {
            get
            {
                complete
                {
                    <h1>Say hello to spray</h1>
                }
            }
        }
    }
}

