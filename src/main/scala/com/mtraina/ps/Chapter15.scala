package com.mtraina.ps

object Chapter15 {
  abstract class Expr
  case class Var(name: String) extends Expr
  case class Number(num: Double) extends Expr
  case class UnOp(operator: String, arg: Expr) extends Expr
  case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

  /**
    * Case classes
    * when the "case" keyword is used, the compiler adds some syntactic parts
    * it adds a factory to create objects without specifying the keyword "new"
    */
  val v = Var("v")

  // it is particularly useful when the creation of objects are nested
  val op = BinOp("+", Number(1), Var("v"))

  // the compiler adds also a default implementation of the methods equals, hashCode and toString
  v.toString // res3: String = Var(v)
  v.hashCode // res2: Int = 717264670
  v.equals(Var("v")) // res4: Boolean = true

  // lastly the compiler creates a copy method useful for making copies of objects with small changes on them
  op.copy(operator = "-") // res5: BinOp = BinOp(-,Number(1.0),Var(v))

  /**
    * Pattern matching
    * it follows the rule "selector match {alternatives}"
    * match is an expression in Scala, so it does return a value
    * if none of the expressions match, an exception in thrown
    * the wildcard "_" is the default value
    */
  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e   // double negation
    case BinOp("+", e, Number(0)) => e  // adding zero
    case BinOp("*", e, Number(1)) => e  // multiply by one
    case _ => expr
  }

  /**
    * Sealed classes are useful for defining all the possible cases in the same file
    * and avoid the definition of a new case somewhere else in the code
    */
  sealed abstract class Expr2
  case class Var2(name: String) extends Expr2
  case class Number2(num: Double) extends Expr2
  case class UnOp2(operator: String, arg: Expr2) extends Expr2
  case class BinOp2(operator: String, left: Expr2, right: Expr2) extends Expr2

  /**
    * Option type
    * it wraps a non present value in a sort of box, it can have 2 results:
    * a some of the value we are expecting or none
    */
  val capitals = Map("France" -> "Paris", "Japan" -> "Tokio")
  capitals get "France" // res0: Option[String] = Some(Paris)
  capitals get "UK"     // res1: Option[String] = None

  /**
    * Pattern matching on Option
    */
  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }
  show(capitals get "Japan")  // res2: String = Tokio
  show(capitals get "USA")    // res3: String = ?

  /**
    * Patterns on variable definition (deconstruction)
    */
  val myTuple = (123, "abc")  // myTuple: (Int, String) = (123,abc)
  val (num, str) = myTuple    // num: Int = 123 str: String = abc

  /**
    * Case sequences as partial functions
    * A case sequence is a function literal
    * Here an example of its usage in Akka
    */
  //  var sum = 0
  //
  //  def receive = {
  //    case Data(byte) => sum += byte
  //    case GetChecksum(requester) =>
  //      val checksum = ~(sum & 0xFF) + 1
  //      requester ! checksum
  //  }

  /**
    * Patters in for expressions
    */
  for((country, city) <- capitals)
    println("The capital of " + country + " is " + city)
}
