Feature: Search and Place Order for Products

  @SearchProduct
  Scenario Outline: Search experience for product search in both home and offers page
    Given User is on GreenCart landing page
    When User searches with <Name> and extracted actual name of product
    Then User searches for <Name> on offers page to check if product exists
    And Validate if product name in offers page matches with landing page
    Examples:
      | Name |
      | Tom  |
      | Beet |

