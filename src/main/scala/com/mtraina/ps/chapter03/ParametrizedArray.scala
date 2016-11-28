package com.mtraina.ps.chapter03

object ParametrizedArray {

  def greetings = {
    val greetStrings = new Array[String](3)

    greetStrings(0) = "Hello"
    greetStrings(1) = ", "
    greetStrings(2) = "world!\n"

    for (s <- greetStrings) {
      println(s)
    }

    greetStrings
  }
}
