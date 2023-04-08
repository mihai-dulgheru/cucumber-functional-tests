Feature: Purchase Product

  Scenario: Purchase Product
    Given Homepage of the website "https://www.vivantis.ro/"
    Then Accept cookies
    Then Click search
    Then Clear search
    Then Type "Dior"
    Then Submit search
    Then Select perfume
    Then Select quantity
    Then Add to cart
    Then Close modal
    Then Click cart
    Then Select transport
    Then Select payment
    Then Click firstname field
    Then Clear firstname field
    Then Fill firstname field
    Then Click lastname field
    Then Clear lastname field
    Then Fill lastname field
    Then Click address field
    Then Clear address field
    Then Fill address field
    Then Click area field
    Then Clear area field
    Then Fill area field
    Then Select area
    Then Click city field
    Then Clear city field
    Then Fill city field
    Then Select city
    Then Click postal code field
    Then Clear postal code field
    Then Fill postal code field
    Then Click phone field
    Then Clear phone field
    Then Fill phone field
    Then Click email field
    Then Clear email field
    Then Fill email field
    Then Click send command
