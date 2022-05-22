package com.rockthejvm

object ContextualAbstractions {


  // context parameters/arguments
  val aList = List(2, 3, 4, 1)
  val anUnorderedList = aList.sorted


  def main(args: Array[String]): Unit = {

    println(anUnorderedList)

  }

}
