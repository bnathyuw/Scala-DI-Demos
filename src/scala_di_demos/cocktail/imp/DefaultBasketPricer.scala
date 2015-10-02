package scala_di_demos.cocktail.imp

class DefaultBasketPricer extends BasketPricer {
  override def price(basket: String): Int = 115
}
