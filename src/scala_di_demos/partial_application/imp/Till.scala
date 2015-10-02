package scala_di_demos.partial_application.imp

object Till {
  def checkOut(getPrice: String => Int, createMessage: (String, Int) => String)(basket: String): String = {
    createMessage(basket, getPrice(basket))
  }
}
