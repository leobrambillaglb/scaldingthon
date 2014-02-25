organization := "me.scaldingthon"

name := "scaldingthon"

version := "0.1"

scalaVersion := "2.10.2"

resolvers ++= Seq(
  "cascading-repo" at "http://conjars.org/repo/"
)

libraryDependencies ++= Seq(
	"com.twitter" %% "scalding-core" % "0.8.11",
	"com.twitter" %% "scalding-date" % "0.8.11",
	"com.twitter" %% "scalding-args" % "0.8.11",
	"org.specs2" % "specs2_2.10" % "2.2" % "test"
)