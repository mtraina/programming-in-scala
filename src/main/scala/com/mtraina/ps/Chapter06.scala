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
    * Adding methods to the Rational class
    */
  class Rational5(n: Int, d: Int){
    require(d != 0)
    val num: Int = n
    val den: Int = d
    override def toString = num + "/" + den

    /**
      * Creation of the method "add"
      * it will return a new immutable object with the result of the sum
      */
    def add(that: Rational5): Rational5 = {
      new Rational5(num * that.den + that.num * den, den * that.den)
    }

    def lessThan(that: Rational5) = this.num * that.den < that.num * this.den

    def max(that: Rational5) = if(this.lessThan(that)) that else this
  }

  /**
    * Auxiliary constructor
    */
  class Rational6(n: Int, d: Int){
    require(d != 0)
    val num: Int = n
    val den: Int = d

    def this(n: Int) = this(n, 1) // it calls the default constructor passing a defaulted denominator
  }

  /**
    * Private methods
    */
  class Rational7(n: Int, d: Int){
    require(d != 0)

    private val g = gcd(n.abs, d.abs)
    val num: Int = n / g
    val den: Int = d / g

    def this(n: Int) = this(n, 1)

    override def toString = num + "/" + den

    def add(that: Rational7): Rational7 =
      new Rational7(num * that.den + that.num * den, den * that.den)

    private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
  }

  /**
    * Defining operators
    */
  class Rational8(n: Int, d: Int){
    require(d != 0)

    private val g = gcd(n.abs, d.abs)
    val num: Int = n / g
    val den: Int = d / g

    def this(n: Int) = this(n, 1)

    override def toString = num + "/" + den

    def +(that: Rational8): Rational8 =
      new Rational8(num * that.den + that.num * den, den * that.den)

    def *(that: Rational8): Rational8 =
      new Rational8(num * that.num, den * that.den)

    private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
  }

  /**
    * Method overloading
    */
  class Rational9(n: Int, d: Int){
    require(d != 0)

    private val g = gcd(n.abs, d.abs)
    val num: Int = n / g
    val den: Int = d / g

    def this(n: Int) = this(n, 1)

    def +(that: Rational9): Rational9 = new Rational9(num * that.den + that.num * den, den * that.den)
    def +(i: Int) = new Rational9(num + i * den, den)

    def -(that: Rational9): Rational9 = new Rational9(num * that.den - that.num * den, den * that.den)
    def -(i: Int) = new Rational9(num - i * den, den)

    def *(that: Rational9): Rational9 = new Rational9(num * that.num, den * that.den)
    def *(i: Int): Rational9 = new Rational9(num * i, den)

    def /(that: Rational9): Rational9 = new Rational9(num * that.den, den * that.num)
    def /(i: Int): Rational9 = new Rational9(num, den * i)

    override def toString = num + "/" + den

    private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
  }

  /**
    * Implicit conversion
    */
  implicit def intToRational(x: Int) = new Rational9(x)
}
