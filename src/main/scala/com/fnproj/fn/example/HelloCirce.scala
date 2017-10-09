package com.fnproj.fn.example

import com.fnproj.fn.{AutoInvokeFunctionHandler, Context}
import io.circe.generic.auto._, io.circe.parser._

case class Greeting(name: String)

object HelloCirce extends App with AutoInvokeFunctionHandler {

  def handle(input: String, context: Context): String = {
    val greeting = decode[Greeting](input)
    greeting.fold(
      _ => "Hello, World!",
      greeting => s"Hello, ${greeting.name}!"
    )
  }
}