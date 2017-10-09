# FDK Scala

Scala FDK for fnproject


```scala
package com.fnproj.fn.example

import com.fnproj.fn.{Context, FunctionHandler}

object Hello extends App {

  new FunctionHandler {
    def handle(input: String, context: Context): String = {
      s"Hello, $input"
    }
  }.run()
}
```
