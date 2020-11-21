/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.scala.tools.resource

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

/**
  * @author Yuriy Stul
  */
class ResourceUtilsTest extends AnyFunSuite with Matchers {

  test("fileNames empty") {
    val list = ResourceUtils.fileNames("empty")
    list.isEmpty shouldBe true
  }

  test("fileNames non empty") {
    val list = ResourceUtils.fileNames(".xml")
    list.isEmpty shouldBe false
  }

  test("fileNames empty mask") {
    val list = ResourceUtils.fileNames("")
    list.isEmpty shouldBe false
  }

  test("fileNames with folder") {
    val list = ResourceUtils.fileNames(".conf", "folder1")
    list.isEmpty shouldBe false

  }

  test("fileNames with folder and no file") {
    val list = ResourceUtils.fileNames(".xyz", "folder1")
    list.isEmpty shouldBe true
  }
}
