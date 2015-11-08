package models

import play.api.db._
import play.api.libs.json._
import play.api.libs.json.util._
import play.api.libs.functional.syntax._
import play.api.Play.current
import anorm._

// A project is identified by its name and associated with a path
// on the local file system.
class Project( val name : String, val path : String )

object Project
{
	implicit val projectWrites = new Writes[ Project ]
	{
		def writes( project : Project ) =
			Json.obj(
				  "name" -> project.name
				, "path" -> project.path
			)
	}

	implicit val projectReads = new Reads[ Project ]
	{
		def reads( json : JsValue ) : JsResult[ Project ] =
			JsSuccess(
				new Project(
					  ( json \ "name" ).as[ String ]
					, ( json \ "path" ).as[ String ]
				)
			)
	}
}

abstract class ProjectRepository
{
	def createProject( project : Project ) : Project
	def updateProject( project : Project ) : Project
	def findProject( name : String ) : Option[ Project ]
	def listProjects() : Seq[ Project ]
}

class DbProject( id : Long, name : String, path : String )
	extends Project( name, path )

object DbProjectRepository
	extends ProjectRepository
{
	def createProject( project : Project ) : Project =
	{
		DB.withConnection
		{
			implicit connection =>
				SQL( s"INSERT INTO projects( name, path ) VALUES( '${project.name}', '${project.path}' );" )
					.execute()
		}
		////TODO: return proper dbProject
		project
	}

	def updateProject( project : Project ) : Project =
	{
		project
	}

	def findProject( name : String ) : Option[ Project ] =
	{
		None
	}

	def listProjects() : Seq[ Project ] =
	{
		DB.withConnection
		{
			implicit connection =>
				SQL( "SELECT * FROM projects" )().map {
					row =>
						new DbProject(
							  id = row[ Long ]( "id" )
							, name = row[ String ]( "name" )
							, path = row[ String ]( "path" )
						)
				}
		}.toSeq
	}
}
