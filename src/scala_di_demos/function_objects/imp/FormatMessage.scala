package scala_di_demos.function_objects.imp

trait FormatMessage {
  def apply(basket: String, price: Int): String
}
