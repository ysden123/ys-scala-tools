lazy val scalaLoggingVersion = "3.9.2"
lazy val scalaTestVersion = "3.2.3"
lazy val scalaCheckVersion = "1.15.1"
lazy val scalaXmlVersion = "1.3.0"
lazy val loggingVersion = "2.14.0"

lazy val commonSettings = Seq(
  organization := "com.stulsoft",
  version := "1.3.1",
  scalaVersion := "2.13.4",
  scalacOptions ++= Seq(
    "-feature",
    "-language:implicitConversions",
    "-language:postfixOps"),
  libraryDependencies ++= Seq(
    "org.scala-lang.modules" %% "scala-xml" % scalaXmlVersion,

    "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingVersion,
    "org.apache.logging.log4j" % "log4j-api" % loggingVersion,
    "org.apache.logging.log4j" % "log4j-core" % loggingVersion,
    "org.apache.logging.log4j" % "log4j-slf4j-impl" % loggingVersion,

    "org.scalatest" %% "scalatest" % scalaTestVersion % "test",
    "org.scalacheck" %% "scalacheck" % scalaCheckVersion % "test"
  )
)

lazy val ysScalaTools = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "ys-scala-tools"
  )