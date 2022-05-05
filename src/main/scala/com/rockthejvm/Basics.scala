package com.rockthejvm

object Basics extends App {
  val meaningOfLife: Int = 42

  val aString = "I love Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  val anExpression = 2 + 3

  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }

  def factorial(n: Int): Int =
    if(n <= 1) 1
    else n * factorial(n - 1)


  // in scala we don't use loops or iteration, we use recursion!


  // the Unit return type = no meaningfull value, something like void
  // type of side effects
  def unitReturningFunction(): Unit = {
    println("returning unit")
  }


  println(aString)
}
