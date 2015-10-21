package scala_di_demos.function_objects.test.unit

import org.scalatest.{FlatSpec, Matchers}

import scala_di_demos.function_objects.imp.DefaultFormatMessage


class DefaultFormatMessageSpec extends FlatSpec with Matchers {
  "format message" should "return the expected message" in {
    val formatMessage = new DefaultFormatMessage
    formatMessage("DCBA", 20) should be("Your basket containing DCBA costs £20.00")
  }
}
