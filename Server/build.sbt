
name := "anything-server"

version := "0.1"

lazy val root = ( project in file( "." ) ).enablePlugins( PlayScala )

routesGenerator := InjectedRoutesGenerator

libraryDependencies ++= Seq(
    specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

fork in run := true

