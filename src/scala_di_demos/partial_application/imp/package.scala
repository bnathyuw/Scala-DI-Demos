package scala_di_demos.partial_application

package object imp {
  type PriceRule = PartialFunction[(Char, Int), Int]
}

