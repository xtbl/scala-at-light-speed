package com.rockthejvm.com

object FunctionalProgramming extends App {
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years.")
  }
  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // INVOKING bob as function === bob.apply(43)
  // apply allows to invoke as function
  /*
  Functional programming
  - compose functions
  - pass functions as args
  - return functions as results

  Conclusion: FunctionX
   */

  val simpleIncrementor = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  stringConcatenator("I love", "Scala")
  // ALL SCALA FUNCTIONS ARE INSTANCES OF THIS FunctionX TYPE

  // syntax sugar
  val doubler: Function1[Int, Int] = (x: Int) => 2 * x
  doubler(4)

  // higher order functions: take fns as args/return fns as results
  val aMappedList: List[Int] = List(1, 2, 3).map(x => x + 1)
  println(aMappedList)
  val aflatMappedList = List(1, 2, 3).flatMap(x => List(x, 2 * x))
  val aflatMappedList2 = List(1, 2, 3).flatMap { x =>
    List(x, 2 * x)
  } // alternative syntax
  println(aflatMappedList)

  val aFilteredList: List[Int] = List(1, 2, 3, 4, 5).filter(x => x <= 3)
  // alternative syntax
  val aFilteredList2: List[Int] = List(1, 2, 3, 4, 5).filter(_ <= 3)
  // time: 16:05
  val allPairs = List(1, 2, 3).flatMap(number =>
    List('a', 'b', 'c').map(letter => s"$number-$letter")
  )
  println(allPairs)

  // for comprehensions
  val alternativePairs = for {
    number <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"

  println(alternativePairs)

  // Collections

  val aList = List(1, 2, 3, 4, 5)
  val firstElement = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList
  val anExtendedList = 0 +: aList :+ 6

  // sequences
  val aSequence: Seq[Int] = Seq(1, 2, 3)
  val accessedElemeent = aSequence(1)

  // vectors
  // sets
  // tuples
  // ranges
  // maps
  val aPhonebook: Map[String, Int] = Map(
    ("Daniel", 12323),
    "Jane" -> 23343 // equivalent to ("Jane", 23343)
  )

}
