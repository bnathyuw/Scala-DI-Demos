package scala_di_demos.cake.imp

import scala.util.{Failure, Try}

trait DefaultBasketPricerComponent extends BasketPricerComponent {
  this: ItemPricerComponent =>

  override val basketPricer: BasketPricer = new BasketPricer {
    override def price(basket: String): Try[Int] = basket match {
      case "" => Failure(EmptyBasket)
      case b => b.toCharArray().groupBy(identity).map(x => itemPricer.price(x._1, x._2.length)).reduceLeft((y, x) => x.map(z => y.get + z))
    }
  }
}