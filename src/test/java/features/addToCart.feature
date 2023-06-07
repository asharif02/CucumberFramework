Feature: Searching for a product, changing quantity, adding to cart, proceed to checkout

  @AddToCart
  Scenario Outline: Adding product to cart
    Given User is on GreenCart landing page
    When User searches with <Name> and extracted actual name of product
    And User adds three to the quantity
    And User clicks add to cart button
    And User clicks cart icon located in the top right corner
    And User clicks the proceed to checkout button
    Then User is navigated to the checkout page
    And User validates if product name matches product in the cart
    Examples:
      | Name  |
      | Tom   |