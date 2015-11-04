package models

case class Token( text : String )

case class TokenUsageTag( text : String )

case class TokenOccurrence( token : Token, usage : TokenUsageTag, file : File, line : Int, column : Int, position : Long )

