/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.scala.tools.io

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

/**
  * @author Yuriy Stul
  */
class FileUtilsTest extends AnyFunSuite with Matchers {

  test("fileNames") {
    val fileNames = FileUtils.fileNames()
    fileNames.nonEmpty shouldBe true
  }

  test("fileNames empty") {
    val fileNames = FileUtils.fileNames("ttt")
    fileNames.isEmpty shouldBe true
  }

  test("fileNames not empty") {
    val fileNames = FileUtils.fileNames("build.sbt")
    fileNames.length shouldBe 1
  }

  test("fileNames not empty 2") {
    val fileNames = FileUtils.fileNames("*.sbt")
    fileNames.length shouldBe 1
  }

  test("fileNames not empty 3") {
    val fileNames = FileUtils.fileNames("build.*")
    fileNames.length shouldBe 1
  }

  test("fileNames not empty 4") {
    val fileNames = FileUtils.fileNames("*.xml", "src/test/resources")
    fileNames.length >= 3 shouldBe true
  }

}
