package scala_di_demos.function_objects.imp

trait PriceItems {
  def apply(item: Char, count: Int): Int
}
