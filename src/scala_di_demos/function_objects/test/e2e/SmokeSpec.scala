package scala_di_demos.function_objects.test.e2e

import org.scalatest.{FlatSpec, Matchers}

import scala_di_demos.function_objects.imp.{DefaultCheckOut, DefaultFormatMessage, DefaultPriceBasket, DefaultPriceItems}

class SmokeSpec extends FlatSpec with Matchers {
  "check out" should "tell you what your basket costs" in {
    val checkOut = new DefaultCheckOut(new DefaultPriceBasket(new DefaultPriceItems), new DefaultFormatMessage)
    checkOut("ABCD") should be("Your basket containing ABCD costs £115.00")
  }
}