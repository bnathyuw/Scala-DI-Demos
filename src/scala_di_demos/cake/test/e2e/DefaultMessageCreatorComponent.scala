package scala_di_demos.cake.test.e2e

import scala_di_demos.cake.imp.MessageCreatorComponent

trait DefaultMessageCreatorComponent extends MessageCreatorComponent{
  def messageCreator: MessageCreator = new MessageCreator {
    override def create(basket: String, price: Int): String = f"Your basket containing $basket%s costs £$price%2.2f"
  }
}
