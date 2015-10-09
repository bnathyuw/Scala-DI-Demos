package scala_di_demos.partial_application

import scala.util.Try

package object imp {
  type PriceRule = PartialFunction[(Char, Int), Try[Int]]
}

