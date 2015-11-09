package scala_di_demos.cake.imp

import scala.util.Try

trait MessageCreatorComponent{
  def messageCreator: MessageCreator

  trait MessageCreator {
    def create(basket: String, price: Try[Int]): String
  }
}
