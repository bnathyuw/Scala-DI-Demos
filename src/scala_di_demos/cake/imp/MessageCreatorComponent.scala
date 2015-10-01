package scala_di_demos.cake.imp

trait MessageCreatorComponent{
  def messageCreator: MessageCreator

  trait MessageCreator {
    def create(basket: String, price: Int): String
  }
}
