package scala_di_demos.function_objects.test.unit

import org.scalatest.{Matchers, FlatSpec}

import scala_di_demos.function_objects.imp.DefaultPriceItems

class DefaultPriceItemsSpec extends FlatSpec with Matchers {
  val priceItems = new DefaultPriceItems

  "price items" should "price one A" in {
    priceItems('A', 1) should be(50)
  }

  it should "price three As" in {
    priceItems('A', 3) should be(120)
  }

  it should "price eight As" in {
    priceItems('A', 8) should be(340)
  }

  it should "price one B" in {
    priceItems('B', 1) should be(30)
  }

  it should "price two Bs" in {
    priceItems('B', 2) should be (45)
  }

  it should "price five Bs" in {
    priceItems('B', 5) should be(120)
  }

  it should "price five Cs" in {
    priceItems('C', 5) should be(100)
  }

  it should "price five Ds" in {
    priceItems('D', 5) should be(75)
  }
}
