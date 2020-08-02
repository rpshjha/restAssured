@MRTMB-14937
Feature: API to fetch dealer list by City code (city group)
  The API should return all the dealer corresponding to a city group or list of city group

  Scenario: dealer list is retured
    Given I set auth token as header
    When I set query param values as :
      | cityGroupId |
      |           1 |
    And I perform GET operation for dealer list
    Then I should get a sucessfull response
    And dealer list should be fetched by cityGroupId 1
    
