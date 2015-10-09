package scala_di_demos.partial_application.imp

import scala.util.{Failure, Success}

object ItemPricer {
  def discountPrice(item: Char, itemPrice:Int, discountCount: Int, discountPrice: Int): PriceRule = {
    case(`item`, count) => Success(count / discountCount * discountPrice + count % discountCount * itemPrice)
  }

  def simplePrice(item: Char, itemPrice: Int): PriceRule = {
    case(`item`, count) => Success(count * itemPrice)
  }

  def unknownItem: PriceRule = {
    case(item, _) => Failure(new UnknownItem(item))
  }
}
