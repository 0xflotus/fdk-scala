package io.fnproj.fn

final class Context {

  val env: Map[String, String] = sys.env

  def fnContext: Map[String, String] = {
    val fnValues = List(
      "FN_APP_NAME",
      "FN_PATH",
      "FN_METHOD",
      "FN_FORMAT",
      "FN_MEMORY",
      "FN_TYPE",
      "FN_PARAM",
      "FN_HEADER",
      "FN_CALL_ID",
      "FN_REQUEST_URL")
    fnValues.foldLeft(Map.empty[String, String]) { case(m, k) =>
      env.get(k) map { v =>
        m + (k -> v)
      } getOrElse m
    }
  }

  def log(msg: String): Unit = Console.err.println(msg)
}
