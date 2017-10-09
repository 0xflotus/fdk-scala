package com.fnproj.fn.example

import com.fnproj.fn.{Context, AutoInvokeFunctionHandler}

object Hello extends App with AutoInvokeFunctionHandler {

  def handle(input: String, context: Context): String = {
      s"Hello, $input"
  }
}
