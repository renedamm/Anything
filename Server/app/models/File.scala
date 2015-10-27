package models

import java.nio.file.attribute.FileTime

case class File( project : Project, relativePath : String, lastScanTime : FileTime )

