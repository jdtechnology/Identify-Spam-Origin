package com.jd.NameIdenifier

import org.scalatest.{WordSpec, Matchers, PrivateMethodTester}

class LatinGenTest extends WordSpec with Matchers with PrivateMethodTester {
  val testData = new LatinGen("J​​‌⁠‌⁠​​‌​⁠﻿ack")
  "LatinGen(J​​‌⁠‌⁠​​‌​⁠﻿ack).secretToB5" should {
    val secretToB5 = PrivateMethod[LatinGen]('secretToB5)
    "Give an array[tuple2] given valid input" in  {
      testData invokePrivate secretToB5() shouldBe an [Array[_]]
    }
    "Return a given array with x input" in {
      testData invokePrivate secretToB5() shouldBe Array(Vector(1, 1), Vector(2, 4), Vector(2, 4), Vector(1, 1), Vector(2, 1), Vector(4, 5))
    }
  }
  "LatinGen(Jack).b5ToDec" should {
    val b5ToDec = PrivateMethod[LatinGen]('b5ToDec)
    "Convert the above from base 5 numbers to base 10" in {
      testData invokePrivate b5ToDec() shouldBe an [Array[Integer]]
    }
    "Correctly convert the given numbers" in {
      testData invokePrivate b5ToDec() shouldBe Array(6, 14, 14, 6, 11, 4)
    }
  }
  "LatinGen(Jack).decToLatin" should {
    val decToLatin = PrivateMethod[LatinGen]('decToLatin)
    "return a string" in {
      testData invokePrivate decToLatin() shouldBe a [String]
    }
    "Convert the b10 numbers from above into Latin alphabet (A-Y)" in {
      testData invokePrivate decToLatin() shouldBe "GOOGLE"
    }
  }
  "LatinGen(Jack).getLatin" should {
    "Provide a publicly available (not subject to change) interface for .decToLatin" in {
      testData.getLatin shouldBe a [String]
    }
    "Only contain characters A-Y" in {
      testData.getLatin should fullyMatch regex "[A-Y]*".r
    }
  }
}
