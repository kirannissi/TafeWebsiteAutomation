@all
Feature: Test to verify global search

  Scenario Outline: User search for a product to view details
    Given I navigate to tafe website
    And I click on search button on right top corner
    Then I enter course name as <skill> and click enter
    Then I validate the results with <skill>
    Then I select a <filter>
    And I select <filter type> from the options
    Then I validate the <filter type> from results

    Examples:
      |skill                  | filter  | filter type |
      |Advanced Barista Skills| Delivery| On campus   |