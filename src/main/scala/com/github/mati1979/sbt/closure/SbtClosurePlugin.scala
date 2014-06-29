package com.github.mati1979.sbt.closure

import sbt.InputKey
import sbt.Keys.scalaSource
import sbt.Keys.streams
import sbt.SettingKey
import sbt.TaskKey
import sbt.inputTask
import sbt.AutoPlugin
import sbt.PluginTrigger
import sbt.Plugins

/**
 * Created by mszczap on 29.06.14.
 */
object SbtClosurePlugin extends AutoPlugin {

  override def trigger: PluginTrigger = allRequirements

  import autoImport._

  override def projectSettings = Seq(
    helloTask <<= inputTask {
      (argTask: TaskKey[Seq[String]]) => {
        (argTask, scalaSource, helloKey, streams) map {
          (args, sourceDir, helloKeyValue, streams) => { streams.log.info("Hello " + sourceDir.getAbsolutePath) }
        }
      }
    },
    helloKey := "default value"
  )

  object autoImport {
    lazy val helloTask = InputKey[Unit]("hello", "Prints Hello world.")
    lazy val helloKey = SettingKey[String]("default value for hello world")
  }

}
