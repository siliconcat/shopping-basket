package shoppingbasket

import org.scalatest.{Matchers, WordSpecLike}

class OffersSpec extends WordSpecLike with Matchers {

  import Offers._

  "The 'buy one get one free' offer" should {
    "not apply if only one item that applies exists" in {
      BuyOneGetOneFree.totalPriceWithOffer(Price(10), 1) should be (Price(10))
    }

    "be the cost of one item if two exist" in {
      BuyOneGetOneFree.totalPriceWithOffer(Price(10), 2) should be (Price(10))
    }

    "add the full price of a third item on top of the discounted two" in {
      BuyOneGetOneFree.totalPriceWithOffer(Price(10), 3) should be (Price(20))
    }

    "apply the discount for multiple items, in pairs" in {
      BuyOneGetOneFree.totalPriceWithOffer(Price(10), 4) should be (Price(20))
      BuyOneGetOneFree.totalPriceWithOffer(Price(10), 80) should be (Price(400))
    }
  }

  "The 'three for the price of two' offer" should {
    "not apply if less than three items exist" in {
      ThreeForThePriceOfTwo.totalPriceWithOffer(Price(10), 1) should be (Price(10))
      ThreeForThePriceOfTwo.totalPriceWithOffer(Price(10), 2) should be (Price(20))
    }

    "be the cost of two if three items exist" in {
      ThreeForThePriceOfTwo.totalPriceWithOffer(Price(10), 3) should be (Price(20))
    }

    "add the full price of a fourth and fifth items on top of the discount" in {
      ThreeForThePriceOfTwo.totalPriceWithOffer(Price(10), 4) should be (Price(30))
      ThreeForThePriceOfTwo.totalPriceWithOffer(Price(10), 5) should be (Price(40))
    }

    "apply the discount for multiple sets of three" in {
      ThreeForThePriceOfTwo.totalPriceWithOffer(Price(10), 6) should be (Price(40))
      ThreeForThePriceOfTwo.totalPriceWithOffer(Price(10), 90) should be (Price(600))
    }
  }

}
