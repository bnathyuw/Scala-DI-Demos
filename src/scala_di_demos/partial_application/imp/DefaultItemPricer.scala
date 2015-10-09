package scala_di_demos.partial_application.imp

object DefaultItemPricer {
  private val ruleForA: PriceRule = ItemPricer.discountPrice('A', 50, 3, 120)
  private val ruleForB: PriceRule = ItemPricer.discountPrice('B', 30, 2, 45)
  private val ruleForC: PriceRule = ItemPricer.simplePrice('C', 20)
  private val ruleForD: PriceRule = ItemPricer.simplePrice('D', 15)
  private val defaultRule: PriceRule = ItemPricer.unknownItem
  val price: PriceRule = ruleForA orElse ruleForB orElse ruleForC orElse ruleForD orElse defaultRule
}
