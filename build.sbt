
lazy val root = (project in file("."))
  .settings(
    name := "SyntaxDescriptions",
    scalaVersion := "2.12.8",
    libraryDependencies += "org.typelevel" %% "cats-core" % "1.5.0"
  )
