package com.mtraina.ps

object Chapter03 {
  /**
    * Arrays
    * always mutable
    */
  val numNames = Array("one", "two", "three")

  /**
    * Lists
    * always immutable
    */
  val oneTwo = List(1,2)

  // concatenation
  val threeFour = List(3,4)
  val oneTwoThreeFour = oneTwo ::: threeFour // List(1,2,3,4)

  // cons (prepend)
  val twoThree = List(2,3)
  val oneTwoThree = 1 :: twoThree // List(1,2,3)

  // empty list
  val empty = Nil
  // create a list and Nil at the end is needed because :: is a method of List.
  val anotherOneTwoThree = 1 :: 2 :: 3 :: Nil
  // methods ending with ':' is invoked to the right operand, here the equivalent of the code above
  Nil.::(3).::(2).::(1)

  /**
    * Tuples
    */
  val pair = (99, "Luftballons")
  println(pair._1)
  println(pair._2)

  /**
    * Sets
    * can be either immutable or mutable
    */
  // immutable
  var jetSet = Set("Boeing", "Airbus")
  jetSet += "Lear"
  println(jetSet.contains("Cessna"))

  // mutable
  import scala.collection.mutable
  val movieSet = mutable.Set("Hitch", "Poltergeist")
  movieSet += "Shrek"
  println(movieSet)

  /**
    * Maps
    * can be either immutable or mutable
    */
  // immutable
  val romanNumeral = Map(1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V")

  // mutable
  val treasureMap = mutable.Map[Int, String]()
  treasureMap += (1 -> "Go to island.")
  treasureMap += (2 -> "Find big X on ground.")
  treasureMap += (3 -> "Dig.")
}
