package scala_di_demos.partial_application.test.e2e

import org.scalatest.{FlatSpec, Matchers}

import scala_di_demos.partial_application.imp._

class SmokeSpec extends FlatSpec with Matchers {
  "check out" should "tell you what your basket costs" in {
    DefaultTill checkOut "ABCD" should be("Your basket containing ABCD costs £115.00")
  }

  it should "give you a helpful message if your basket contains something unexpected" in {
    DefaultTill checkOut "AB$D" should be ("Unexpected item in bagging area: $")
  }
}



