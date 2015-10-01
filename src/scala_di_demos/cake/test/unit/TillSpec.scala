package scala_di_demos.cake.test.unit

import org.scalatest.{FlatSpec, Matchers}

import scala_di_demos.cake.imp.{MessageCreatorComponent, BasketPricerComponent, DefaultTillComponent}

class TillSpec extends FlatSpec with Matchers with DefaultTillComponent with BasketPricerComponent with MessageCreatorComponent {

  var actualBasket: String = _
  var actualBasketAndPrice: (String, Int) = _

  override def basketPricer = new BasketPricer {
    override def price(basket: String): Int = {
      actualBasket = basket
      50
    }
  }

  override def messageCreator: MessageCreator = new MessageCreator {
    def create(basket: String, price: Int): String = {
      actualBasketAndPrice = (basket, price)
      "Expected message"
    }
  }

  "till" should "get price of basket" in {
    val basket = "ABCD"

    till.checkOut(basket)

    actualBasket should be(basket)
  }

  it should "get an output message" in {
    val basket = "ABCD"

    till.checkOut(basket)

    actualBasketAndPrice should be (basket, 50)
  }

  it should "return the generated output message" in {
    val basket = "ABCD"

    val message = till.checkOut(basket)

    message should be ("Expected message")
  }
}


