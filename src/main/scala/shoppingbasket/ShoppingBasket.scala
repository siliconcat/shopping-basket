package shoppingbasket

import shoppingbasket.Items.Item

class ShoppingBasket(items: Seq[Item]) {
  def total = Price(items.map(_.price.pence).sum)
}
