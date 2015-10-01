package scala_di_demos.cake.imp

trait BasketPricerComponent {

  def basketPricer: BasketPricer

  trait BasketPricer {

    def price(basket: String): Int
  }

}
