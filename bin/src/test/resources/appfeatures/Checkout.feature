@all @regression
Feature: Test to verify global search

  Scenario Outline: User search for a product to view details
    Given I navigate to web shop website
    And I open the product category as specified in test case id <id>
    Then I validate the product category page
    When I add a product to cart as per the test data
    Then I validate the cart information
    And I agree with the terms and conditions
    Then I checkout as a guest user
    And I enter checkout information
    When I confirm the order details
    Then I submit the order
    And I validate the successful order submission

    Examples:
    |   id   |
    | WSCOT1 |
    | WSCOT2 |
    | WSCOT3 |
    | WSCOT4 |