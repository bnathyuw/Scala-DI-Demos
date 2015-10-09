package scala_di_demos.partial_application.imp

import scala.util.{Failure, Success, Try}

object Till {
  def checkOut(getPrice: String => Try[Int], createMessage: (String, Int) => String)(basket: String): String = {
    getPrice(basket) match {
      case Success(price) => createMessage(basket, price)
      case Failure(UnknownItem(item)) => f"Unexpected item in bagging area: $item"
    }
  }
}