val scala3Version = "3.0.0-M3"

val baseDependencies = List(
  "com.novocode" % "junit-interface" % "0.11" % "test"
)

val catsDependencies = List(
  "org.typelevel" %% "cats-core" % "2.4.2",
  "org.typelevel" %% "cats-effect" % "3.0.0-RC2"
)

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-simple",
    version := "0.1.0",

    scalaVersion := scala3Version,
    libraryDependencies ++= baseDependencies ++ catsDependencies
  )