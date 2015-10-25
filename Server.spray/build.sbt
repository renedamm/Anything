
name := "anything-server"
version := "0.0.1"

mainClass in Compile := Some( "anything.server.AnythingServerApp" )

libraryDependencies ++=
{
    val akkaVersion = "2.3.9"
    val sprayVersion = "1.3.3"

    Seq(
      "io.spray"          %% "spray-can"      % sprayVersion,
      "io.spray"          %% "spray-routing"  % sprayVersion,
      "io.spray"          %% "spray-testkit"  % sprayVersion % "test",
      "com.typesafe.akka" %% "akka-actor"     % akkaVersion,
      "com.typesafe.akka" %% "akka-testkit"   % akkaVersion % "test",
      "org.specs2"        %% "specs2-core"    % "2.3.7" % "test",
      "org.mockito"       %  "mockito-core"   % "1.9.5" % "test"
    )
}

