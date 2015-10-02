package scala_di_demos.partial_application.test.unit

import org.scalatest.{FlatSpec, Matchers}

import scala_di_demos.partial_application.imp.Till

class TillSpec extends FlatSpec with Matchers {
  private val expectedBasket: String = "ABCD"
  private val expectedPrice: Int = 50
  private val expectedMessage: String = "Expected message"

  def price(basket: String): Int = basket match {
    case `expectedBasket` => expectedPrice
  }

  def create(basket: String, price: Int): String = (basket, price) match {
    case (`expectedBasket`, `expectedPrice`) => expectedMessage
  }

  "check out" should "return message" in {
    val checkOut = Till.checkOut(this.price, this.create)(_)
    val message = checkOut(expectedBasket)

    message should be(expectedMessage)
  }
}
