//import AssemblyKeys._

//assemblySettings

assemblyJarName in assembly := "jquantlib.jar"

test in assembly := {}

name := "jquantlib"

organization := "org.jquantlib"

version := "0.1.0"

//scalaVersion := "2.10.5"
scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "net.jcip" % "jcip-annotations" % "1.0" % "provided",
  "org.slf4j" % "slf4j-api" % "1.7.25" % "provided",
  "org.jfree" % "jcommon" % "1.0.24" % "provided",
  "org.jfree" % "jfreechart" % "1.0.14" % "provided",
  "org.joda" % "joda-primitives" % "1.0" % "provided"
)

scalacOptions ++= Seq(
  "-deprecation",
  //  "-feature",
  //  "-unchecked",
  //  "-Xlint",
  "-Ywarn-dead-code"
  //  "-Xlog-implicits"
  //"-Ywarn-numeric-widen",
  //"-Ywarn-value-discard"
)

classDirectory in Compile := (baseDirectory apply ( _ / "target" / "classes" )).value

initialCommands := "import org.jquantlib._"

retrieveManaged := false

sources in (Compile,doc) := Seq.empty

publishArtifact in (Compile, packageDoc) := false
