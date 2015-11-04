import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._
import play.api.libs.json._

@RunWith( classOf[ JUnitRunner ] )
class ProjectsSpec
    extends Specification
{
	"Projects" should
	{
		"respond 404 when accessing project that doesn't exist" in new WithApplication
		{
			route( FakeRequest( GET, "/projects/foo" ) ) must beSome.which( status( _ ) == NOT_FOUND )
		}

		"respond with empty array when listing projects with no projects" in new WithApplication
		{
			val Some( result ) = route( FakeRequest( GET, "/projects" ) )

			status( result ) must beEqualTo( OK )
			contentType( result ) must beSome( "application/json" )

			var json = Json.parse( contentAsString( result ) )
			json must haveClass[ JsArray ]
			json.as[ JsArray ].value.size must beEqualTo( 0 )
		}

		"respond with new project when creating valid project" in new WithApplication
		{
			val Some( result ) = route(
				FakeRequest( PUT, "/projects" )
					.withHeaders( "Content-Type" -> "application/json" )
					.withBody( """{ "name" : "test", "path" : "D:/Unity/trunk" }""" )
			)

			status( result ) must beEqualTo( OK )
			contentType( result ) must beSome( "application/json" )

			var json = Json.parse( contentAsString( result ) )
			json must haveClass[ JsObject ]
			json.as[ JsObject ].value( "name" ).as[ String ] must beEqualTo( "test" )
			json.as[ JsObject ].value( "path" ).as[ String ] must beEqualTo( "D:/Unity/trunk" )
		}
	}
}

