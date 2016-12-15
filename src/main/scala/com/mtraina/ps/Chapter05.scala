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
}
