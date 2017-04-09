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
}
