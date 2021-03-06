Feature: Checkout system

  Scenario Outline: Items scanned at the till outputs the total cost including offers
    Given I have the following items in my shopping basket: <items>
    When my basket is scanned at the till
    Then the total is <total>
    Examples:
      | items                                | total |
      | Apple                                | £0.60 |
      | Orange                               | £0.25 |
      | Orange, Apple                        | £0.85 |
      | Apple, Apple, Orange, Apple          | £1.45 |
      | Orange, Apple, Orange, Apple, Orange | £1.10 |

