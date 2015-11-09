package scala_di_demos.function_objects.imp

class DefaultPriceBasket(priceItems: PriceItems) extends PriceBasket {
  override def apply(basket: String): Int = {
    basket.toSeq.groupBy(identity).map(x => priceItems(x._1, x._2.length)).sum
  }
}
