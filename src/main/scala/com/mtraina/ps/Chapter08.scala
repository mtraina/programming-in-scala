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

  /**
    * Partially applied functions
    */
  def sum(a: Int, b: Int, c: Int) = a + b + c   // we create a function that sums the value of three parameters together
  val a = sum _   // a is a partially applied function where we didn't provide any parameters
  a(1, 2, 3)      // this will call the function passing 1, 2 and 3 as parameters, similarly to what would happen when calling sum(1, 2, 3)
  val b = sum(1, _: Int, 3) // the function b is another partially applied function where we provided 1 and 3 as first and last parameter
  b(5)            // this will now be executed as 1 + 5 + 3 where 5 is the only free parameter we can provide using b
}
