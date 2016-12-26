package com.mtraina.ps

import org.scalatest.{FlatSpec, Matchers}
import Chapter06.{Rational5, Rational7, Rational8, Rational9}

class Chapter06Spec extends FlatSpec with Matchers {
  "A rational" should "add another rational and return a new rational" in {
    (new Rational5(1, 3) add new Rational5(3, 2)).toString shouldBe "11/6"
    (new Rational5(2, 5) add new Rational5(1, 9)).toString shouldBe "23/45"

    (new Rational8(1, 3) + new Rational8(3, 2)).toString shouldBe "11/6"
    (new Rational8(2, 5) + new Rational8(1, 9)).toString shouldBe "23/45"
  }

  it should "return the less than rational" in {
    new Rational5(1, 2) lessThan new Rational5(2, 3) shouldBe true
    new Rational5(5, 6) lessThan new Rational5(5, 8) shouldBe false
  }

  it should "return the max between two rationals" in {
    (new Rational5(1, 3) max new Rational5(2, 5)).toString shouldBe "2/5"
    (new Rational5(2, 3) max new Rational5(1, 7)).toString shouldBe "2/3"
  }

  it should "return the normalized version of the rational" in {
    new Rational7(2, 4).toString shouldBe "1/2"
    new Rational7(6, 6).toString shouldBe "1/1"
  }

  it should "multiply another rational and return a new rational" in {
    (new Rational8(1, 2) * new Rational8(1, 2)).toString shouldBe "1/4"
    (new Rational8(3, 2) * new Rational8(1, 4)).toString shouldBe "3/8"
  }

  it should "multiply an int to a rational" in {
    // the implicit conversion has to be in scope, inside the class Rational won't be sufficient
    implicit def intToRational(x: Int) = new Rational9(x)

    (2 * new Rational9(1, 2)).toString shouldBe "1/1"
    (3 * new Rational9(2, 5)).toString shouldBe "6/5"
  }
}
