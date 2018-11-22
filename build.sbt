name := "NameIdentify"

version := "0.2.01"

scalaVersion := "2.12.5"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % Test

coverageEnabled := true

coverageMinimum := 80

coverageFailOnMinimum := true

mainClass in assembly := Some("com.jd.nameidentify.NameIdentify")

assemblyJarName in assembly := "nameidentify.jar"
