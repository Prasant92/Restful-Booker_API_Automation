@test=Health_Check
Feature: Validate various scenarios for the Health check of the Restful Booker API

  Background: User is designing the request body and hitting the request for GET call while performing Health Check
    Given User designs the request body with all required headers with all required details
    When User performs the GET call for that Health check request

    Scenario: Validate the status code of the response
      Then validate that the response status code is "201"

    Scenario: Validate the status line message of the response
      Then validate that the response status line is "CREATED"

    Scenario: Validate the time taken for response
      Then validate that the time taken for response is less than "5000" milliseconds

    Scenario: Validate the content type of the response
      Then validate that the content type of the response is "text/plain; charset=utf-8"

    Scenario: Validate the response body of the response
      Then validate that the body of the response is "Created"