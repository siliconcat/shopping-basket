import sbt._
import sbt.Keys._

object ShoppingBasketBuild extends Build {

  lazy val commonSettings = Seq(
    scalaVersion := "2.11.6",
    organization := "uk.co.siliconcat",
    name := "shopping-basket"
  )

  lazy val FunTest = config("fun") extend Test

  lazy val root = (project in file("."))
    .settings(commonSettings: _*)
    .settings(
      testOptions in Test := Seq(Tests.Filter(_.endsWith("Spec")))
    )
    .configs(FunTest)
    .settings(inConfig(FunTest)(Defaults.testSettings): _*)
    .settings(
      testOptions in FunTest := Seq(Tests.Filter(_.endsWith("FeatureTests"))),
      unmanagedSourceDirectories   in FunTest <<= (baseDirectory in FunTest)(base => Seq(base / "src" / "test")),
      unmanagedResourceDirectories in FunTest <<= (baseDirectory in FunTest)(base => Seq(base / "src" / "test"))
    )
    .settings(
      libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "2.2.1" % "test",
        "info.cukes" %% "cucumber-scala" % "1.1.8" % "fun,test",
        "info.cukes" % "cucumber-junit" % "1.1.8" % "fun,test",
        "junit" % "junit" % "4.11" % "fun,test",
        "com.novocode" % "junit-interface" % "0.11" % "fun,test"
      )
    )

}
