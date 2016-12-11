package com.mtraina.ps

object Chapter04 {

  /**
    * Class definition in Scala with a mutable field (var sum)
    */
  class ChecksumAccumulator {
    var sum = 0
  }

  /**
    * The default access level in Scala is "public"
    */
  val acc = new ChecksumAccumulator
  acc.sum = 3

  /**
    * Same class definition with a private field
    */
  class PrivateChecksumAccumulator {
    private var sum = 0
  }
  val acc2 = new PrivateChecksumAccumulator
  // invoke acc2.sum is now not possible


}
