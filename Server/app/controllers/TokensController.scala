package controllers

import play.api.mvc._

class TokensController
	extends Controller
{
	def listAll( projectName : String ) = Action
	{
		Ok( "Success" )
	}

	def listMatches( projectName : String, substr : String ) = Action
	{
		Ok( "Success" )
	}

	def listOccurrences( projectName : String, substr : String ) = Action
	{
		Ok( "Success" )
	}
}

