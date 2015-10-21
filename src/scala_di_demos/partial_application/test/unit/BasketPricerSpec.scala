package scala_di_demos.partial_application.test.unit

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

import scala.util.{Success, Try}
import scala_di_demos.partial_application.imp.{PriceRule, BasketPricer}

class BasketPricerSpec extends FlatSpec with Matchers with BeforeAndAfter {
  var actualCalls: List[(Char, Int)] = Nil
  var result: Try[Int] = _

  def getPrice: PriceRule = {
    case (item, count) =>
      actualCalls = actualCalls :+(item, count)
      Success(count)
  }

  before {
    result = BasketPricer.price(getPrice)("ABCABA")
  }

  "pricing a basket with three As, two Bs and a C" should "get the price of three As" in {
    actualCalls should contain(('A', 3))
  }

  it should "get the price of two Bs" in {
    actualCalls should contain(('B', 2))
  }

  it should "get the price of one C" in {
    actualCalls should contain(('C', 1))
  }

  it should "return the sum of the amounts returned" in {
    result should be(Success(6))
  }
}