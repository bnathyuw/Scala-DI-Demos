package scala_di_demos.cocktail.imp

class Till(val basketPricer: BasketPricer, val messageCreator: MessageCreator) {
  def checkOut(basket: String): String = {
    val price = basketPricer.price(basket)
    messageCreator.create(basket, price)
  }
}
