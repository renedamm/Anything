package controllers

import play.api.mvc._

class FilesController
    extends Controller
{
    def list( projectName : String ) = Action
    {
        Ok( "Success" )
    }
}

