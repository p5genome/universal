name := "universal"

version := "2017.8.1-beta"

enablePlugins(ScalaJSPlugin)

val scala211 = "2.11.11"

val scala212 = "2.12.2"

scalaVersion := scala212

crossScalaVersions := Seq(scala211, scala212)

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:existentials",
  "-language:implicitConversions"
)

//Dependencies
libraryDependencies += "scalajs-react-interface" %%% "core" % "2017.4.23-beta" % Provided
libraryDependencies += "scalajs-react-interface" %%% "macros" % "2017.3.26-beta"
libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.1"

//bintray
//resolvers += Resolver.jcenterRepo

organization := "p5genome-sri"
//organization := "scalajs-react-interface"

publishTo := Some(Resolver.file("universal", file("repo"))(Patterns(true, Resolver.mavenStyleBasePattern)))

licenses += ("Apache-2.0", url(
  "https://www.apache.org/licenses/LICENSE-2.0.html"))

publishArtifact in Test := false

//Test
resolvers += Resolver.bintrayRepo("scalajs-react-interface", "maven")
libraryDependencies += "org.scalatest" %%% "scalatest" % "3.0.0" % Test
scalaJSStage in Global := FastOptStage

scalaJSModuleKind in Test := ModuleKind.CommonJSModule
