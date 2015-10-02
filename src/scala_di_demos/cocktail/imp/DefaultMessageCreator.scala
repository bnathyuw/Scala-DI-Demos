package scala_di_demos.cocktail.imp

class DefaultMessageCreator extends MessageCreator {
  override def create(basket: String, price: Int): String = f"Your basket containing $basket%s costs £$price%2.2f"
}
