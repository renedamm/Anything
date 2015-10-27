package controllers

import play.api.mvc._

class Projects
    extends Controller
{
    def list = Action
    {
        Ok( "Success" )
    }

	def get( name : String ) = Action
	{
		Ok( "Success" )
	}

	def create( name : String ) = Action
	{
		Ok( "Success" )
	}
}

