import sbt.{TestFramework, ProjectInfo, DefaultProject}

/**
 * Created by Daniel Hinojosa
 * User: Daniel Hinojosa
 * Date: Oct 17, 2010
 * Time: 10:21:49 PM
 * url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 * email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 * tel: 505.363.5832
 */
class TestingScalaProject(info: ProjectInfo) extends DefaultProject(info) with IdeaProject {
  val scalaToolsRepository = "Scala-Tools Maven2 Repository" at "http://scala-tools.org/repo-releases"
  val snapshots = "snapshots" at "http://scala-tools.org/repo-snapshots"
  val releases = "releases" at "http://scala-tools.org/repo-releases"

  val scalaCheck = "org.scala-tools.testing" % "scalacheck_2.9.0" % "1.9" withSources ()
  val scalaTest = "org.scalatest" % "scalatest_2.9.0" % "1.6.1" withSources ()
  val testNG = "org.testng" % "testng" % "5.14" withSources ()
  val specs = "org.scala-tools.testing" % "specs_2.8.0" % "1.6.5" withSources ()
//  val junit4 = "junit" % "junit" % "4.8.2" withSources ()

  val borachio = "com.borachio" % "borachio_2.9.0" % "1.1"

  val specs2 = "org.specs2" %% "specs2" % "1.4" % "test"
  val scalaz = "org.specs2" %% "specs2-scalaz-core" % "6.0.RC2" % "test"

  def specs2Framework = new TestFramework("org.specs2.runner.SpecsFramework")

  override def testFrameworks = super.testFrameworks ++ Seq(specs2Framework)
}
