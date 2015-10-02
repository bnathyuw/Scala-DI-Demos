package scala_di_demos.cocktail.test.e2e

import org.scalatest.{FlatSpec, Matchers}

import scala_di_demos.cocktail.imp.{DefaultBasketPricer, DefaultMessageCreator, Till}

class SmokeSpec extends FlatSpec with Matchers {
  "till" should "tell you what your basket costs" in {
    val till = new Till(new DefaultBasketPricer, new DefaultMessageCreator)

    val basket = "ABCD"

    till checkOut basket should be("Your basket containing ABCD costs £115.00")
  }

}