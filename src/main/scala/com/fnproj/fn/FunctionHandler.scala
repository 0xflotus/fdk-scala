package com.fnproj.fn

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
    val context = new Context()
    getInput.map(handle(_, context))
      .foreach(FDK.write)
  }

  /**
    * Read stdin. We only consume if there is data to be read
    * otherwise the buffer will block
    *
    * @return
    */
  private def getInput: Option[String] = {
    val input = FDK.read()
    if (input.bufferedReader().ready()) Some(input.mkString) else None
  }
}

/**
  * When extending the auto invoke function handler, the handle method is automatically
  * triggered with the function execution context
  */
trait AutoInvokeFunctionHandler extends FunctionHandler {
  invoke()
}
