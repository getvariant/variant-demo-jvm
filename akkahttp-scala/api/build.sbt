lazy val akkaHttpVersion = "10.4.0"
lazy val akkaVersion = "2.7.0"
lazy val circeVersion = "0.14.3"
lazy val variantVersion = "1.4.0"

// Run in a separate JVM, to make sure sbt waits until all threads have
// finished before returning.
// If you want to keep the application running while executing other
// sbt tasks, consider https://github.com/spray/sbt-revolver/
fork := true

lazy val root = (project in file("."))
  .settings(
    inThisBuild(List(
      organization    := "com.variant",
      version         := variantVersion,
      scalaVersion    := "2.13.4"
    )),
    name := "bookworms-api",

    // Add local Maven repo for com.variant.share artifacts built with Maven.
    resolvers += Resolver.mavenLocal,

    javacOptions ++= Seq("-source", "17", "-target", "17"),

    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-actor" % akkaVersion,
      "com.typesafe.akka" %% "akka-stream" % akkaVersion,
      "ch.qos.logback" % "logback-classic" % "1.2.11",

      "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4",
      "com.typesafe.slick" %% "slick" % "3.4.1",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.4.1",
      "org.postgresql" % "postgresql" % "42.6.0",

      // JSON parsing
      "io.circe" %% "circe-core" % circeVersion,
      "io.circe" %% "circe-generic" % circeVersion,
      "io.circe" %% "circe-parser" % circeVersion,

      // Variant SDK
      // We must list transitive dependencies because for now
      // Variant client JAR is included as unmanaged dependency.
      "com.fasterxml.jackson.core" % "jackson-core" % "2.13.4",
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.13.4",
      "com.fasterxml.jackson.core" % "jackson-annotations" % "2.13.4",
      "org.yaml" % "snakeyaml" % "2.0",
    )
  )

