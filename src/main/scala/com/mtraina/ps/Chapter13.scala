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

}
