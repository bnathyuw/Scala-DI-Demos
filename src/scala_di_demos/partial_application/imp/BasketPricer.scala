package scala_di_demos.partial_application.imp

import scala.util.Try

object BasketPricer {
  def price(getPrice: PriceRule)(basket: String): Try[Int] = {
    basket.toSeq
      .groupBy(identity)
      .map(x => getPrice(x._1, x._2.length))
      .reduceLeft((y, x) => x.map(z => y.get + z))
  }
}
