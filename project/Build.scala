import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "konbu.md"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "com.tristanhunt" %% "knockoff" % "0.8.1"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here
    )

}
