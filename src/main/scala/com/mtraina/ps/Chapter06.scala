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

  /**
    * Adding precondition
    */
  class Rational4(n: Int, d: Int){
    require(d != 0)
    override def toString = n + "/" + d
  }
  new Rational4(1, 0) // not satisfying the precondition throws a java.lang.IllegalArgumentException

  /**
    * Creation of the method "add"
    * it will return a new immutable object with the result of the sum
    */
  class Rational5(n: Int, d: Int){
    require(d != 0)
    val num: Int = n
    val den: Int = d
    override def toString = num + "/" + den
    def add(that: Rational5): Rational5 = {
      new Rational5(num * that.den + that.num * den, den * that.den)
    }
  }
}
