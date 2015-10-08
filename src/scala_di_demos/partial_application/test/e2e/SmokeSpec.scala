package scala_di_demos.partial_application.test.e2e

import org.scalatest.{FlatSpec, Matchers}

import scala_di_demos.partial_application.imp.{BasketPricer, ItemPricer, MessageCreator, Till}

class SmokeSpec extends FlatSpec with Matchers {
  "check out" should "tell you what your basket costs" in {
    val checkOut = Till.checkOut(BasketPricer.price(ItemPricer.discountPrice('A', 50, 3, 120), ItemPricer.discountPrice('B', 30, 2, 45), ItemPricer.simplePrice('C', 20), ItemPricer.simplePrice('D', 15)), MessageCreator.createMessage)(_)
    val basket = "ABCD"

    checkOut(basket) should be("Your basket containing ABCD costs £115.00")
  }
}

