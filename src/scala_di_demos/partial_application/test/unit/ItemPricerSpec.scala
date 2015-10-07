package scala_di_demos.partial_application.test.unit

import org.scalatest.{FlatSpec, Matchers}

import scala_di_demos.partial_application.imp.ItemPricer

class ItemPricerSpec extends FlatSpec with Matchers {
  "item pricer" should "price one A correctly" in {
    ItemPricer.price('A', 1) should be(50)
  }

  it should "price one B correctly" in {
    ItemPricer.price('B', 1) should be(30)
  }

  it should "price one C correctly" in {
    ItemPricer.price('C', 1) should be(20)
  }

  it should "price one D correctly" in {
    ItemPricer.price('D', 1) should be(15)
  }
}
