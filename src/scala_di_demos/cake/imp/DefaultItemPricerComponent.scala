package scala_di_demos.cake.imp

import scala.util.{Failure, Success, Try}

trait DefaultItemPricerComponent extends ItemPricerComponent {
  override val itemPricer = new ItemPricer {
    override def price(item: Char, count: Int): Try[Int] =  (item, count) match {
      case ('A', count) => Success(50 * count)
      case ('B', count) => Success(30 * count)
      case ('C', count) => Success(20 * count)
      case ('D', count) => Success(15 * count)
      case (item, _) => Failure(UnknownItem(item))
    }
  }
}
