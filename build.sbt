ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "minimum-triangle-path",
    libraryDependencies += "org.typelevel" %% "cats-effect" % "3.5.1"
  )
