package scala_di_demos.cake.imp

import scala.util.Try

trait BasketPricerComponent {
  def basketPricer: BasketPricer

  trait BasketPricer {
    def price(basket: String): Try[Int]
  }
}
