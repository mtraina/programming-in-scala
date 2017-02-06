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

}
