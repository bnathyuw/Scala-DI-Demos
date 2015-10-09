package scala_di_demos.partial_application.imp

object DefaultBasketPricer {
  val price: (String) => Int = BasketPricer.price(DefaultItemPricer.price)
}
