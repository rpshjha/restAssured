@MRTMB-14280
Feature: Generic API to provide all possible values for model_code, variant_code, Body_Type, Color , Channel_ID.
  
  As an architect I want enhancement in existing vehicle listing for model_code, variant_code, Body_Type, Channel_ID.

  Scenario: verify vehicle attribute is retured
    Given I set auth token as header
    And I set content type as Json
    When I set query param values as :
      | model | variant | color | bodyType | channelType | registrationType | transmissionType |
      | true  | true    | true  | true     | true        | true             | true             |
    When I perform GET operation for vehicle attributes master
    Then I should get a sucessfull response

  Scenario: Verify Error Code should be returned if any of the query param is missing
    Given I set auth token as header
    And I set content type as Json
    When I set query param values as :
      | model | variant | color | bodyType | channelType | registrationType |
      | true  | true    | true  | true     | true        | true             |
    When I perform GET operation for vehicle attributes master
    Then I should get error code as All required values must be provided

  Scenario: verify if all parameters are kept as false then data returned should be null
    Given I set auth token as header
    And I set content type as Json
    When I set query param values as :
      | model | variant | color | bodyType | channelType | registrationType | transmissionType |
      | false | false   | false | false    | false       | false            | false            |
    When I perform GET operation for vehicle attributes master
    Then I should get a sucessfull response
    And I should get model as null
    And I should get variant as null
    And I should get color as null
    And I should get body type as null
    And I should get channel type as null
    And I should get transmission type as null

  Scenario: verify if model value is true then valid value is returned
    Given I set auth token as header
    And I set content type as Json
    When I set query param values as :
      | model | variant | color | bodyType | channelType | registrationType | transmissionType |
      | true  | false   | false | false    | false       | false            | false            |
    When I perform GET operation for vehicle attributes master
    Then I should get a sucessfull response
    And I should get all the models stored in the DB
    And I should get variant as null
    And I should get color as null
    And I should get body type as null
    And I should get channel type as null
    And I should get transmission type as null

  Scenario: verify if variant value is true then valid value is returned
    Given I set auth token as header
    And I set content type as Json
    When I set query param values as :
      | model | variant | color | bodyType | channelType | registrationType | transmissionType |
      | false | true    | false | false    | false       | false            | false            |
    When I perform GET operation for vehicle attributes master
    Then I should get a sucessfull response
    And I should get model as null
    And I should get all the variant stored in the DB
    And I should get color as null
    And I should get body type as null
    And I should get channel type as null
    And I should get transmission type as null

  Scenario: verify if color value is true then valid value is returned
    Given I set auth token as header
    And I set content type as Json
    When I set query param values as :
      | model | variant | color | bodyType | channelType | registrationType | transmissionType |
      | false | false   | true  | false    | false       | false            | false            |
    When I perform GET operation for vehicle attributes master
    Then I should get a sucessfull response
    And I should get model as null
    And I should get variant as null
    And I should get all the color stored in the DB
    And I should get body type as null
    And I should get channel type as null
    And I should get transmission type as null

  Scenario: verify if body type value is true then valid value is returned
    Given I set auth token as header
    And I set content type as Json
    When I set query param values as :
      | model | variant | color | bodyType | channelType | registrationType | transmissionType |
      | false | false   | false | true     | false       | false            | false            |
    When I perform GET operation for vehicle attributes master
    Then I should get a sucessfull response
    And I should get model as null
    And I should get variant as null
    And I should get color as null
    And I should get all the body type stored in the DB
    And I should get channel type as null
    And I should get transmission type as null

  Scenario: verify if transmission value is true then valid value is returned
    Given I set auth token as header
    And I set content type as Json
    When I set query param values as :
      | model | variant | color | bodyType | channelType | registrationType | transmissionType |
      | false | false   | false | false    | false       | false            | true             |
    When I perform GET operation for vehicle attributes master
    Then I should get a sucessfull response
    And I should get model as null
    And I should get variant as null
    And I should get color as null
    And I should get body type as null
    And I should get channel type as null
    And I should get registration type as null
    And I should get all the transmission type stored in the DB
