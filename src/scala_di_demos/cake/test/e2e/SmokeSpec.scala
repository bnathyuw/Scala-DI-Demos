package scala_di_demos.cake.test.e2e

import org.scalatest.{FlatSpec, Matchers}

class SmokeSpec extends FlatSpec with Matchers {
  "till" should "tell you what your basket costs" in {

    val basket = "ABCD"

    till checkOut basket should be("Your basket containing ABCD costs £115.00")
  }

  def till = new {
    def checkOut(basket: String): String = "Your basket containing ABCD costs £115.00"
  }

}
