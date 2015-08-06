import sbt._

object Dependencies {
 
    lazy val springVersion = "4.0.3.RELEASE"
    lazy val togglzVersion = "2.2.0.Final"
    
    val mockito = "org.mockito" % "mockito-core" % "1.+" % "test"
 	val sprintTest = "org.springframework" % "spring-test" % springVersion % "test"
 	val cukeJava = "info.cukes" % "cucumber-java" % "1.2.2" % "test"
    val cukeJunit = "info.cukes" % "cucumber-junit" % "1.2.2" % "test"
    val cukeJvm = "info.cukes" % "cucumber-jvm" % "1.2.2" % "test"
    val cukeSpring = "info.cukes" % "cucumber-spring" % "1.2.2" % "test"
 	
 	val testDeps = Seq(
 		mockito,
 		sprintTest,
 		cukeJava,
 		cukeJunit,
 		cukeJvm,
 		cukeSpring
 	)

    val compileDeps = Seq(
	    "org.hibernate" % "hibernate-entitymanager" % "4.3.8.Final",
	    "org.apache.commons" % "commons-io" % "1.3.2",
	    "org.springframework" % "spring-context" % springVersion,
	    "org.springframework" % "spring-orm" % springVersion,
	    "org.springframework" % "spring-jdbc" % springVersion,
	    "org.springframework" % "spring-tx" % springVersion,
	    "org.springframework" % "spring-expression" % springVersion,
	    "org.springframework" % "spring-aop" % springVersion,
	    "cglib" % "cglib" % "2.2.2",
	    "be.objectify" %% "deadbolt-java" % "2.3.3",
	    "mysql" % "mysql-connector-java" % "5.1.18",
	    "org.togglz" % "togglz-servlet" % togglzVersion,
	    "org.togglz" % "togglz-spring-core" % togglzVersion,
	    "org.togglz" % "togglz-console" % togglzVersion
	)

 	val rentsimpleDeps = (compileDeps ++ testDeps)

 	/** this is needed because sbt automatically gets the latest version in the ivy2 repository and
		this is the way to override it...http://www.scala-sbt.org/0.13/docs/Library-Management.html see "Evicted"
		
 	**/
 	val depsOverrides = Set(
		"org.springframework" % "spring-context" % springVersion,
		"org.springframework" % "spring-expression" % springVersion,
	    "org.springframework" % "spring-aop" % springVersion
	)

}