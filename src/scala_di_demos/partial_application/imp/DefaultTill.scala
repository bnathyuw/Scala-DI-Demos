package scala_di_demos.partial_application.imp

object DefaultTill {
  val checkOut: (String) => String = Till.checkOut(DefaultBasketPricer.price, DefaultMessageCreator.createMessage)
}