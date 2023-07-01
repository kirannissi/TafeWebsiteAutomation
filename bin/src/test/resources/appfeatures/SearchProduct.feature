@all @regression
Feature: Test to verify global search

  Scenario Outline: User search for a product to view details
    Given I navigate to web shop website
    And I search for a product as specified in test case id <id>
    Then I validate the search results
    When I open the product to view more details
    And I validate the details of the product

    Examples:
    |  id    |
    | WSSPT1 |
    | WSSPT2 |
    | WSSPT3 |
    | WSSPT4 |