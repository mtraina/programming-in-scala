package com.mtraina.ps.chapter03

import org.scalatest.{FlatSpec, Matchers}

class ParametrizedArraySpec extends FlatSpec with Matchers {

  "A greeting strings" should "contain the expected values" in {
    val greetings = ParametrizedArray.greetings
    greetings(0) shouldBe "Hello"
    greetings(1) shouldBe ", "
    greetings(2) shouldBe "world!\n"
  }
}
