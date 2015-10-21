package scala_di_demos.function_objects.imp

class DefaultCheckOut(priceBasket: PriceBasket, formatMessage: FormatMessage) {
  def apply(basket: String): String = {
    formatMessage(basket, priceBasket(basket))
  }
}
