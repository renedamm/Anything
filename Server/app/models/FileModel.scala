package models

import java.nio.file.attribute.FileTime

class File( val project : Project, val relativePath : String )
{
	var lastScanTime : Option[ FileTime ] = None
}

class FileType( val name : String )
{
	var extensions : Set[ String ] = Set[ String ]()
	var ignoreTokens : Set[ String ] = Set[ String ]()
	var usageTagPatterns : Set[ String ] = Set[ String ]()
	////TODO: comments
	////TODO: strings
}

abstract class FileRepository
{
}

case class DbFile( val id : Long, override val project : Project, override val relativePath : String )
	extends File( project, relativePath )

