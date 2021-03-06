package com.mtraina.ps

import java.io.{File, PrintWriter}
import java.util.Date
import java.util.function.Predicate

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
    def filesRegex(query: String) =
      for(file <- filesHere; if file.getName.matches(query))
        yield file
  }

  /**
    * Refactored file matcher where we reuse the common part of matching the file name
    */
  object FileMatcherRefactored {
    private def filesHere = new java.io.File(".").listFiles()

    def filesMatching(query: String, matcher: (String, String) => Boolean) = {
      for(file <- filesHere; if matcher(file.getName, query))
        yield file
    }

    // the first placeholder (_) will be fulfilled with the value of "file.getName" being it the first parameter passed
    // to the function matcher inside the method fileMatching
    // similarly the second placeholder will get the value of "query", being it the second parameter passed
    def fileEnding(query: String) = filesMatching(query, _.endsWith(_))
    def fileContaining(query: String) = filesMatching(query, _.contains(_))
    def fileRegex(query: String) = filesMatching(query, _.matches(_))
  }

  /**
    * Refactored file matcher using closures: query is the free variable
    */
  object FileMatcherClosure {
    private def filesHere = new java.io.File(".").listFiles()

    private def filesMatching(matcher: String => Boolean) =
      for(file <- filesHere; if matcher(file.getName))
        yield file

    def fileEnding(query: String) = filesMatching(_.endsWith(query))
    def fileContaining(query: String) = filesMatching(_.contains(query))
    def fileRegex(query: String) = filesMatching(_.matches(query))
  }

  /**
    * Simplify client code using high order functions
    */
  def containsNeg(nums: List[Int]): Boolean = {
    var exists = false
    for(num <- nums)
      if(num < 0)
        exists = true
    exists
  }
  containsNeg(List(1,2,3,-4))   // true

  // the following method give us the same result of the one above, in a more concise way
  def containsNegRefactored(nums: List[Int]) = nums.exists(_ < 0)

  /**
    * Currying
    */
  // in this example we show a typical function where we pass the two arguments and the body of the function sums them
  def plainOldSum(x: Int, y: Int) = x + y
  plainOldSum(1, 2) // 3

  // in the example shown below, instead, we show create a function that takes an integer as parameter and returns
  // a function. Passing the second parameter to the last function yields the sum
  def curriedSum(x: Int)(y: Int) = x + y
  curriedSum(1)(2)  // 3

  /**
    * Writing new control structures
    */
  def twice(op: Double => Double, x: Double) = op(op(x))
  twice(_ + 1, 5)   // 7 (5 + 1 + 1)

  // in any method invocation in which we are passing in exactly one argument, we can use curly braces in stead of parentheses
  println("Hello world!")
  println { "Hello world!" }

  // the advantage of using curly braces is that enables client programmers to write function literals in between
  def withPrintWriter(file: File, op: PrintWriter => Unit) ={
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }
  withPrintWriter(new File("a.txt"),
                  writer => writer.println(new Date))

  // the same function as above refactored using the loan pattern
  def withPrintWriterRefactored(file: File)(op: PrintWriter => Unit) ={
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  // refactoring the function in this way let us use the curly braces for passing the last parameter
  withPrintWriterRefactored(new File("a.txt")){ writer =>
    writer.println(new Date)
  }

  /**
    * By-name parameters
    */
  var assertionsEnabled = true

  // in this case we pass a function, it won't be evaluated if assertionsEnabled is false
  def myAssert(predicate: () => Boolean) =
    if(assertionsEnabled && !predicate())
      throw new AssertionError

  // using this function is a bit awkward
  myAssert(() => 5 > 3)

  // the next function is equivalent to the first
  def byNameAssert(predicate: => Boolean) =
    if(assertionsEnabled && !predicate)
      throw new AssertionError

  // calling it looks more natural
  byNameAssert(5 > 3)

  // this last case is similar but the parameter "predicate" will be evaluate before the call to the boolAssert method
  def boolAssert(predicate: Boolean) =
    if(assertionsEnabled && !predicate)
      throw new AssertionError

  val x = 5
  assertionsEnabled = false
  boolAssert(x / 0 == 0)      // this will produce an arithmetic exception because it will be evaluated before entering the method

  byNameAssert(x / 0 == 0)    // it won't throw any exception because with assertionsEnable to false, the predicate won't be evaluated
}
