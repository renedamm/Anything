
name := "anything-server"

version := "0.1"

lazy val root = ( project in file( "." ) ).enablePlugins( PlayScala )

// Choose router generation that uses depencency injection.
routesGenerator := InjectedRoutesGenerator

libraryDependencies ++= Seq(
	  jdbc
	, evolutions
    , specs2 % Test
	, "com.typesafe.akka" %% "akka-actor" % "2.3.13"
	, "com.typesafe.akka" %% "akka-testkit" % "2.3.13"
	, "com.typesafe.play" %% "anorm" % "2.4.0"
	, "org.scalaz" %% "scalaz-core" % "7.1.5"
	, "org.scalatest" %% "scalatest" % "2.2.4" % Test
)


resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

fork in run := true

