package scala_di_demos.cake.test.unit

import org.scalatest.{Matchers, FlatSpec}

import scala.util.{Try, Failure}
import scala_di_demos.cake.imp.{EmptyBasket, ItemPricerComponent, DefaultBasketPricerComponent}

class BasketPricerSpecForEmptyBasket extends FlatSpec with Matchers with DefaultBasketPricerComponent with ItemPricerComponent{
  "basket pricer" should "fail for an empty basket" in {
    basketPricer price "" should be(Failure(EmptyBasket))
  }

  override def itemPricer: ItemPricer = new ItemPricer {
    override def price(item: Char, count: Int): Try[Int] = ???
  }
}
