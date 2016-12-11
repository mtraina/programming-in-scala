package com.mtraina.ps

import scala.collection.mutable

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

    def add(b: Byte): Unit = {
      sum += b
    }
    def checksum(): Int = {
      return ~(sum & 0xFF) + 1
    }
  }
  val acc2 = new PrivateChecksumAccumulator
  // invoke acc2.sum is now not possible

  /**
    * The parameters passed to a method are vals so not reassignable
    */
  def add(b: Byte): Unit = {
    // b = 1 this is not possible
  }

  /**
    * Refactored class removing the "return" keyword and the curly braces because the methods body is long only one line
    * It's possible to remove also the returned type from the method and let the compiler infer for us, but for better
    * readability is advised to keep it
    */
  class RefactoredChecksumAccumulator {
    private var sum = 0
    def add(b: Byte): Unit = sum += b
    def checksum(): Int = ~(sum & 0xFF) + 1
  }

  /**
    * This method returns Unit, so it's executed for its side effects.
    * Methods that are used only for they side effects are named "procedure"
    */
  // def add(b: Byte): Unit = sum += b

  /**
    * Singleton objects
    * They are the way Scala uses instead of static memebers
    * They must be defined in the same file where the class is defined
    *
    * This object is calculating the checksum of the characters in a string
    * first it checks if the passed value has been previously calculated and it that case it gets the result from an internal cache
    * otherwise, if the value wasn't present in the cache, it calculates the checksum, saves in the cache the result and returns it
    */
  object ChecksumAccumulator {
    private val cache = mutable.Map.empty[String, Int]

    def calculate(s: String): Int =
      if(cache.contains(s))
        cache(s)
      else {
        val acc = new RefactoredChecksumAccumulator
        for(c <- s){
          acc.add(c.toByte)
        }
        val cs = acc.checksum()
        cache += (s -> cs)
        cs
      }
  }
}
