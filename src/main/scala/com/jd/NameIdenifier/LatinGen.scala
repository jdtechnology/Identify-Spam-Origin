package com.jd.NameIdenifier

import scala.collection.immutable

/**
  * @constructor Instantiate to reveal a secret
  * @param secretString the string containing the secret
  */
class LatinGen(secretString: String) extends SecretAlphabet {

  private val stripWord = secretString.filter(privAlphabet.contains(_))

  /**
    * Converts our characters into Base5 representation
    * @return Nested Array of Base 5 numbers
    */
  private def secretToB5: Array[immutable.IndexedSeq[Int]] = {
    stripWord.map{x =>
      privAlphabet.indexOf(x)
    }.grouped(2).toArray
  }

  /**
    * Converts base 5 to base 10, and pads our 'spare character' if it is there
    * @return Array of our base 5 to base 10 numbers represented as part of the latin alphabet
    */
  private def b5ToDec: Array[Integer] = {
    secretToB5.map {x =>
      if(!x.contains(5)) Integer.valueOf(x.mkString, 5)
      else Integer.valueOf(x.mkString.apply(0).toString, 5)
    }
  }

  /**
    * Turns our base 10 numbers into A-Y characters
    * @return String of A-Y
    */
  private def decToLatin: String = {
    b5ToDec.map(latinAlphabet(_)).mkString
  }

  /**
    * Publicly available, not subject to ever change
    * @return The secret string as latin
    */
  def getLatin: String = decToLatin
}
