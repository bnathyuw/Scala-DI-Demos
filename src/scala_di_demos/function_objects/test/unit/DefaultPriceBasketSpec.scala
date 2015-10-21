package scala_di_demos.function_objects.test.unit

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

import scala_di_demos.function_objects.imp.{PriceItems, DefaultPriceBasket}

class DefaultPriceBasketSpec extends FlatSpec with Matchers with PriceItems with BeforeAndAfter {
  var actualCalls: List[(Char, Int)] = Nil
  var result: Int = _

  before {
    val priceBasket = new DefaultPriceBasket(this)

    result = priceBasket("ABABA")
  }

  "price basket" should "get the cumulative price of each group of items" in {
    actualCalls should contain(('A', 3))
    actualCalls should contain(('B', 2))
  }

  it should "return the sum of the results" in {
    result should be(5)
  }

  override def apply(item: Char, count: Int): Int = {
    actualCalls = actualCalls :+(item, count)
    count
  }
}
