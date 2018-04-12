package com.jd.nameidentify

/**
  * @constructor Instantiate to hide the param in a word
  * @param latin the word to be hidden
  */
class SecretGen(latin: String) extends SecretAlphabet {
  private val splitString: Array[Char] = latin.toUpperCase.toArray

  /**
    * This function converts letters from the latin alphabet into base 5 numbers
    * Stops at "Y"
    * @param ss
    * @return Array[Base6 Numbers]
    */
  private def convertToB5(ss: Array[Char]): Array[String] = {
    ss.map(x => Integer.toString(latinAlphabet.indexOf(x), 5))
  }

  /**
    * This function takes a the base5 array and maps it to its secret parameters
    * @return Each letter represented as two of the 6 possible invisible chars
    */
  private def toInvisiString: Array[(Char,Char)] = {
    convertToB5(splitString).map { x =>
      if(x.length > 1) (privAlphabet(x.toArray.head.asDigit), privAlphabet(x.toArray.apply(1).asDigit))
      else (privAlphabet(x.toArray.head.asDigit), privAlphabet(5))
    }
  }

  /**
    *
    * @return Secret Array represented as a string
    */
  private def getSecret = {
    toInvisiString.map{case (x, y) => s"$x$y"}.mkString
  }

  /**
    *
    * @param firstName
    * @return secret string between char 1 and char 2
    */
  def getEmbeddedSecret(firstName: String): String = "%c%s%s".format(firstName.head, getSecret, firstName.tail)
}
