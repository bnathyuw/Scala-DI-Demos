package scala_di_demos.partial_application.imp

object ItemPricer {
  def price: (Char, Int) => Int = {
    (item, count) => item match {
      case 'A' => count / 3 * 120 + count % 3 * 50
      case 'B' => count / 2 * 45 + count % 2 * 30
      case 'C' => count * 20
      case 'D' => count * 15
    }
  }
}
