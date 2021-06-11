Feature: Verify BlazeDemo Functionality

  @BlazeDemoTest
  Scenario: TravelUITest - Verify Booking confirmation
   Given user navigates to the BlazeDemo URL
   And user books the flight
   And user fills the details
   Then user validates confirmation Id


