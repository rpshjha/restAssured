@MRTMB-13600
Feature: Vehicle Category

  Background: Hit GET Api for Vehicle Category
    Given I perform GET operation for vehicle category
    Then I should get a sucessfull response

  Scenario: vehicle category is retured
    And I should see category name and id

  Scenario: tenure start and tenure end should be fetched correctly
    And I should see tenure start and tenure end
    And tenure start and tenure end should be correctly mapped to DB
