@MRTMB-14252 @carListing @MRTMB-13599
Feature: Vehicle List

  Background: 
    Given I set auth token as header
    And I set content type as Json
    And I set app id 4 as header

@sort
  Scenario: vehicle price should be sorted in ascending order
    #And I set correlation id 88269639491 as header
    And I set body parameters as "{\"filter\":{\"cityId\":1,\"tenureId\":4,\"resolution\":\"xxhdpi\",\"isNew\":true},\"sort\":{\"price\":\"ASC\"}}"
    Given I perform POST operation for vehicle list
    Then I should get a sucessfull response
    And I should get list of vehicles
    And price of vehicle should be sorted in ascending order

  Scenario: vehicle price should be sorted in descending order
    #And I set correlation id 88269639491 as header
    And I set body parameters as "{\"filter\":{\"cityId\":1,\"tenureId\":4,\"resolution\":\"xxhdpi\",\"isNew\":true},\"sort\":{\"price\":\"DESC\"}}"
    Given I perform POST operation for vehicle list
    Then I should get a sucessfull response
    And I should get list of vehicles
    And price of vehicle should be sorted in descending order

  Scenario: Verify Only New Vehicle list should be retured if isNew is passed as true
    And I set body parameters as "{\"filter\":{\"cityId\":1,\"tenureId\":4,\"resolution\":\"xxhdpi\",\"isNew\":true}}"
    Given I perform POST operation for vehicle list
    Then I should get a sucessfull response
    And I should get list of vehicles
    And vehicle list should be of new type

  Scenario: Verify Only Old Vehicle list should be retured if isNew is passed as false
    And I set body parameters as "{\"filter\":{\"cityId\":1,\"tenureId\":4,\"resolution\":\"xxhdpi\",\"isNew\":false}}"
    Given I perform POST operation for vehicle list
    Then I should get a sucessfull response
    And I should get list of vehicles
    And vehicle list should be of used type

  Scenario Outline: Verify Only model code which is requested should be returned
    When I set Vehicle type as "new"
    And I set model code <modelCode> as filter
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And I should only get list of vehicles having model code as <modelCode>

    Examples: 
      | modelCode |
      | "SR"      |
      | "ER"      |
      | "DR"      |

  Scenario Outline: Verify Only variant code which is requested should be returned
    When I set Vehicle type as "new"
    And I set variant code <variantCode> as filter
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And I should only get list of vehicles having variant code as <variantCode>

    Examples: 
      | variantCode |
      | "SRR4BV1"   |
      | "ERR4BV1"   |
      | "DRR4BV1"   |

  Scenario Outline: Verify Only bodyType which is requested should be returned
    When I set Vehicle type as "new"
    And I set bodyType <bodyType> as filter
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And I should only get list of vehicles having body type as <bodyType>

    Examples: 
      | bodyType    |
      | "HATCHBACK" |
      | "SEDAN"     |
      | "MUV"       |

  Scenario Outline: Verify Only RegistrationType which is requested should be returned
    When I set Vehicle type as "new"
    And I set registrationType <registration_type> as filter
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And I should only get list of vehicles having registration type as <registration_type>

    Examples: 
      | registration_type |
      | "BLACK"           |

  Scenario Outline: Verify Only channelType  which is requested should be returned
    When I set Vehicle type as "new"
    And I set channelType <channel_type> as filter
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And I should only get list of vehicles having channel type as <channel_type>

    Examples: 
      | channel_type |
      | "NRE"        |

  Scenario Outline: Verify Only color code which is requested should be returned
    When I set Vehicle type as "new"
    And I set color code <color> as filter
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And I should only get list of vehicles having color code as <color>

    Examples: 
      | color |
      | "Z7Q" |

  Scenario: discount is returned as mentioned in the DB
    When I set Vehicle type as "new"
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And I should get discount as stored in DB

  Scenario: price is returned as mentioned in the DB
    When I set Vehicle type as "new"
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And I should get price as stored in DB


  Scenario: Verify vehicle image url is correct for new vehicle
    When I set Vehicle type as "new"
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And I should get list of vehicle image

  Scenario: Verify vehicle image url is correct for used vehicle
    When I set Vehicle type as "used"
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And I should get list of vehicle image

  Scenario: Verify vehicle registration type is correct for used vehicle
    When I set Vehicle type as "used"
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And registration Type should be fetched from DB

  Scenario: Verify vehicle registration type is correct for new vehicle
    When I set Vehicle type as "new"
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And registration Type should be fetched from DB

  Scenario: Verify vehicle channel type is correct for used vehicle
    When I set Vehicle type as "used"
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And channel Type should be fetched from DB

  Scenario: Verify vehicle channel type is correct for new vehicle
    When I set Vehicle type as "new"
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And channel Type should be fetched from DB

  Scenario: Verify body type is fetched from DB for used vehicle
    When I set Vehicle type as "used"
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And body Type should be fetched from DB


  Scenario: Verify body type is fetched from DB for new vehicle
    When I set Vehicle type as "new"
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And body Type should be fetched from DB

  Scenario: Verify fuel type is fetched from DB for used vehicle
    When I set Vehicle type as "used"
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And fuel Type should be fetched from DB

  Scenario: Verify fuel type is fetched from DB for new vehicle
    When I set Vehicle type as "new"
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And fuel Type should be fetched from DB

  Scenario: Verify transmission type is fetched from DB for used vehicle
    When I set Vehicle type as "used"
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And transmission Type should be fetched from DB

  Scenario: Verify transmission type is fetched from DB for new vehicle
    When I set Vehicle type as "new"
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And transmission Type should be fetched from DB

  Scenario: Verify color image url is correct for new vehicle
    When I set Vehicle type as "new"
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And I should get list of color image

  Scenario: Verify color image url is correct for used vehicle
    When I set Vehicle type as "used"
    Given I perform POST operation for vehicle list with mandatory body
    Then I should get a sucessfull response
    And I should get list of color image
