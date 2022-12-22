@test=Create_Booking_ID
Feature: Validate various scenarios for the POST call while creating booking ID of the Restful Booker API

  Background: User is designing the request body and hitting the request for POST call while creating booking ID
    Given User designs the request body with all required headers with all required details for POST call while creating booking ID
    When User performs the POST call for that CreateBookingID request

  Scenario: Validate the status code of the POST call while creating booking ID response
    Then validate that the response status code of the POST call while creating booking ID is "200"

  Scenario: Validate the status line message of the POST call while creating booking ID response
    Then validate that the response status line of the POST call while creating booking ID is "OK"

  Scenario: Validate the time taken for POST call while creating booking ID response
    Then validate that the time taken for response of the POST call while creating booking ID is less than "5000" milliseconds

  Scenario: Validate the content type of the POST call while creating booking ID response
    Then validate that the content type of the POST call while creating booking ID is "application/json; charset=utf-8"

  Scenario: Validate the BookingID of from response body of the POST call while creating booking ID response
    Then validate that the body of the response contains booking ID

  Scenario: Validate the checkIn and checkOut times from response body of the POST call while creating booking ID response
    Then validate that the body of the response contains checkIn and checkOut times