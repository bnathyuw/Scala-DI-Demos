package scala_di_demos.cake.test.unit

import org.scalatest.{FlatSpec, Matchers}

import scala.util.{Success, Try}
import scala_di_demos.cake.imp._

class BasketPricerSpec extends FlatSpec with Matchers with DefaultBasketPricerComponent with ItemPricerComponent{
  it should "aggregate the prices of items passed in" in {
    basketPricer price "ABCDE" should be(Success(50))
  }

  override def itemPricer: ItemPricer = new ItemPricer {
    override def price(item: Char, count: Int): Try[Int] = Success(count * 10)
  }
}