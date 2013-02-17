import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "konbumd"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "com.tristanhunt" %% "knockoff" % "0.8.1"
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      // Add your own project settings here
    )

}
