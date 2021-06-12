Feature: Verify BlazeDemo Functionality

  @BlazeDemoTest
  Scenario: TravelUITest - Verify Booking confirmation
   Given user navigates to the BlazeDemo URL
   And user books the flight
   And user fills the details
   Then user validates confirmation Id


  @APITest
  Scenario: APITest - Verify SpaceX
    Given user hits the get spaceX to check status code
    Then user hits the get spaceX to check payload
    Then user hits the get spaceX to get cores and ships


