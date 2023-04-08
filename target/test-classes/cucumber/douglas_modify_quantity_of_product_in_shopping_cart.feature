Feature: Modify quantity of product in shopping cart

  Background:
    Given Internet connection
    And Google Chrome Version "111.0.5563.146"
    And At least one product in the shopping cart

  Scenario Outline: Modify quantity of product in shopping cart
    When Click on the "Shopping cart" button
    And Click on the "View shopping cart" link
    And Click on the "Quantity" select box
    And Select the option "<quantity>"
    Then The quantity of the product in the shopping cart has been modified

    Examples:
      | quantity |
      | 2        |
