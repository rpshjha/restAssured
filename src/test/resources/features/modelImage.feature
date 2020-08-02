@MRTMB-13758
Feature: Model Image

  Scenario: vehicle image is retured
    Given I set auth token as header
    And I set app id 1 as header
    When I set query param values as :
      | modelId | colorId | resolution | modelCd | variantCd |
      |     176 | ZYA     | xxxhdpi    | BA      | BAA4CZ100 |
    And I perform GET operation for model image
    Then I should get a sucessfull response
    And I should get model imageUrl which are valid
