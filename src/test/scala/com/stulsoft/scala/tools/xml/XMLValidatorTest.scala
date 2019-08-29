/*
 * Copyright (c) 2019. Yuriy Stul
 */

/**
  * @author Yuriy Stul
  */
package com.stulsoft.scala.tools.xml

import com.stulsoft.scala.tools.source.SourceUtils
import org.scalatest.{FunSuite, Matchers}

class XMLValidatorTest extends FunSuite with Matchers {

  test("testValidate valid") {
    val xml = s"""<test>text</test>"""
    XMLValidator.validate(xml).isSuccess shouldBe true
  }

  test("testValidate valid 2") {
    val xml = SourceUtils.source("xml1.xml").get.getLines().mkString
    XMLValidator.validate(xml).isSuccess shouldBe true
  }

  test("testValidate invalid") {
    val xml = s"""<test>text</testERROR>"""
    XMLValidator.validate(xml).isSuccess shouldBe false
  }

  test("testValidate invalid 2") {
    val xml = SourceUtils.source("xml1ERR.xml").get.getLines().mkString
    XMLValidator.validate(xml).isSuccess shouldBe false
  }

}
