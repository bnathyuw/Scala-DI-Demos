package scala_di_demos.partial_application.imp

object BasketPricer {
  def price(getPrice: (Char, Int) => Int)(basket: String): Int = {
    basket.toSeq
    .groupBy(identity)
    .map(x => getPrice(x._1, x._2.length))
    .sum
  }
}
