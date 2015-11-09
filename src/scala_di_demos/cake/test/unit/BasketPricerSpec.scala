package scala_di_demos.cake.test.unit

import org.scalatest.{FlatSpec, Matchers}
import scala.util.Failure

import scala_di_demos.cake.imp.DefaultBasketPricerComponent

class BasketPricerSpec extends FlatSpec with Matchers with DefaultBasketPricerComponent {
  "basket pricer" should "fail for an empty basket" in {
    basketPricer price "" should be(Failure(EmptyBasket))
  }
}