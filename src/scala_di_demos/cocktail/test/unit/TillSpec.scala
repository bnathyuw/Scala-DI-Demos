package scala_di_demos.cocktail.test.unit

import org.scalatest.{FlatSpec, Matchers}

import scala_di_demos.cocktail.imp.{BasketPricer, MessageCreator, Till}

class TillSpec extends FlatSpec with Matchers with BasketPricer with MessageCreator {
  private val expectedPrice: Int = 50
  private val expectedMessage: String = "Expected message"
  private val expectedBasket: String = "ABCD"

  override def price(basket: String): Int = basket match {
    case `expectedBasket` => expectedPrice
  }

  override def create(basket: String, price: Int) = (basket, price) match {
    case (`expectedBasket`, `expectedPrice`) => expectedMessage
  }

  "till" should "return a message constructed from the basket and its price" in {
    val till = new Till(this, this)
    val message = till.checkOut(expectedBasket)

    message should be(expectedMessage)
  }
}
