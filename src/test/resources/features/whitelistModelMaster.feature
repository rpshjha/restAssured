@MRTMB-14236
Feature: Generic API to get Whitelist model variant.
  
  If we do not provide any model code then API should return all model variant listing or if we provide model variant then it should return only those model variant in the response.

  Scenario: Verify Model variant which is passed in the request is retured only
    Given I set auth token as header
    And I set app id 1 as header
    And I set content type as Json
    When I set resolution as "xxhdpi"
    And I set isColorsRequired as "true"
    And I set isBodyTypesRequired as "true"
    And I set isEnginTypesRequired as "true"
    And I set isTransmissionTypesRequired as "true"
    And I set isFuelTypesRequired as "true"
    And I set modelCodes as
      | SR |
      | ER |
    And I perform POST operation for whitelist model master api
    Then I should get a sucessfull response
    And I should get list of vehicles with modelCode as
      | SR |
      | ER |

  Scenario: Verify variant code which is passed in the request is retured only
    Given I set auth token as header
    And I set app id 1 as header
    When I set resolution as "xxhdpi"
    And I set isColorsRequired as "true"
    And I set isBodyTypesRequired as "true"
    And I set isEnginTypesRequired as "true"
    And I set isTransmissionTypesRequired as "true"
    And I set isFuelTypesRequired as "true"
    And I set variantCodes as
      | SRR4BZ100 |
    And I perform POST operation for whitelist model master api
    Then I should get a sucessfull response
    And I should get list of vehicles with variantCode as
      | SRR4BZ100 |
