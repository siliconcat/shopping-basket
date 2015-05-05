package shoppingbasket

trait Offer {
  def totalPriceWithOffer(price: Price, count: Int): Price
}

object Offers {
  val BuyOneGetOneFree = new Offer {
    override def totalPriceWithOffer(price: Price, count: Int) = Price(
      ((count / 2) + (count % 2)) * price.pence
    )
  }

  val ThreeForThePriceOfTwo = new Offer {
    override def totalPriceWithOffer(price: Price, count: Int) = Price(
      ((count / 3) * (price.pence * 2)) + ((count % 3) * price.pence)
    )
  }
}
