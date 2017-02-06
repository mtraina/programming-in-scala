package com.mtraina.ps

object Chapter12 {

  /**
    * Traits
    * they can't be instantiated but a class can extend any of them
    */
  trait Philosophical {
    def philosophize() = {
      println("I consume memory, therefore I am!")
    }
  }

  class Frog extends Philosophical {
    override def toString = "green"
  }

  /**
    * Mixing the same final version of the class Rational in chapter 6 with the trait Ordered
    */
  class Rational(n: Int, d: Int) extends Ordered[Rational] {
    require(d != 0)

    private val g = gcd(n.abs, d.abs)
    val num: Int = n / g
    val den: Int = d / g

    def this(n: Int) = this(n, 1)

    def +(that: Rational): Rational = new Rational(num * that.den + that.num * den, den * that.den)

    def +(i: Int) = new Rational(num + i * den, den)

    def -(that: Rational): Rational = new Rational(num * that.den - that.num * den, den * that.den)

    def -(i: Int) = new Rational(num - i * den, den)

    def *(that: Rational): Rational = new Rational(num * that.num, den * that.den)

    def *(i: Int): Rational = new Rational(num * i, den)

    def /(that: Rational): Rational = new Rational(num * that.den, den * that.num)

    def /(i: Int): Rational = new Rational(num, den * i)

    override def toString = num + "/" + den

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    // overridden from Ordered
    override def compare(that: Rational): Int = (this.num * that.den) - (that.num * this.den)
  }

  val half = new Rational(1, 2)
  val third = new Rational(1, 3)

  half < third // Boolean = false
  half > third // Boolean = true
}
