package com.mtraina.ps

object Chapter05 {
  /**
    * String interpolation
    */
  val name = "reader"
  println(s"Hello, $name")

  // same as before but recognize escape sequence
  println(raw"No\\\\escape!") // prints No\\\\escape!

  // add formatting instructions
  println(f"${Math.PI}%.5f") // prints 3.14159

  /**
   * Operators are methods
   */
   val sum = 1 + 2 // in this case Scala invokes the method + on the Int 1, so 1.+(2)

  /**
    * Objects equality
    * Scala compares values not references like in Java
    */
  1 == 2                      // false
  2 == 2                      // true
  null == List(1,2,3)         // false
  List(1,2,3) == List(1,2,3)  // true
  "he" + "llo" == "hello"     // true



}
