package scala_di_demos.partial_application.test.unit

import org.scalatest.{Matchers, FlatSpec}

import scala.util.{Try, Success}
import scala_di_demos.partial_application.imp.Till

class TillHandlesPricedBasketSpec extends FlatSpec with Matchers {
  private val expectedBasket: String = "ABCD"
  private val expectedPrice: Int = 50
  private val expectedMessage: String = "Expected message"

  def price(basket: String): Try[Int] = basket match {
    case `expectedBasket` => Success(expectedPrice)
  }

  def create(basket: String, price: Int): String = (basket, price) match {
    case (`expectedBasket`, `expectedPrice`) => expectedMessage
  }

  "check out" should "return message" in {
    val checkOut = Till.checkOut(price, create)(_)
    val message = checkOut(expectedBasket)

    message should be(expectedMessage)
  }
}
