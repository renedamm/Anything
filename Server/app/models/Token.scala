package models

case class Token( text : String )

case class TokenOccurrence( token : Token, file : File, line : Int, column : Int, position : Long )

