package scala_di_demos.partial_application.test.unit

import org.scalatest.{FlatSpec, Matchers}

import scala_di_demos.partial_application.imp.{ItemPricer, PriceRule}

class DiscountPriceSpec extends FlatSpec with Matchers {
  val item = 'Z'
  val expectedPrice = 3
  val discountCount: Int = 7
  val discountPrice: Int = 11

  val price: PriceRule = ItemPricer.discountPrice(item, expectedPrice, discountCount, discountPrice)

  "discount price" should "price one item correctly" in {
    price(item, 1) should be (expectedPrice)
  }

  it should "price an undiscounted group of items correctly" in {
    val numberOfItems: Int = 2
    price(item, numberOfItems) should be (expectedPrice * numberOfItems)
  }

  it should "price a discount correctly" in {
    price(item, discountCount) should be (discountPrice)
  }

  it should "price a group of items part of which gets a discount correctly" in {
    price(item, discountCount + 1) should be (discountPrice + expectedPrice)
  }

  it should "price several discounts correctly" in {
    val numberOfDiscounts: Int = 13
    price(item, discountCount * numberOfDiscounts) should be (discountPrice * numberOfDiscounts)
  }
}
