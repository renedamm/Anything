package models

import play.api.libs.json._
import play.api.libs.json.util._
import play.api.libs.functional.syntax._

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
		Seq()
	}
}
