package com.mtraina.ps

object Chapter11 {

  /**
    * Nothing is the subtype of all the other types
    */
  def error(message: String): Nothing = throw new RuntimeException(message)

  def divide(x: Int, y: Int): Int = {
    if(y != 0) x/y
    else error("can't divide by zero")  // we can actually return nothing here being nothing also subclass of Int
  }

  /**
    * Avoid a types monoculture
    * Passing just strings can be confusing and it is easy to mix the parameters
    */
  def title(text: String, anchor: String, style: String): String =
    s"<a id='$anchor'><h1 class='$style'>$text</h1></a>"

  // the compiler can help if we define types for each parameter
  class Anchor(val value: String)
  class Style(val value: String)
  class Text(val value: String)
  class Html(val value: String)

  def title(text: Text, anchor: Anchor, style: Style): Html =
    new Html(s"<a id='${anchor.value}'><h1 class='${style.value}'>${text.value}</h1></a>")
}
