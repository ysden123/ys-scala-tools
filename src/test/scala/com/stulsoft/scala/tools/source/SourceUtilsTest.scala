/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.scala.tools.source

import com.stulsoft.scala.tools.xml.XMLValidator
import org.scalatest.{FunSuite, Matchers}

/**
  * @author Yuriy Stul
  */
class SourceUtilsTest extends FunSuite with Matchers {

  test("testValidate invalid 2") {
    val xml = SourceUtils.source("xml1ERR.xml").get.getLines().mkString
    XMLValidator.validate(xml).isSuccess shouldBe false
  }

  test("source from resource") {
    val source = SourceUtils.source("logback-test.xml")
    source.isSuccess shouldBe true
  }

  test("source from resource with error") {
    val source = SourceUtils.source("logback-test.ERR")
    source.isFailure shouldBe true
  }

  test("source from file system") {
    val source = SourceUtils.source("build.sbt")
    source.isSuccess shouldBe true
  }

  test("source from file system with error") {
    val source = SourceUtils.source("build.ERR")
    source.isFailure shouldBe true
  }

  test("sources from file system") {
    val sources = SourceUtils.sources(".sbt")
    sources.isEmpty shouldBe false
    sources.foreach(s => s.close())
  }
}
