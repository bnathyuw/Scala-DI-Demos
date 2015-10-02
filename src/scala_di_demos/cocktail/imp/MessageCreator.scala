package scala_di_demos.cocktail.imp

trait MessageCreator {
  def create(basket: String, price: Int): String
}
