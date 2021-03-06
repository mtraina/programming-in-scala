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

  /**
    * Override a method with a filed from the constructor
    * the result of this example is equivalent to the previous one, but even shorter
    * the name of the parameter passed to the constructor has to be the same as the value we want to override
    */
  class ArrayElement3(val contents: Array[String]) extends Element

  val ar3 = new ArrayElement3(Array("world"))
  ar3.width

  /**
    * Invoking superclass constructors
    */
  class LineElement(s: String) extends ArrayElement(Array(s)){
    override def width = s.length
    override def height = 1
  }

  /**
    * Polymorphism and dynamic binding
    */
  class UniformElement(ch: Char, override val width: Int, override val height: Int) extends Element {
    private val line = ch.toString * width
    def contents = Array.fill(height)(line)
  }

  /**
    * Concatenate arrays
    */
  Array(1, 2 ,3) ++ Array(4, 5, 6)  // Array(1, 2, 3, 4, 5, 6)

  /**
    * Zip: it combines the elements on the first array with the elements of the second in tuple.
    * If one of the two arrays is shorter, zip will drop the remaining elements
    */
  Array(1, 2, 3) zip Array("a", "b") // Array((1, "a"), (2, "b"))
}
