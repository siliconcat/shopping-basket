package shoppingbasket

import org.scalatest.{Matchers, WordSpecLike}
import shoppingbasket.Items.{Orange, Apple}

class ItemsSpec extends WordSpecLike with Matchers {

  "An apple" should {
    "cost 60p" in {
      Apple.price should be (Price(60))
    }
  }

  "An orange" should {
    "cost 25p" in {
      Orange.price should be (Price(25))
    }
  }




}
