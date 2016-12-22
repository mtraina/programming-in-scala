package com.mtraina.ps

import org.scalatest.{FlatSpec, Matchers}
import Chapter06.{Rational5, Rational7}

class Chapter06Spec extends FlatSpec with Matchers {
  "A rational" should "add another rational and return a new rational" in {
    new Rational5(1, 3) add new Rational5(3, 2) shouldBe new Rational5(11, 6)
    new Rational5(2, 5) add new Rational5(1, 9) shouldBe new Rational5(23, 45)
  }

  it should "return the less than rational" in {
    new Rational5(1, 2) lessThan new Rational5(2, 3) shouldBe true
    new Rational5(5, 6) lessThan new Rational5(5, 8) shouldBe false
  }

  it should "return the max between two rationals" in {
    new Rational5(1, 3) max new Rational5(2, 5) shouldBe new Rational5(2, 5)
    new Rational5(2, 3) max new Rational5(1, 7) shouldBe new Rational5(2, 3)
  }

  it should "return the normalized version of the rational" in {
    new Rational7(2, 4).toString shouldBe "1/2"
    new Rational7(6, 6).toString shouldBe "1/1"
  }
}
