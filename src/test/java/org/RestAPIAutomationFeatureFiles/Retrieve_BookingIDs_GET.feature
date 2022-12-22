@test=Get_Booking_IDs
Feature: Validate various scenarios for the GET call while retrieving booking IDs of the Restful Booker API

  Background: User is trying to retrieve the information of the customer by performing GET call
    Given User is passing the ID of the customer to get their required information
    When User performs the GET call for retrieving all info

  Scenario: Validate the status code of the GET call while retrieving booking ID response
    Then validate that the response status code of the GET call while retrieving booking ID is "200"

  Scenario: Validate the status line message of the GET call while retrieving booking ID response
    Then validate that the response status line of the GET call while retrieving booking ID is "OK"

  Scenario: Validate the time taken for GET call while retrieving booking ID info
    Then validate that the time taken for response of the GET call while retrieving booking ID is less than "5000" milliseconds

  Scenario: Validate the count of Booking IDs and list out all the Booking IDs from the JSON response
    Then validate that total count of booking IDs is more than "1000" and list out all the booking IDs from response