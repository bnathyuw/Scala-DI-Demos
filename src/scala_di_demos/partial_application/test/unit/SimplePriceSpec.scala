package scala_di_demos.partial_application.test.unit

import org.scalatest.{Matchers, FlatSpec}

import scala_di_demos.partial_application.imp.ItemPricer

class SimplePriceSpec extends FlatSpec with Matchers {
  val item = 'Z'
  val expectedPrice = 3

  val price: PartialFunction[(Char, Int), Int] = ItemPricer.simplePrice(item, expectedPrice)

  "simple price" should "price one item correctly" in {
    price(item, 1) should be(expectedPrice)
  }

  it should "price many items correctly" in {
    val numberOfItems: Int = 5
    price(item, numberOfItems) should be(expectedPrice * numberOfItems)
  }
}

