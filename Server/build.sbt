
name := "anything-server"

version := "0.1"

lazy val root = ( project in file( "." ) ).enablePlugins( PlayScala )

routesGenerator := InjectedRoutesGenerator

fork in run := true

