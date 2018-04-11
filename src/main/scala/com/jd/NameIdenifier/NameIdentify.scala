package com.jd.NameIdenifier

object NameIdentify {

  def main(args: Array[String]): Unit = {

    if(scala.io.StdIn.readLine("Select either\n1. New Embedded Secret\n2.Retrieve a secret\n", Int).toInt == 1) {
      val wordToCrypt = scala.io.StdIn.readLine("What secret word would you like to use (A-Y) only: ")
      val cBuild = new SecretGen(wordToCrypt)
      val name = scala.io.StdIn.readLine("What is your first name: ")
      println(s"Your secret is in: %s".format(cBuild.getEmbeddedSecret(name)))
    } else {
      val pToDcrypt = scala.io.StdIn.readLine("What is the word that contains the secret?: ")
      val cBuild = new LatinGen(pToDcrypt)
      println(s"Your secret word was: %s".format(cBuild.getLatin))
    }

  }

}
