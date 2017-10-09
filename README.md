# Scala Function Development Kit (FDK)

The Scala FDK provides convenience functions for writing Scala fn code.

For getting started with fn, please refer to https://github.com/fnproject/fn/blob/master/README.md

## Examples

This example below shows a simple "Hello World" example. A hander is passed the input from stdin along with a context
which contains information such as the fn configuration and environment.

```scala
import com.fnproj.fn.{Context, AutoInvokeFunctionHandler}

object Hello extends App with AutoInvokeFunctionHandler {

  def handle(input: String, context: Context): String = {
      s"Hello, $input"
  }
}
```

## Advanced

You can use Circe to derive types from JSON as in the following example

Define the input for our greeting function

```json
{
    "name": "Owain"
}
```

```scala
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
```

Run it with

```
cat payload.json | sbt run
```