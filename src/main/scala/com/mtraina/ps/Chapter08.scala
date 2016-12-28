package com.mtraina.ps

object Chapter08 {
  /**
    * First class functions
    */
  val someNumbers = List(-11, -10, -5, 0, 5, 10)

  // we pass a function to the method "foreach" of list
  someNumbers.foreach((x: Int) => println(x))

  // shorter version
  someNumbers.foreach(x => println(x))

  /**
    * Placeholder syntax
    * it's an even more succinct version of the previous methods
    */
  someNumbers.foreach(println(_))
}
