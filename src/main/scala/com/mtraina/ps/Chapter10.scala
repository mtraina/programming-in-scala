package com.mtraina.ps

object Chapter10 {

  /**
    * An abstract class contains method that may not be implemented, so it can't be instantiated
    */
  abstract class Element {
    def contents: Array[String]
    def height: Int = contents.length
    def width: Int = if(height == 0) 0 else contents(0).length
  }

  /**
    * Conventions betwenn parameterless and empty-paren methods
    */
  "hello".length  // this method is parameterless because it doesn't make side effects
  println()       // this method has side effects

  /**
    * Extending classes
    */
  class ArrayElement(conts: Array[String]) extends Element {
    override def contents: Array[String] = conts
  }

  val ar = new ArrayElement(Array("hello", "world"))
  ar.width      // prints "5"

  /**
    * Override a method with a field
    */
  class ArrayElement2(conts: Array[String]) extends Element {
    val contents: Array[String] = conts
  }

  val ar2 = new ArrayElement2(Array("hello"))
  ar2.width     // prints "5"
}
