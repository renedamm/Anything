
name := "anything-server"

version := "0.1"

lazy val root = ( project in file( "." ) ).enablePlugins( PlayScala )

// Choose router generation that uses depencency injection.
routesGenerator := InjectedRoutesGenerator

libraryDependencies ++= Seq(
	  jdbc
	, evolutions
    , specs2 % Test
	, "com.typesafe.play" %% "anorm" % "2.4.0"
)


resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

fork in run := true

