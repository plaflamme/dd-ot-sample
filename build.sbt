ThisBuild / scalaVersion := "2.13.5"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

//val DatadogTraceVersion = "0.62.0" // ok version
val DatadogTraceVersion = "0.92.0" // broken version

lazy val root = (project in file("."))
  .enablePlugins(JavaAgent)
  .settings(
    name := "dd-ot-sample",
    libraryDependencies ++= Seq(
      "com.datadoghq" % "dd-trace-api" % DatadogTraceVersion,
      "com.datadoghq" % "dd-trace-ot" % DatadogTraceVersion,
    ),
    envVars ++= Map(
      "DD_TRACE_ENABLED" -> "false",
      "DD_PROPAGATION_STYLE_EXTRACT" -> "Datadog,B3",
    ),
    javaAgents += "com.datadoghq" % "dd-java-agent" % DatadogTraceVersion % "runtime",
  )
