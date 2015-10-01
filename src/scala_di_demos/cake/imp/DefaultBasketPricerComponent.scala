package scala_di_demos.cake.imp

trait DefaultBasketPricerComponent extends BasketPricerComponent {
  override def basketPricer: BasketPricer = new BasketPricer {
    override def price(basket: String): Int = 115
  }
}
