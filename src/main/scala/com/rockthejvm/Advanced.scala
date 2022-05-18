package com.rockthejvm

import scala.util.Try
import scala.util.Success
import scala.util.Failure
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {

  // lazy evaluation
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("lazy value is lazy")
    43
  }

  // can be used in infinite collections
  val eagerValue = lazyValueWithSideEffect + 1
  println("something")

  // pseudo-collections Option, Try
  def methodWhichCanReturnNull(): String = "Hello Scala"
  val anOption = Option(methodWhichCanReturnNull()) // Some("Hello Scala")
  // option = "collection" which contains at most one element: Some(value) or None
  val stringProcessing = anOption match {
    case Some(string) => s"content is $string"
    case None         => "empty option"
  }

  def methodWhichCanThrowException(): String = throw new RuntimeException
  val aTry = Try(methodWhichCanThrowException())

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"value is $validValue"
    case Failure(ex)         => s"Exception $ex"
  }

  // future is a "collection" that contains a value when it's evaluated
  // future is composable with map, flatMap and filter
  val aFuture = Future {
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value")
    67
  }

  Thread.sleep(2000)

  // Implicits

  // implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitVal = 46
  println(aMethodWithImplicitArgs)

  // implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }

  println(23.isEven())

}
