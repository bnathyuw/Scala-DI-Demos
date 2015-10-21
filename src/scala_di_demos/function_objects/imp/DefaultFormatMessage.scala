package scala_di_demos.function_objects.imp

class DefaultFormatMessage extends FormatMessage {
  override def apply(basket: String, price: Int): String = f"Your basket containing $basket%s costs £$price%2.2f"
}
