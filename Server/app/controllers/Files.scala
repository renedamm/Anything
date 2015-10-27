package controllers

import play.api.mvc._

class Files
    extends Controller
{
    def list( projectName : String ) = Action
    {
        Ok( "Success" )
    }
}

