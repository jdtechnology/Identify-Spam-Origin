package com.jd.NameIdenifier

import java.io.{ByteArrayInputStream, InputStream}
import java.nio.charset.StandardCharsets

import org.scalatest.{Matchers, WordSpec}

class NameIdentifyTest extends WordSpec with Matchers with SecretAlphabet {

  "generateSecret" should {
    val testInputString = "TestData\nJack\n"
    "Return a string" in {
      val in: InputStream = new ByteArrayInputStream(testInputString.getBytes(StandardCharsets.UTF_8))
      Console.withIn(in)(NameIdentify.generateSecret) shouldBe a [String]
    }
    "Return a string that contains letters from the hidden alphabet" in {
      val in: InputStream = new ByteArrayInputStream(testInputString.getBytes(StandardCharsets.UTF_8))
      Console.withIn(in)(NameIdentify.generateSecret) should contain atLeastOneElementOf privAlphabet
    }
    "Give the correct secret" in {
      val in: InputStream = new ByteArrayInputStream(testInputString.getBytes(StandardCharsets.UTF_8))
      Console.withIn(in)(NameIdentify.generateSecret) shouldBe "J‍⁠⁠﻿‍‍‍⁠‍﻿᠎﻿‍⁠᠎﻿ack"
    }
  }
  "backToLatin" should {
    val testInputString = "J‍⁠⁠﻿‍‍‍⁠‍﻿᠎﻿‍⁠᠎﻿ack\n"
    "Return a string given valid user input" in {
      val in: InputStream = new ByteArrayInputStream(testInputString.getBytes(StandardCharsets.UTF_8))
      Console.withIn(in)(NameIdentify.backToLatin) shouldBe a [String]
    }
    "also said string should contain only characters A-Y" in {
      val in: InputStream = new ByteArrayInputStream(testInputString.getBytes(StandardCharsets.UTF_8))
      Console.withIn(in)(NameIdentify.backToLatin) should fullyMatch regex "[A-Y]*".r
    }
  }

}
