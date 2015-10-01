package scala_di_demos.cake.test.e2e

import scala_di_demos.cake.imp.BasketPricerComponent

trait DefaultBasketPricerComponent extends BasketPricerComponent {
  override def basketPricer: BasketPricer = new BasketPricer {
    override def price(basket: String): Int = 115
  }
}
