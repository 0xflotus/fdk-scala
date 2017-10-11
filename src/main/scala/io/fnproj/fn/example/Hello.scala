package io.fnproj.fn.example

import io.fnproj.fn.{Context, AutoInvokeFunctionHandler}

object Hello extends AutoInvokeFunctionHandler {

  def handle(input: String, context: Context): String = {
    context.log(s"Function called with input $input")
    s"Hello, $input"
  }
}
