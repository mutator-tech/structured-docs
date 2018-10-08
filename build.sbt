val scaffolder = (
	project in file(".")
).settings(
	organization := "tech.mutator",
	name := "structured-documentation",
	version := "0.0.0",
	scalaVersion := "2.12.7",
	libraryDependencies ++= {
		val versions = List(
			"scopt" -> "3.7.0",
			"parbolled2" -> "2.1.5",
			"fansi" -> "0.2.5",
			"better-files" -> "3.6.0",
			"akka-actor" -> "2.5.13"
		).toMap

		Seq(
			"com.github.scopt" %% "scopt" % versions("scopt"),
			"org.parboiled" %% "parboiled" % versions("parbolled2"),
			"com.lihaoyi" %% "fansi" % versions("fansi"),
			"com.github.pathikrit" %% "better-files" % versions("better-files"),
			"com.typesafe.akka" %% "akka-actor" % versions("akka-actor")
		)
	}
)
