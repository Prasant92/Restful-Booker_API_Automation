@test=Delete_Booking_ID
Feature: Validate various scenarios for the Delete call while removing booking info of the Restful Booker API

  Background: User is trying to create the BookingID of the customer by performing POST call and retrieve info using GET
    Given User designs the request body with all required headers with all required details for POST call while creating booking ID
    When User performs the POST call for that CreateBookingID request for DELETE operation
    Then validate that the body of the response contains booking ID
    Given User is passing the ID of the customer to get their required information
    When User performs the GET call for that info using BookingID received in response of POST call
    Then validate that the response status code of the GET call while retrieving booking ID is "200"
    Given User is passing the ID of the customer to modify their required information
    Then User runs the request for removing the Booking ID obtained in POST call using DELETE call

  Scenario: Validate the response code of the response post DELETE method call
    And validate that the response status code of the DELETE call while retrieving booking ID is "201"

  Scenario: Validate the response status of the response post DELETE method call
    And validate that the response status line of the DELETE call while modifying booking ID is "Created"

  Scenario: Validate the response time of the response post DELETE method call
    And validate that the time taken for response of the DELETE call while modifying booking ID is less than "5000" milliseconds