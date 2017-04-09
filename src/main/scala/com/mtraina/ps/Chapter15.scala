package com.mtraina.ps

object Chapter15 {
  abstract class Expr
  case class Var(name: String) extends Expr
  case class Number(num: Double) extends Expr
  case class UnOp(operator: String, arg: Expr) extends Expr
  case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

  // when the "case" keyword is used, the compiler adds some syntactic parts
  // it adds a factory to create objects without specifying the keyword "new"
  val v = Var("v")

  // it is particularly useful when the creation of objects are nested
  val op = BinOp("+", Number(1), Var("v"))

  // the compiler adds also a default implementation of the methods equals, hashCode and toString
  v.toString // res3: String = Var(v)
  v.hashCode // res2: Int = 717264670
  v.equals(Var("v")) // res4: Boolean = true

  // lastly the compiler creates a copy method useful for making copies of objects with small changes on them
  op.copy(operator = "-") // res5: BinOp = BinOp(-,Number(1.0),Var(v))
}
