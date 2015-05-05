package shoppingbasket

import shoppingbasket.Items.Item

class ShoppingBasket(items: Seq[Item]) {
  def total = {
    val itemsByType = items.groupBy(i => i)

    val prices = itemsByType map {
      case (x, xs) => x.offer.totalPriceWithOffer(x.price, xs.size).pence
    }

    Price(prices.sum)
  }
}
