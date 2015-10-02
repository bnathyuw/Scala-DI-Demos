package scala_di_demos.cocktail.test.unit

import org.scalatest.{FlatSpec, Matchers}

import scala_di_demos.cocktail.imp.{MessageCreator, BasketPricer, Till}

class TillSpec extends FlatSpec with Matchers with BasketPricer with MessageCreator {
  var actualBasket: String = _
  var actualBasketAndPrice: (String, Int) = _

  override def price(basket: String): Int = {
    actualBasket = basket
    50
  }

  override def create(basket: String, price: Int) = {
    actualBasketAndPrice = (basket, price)
    "Expected message"
  }

  "till" should "get price of basket" in {
    val till = new Till(this, this)
    val basket = "ABCD"

    till.checkOut(basket)

    actualBasket should be(basket)
  }

  it should "create a message" in {
    val till = new Till(this, this)
    val basket = "ABCD"

    till.checkOut(basket)

    actualBasketAndPrice should be(basket, 50)
  }

  it should "return the message created" in {
    val till = new Till(this, this)
    val basket = "ABCD"

    val message = till.checkOut(basket)

    message should be("Expected message")
  }
}
