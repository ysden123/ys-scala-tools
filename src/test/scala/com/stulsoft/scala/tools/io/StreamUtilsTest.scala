/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.scala.tools.io

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers


/**
  * @author Yuriy Stul
  */
class StreamUtilsTest extends AnyFunSuite with Matchers {

  test("inputStreams") {
    val iss = StreamUtils.inputStreams(".sbt")
    iss.isEmpty shouldBe false
    iss.foreach(is => is.close())
  }

  test("inputStreams empty") {
    val iss = StreamUtils.inputStreams(".123")
    iss.isEmpty shouldBe true
  }
}
