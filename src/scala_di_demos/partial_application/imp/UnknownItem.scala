package scala_di_demos.partial_application.imp

object UnknownItem {
  def unapply(unknownItem: UnknownItem): Option[Char] = Some(unknownItem.item)
}

class UnknownItem(val item: Char) extends scala.RuntimeException {

}