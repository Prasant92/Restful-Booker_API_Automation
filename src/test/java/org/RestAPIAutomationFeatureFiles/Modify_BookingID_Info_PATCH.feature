@test=Modify_Booking_ID_PATCH
Feature: Validate various scenarios for the PATCH call while modifying existing booking info of the Restful Booker API

  Background: User is trying to create the BookingID of the customer by performing POST call and retrieve info using GET
    Given User designs the request body with all required headers with all required details for POST call while creating booking ID
    When User performs the POST call for that CreateBookingID request for PATCH operation
    Then validate that the body of the response contains booking ID
    Given User is passing the ID of the customer to get their required information
    When User performs the GET call for that info using BookingID received in response of POST call
    Then validate that the response status code of the GET call while retrieving booking ID is "200"
    Given User is passing the ID of the customer to modify their required information

  Scenario Outline: Validate the response parameters of the response post PATCH method call based on modified names while retrieving booking ID response
    Then User runs the serialized modified request body with changed "<Firstname>" and "<Lastname>" for PATCH call for same booking ID
    And validate that the response status code of the PATCH call while retrieving booking ID is "200"
    And validate that the response status line of the PATCH call while modifying booking ID is "OK"
    And validate that the time taken for response of the PATCH call while modifying booking ID is less than "5000" milliseconds
    Examples:
      |Firstname|Lastname|
      |Prasant_Test|Bhagavatula_Test|
      |P     |B     |

  Scenario Outline: Validate the response parameters of the response post PATCH method call based on modified dates while retrieving booking ID response
    Then User runs the serialized modified request body with changed dates "<checkInDate>" and "<checkOutDate>" for PATCH call for same booking ID
    And validate that the response status code of the PATCH call while retrieving booking ID is "200"
    And validate that the response status line of the PATCH call while modifying booking ID is "OK"
    And validate that the time taken for response of the PATCH call while modifying booking ID is less than "5000" milliseconds
    Examples:
      |checkInDate|checkOutDate|
      |2014-11-11|2015-11-11|
      |2018-10-11|2019-11-11|

  Scenario Outline: Validate the response parameters of the response post PATCH method call based on modified totalPrice, dates and additionalNeeds while retrieving booking ID response
    Then User runs the serialized modified request body with changed info "<totalPrice>", "<checkInDate>", "<checkOutDate>" and "<additionalNeeds>" for PATCH call for same booking ID
    And validate that the response status code of the PATCH call while retrieving booking ID is "200"
    And validate that the response status line of the PATCH call while modifying booking ID is "OK"
    And validate that the time taken for response of the PATCH call while modifying booking ID is less than "5000" milliseconds
    Examples:
    |totalPrice|checkInDate|checkOutDate|additionalNeeds|
    |222  |2014-11-11|2015-11-11|Additional Bed with Pillow|
    |1000  |2018-10-11|2019-11-11|4 Glasses With Jar       |