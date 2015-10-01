package scala_di_demos.cake.test.e2e

import org.scalatest.{FlatSpec, Matchers}

import scala_di_demos.cake.imp.{MessageCreatorComponent, BasketPricerComponent, DefaultTillComponent}

class SmokeSpec extends FlatSpec with Matchers with DefaultTillComponent with BasketPricerComponent with MessageCreatorComponent {
  "till" should "tell you what your basket costs" in {

    val basket = "ABCD"

    till checkOut basket should be("Your basket containing ABCD costs £115.00")
  }

  override def basketPricer: BasketPricer = new BasketPricer {
    override def price(basket: String): Int = 115
  }

  override def messageCreator: MessageCreator = new MessageCreator{
    override def create(basket: String, price: Int): String = f"Your basket containing $basket%s costs £$price%2.2f"
  }
}

