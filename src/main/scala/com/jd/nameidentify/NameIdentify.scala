package com.jd.nameidentify

object NameIdentify {

  def main(args: Array[String]): Unit = {
    val optionInput = scala.io.StdIn.readLine("Select either\n1. New Embedded Secret\n2.Retrieve a secret\n", Int).toInt
    if(optionInput == 1) {
      println(s"Your secret is in: %s".format(generateSecret))
    } else if (optionInput == 2) {
      println(s"Your secret word was: %s".format(backToLatin))
    } else println("You have entered an invalid option!")
  }

  /**
    * Polls for user information
    * Instantiates a class and calls its public method
    * @return a secret word hidden in user input string
    */
  def generateSecret: String = {
    val wordToCrypt = scala.io.StdIn.readLine("What secret word would you like to use (A-Y) only: ")
    val cBuild = new SecretGen(wordToCrypt)
    val name = scala.io.StdIn.readLine("What is your first name: ")
    cBuild.getEmbeddedSecret(name)
  }

  /**
    * Polls for user information
    * Instantiates a class and calls its public method
    * @return the secret word hidden in user input
    */
  def backToLatin: String = {
    val pToDcrypt = scala.io.StdIn.readLine("What is the word that contains the secret?: ")
    val cBuild = new LatinGen(pToDcrypt)
    cBuild.getLatin
  }

}
