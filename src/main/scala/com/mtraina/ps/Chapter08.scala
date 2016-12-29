package com.mtraina.ps

object Chapter08 {
  /**
    * First class functions
    */
  val someNumbers = List(-11, -10, -5, 0, 5, 10)

  // we pass a function to the method "foreach" of list
  someNumbers.foreach((x: Int) => println(x))

  // shorter version
  someNumbers.foreach(x => println(x))

  /**
    * Placeholder syntax
    * it's an even more succinct version of the previous methods
    */
  someNumbers.foreach(println(_))

  /**
    * Partially applied functions
    */
  def sum(a: Int, b: Int, c: Int) = a + b + c   // we create a function that sums the value of three parameters together
  val a = sum _   // a is a partially applied function where we didn't provide any parameters
  a(1, 2, 3)      // this will call the function passing 1, 2 and 3 as parameters, similarly to what would happen when calling sum(1, 2, 3)
  val b = sum(1, _: Int, 3) // the function b is another partially applied function where we provided 1 and 3 as first and last parameter
  b(5)            // this will now be executed as 1 + 5 + 3 where 5 is the only free parameter we can provide using b

  /**
    * Closures
    * They capture the bindings (the values) of a free variable, in the following examples named "more"
    */
  var more = 1    // set the variable more to the value 1
  val addMore = (x: Int) => x + more  // creates a function that binds the value of x to the value of more
  addMore(3)      // returns 4
  more = 3        // we update the value of more
  addMore(3)      // we call again the function and now it returns 6

  def makeIncreaser(more: Int) = (x: Int) => x + more   // we define a function that returns closures
                                                        // each time the function is invoked it'll create a closure that binds
                                                        // the value of the parameter "more" related to that invocation
  val inc1 = makeIncreaser(1)         // binds the value 1 as more
  val inc9999 = makeIncreaser(9999)   // binds the value 9999 as more
  inc1(10)      // 11
  inc9999(10)   // 1009

  /**
    * Repeated parameters
    * They are defined with the asterisk sign
    */
  def echo(args: String*) = for(arg <- args) println(arg)

  /**
    * Named arguments
    */
  def speed(distance: Float, time: Float): Float = distance / time
  speed(100, 10)                    // if the name of the parameters is specified, they are assigned in the oder they are defined
  speed(distance = 100, time = 10)  // equivalent to the case listed above
  speed(time = 10, distance = 100)  // in this case is possible to change the order of the parameters and acheive the ame result

  /**
    * Default parameter values
    * When not specified, the parameter is defaulted
    */
  def printTime(out: java.io.PrintStream = Console.out) = out.println("time = " + System.currentTimeMillis())

  // case where we combine both default and named parameters
  def printTime2(out: java.io.PrintStream = Console.out, divisor: Int = 1) = out.println("time = " + System.currentTimeMillis() / divisor)
  // all the following calls are valid
  printTime2()
  printTime2(divisor = 2)
  printTime2(out = Console.err)
  printTime2(out = Console.err, divisor = 2)

  /**
    * Tail recursion
    * A tail recursive function is a function that call itself as last operation
    * In a case of tail recursive function, the Scala compiler can optimize the recursive code into a loop
    * and avoiding to create a new frame for each iteration
    *
    * The following example shows a NON-tail-recursive function
    * it is not a tail recursive function because the increment operation is actually the last
    */
  def boom(x: Int): Int = {
    if(x == 0) throw new Exception("boom!")
    else boom(x - 1) + 1
  }
  boom(3)
  // when executed, we'll receive the output listed below, where is clear that
  // the function created 4 frames for each iteration before throwing the exception
  //
  //  java.lang.Exception: boom!
  //    at .boom(<console>:12)
  //    at .boom(<console>:13)
  //    at .boom(<console>:13)
  //    at .boom(<console>:13)
  //    ... 32 elided

  /**
    * the following function is actual tail-recursive because the call to itself is in fact the last statement
    */
  def bang(x: Int): Int = {
    if(x == 0) throw new Exception("bang!")
    else bang(x -1)
  }
  bang(3)
  // when this function is executed, we'll see a shorter stacktrace,
  // actually showing only one frame before the exception is thrown
  // the Scala compiler applied the optimization
  //
  //  java.lang.Exception: bang!
  //    at .bang(<console>:12)
  //    ... 32 elided
}
