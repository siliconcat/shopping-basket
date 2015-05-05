package shoppingbasket

import org.scalatest.{Matchers, WordSpecLike}

class PriceSpec extends WordSpecLike with Matchers {

  "pence" should {
    "return the Amount in pence" in {
      Price(67).pence should be (67)
    }
  }

  "pounds" should {
    "return the Amount in pounds" in {
      Price(67).pounds should be (0.67)
    }
  }

  "toString" should {
    "return the amount with the British Pound symbol" in {
      Price(1067).toString should be ("£10.67")
    }
  }

  "The price" can {
    "be zero" in {
      Price(0).pence should be (0)
    }

    "not be negative" in {
      intercept[IllegalArgumentException] {
        Price(-1)
      }
    }
  }
}
