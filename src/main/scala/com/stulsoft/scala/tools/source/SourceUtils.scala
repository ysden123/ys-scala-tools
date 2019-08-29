/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.scala.tools.source

import java.io.{File, FileFilter}

import com.typesafe.scalalogging.LazyLogging

import scala.io.Source
import scala.util.{Failure, Try}

/**
  * @author Yuriy Stul
  */
object SourceUtils extends LazyLogging {

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


  def sources(fileNameSuffix: String, folder: String = "."): Seq[Source] = {
    new File(folder)
      .listFiles(new FileFilter {
        override def accept(pathname: File): Boolean = pathname.isFile && pathname.getName.endsWith(fileNameSuffix)
      })
      .map(file => source(file.getName).get)
  }
}
