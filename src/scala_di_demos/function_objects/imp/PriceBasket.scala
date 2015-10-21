package scala_di_demos.function_objects.imp

trait PriceBasket {
  def apply(basket: String): Int
}
