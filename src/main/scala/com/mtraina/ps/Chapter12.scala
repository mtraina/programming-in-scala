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

  /**
    * Mixing the same final version of the class Rational in chapter 6 with the trait Ordered
    */
  class Rational(n: Int, d: Int) extends Ordered[Rational] {
    require(d != 0)

    private val g = gcd(n.abs, d.abs)
    val num: Int = n / g
    val den: Int = d / g

    def this(n: Int) = this(n, 1)

    def +(that: Rational): Rational = new Rational(num * that.den + that.num * den, den * that.den)

    def +(i: Int) = new Rational(num + i * den, den)

    def -(that: Rational): Rational = new Rational(num * that.den - that.num * den, den * that.den)

    def -(i: Int) = new Rational(num - i * den, den)

    def *(that: Rational): Rational = new Rational(num * that.num, den * that.den)

    def *(i: Int): Rational = new Rational(num * i, den)

    def /(that: Rational): Rational = new Rational(num * that.den, den * that.num)

    def /(i: Int): Rational = new Rational(num, den * i)

    override def toString = num + "/" + den

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    // overridden from Ordered
    override def compare(that: Rational): Int = (this.num * that.den) - (that.num * this.den)
  }

  val half = new Rational(1, 2)
  val third = new Rational(1, 3)

  half < third // Boolean = false
  half > third // Boolean = true

  /**
    * Traits as stackable modifications
    */
  abstract class IntQueue {
    def get(): Int
    def put(x: Int)
  }

  import scala.collection.mutable.ArrayBuffer

  class BasicIntQueue extends IntQueue {
    private val buf = new ArrayBuffer[Int]
    override def get() = buf.remove(0)
    override def put(x: Int) = buf += x
  }

  trait Doubling extends IntQueue {
    abstract override def put(x: Int) = super.put(x * 2)
  }

  class MyQueue extends BasicIntQueue with Doubling

  val q = new MyQueue
  q.put(10)   // puts 10 * 2 because of the trait doubling
  q.get       // 20

  trait Incrementing extends IntQueue {
    abstract override def put(x: Int) = super.put(x + 1)
  }
  trait Filtering extends IntQueue {
    abstract override def put(x: Int) = if(x >= 0) super.put(x)
  }

  // class that extends two traits that define the same method
  // to avoid the diamond problem the implementation most at the right hand side takes effect first
  // than every time "super" is called, the selection of the implementation will be to nearer on the left ans o on
  val filteredThenIncrementedQueue = new BasicIntQueue with Incrementing with Filtering
  filteredThenIncrementedQueue.put(-1)
  filteredThenIncrementedQueue.put(0)
  filteredThenIncrementedQueue.put(1)

  filteredThenIncrementedQueue.get()    // 1 (x >= 0 then x + 1 = 0 + 1)
  filteredThenIncrementedQueue.get()    // 2 (x >= 0 then x + 1 = 1 + 1)

  val incrementThenFilterQueue = new BasicIntQueue with Filtering with Incrementing
  incrementThenFilterQueue.put(-1)
  incrementThenFilterQueue.put(0)
  incrementThenFilterQueue.put(1)

  incrementThenFilterQueue.get()        // 0 (-1 + 1 than x >= 0)
  incrementThenFilterQueue.get()        // 1 (0 + 1 than x >= 0)
  incrementThenFilterQueue.get()        // 2 (1 + 1 than x >= 0)
}
