@test=Modify_Booking_ID_PUT
Feature: Validate various scenarios for the PUT call while modifying existing booking info of the Restful Booker API

  Background: User is trying to retrieve the information of the customer by performing GET call
    Given User is passing the ID of the customer to get their required information
    When User performs the GET call for that "<GetBookingID>" info
    Then validate that the response status code of the GET call while retrieving booking ID is "200"
    Given User is passing the ID of the customer to modify their required information


  Scenario Outline: Validate the status code of the GET and PUT calls while retrieving booking ID response
    Then User runs the modified request body at specified "<Path>" for PUT call for same "<GetBookingID>" booking ID
    And validate that the response status code of the PUT call while retrieving booking ID is "200"
    Examples:
      |Path|GetBookingID|
      |src/main/resources/BookingID_Creation_PUT_ReqBody_For_Dates.json|400|
      |src/main/resources/BookingID_Creation_PUT_ReqBody_For_AdditionalNeeds.json|500|
      |src/main/resources/BookingID_Creation_PUT_ReqBody_For_TotalPrice.json|111|
      |src/main/resources/BookingID_Creation_PUT_ReqBody_For_TotalPrice.json|5|

  Scenario Outline: Validate the status code of the GET and PUT calls while retrieving booking ID response
    Then User runs the modified request body at specified "<Path>" for PUT call for same "<GetBookingID>" booking ID
    And validate that the response status line of the PUT call while modifying booking ID is "OK"
    Examples:
      |Path|GetBookingID|
      |src/main/resources/BookingID_Creation_PUT_ReqBody_For_Dates.json|400|
      |src/main/resources/BookingID_Creation_PUT_ReqBody_For_AdditionalNeeds.json|500|
      |src/main/resources/BookingID_Creation_PUT_ReqBody_For_TotalPrice.json|111|
      |src/main/resources/BookingID_Creation_PUT_ReqBody_For_TotalPrice.json|5|

  Scenario Outline: Validate the status code of the GET and PUT calls while retrieving booking ID response
    Then User runs the modified request body at specified "<Path>" for PUT call for same "<GetBookingID>" booking ID
    And validate that the time taken for response of the PUT call while modifying booking ID is less than "5000" milliseconds
    Examples:
      |Path|GetBookingID|
      |src/main/resources/BookingID_Creation_PUT_ReqBody_For_Dates.json|400|
      |src/main/resources/BookingID_Creation_PUT_ReqBody_For_AdditionalNeeds.json|500|
      |src/main/resources/BookingID_Creation_PUT_ReqBody_For_TotalPrice.json|111|
      |src/main/resources/BookingID_Creation_PUT_ReqBody_For_TotalPrice.json|5|

  Scenario Outline: Validate the status code of the GET and PUT calls based on modified names while retrieving booking ID response
    Then User runs the serialized modified request body with changed "<Firstname>" and "<Lastname>" for PUT call for same "<GetBookingID>" booking ID
    And validate that the response status code of the PUT call while retrieving booking ID is "200"
    And validate that the response status line of the PUT call while modifying booking ID is "OK"
    And validate that the time taken for response of the PUT call while modifying booking ID is less than "5000" milliseconds
    Examples:
      |Firstname|Lastname|GetBookingID|
      |Dane_Test|Liu_Test|400|
      |Dane     |Liu     |400|

  Scenario Outline: Validate the status code of the GET and PUT calls based on modified names while retrieving booking ID response
    Then User runs the serialized modified request body with changed dates "<checkInDate>" and "<checkOutDate>" for PUT call for same "<GetBookingID>" booking ID
    And validate that the response status code of the PUT call while retrieving booking ID is "200"
    And validate that the response status line of the PUT call while modifying booking ID is "OK"
    And validate that the time taken for response of the PUT call while modifying booking ID is less than "5000" milliseconds
    Examples:
      |checkInDate|checkOutDate|GetBookingID|
      |2014-11-11|2015-11-11|400|
      |2018-10-11|2019-11-11|400|
