package com.rockthejvm

object PatternMatching extends App {
  val anInteger = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }

  println(order)

  case class Person(name: String, age: Int)
  val bob = Person("Bob", 54) // equivalent to Person.apply("Bob", 54)

  // case class decomposition
  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and my age is $a years old."
    case _            => "Something else"
  }

  // deconstructing tuples
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band is $genre music"
    case _             => "something else"
  }
  println(bandDescription)

  // decomposing lists
  val aList = List(1, 2, 3)
  val listDescription = aList match {
    case List(_, 2, _) => "List containing 2 in the second position"
    case _             => "other list"
  }

  println(listDescription)

}
