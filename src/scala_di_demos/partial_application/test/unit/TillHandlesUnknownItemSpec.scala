package scala_di_demos.partial_application.test.unit

import org.scalatest.{FlatSpec, Matchers}

import scala.util.{Failure, Try}
import scala_di_demos.partial_application.imp.{Till, UnknownItem}

class TillHandlesUnknownItemSpec extends FlatSpec with Matchers {
  def price(basket: String): Try[Int] = Failure(new UnknownItem('Z'))

  def create(basket: String, price: Int): String = ""

  "check out" should "give a helpful error message" in {
    val checkOut = Till.checkOut(price, create)(_)
    val message = checkOut("ABCD")

    message should be ("Unexpected item in bagging area: Z")
  }
}


