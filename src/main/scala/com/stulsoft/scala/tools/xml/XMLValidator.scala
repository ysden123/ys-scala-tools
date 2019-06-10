/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.scala.tools.xml


import com.typesafe.scalalogging.LazyLogging

import scala.util.Try
import scala.xml.XML


/** XML validator
  *
  * @author Yuriy Stul
  * @since 1.1.0
  */
object XMLValidator extends LazyLogging {

  /**
    * Validates XML syntax
    * @param xmlText the XML text
    * @return Success, if XML is valid
    */
  def validate(xmlText: String): Try[Unit] = {
    Try(
      XML.loadString(xmlText)
    )
  }
}
