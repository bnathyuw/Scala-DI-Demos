package scala_di_demos.partial_application.imp

object Till {
  def checkOut(getPrice: String => Int, createMessage: (String, Int) => String)(basket: String): String = {
    try{
    createMessage(basket, getPrice(basket))}
    catch{
      case UnknownItem(item) => f"Unexpected item in bagging area: $item"
    }
  }
}