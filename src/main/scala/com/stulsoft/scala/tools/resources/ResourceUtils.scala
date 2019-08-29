/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.scala.tools.resources

import java.io.{File, FileFilter}

import com.typesafe.scalalogging.LazyLogging

/** Resource utilities
  *
  * @author Yuriy Stul
  * @since 1.0.0
  */
object ResourceUtils extends LazyLogging {
  /**
    * Searches in the resources a list of file names matching a file name suffix
    *
    * @param fileNameSuffix the file name suffix; empty - all files
    * @param folder         specifies a folder; default value is "."
    * @return the list of file names matching a file name suffix
    */
  def fileNames(fileNameSuffix: String, folder: String = "."): Seq[String] = {
    new File(Thread
      .currentThread()
      .getContextClassLoader
      .getResource(folder)
      .getPath)
      .listFiles(new FileFilter {
        override def accept(pathname: File): Boolean = {
          //          logger.debug(s"pathname.isFile=${pathname.isFile}, pathname.getName=${pathname.getName}")
          pathname.isFile && pathname.getName.endsWith(fileNameSuffix)
        }
      })
      .map(file => file.getName)
  }
}
