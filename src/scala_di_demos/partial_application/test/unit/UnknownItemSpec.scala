package scala_di_demos.partial_application.test.unit

import org.scalatest.{FlatSpec, Matchers}

import scala.util.Failure
import scala_di_demos.partial_application.imp.{ItemPricer, UnknownItem}

class UnknownItemSpec extends FlatSpec with Matchers {
  "unknown item" should "throw unknown item" in {
    val expectedItem: Char = 'Z'

    val Failure(UnknownItem(item)) = ItemPricer.unknownItem(expectedItem, 10)

    item should be(expectedItem)
  }
}
