package com.jd.NameIdenifier

import scala.collection.immutable

class LatinGen(secretString: String) extends SecretAlphabet {
  private val stripWord = secretString.drop(1).filter(privAlphabet.contains(_))

  private def secretToB5: Array[immutable.IndexedSeq[Int]] = {
    stripWord.map{x =>
      privAlphabet.indexOf(x)
    }.grouped(2).toArray
  }

  private def b5ToDec: Array[Integer] = {
    secretToB5.map {x =>
      if(!x.contains(5)) {
        Integer.valueOf(x.mkString, 5)
      }
      else {
        //println(x)
        //val y = x.filter{_ > 4}
        Integer.valueOf(x.mkString.apply(0).toString, 5)
      }
    }
  }
  private def decToLatin: String = {
    b5ToDec.map(latinAlphabet(_)).mkString
  }

  def getLatin: String = decToLatin
}
