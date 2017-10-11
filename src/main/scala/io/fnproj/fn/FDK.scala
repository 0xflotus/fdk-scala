package io.fnproj.fn

import scala.io.{BufferedSource, Source}

object FDK {
  def read(): BufferedSource = Source.stdin
  
  def write(msg: String): Unit = Console.out.println(msg)
}
