package com.fnproj.fn

import scala.io.Source

object Base {
  /**
    * Consume the entire function event body as a string
    */
  def readAll: String = Source.stdin.mkString

  /**
    * Consume a single line of input
    *
    * @return
    */
  def readLines: List[String] = Source.stdin.getLines().toList

  /**
    * Write a log message
    *
    * @param msg
    */
  def log(msg: String): Unit = Console.err.println(msg)

  /**
    * Write a string to stdout
    *
    * @param msg
    */
  def write(msg: String): Unit = Console.out.println(msg)
}
