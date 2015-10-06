package scala_di_demos.partial_application.test.e2e

import org.scalatest.{FlatSpec, Matchers}

import scala_di_demos.partial_application.imp.{MessageCreator, BasketPricer, Till}

class SmokeSpec extends FlatSpec with Matchers {
  "check out" should "tell you what your basket costs" in {
    val checkOut = Till.checkOut(BasketPricer.price((item,count) => item match {
      case 'A' => 50
      case 'B' => 30
      case 'C' => 20
      case 'D' => 15
    }), MessageCreator.createMessage)(_)
    val basket = "ABCD"
    
    checkOut(basket) should be("Your basket containing ABCD costs £115.00")
  }
}