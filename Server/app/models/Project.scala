package models

import play.api.libs.json._

abstract class Project
{
	val name : String
	val path : String
}

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
}

abstract class ProjectRepository
{
	def createProject( name : String, path : String ) : Project
	def findProject( name : String ) : Option[ Project ]
	def listProjects() : Seq[ Project ]
}

case class DbProject( id : Long, name : String, path : String )
	extends Project

object DbProjectRepository
	extends ProjectRepository
{
	def createProject( name : String, path : String ) : Project =
	{
		new DbProject( 0, name, path )
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
