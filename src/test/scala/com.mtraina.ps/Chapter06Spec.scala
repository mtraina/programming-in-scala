package com.mtraina.ps

import org.scalatest.{FlatSpec, Matchers}
import Chapter06.Rational5

class Chapter06Spec extends FlatSpec with Matchers {
  "A rational" should "add another rational and return a new rational" in {
    new Rational5(1, 3) add new Rational5(3, 2) shouldBe new Rational5(11, 6)
    new Rational5(2, 5) add new Rational5(1, 9) shouldBe new Rational5(23, 45)
  }
}
