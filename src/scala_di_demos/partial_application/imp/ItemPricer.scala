package scala_di_demos.partial_application.imp

object ItemPricer {
  def discountPrice(item: Char, itemPrice:Int, discountCount: Int, discountPrice: Int): PartialFunction[(Char, Int), Int] = {
    case(`item`, count) => count / discountCount * discountPrice + count % discountCount * itemPrice
  }

  def simplePrice(item: Char, itemPrice: Int): PartialFunction[(Char, Int), Int] = {
    case(`item`, count) => count * itemPrice
  }
}
