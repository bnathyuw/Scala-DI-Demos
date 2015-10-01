package scala_di_demos.cake.test.unit

import org.scalatest.{FlatSpec, Matchers}

import scala_di_demos.cake.imp.{BasketPricerComponent, DefaultTillComponent}

class TillSpec extends FlatSpec with Matchers with DefaultTillComponent with BasketPricerComponent {

  var actualBasket: String = _

  override def basketPricer = new BasketPricer {
    override def price(basket: String): Int = {
      actualBasket = basket
      0
    }
  }

  "till" should "get price of basket" in {
    val basket = "ABCD"

    till.checkOut(basket)

    actualBasket should be(basket)
  }
}
