package shoppingbasket

object Items {

  import Offers._

  sealed abstract class Item (
      val price: Price,
      val offer: Offer
  )

  case object Apple extends Item(Price(60), BuyOneGetOneFree)
  case object Orange extends Item(Price(25), ThreeForThePriceOfTwo)

}