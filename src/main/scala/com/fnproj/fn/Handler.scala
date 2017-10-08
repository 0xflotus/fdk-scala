package com.fnproj.fn

final case class Context(config: Map[String, String])

trait Handler {

  /**
    * Handle a function invocation
    *
    * @param context The request context containing environment variables and configuration
    * @param input The raw function input
    * @return A string to return as the response
    */
  def handle(context: Context, input: String): String
}
