package com.rockthejvm

object ObjectOrientation extends app {
  class Animal {
    val age: Int = 0
    def eat() = println("I'm eating")
  }

  val anAnimal = new Animal

  class Dog(val name: String) extends Animal 
  val aDog = new Dog("Lassie")
  aDog.name

  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat()

  abstract class WalkingAnimal {
    val hasLegs = true
    def walk(): Unit
  }

  // scala "interface"
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // valid method name
  }

  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I'm eating you, animal!")

    override def ?!(thought: String): Unit = println(s"I was thinking: $thought")
  }

  aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation, is the same. only available for methods with 1 argument
  aCroc ?! "What if we could fly?"

  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // equivalent



  // singleton object
  object MySingleton {
    val mySpecialValue = 405450
    def mySpecialMethod(): Int = 3434
    def apply(x: Int): Int = x + 1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // equivalent


  object Animal { // companion - companion object 
    // companions can access each other fields/methods
    // singleton Animal and instances are different things
    val canLiveIndefinetely = false
  }

  val animalsCanLiveForever = Animal.canLiveIndefinetely // "static" fields/methods


  // case classes - lightweight datastructures with some boilerplate
  // - sensible equals and hash code
  // - serialization
  // - companion with apply
  case class Person(name: String, age: Int)
  // may be constructed without new
  val bob = Person("Bob", 54) // Person.apply("Bob", 54)
  
}
