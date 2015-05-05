package shoppingbasket

import org.scalatest.{Matchers, WordSpecLike}

class ShoppingBasketSpec extends WordSpecLike with Matchers {

  import Items._

  "The shopping basket total" should {
    "be the price of the items presented one at a time" in {
      new ShoppingBasket(Seq(Apple, Orange)).total should be (Price(85))
      new ShoppingBasket(Seq(Apple, Orange, Orange)).total should be (Price(110))
    }

    "include any offers" should {
      new ShoppingBasket(Seq(Apple, Apple, Orange)).total should be (Price(85))
      new ShoppingBasket(Seq(Apple, Orange, Orange, Orange)).total should be (Price(110))
    }

    "be zero if there are no items" in {
      new ShoppingBasket(Seq.empty).total should be (Price(0))
    }
  }

}
