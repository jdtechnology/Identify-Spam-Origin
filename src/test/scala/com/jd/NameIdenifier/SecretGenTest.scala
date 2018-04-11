package com.jd.NameIdenifier

import org.scalatest.{WordSpec, Matchers, PrivateMethodTester}

class SecretGenTest extends WordSpec with Matchers with PrivateMethodTester {
  val testData = new SecretGen("Google")
  "SecretGen(Google).convertToB5" should {
    "return a valid array of Base 5 numbers" in {

      val convertToB5 = PrivateMethod[SecretGen]('convertToB5)
      testData invokePrivate convertToB5("GOOGLE".toArray) shouldBe Array("11", "24", "24", "11", "21", "4")
    }
    //Write tests to deal with further/error cases
  }
  "SecretGen(Google).toInvisiString" should {
    "Return an array of tuple2 representing each invisible letter" in {
      val toInvisiString = PrivateMethod[SecretGen]('toInvisiString)
      testData invokePrivate toInvisiString() shouldBe a [Array[_]]
    }
  }
  "SecretGen(Google).getSecret" should {
    "give us a string" in {
      val getSecret = PrivateMethod[SecretGen]('getSecret)
      testData invokePrivate getSecret() shouldBe a [String]
    }
  }
  "getEmbeddedSecret" should {
    "Give us a string when passed a string" in {
      testData.getEmbeddedSecret("Jack") shouldBe a [String]
    }
    "hide a secret in said string" in {
      testData.getEmbeddedSecret("Jack") shouldBe "J​​‌⁠‌⁠​​‌​⁠﻿ack" //"J\u200B\u200B\u200C\u2060\u200C\u2060\u200B\u200B\u200C\u200B\u2060\uFEFFack"
    }
  }
}
