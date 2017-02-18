package com.mtraina.ps {
  /**
    * In Scala you can create nested packages in the same file
    */
  package tools {
    class NumberFormatter
  }
}

object Chapter13 {
  /**
    * The import of a package can be inside the class/object definition and not only at the beginning of the file
    */
  import com.mtraina.ps.tools.NumberFormatter

  val nf: NumberFormatter = new NumberFormatter

  /**
    * By default the access modifier for Scala is public.
    * Protected and private are also allowed modifiers and they have to be explicitly used
    */
  val length = 10 // public
  protected val height = 20 // protected
  private val weight = 30   // private
}