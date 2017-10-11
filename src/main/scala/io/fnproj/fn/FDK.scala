package io.fnproj.fn

import scala.io.{BufferedSource, Source}

object FDK {
  /**
    * Consume the entire function event body as a string
    */
  def read(): BufferedSource = Source.stdin

  /**
    * Write a string to stdout
    *
    * @param msg
    */
  def write(msg: String): Unit = Console.out.println(msg)
}
