import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

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
	}
}

