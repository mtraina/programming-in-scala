package com.mtraina.ps

import com.mtraina.ps.Chapter14.Elem
import org.scalatest.{MustMatchers, WordSpec}
import org.scalatest.prop.PropertyChecks

class Chapter14Spec extends WordSpec with PropertyChecks with MustMatchers {
  "elem result" must {
    "have passed size" in {
      forAll { (s: Int) =>
        whenever(s > 0){
          Elem("name", s).size must equal (s)
        }
      }
    }
  }
}
