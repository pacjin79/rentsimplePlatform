import Dependencies._

name := """rentsimplePlatform"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  cache
)

lazy val commonSettings = Seq(
  scalaVersion := "2.11.6",
  libraryDependencies ++= rentsimpleDeps,
  dependencyOverrides := depsOverrides,
  unmanagedResourceDirectories in Test <+= baseDirectory( _ / "features" )
)

lazy val rentsimplePlatform = project.in(file("."))
    .settings(commonSettings: _*)
    .aggregate(platformDomain, platformService)
    .dependsOn(platformDomain, platformService)
    .enablePlugins(PlayJava)

lazy val platformDomain = project.in(file("modules/domain")).settings(commonSettings: _*).enablePlugins(PlayJava)
lazy val platformService = project.in(file("modules/service")).settings(commonSettings: _*).dependsOn(platformDomain).enablePlugins(PlayJava)