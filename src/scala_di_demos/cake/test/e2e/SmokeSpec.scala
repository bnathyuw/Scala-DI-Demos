package scala_di_demos.cake.test.e2e

import org.scalatest.{FlatSpec, Matchers}

import scala_di_demos.cake.imp.{BasketPricerComponent, DefaultTillComponent}

class SmokeSpec extends FlatSpec with Matchers with DefaultTillComponent with BasketPricerComponent {
  "till" should "tell you what your basket costs" in {

    val basket = "ABCD"

    till checkOut basket should be("Your basket containing ABCD costs £115.00")
  }

  override def basketPricer: BasketPricer = new BasketPricer {
    override def price(basket: String): Int = 0
  }
}

