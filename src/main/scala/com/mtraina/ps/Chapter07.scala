package com.mtraina.ps

object Chapter07 {
  /**
    * For expressions
    */
  for(i <- 1 to 4)
    println("Iteration " + i)

  // filtering
  for(i <- 1 to 4 if i % 2 == 0)
    println("Iteration " + i)     // prints only even numbers

  // more than one filter applied
  for(
    i <- 1 to 4
    if i % 2 == 0
    if i > 2
  ) print(i)       // prints 4

  // keep values that satisfied the filtering
  for(
    i <- 1 to 6
    if i % 2 == 0
    if i > 2
  ) yield i        // Vector(4, 6)

  /**
    * Match expressions
    * Similar to the Java switch it doesn't use the keyword "break"
    * The default value is defined using the symbol "_"
    */
  val friend = "salt" match {
    case "salt" => "pepper"
    case "eggs" => "bacon"
    case _ => "huh?"
  }
  println(friend) // prints "pepper"
}


