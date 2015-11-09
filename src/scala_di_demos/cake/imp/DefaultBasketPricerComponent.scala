package scala_di_demos.cake.imp

import scala.util.{Success, Try, Failure}
import scala_di_demos.cake.test.unit.EmptyBasket

trait DefaultBasketPricerComponent extends BasketPricerComponent {
  override def basketPricer: BasketPricer = new BasketPricer {
    override def price(basket: String): Try[Int] = {
      if(basket == "") Failure(EmptyBasket) else Success(115)
    }
  }
}
