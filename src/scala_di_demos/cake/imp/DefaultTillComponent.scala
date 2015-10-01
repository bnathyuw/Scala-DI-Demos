package scala_di_demos.cake.imp

trait DefaultTillComponent {
  this: BasketPricerComponent with MessageCreatorComponent =>

  def till = new {
    def checkOut(basket: String): String = {
      val price = basketPricer.price(basket)
      messageCreator.create(basket, price)
      "Your basket containing ABCD costs £115.00"
    }
  }
}
