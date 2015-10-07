package scala_di_demos.partial_application.imp

object ItemPricer {
  private def discountPrice(item: Char, itemPrice:Int, discountCount: Int, discountPrice: Int): PartialFunction[(Char, Int), Int] = {
    case(`item`, count) => count / discountCount * discountPrice + count % discountCount * itemPrice
  }

  private def simplePrice(item: Char, itemPrice: Int): PartialFunction[(Char, Int), Int] = {
    case(`item`, count) => count * itemPrice
  }

  private val rules: PartialFunction[(Char, Int), Int] = discountPrice('A', 50, 3, 120) orElse discountPrice('B', 30, 2, 45) orElse simplePrice('C', 20) orElse simplePrice('D', 15)

  def price(item: Char, count: Int): Int = rules(item, count)

}
