package shoppingbasket

object Items {

  sealed abstract class Item (
      val price: Price
  )

  case object Apple extends Item(Price(60))
  case object Orange extends Item(Price(25))

}