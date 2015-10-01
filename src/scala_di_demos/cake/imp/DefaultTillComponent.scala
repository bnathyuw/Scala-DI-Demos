package scala_di_demos.cake.imp

trait DefaultTillComponent {
  def till = new {
    def checkOut(basket: String): String = "Your basket containing ABCD costs £115.00"
  }
}
