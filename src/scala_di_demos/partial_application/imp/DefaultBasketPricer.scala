package scala_di_demos.partial_application.imp

import scala.util.Try

object DefaultBasketPricer {
  val price: (String) => Try[Int] = BasketPricer.price(DefaultItemPricer.price)
}
