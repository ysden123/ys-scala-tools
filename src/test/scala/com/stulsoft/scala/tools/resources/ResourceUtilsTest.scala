/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.scala.tools.resources

import org.scalatest.{FunSuite, Matchers}

/**
  * @author Yuriy Stul
  */
class ResourceUtilsTest extends FunSuite with Matchers {

  test("testFileNames") {
    val list = ResourceUtils.fileNames("empty")
    list.isEmpty shouldBe true
  }

}
