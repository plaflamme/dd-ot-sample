package example

import datadog.opentracing.DDTracer

object Hello extends App {
  DDTracer.builder().build()
}

