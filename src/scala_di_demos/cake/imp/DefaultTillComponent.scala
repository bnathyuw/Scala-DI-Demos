package scala_di_demos.cake.imp

trait DefaultTillComponent {
  this: BasketPricerComponent =>
  def till = new {
    def checkOut(basket: String): String = {
      basketPricer.price(basket)
      "Your basket containing ABCD costs £115.00"
    }
  }
}
