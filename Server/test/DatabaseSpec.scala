import org.specs2.mutable._
import play.api.db._
import play.api.db.evolutions._

class DatabaseSpec
	extends Specification
{
	var database : Database = Databases.inMemory()

	def before =
	{
		Evolutions.applyEvolutions( database )
	}
}

