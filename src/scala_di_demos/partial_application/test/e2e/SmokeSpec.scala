package scala_di_demos.partial_application.test.e2e

import org.scalatest.{FlatSpec, Matchers}

import scala_di_demos.partial_application.imp.{ItemPricer, MessageCreator, BasketPricer, Till}

class SmokeSpec extends FlatSpec with Matchers {
  "check out" should "tell you what your basket costs" in {
    val checkOut = Till.checkOut(BasketPricer.price(ItemPricer.price), MessageCreator.createMessage)(_)
    val basket = "ABCD"
    
    checkOut(basket) should be("Your basket containing ABCD costs £115.00")
  }
}

