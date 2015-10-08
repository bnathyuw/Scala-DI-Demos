package scala_di_demos.partial_application.imp

object BasketPricer {
  def price(priceRules: PartialFunction[(Char, Int), Int]*)(basket: String): Int = {
    val getPrice = priceRules.reduceLeft(_ orElse _)
    basket.toSeq
    .groupBy(identity)
    .map(x => getPrice(x._1, x._2.length))
    .sum
  }
}
