package scala_di_demos.partial_application.imp

object DefaultMessageCreator {
  val createMessage: (String, Int) => String = MessageCreator.createMessage
}
