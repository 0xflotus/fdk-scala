package com.fnproj.fn

import scala.io.BufferedSource

trait FunctionHandler {

  /**
    * Handler defines the user entry point for a function
    *
    * @param context The request context containing environment variables and configuration
    * @param input The raw function input\
    *
    * @return A string to return as the response
    */
  def handle(input: String, context: Context): String

  def invoke(): Unit = {
    val input: BufferedSource = FDK.read()
    val context = new Context()

    if (input.bufferedReader().ready()) {
      val result = handle(input.mkString, context)
      FDK.write(result)
    }
  }
}

/**
  * When extending the auto invoke function handler, the handle method is automatically
  * triggered with the function execution context
  */
trait AutoInvokeFunctionHandler extends FunctionHandler {
  invoke()
}
