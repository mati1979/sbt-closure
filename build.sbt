sbtPlugin := true

organization := "pl.matisoft"

name := "sbt-closure-plugin"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.10.4"

addSbtPlugin("com.typesafe.sbt" % "sbt-web" % "1.0.0")

lazy val sbtClosurePlugin = project in file(".")
