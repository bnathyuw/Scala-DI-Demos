package scala_di_demos.partial_application.imp

object DefaultTill {
  def checkOut: (String) => String = {
    val ruleForA: PriceRule = ItemPricer.discountPrice('A', 50, 3, 120)
    val ruleForB: PriceRule = ItemPricer.discountPrice('B', 30, 2, 45)
    val ruleForC: PriceRule = ItemPricer.simplePrice('C', 20)
    val ruleForD: PriceRule = ItemPricer.simplePrice('D', 15)
    val priceBasket: (String) => Int = BasketPricer.price(ruleForA, ruleForB, ruleForC, ruleForD, ItemPricer.unknownItem)
    val createMessage: (String, Int) => String = MessageCreator.createMessage _
    Till.checkOut(priceBasket, createMessage)(_)
  }
}