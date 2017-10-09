# FDK Scala

Scala FDK for fnproject

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