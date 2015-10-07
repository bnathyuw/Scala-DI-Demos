package scala_di_demos.partial_application.test.unit

import org.scalatest.{FlatSpec, Matchers}

import scala_di_demos.partial_application.imp.ItemPricer

class ItemPricerSpec extends FlatSpec with Matchers {
  "item pricer" should "price one A correctly" in {
    ItemPricer.price('A', 1) should be(50)
  }

  it should "price two As correctly" in {
    ItemPricer.price('A', 2) should be(100)
  }

  it should "price three As correctly" in {
    ItemPricer.price('A', 3) should be(120)
  }

  it should "price one B correctly" in {
    ItemPricer.price('B', 1) should be(30)
  }

  it should "price two Bs correctly" in {
    ItemPricer.price('B', 2) should be (45)
  }

  it should "price one C correctly" in {
    ItemPricer.price('C', 1) should be(20)
  }

  it should "price three Cs correctly" in {
    ItemPricer.price('C', 3) should be(60)
  }

  it should "price one D correctly" in {
    ItemPricer.price('D', 1) should be(15)
  }

  it should "price four Ds correctly" in {
    ItemPricer.price('D', 4) should be(60)
  }
}
