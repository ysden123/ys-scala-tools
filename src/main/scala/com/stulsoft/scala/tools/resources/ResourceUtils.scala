/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.scala.tools.resources

import com.typesafe.scalalogging.LazyLogging

/** Resource utilities
  *
  * @author Yuriy Stul
  * @since 1.0.0
  */
object ResourceUtils extends LazyLogging {
  /**
    * Searches in the resources a list of file names matching a pattern
    *
    * @param pattern the file name pattern
    * @return the list of file names matching a pattern
    */
  def fileNames(pattern: String): Seq[String] = {
    Seq.empty
  }
}
