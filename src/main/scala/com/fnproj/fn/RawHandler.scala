package com.fnproj.fn

import scala.io.BufferedSource

trait RawHandler {

  def handle(input: BufferedSource, context: Context)
}
