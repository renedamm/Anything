package controllers

import play.api.mvc._
import play.api.libs.json.Json
import models._

class Projects
    extends Controller
{
	val repository : ProjectRepository = DbProjectRepository

    def list = Action
    {
		Ok( Json.toJson( repository.listProjects ) )
    }

	def get( name : String ) = Action
	{
		repository.findProject( name ) match
		{
			case None => NotFound( name )
			case Some( project ) => Ok( Json.toJson( project ) )
		}
	}

	def create( name : String ) = Action
	{
		Ok( "Success" )
	}
}

