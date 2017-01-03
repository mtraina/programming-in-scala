package com.mtraina.ps

object Chapter09 {

  /**
    * We define a singleton to match the files in a directory following certain criteria
    */
  object FileMatcher {
    private def filesHere = new java.io.File(".").listFiles()

    // returns all the files in the directory that ends with a specific suffix
    def fileEnding(query: String) =
      for(file <- filesHere; if file.getName.endsWith(query))
        yield file

    //returns all the files containing a specific token in their name
    def filesContaining(query: String) =
      for(file <- filesHere; if file.getName.contains(query))
        yield file

    //returns all the files matching a specific regex in their name
    def filesregex(query: String) =
      for(file <- filesHere; if file.getName.matches(query))
        yield file
  }
}
