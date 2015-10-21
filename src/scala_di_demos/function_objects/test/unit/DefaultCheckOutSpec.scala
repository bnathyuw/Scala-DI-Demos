package scala_di_demos.function_objects.test.unit

import org.scalatest.{FlatSpec, Matchers}

import scala_di_demos.function_objects.imp.{DefaultCheckOut, FormatMessage, PriceBasket}

class DefaultCheckOutSpec extends FlatSpec with Matchers with PriceBasket with FormatMessage {
  private val ExpectedBasket: String = "ABCD"
  private val ExpectedMessage: String = "Expected message"
  private val ExpectedPrice: Int = 115

  "check out" should "return a message using the basket and its price" in {
    val checkOut = new DefaultCheckOut(this, this)
    checkOut(ExpectedBasket) should be(ExpectedMessage)
  }

  override def apply(basket: String): Int = basket match {
    case ExpectedBasket => ExpectedPrice
  }

  override def apply(basket: String, price: Int): String = (basket, price) match {
    case (ExpectedBasket, ExpectedPrice) => ExpectedMessage
  }
}
