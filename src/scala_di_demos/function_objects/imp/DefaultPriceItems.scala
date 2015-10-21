package scala_di_demos.function_objects.imp

class DefaultPriceItems extends PriceItems {
  override def apply(item: Char, count: Int): Int = (item, count) match {
    case ('A', count) => count / 3 * 120 + count % 3 * 50
    case ('B', count) => count / 2 * 45 + count % 2 * 30
    case ('C', count) => count * 20
    case ('D', count) => count * 15
  }
}
