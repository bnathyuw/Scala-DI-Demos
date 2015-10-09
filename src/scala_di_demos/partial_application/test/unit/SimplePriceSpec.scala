package scala_di_demos.partial_application.test.unit

import org.scalatest.{FlatSpec, Matchers}

import scala.util.Success
import scala_di_demos.partial_application.imp.{ItemPricer, PriceRule}

class SimplePriceSpec extends FlatSpec with Matchers {
  val item = 'Z'
  val expectedPrice = 3

  val price: PriceRule = ItemPricer.simplePrice(item, expectedPrice)

  "simple price" should "price one item correctly" in {
    price(item, 1) should be(Success(expectedPrice))
  }

  it should "price many items correctly" in {
    val numberOfItems: Int = 5
    price(item, numberOfItems) should be(Success(expectedPrice * numberOfItems))
  }
}

