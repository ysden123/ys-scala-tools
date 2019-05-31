/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.scala.tools.resources

import java.io.{File, FileFilter}

import com.typesafe.scalalogging.LazyLogging

import scala.io.Source
import scala.util.{Failure, Try}

/** Resource utilities
  *
  * @author Yuriy Stul
  * @since 1.0.0
  */
object ResourceUtils extends LazyLogging {
  /**
    * Searches in the resources a list of file names matching a mask
    *
    * @param fileMask the file name mask; empty - all files
    * @param folder   specifies a folder; default value is "."
    * @return the list of file names matching a mask
    */
  def fileNames(fileMask: String, folder: String = "."): Seq[String] = {
    new File(Thread
      .currentThread()
      .getContextClassLoader
      .getResource(folder)
      .getPath)
      .listFiles(new FileFilter {
        override def accept(pathname: File): Boolean = {
//          logger.debug(s"pathname.isFile=${pathname.isFile}, pathname.getName=${pathname.getName}")
          pathname.isFile && pathname.getName.endsWith(fileMask)
        }
      })
      .map(file => file.getName)
  }

  /**
    * Returns a Source from specified file name.
    *
    * @param name specifies the file; it may be a file in resources and in JAR as well, or it may be any file
    * @return the Source from specified file name.
    */
  def source(name: String): Try[Source] = {
    try {
      if (getClass.getClassLoader.getResourceAsStream(name) != null) {
        Try(Source.fromResource(name))
      } else {
        Try(Source.fromFile(name))
      }
    }
    catch {
      case e: Exception => Failure(e)
    }
  }
}
