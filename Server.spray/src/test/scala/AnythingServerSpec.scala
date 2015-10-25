package anything.server

import org.specs2.mutable._
import org.mockito.Mockito._

class AnythingServerSpec
    extends Specification
{
    val server = new AnythingServer

    "An AnythingServer" should
    {
        "not find any match when not having any token collections" in
        {
            server.lookup( "test" ).hasNext must be_==( false )
        }

        "allow adding file collections" in
        {
            // Arrange.
            val fileCollection = mock( classOf[ FileCollection ] )

            // Act.
            //server.addFileCollection( fileCollection )

            // Assert.
            success
        }

        "allow removing file collections" in
        {
            success
        }
    }
}

