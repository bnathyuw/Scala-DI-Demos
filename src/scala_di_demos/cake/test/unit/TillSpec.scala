package scala_di_demos.cake.test.unit

import org.scalatest.{FlatSpec, Matchers}

import scala.util.{Success, Try}
import scala_di_demos.cake.imp.{BasketPricerComponent, DefaultTillComponent, MessageCreatorComponent}

class TillSpec extends FlatSpec with Matchers with DefaultTillComponent with BasketPricerComponent with MessageCreatorComponent {

  private val expectedBasket: String = "ABCD"
  private val expectedPrice: Int = 50
  private val expectedMessage: String = "Expected message"

  override def basketPricer = new BasketPricer {
    override def price(basket: String): Try[Int] = basket match {
      case `expectedBasket` => Success(expectedPrice)
    }
  }

  override def messageCreator: MessageCreator = new MessageCreator {
    def create(basket: String, price: Try[Int]): String = (basket, price) match {
      case (`expectedBasket`, Success(`expectedPrice`)) => expectedMessage
    }
  }

  "till" should "return the a message constructed from the basket and its price" in {
    till checkOut expectedBasket should be(expectedMessage)
  }
}


