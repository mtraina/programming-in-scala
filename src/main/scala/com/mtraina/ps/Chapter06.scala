package com.mtraina.ps

object Chapter06 {

  /**
    * Class no body, default constructor
    */
  class Rational(n: Int, d: Int)

  /**
    * Class default constructor
    * The body will be part of the constructor body
    */
  class Rational2(n: Int, d: Int){
    println("Created " + n + "/" + d)
  }
  new Rational2(1, 3) // prints res1: Rational2 = Rational2@e9dc4d0

  /**
    * Override toString method
    */
  class Rational3(n: Int, d: Int){
    override def toString = n + "/" + d
  }
}
