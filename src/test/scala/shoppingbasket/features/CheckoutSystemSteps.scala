package shoppingbasket.features

import cucumber.api.{DataTable, PendingException}
import cucumber.api.scala.{ScalaDsl, EN}
import org.scalatest.Matchers

import scala.collection.JavaConversions._

import shoppingbasket.Items.{Apple, Orange}
import shoppingbasket.{Price, ShoppingBasket}

class CheckoutSystemSteps extends ScalaDsl with EN with Matchers {

  var shoppingBasket: ShoppingBasket = null
  var total: Price = null

  Given("""^I have the following items in my shopping basket: (.+)$"""){ (itemList: String) =>
    val items = itemList.split(", ") map {
      case "Apple" => Apple
      case "Orange" => Orange
    }
    shoppingBasket = new ShoppingBasket(items)
  }

  When("""^my basket is scanned at the till$"""){ () =>
    total = shoppingBasket.total
  }

  Then("""^the total is (.+)$"""){ (expectedTotal: String) =>
    total.toString should be (expectedTotal)
  }

}
