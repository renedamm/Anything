package models

import java.nio.file.attribute.FileTime

abstract class File
{
	val project : Project
	val relativePath : String
	val lastScanTime : FileTime 
}

abstract class FileRepository
{
}

case class DbFile( project : Project, relativePath : String, lastScanTime : FileTime )
	extends File

