Feature: Checkout system

  Scenario Outline: Items scanned at the till outputs the total cost
    Given I have the following items in my shopping basket: <items>
    When my basket is scanned at the till
    Then the total is <total>
    Examples:
      | items                       | total |
      | Apple                       | £0.60 |
      | Orange                      | £0.25 |
      | Orange, Apple               | £0.85 |
      | Apple, Apple, Orange, Apple | £2.05 |

