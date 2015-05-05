package shoppingbasket

import java.text.NumberFormat
import java.util.Locale

case class Price(pence: Long) {
  require(pence >= 0)

  def pounds: BigDecimal = BigDecimal(pence) / 100

  override def toString = NumberFormat.getCurrencyInstance(Locale.UK).format(pounds)
}