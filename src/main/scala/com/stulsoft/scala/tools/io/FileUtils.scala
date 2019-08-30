/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.scala.tools.io

import java.nio.file._

import com.typesafe.scalalogging.LazyLogging

import scala.jdk.CollectionConverters._

/**
  * @author Yuriy Stul
  */
object FileUtils extends LazyLogging {
  /**
    * Returns a file list
    *
    * @param fileMask specifies the file name mask; empty (default value) for all files
    * @param folder   specifies a folder; default value is "."
    * @return the file list
    */
  def fileNames(fileMask: String = "", folder: String = "."): Seq[String] = {
    val matcher: PathMatcher = if (fileMask.isEmpty)
      null
    else
      FileSystems.getDefault.getPathMatcher(s"glob:**/$fileMask")

    def fnMatch(path: Path): Boolean = {
      if (fileMask.isEmpty)
        true
      else
        matcher.matches(path)
    }

    Files.walk(Paths.get(folder),1)
      .iterator()
      .asScala
      .filter(path => !Files.isDirectory(path) && fnMatch(path))
      .map(p => p.toAbsolutePath.toString)
      .toSeq
  }
}
