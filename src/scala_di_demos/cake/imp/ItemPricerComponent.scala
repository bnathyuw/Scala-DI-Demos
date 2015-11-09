package scala_di_demos.cake.imp

import scala.util.Try

trait ItemPricerComponent {
  def itemPricer: ItemPricer

  trait ItemPricer{
    def price(item: Char, count: Int): Try[Int]
  }
}
