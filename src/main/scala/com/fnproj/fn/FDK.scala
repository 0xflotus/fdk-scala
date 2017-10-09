package com.fnproj.fn

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

  /**
    * Write a log message
    *
    * @param msg
    */
  def log(msg: String): Unit = Console.err.println(msg)
}
