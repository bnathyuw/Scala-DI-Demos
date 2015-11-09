package scala_di_demos.cake.test.unit

import org.scalatest.{Matchers, FlatSpec}

import scala.util.{Try, Failure}
import scala_di_demos.cake.imp.{UnknownItem, ItemPricerComponent, DefaultBasketPricerComponent}

class BasketPricerSpecForUnknownItem extends FlatSpec with Matchers with DefaultBasketPricerComponent with ItemPricerComponent {
  val expectedError: UnknownItem = UnknownItem('?')

  "basket pricer" should "return failure from item pricer" in {
    basketPricer price "Anything" should be(Failure(expectedError))
  }

  override def itemPricer: ItemPricer = new ItemPricer {
    override def price(item: Char, count: Int): Try[Int] = Failure(expectedError)
  }
}
