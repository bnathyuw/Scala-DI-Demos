package scala_di_demos.cake.imp

import scala.util.{Success, Try}

trait DefaultMessageCreatorComponent extends MessageCreatorComponent{
  def messageCreator: MessageCreator = new MessageCreator {
    override def create(basket: String, price: Try[Int]): String = (basket, price) match {
      case (basket, Success(price)) => f"Your basket containing $basket%s costs £$price%2.2f"
      case _ => "Foo bar baz"
    }
  }
}
