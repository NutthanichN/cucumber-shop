Feature: Buy products
    As a customer
    I want to buy products

Background:
    Given 5 of product Bread with price 20.50 exists
    And 1 of product Jam with price 80.00 exists

Scenario: Buy one product
    When I buy Bread with quantity 2
    Then total should be 41.00

Scenario: Buy multiple products
    When I buy Bread with quantity 2
    And I buy Jam with quantity 1
    Then total should be 121.00

Scenario: Buy product with a maximum quantity in stock
    When I buy Bread with quantity 5
    Then total should be 102.5
