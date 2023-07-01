@all
Feature: Test to verify global search

  Scenario Outline: User search for a product to view details
    Given I navigate to tafe website
    And I click on search button on right top corner
    Then I enter course name as <skill> and click enter
    Then I verify Results have relevant skills
    Then I click on delivery filter
    And select "oncampus" from the options
    Then I have seen deivery as "oncampus" from results

  Examples:
    |skill|
    |Advanced Barista skills|