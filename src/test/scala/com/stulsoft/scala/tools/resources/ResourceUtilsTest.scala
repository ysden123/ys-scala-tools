/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.scala.tools.resources

import org.scalatest.{FunSuite, Matchers}

/**
  * @author Yuriy Stul
  */
class ResourceUtilsTest extends FunSuite with Matchers {

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

  test("fileNames with folder"){
    val list = ResourceUtils.fileNames(".conf", "folder1")
    list.isEmpty shouldBe false

  }

  test("fileNames with folder and no file"){
    val list = ResourceUtils.fileNames(".xyz", "folder1")
    list.isEmpty shouldBe true
  }

  test("source from resource"){
    val source = ResourceUtils.source("logback-test.xml")
    source.isSuccess shouldBe true
  }

  test("source from resource with error"){
    val source = ResourceUtils.source("logback-test.ERR")
    source.isFailure shouldBe true
  }

  test("source from file system"){
    val source = ResourceUtils.source("build.sbt")
    source.isSuccess shouldBe true
  }

  test("source from file system with error"){
    val source = ResourceUtils.source("build.ERR")
    source.isFailure shouldBe true
  }

}
