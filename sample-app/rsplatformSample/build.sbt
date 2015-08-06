name := """rsplatformSample"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

resolvers += (
    "Local Play Repository" at "file:///home/pacjin/.ivy2/local"
)

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "rentsimpleplatform" % "rentsimpleplatform_2.11" % "1.0-SNAPSHOT"
)


