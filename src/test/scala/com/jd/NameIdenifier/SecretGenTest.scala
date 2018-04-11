package com.jd.NameIdenifier

import org.scalatest.{WordSpec, Matchers, PrivateMethodTester}

class SecretGenTest extends WordSpec with Matchers with PrivateMethodTester {
  "SecretGen(Google).convertToB5" should {
    "return a valid array of Base 5 numbers" in {
      val testData = new SecretGen("Google")
      val convertToB5 = PrivateMethod[SecretGen]('convertToB5)
      testData invokePrivate convertToB5("GOOGLE".toArray) shouldBe Array("11", "24", "24", "11", "21", "4")
    }
  }
}
