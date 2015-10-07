package scala_di_demos.partial_application.imp

object ItemPricer {
  def price: (Char, Int) => Int = {
    (item, count) => item match {
      case 'A' => 50
      case 'B' => 30
      case 'C' => 20
      case 'D' => 15
    }
  }
}
