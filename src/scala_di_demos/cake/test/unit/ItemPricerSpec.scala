package scala_di_demos.cake.test.unit

import org.scalatest.{FlatSpec, Matchers}

import scala.util.{Failure, Success}
import scala_di_demos.cake.imp.{UnknownItem, DefaultItemPricerComponent}

class ItemPricerSpec extends FlatSpec with Matchers with DefaultItemPricerComponent {
  "item pricer" should "price an A correctly" in {
    itemPricer price('A', 1) should be(Success(50))
  }

  it should "price two Bs correctly" in {
    itemPricer price('B', 2) should be(Success(60))
  }

  it should "price three Cs correctly" in {
    itemPricer price('C', 3) should be(Success(60))
  }

  it should "price four Ds correctly" in {
    itemPricer price('D', 4) should be(Success(60))
  }

  it should "fail for an unknown item" in {
    itemPricer price('E', 5) should be(Failure(UnknownItem('E')))
  }
}
