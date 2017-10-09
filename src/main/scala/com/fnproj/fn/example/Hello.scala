package com.fnproj.fn.example

import com.fnproj.fn.{Context, AutoInvokeFunctionHandler}

object Hello extends AutoInvokeFunctionHandler {

  def handle(input: String, context: Context): String = {
    log(s"Function called with input $input")
    s"Hello, $input"
  }
}
