package scala_di_demos.partial_application.imp

object ItemPricer {
  val priceAs: PartialFunction[(Char, Int), Int] = {
    case ('A', c) => c / 3 * 120 + c % 3 * 50
  }
  val priceBs: PartialFunction[(Char, Int), Int] = {
    case ('B', c) => c / 2 * 45 + c % 2 * 30
  }
  val priceCs: PartialFunction[(Char, Int), Int] = {
    case ('C', c) => c * 20
  }
  val priceDs: PartialFunction[(Char, Int), Int] = {
    case ('D', c) => c * 15
  }

  def price(item: Char, count: Int): Int = (priceAs orElse priceBs orElse priceCs orElse priceDs)(item, count)

}
