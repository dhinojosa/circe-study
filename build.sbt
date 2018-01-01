name := "circe-study"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.4"

val circeVersion = "0.8.0"

scalacOptions in Scope.Global := Seq("-deprecation", "-feature")

libraryDependencies ++= Seq(
    "io.circe" %% "circe-core" % circeVersion
  , "io.circe" %% "circe-generic" % circeVersion
  , "io.circe" %% "circe-parser" % circeVersion
  , "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.10.0"
  , "org.apache.logging.log4j" % "log4j-api" % "2.10.0"
  , "org.apache.logging.log4j" % "log4j-core" % "2.10.0"
  , "org.scalatest" %% "scalatest" % "3.0.4" % "test"
)
