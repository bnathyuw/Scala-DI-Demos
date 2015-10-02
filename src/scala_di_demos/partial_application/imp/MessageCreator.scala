package scala_di_demos.partial_application.imp

object MessageCreator {
  def createMessage(basket: String, price: Int): String = f"Your basket containing $basket%s costs £$price%2.2f"
}
