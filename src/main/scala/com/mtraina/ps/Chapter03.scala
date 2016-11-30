package com.mtraina.ps

object Chapter03 {
  // arrays
  val numNames = Array("one", "two", "three")

  // lists
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
}
