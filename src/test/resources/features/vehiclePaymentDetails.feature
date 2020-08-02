@MRTMB-13790
Feature: Vehicle Payment Details

  Scenario: Vehicle Payment Details
    When I set auth token as header
    When I set app id 1 as header
    And I set cityId as 6
    And I set tenure as 24
    And I set category id as 2
    And I give modelCode as "CI" and variantCode as "CIA4CZ100"
    And I give startDate as "05-06-2020"
    And I set isPriceRequired as "true"
    And I set isDiscountRequired as "true"
    And I set isSecurityRequired as "true"
    And I set isGSTRequired as "false"
    Given I perform POST operation for vehicle payment details
    Then I should get list of vehicles with category id as 2
   
    
    
