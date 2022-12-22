@test=Get_Booking_ID
Feature: Validate various scenarios for the GET call while retrieving booking ID of the Restful Booker API

  Background: User is trying to retrieve the information of the customer by performing GET call
    Given User is passing the ID of the customer to get their required information


  Scenario Outline: Validate the status code of the GET call while retrieving booking ID response
    When User performs the GET call for that "<GetBookingID>" info
    Then validate that the response status code of the GET call while retrieving booking ID is "200"
    Examples:
      |GetBookingID|
      |1           |
      |100         |
      |12          |

  Scenario Outline: Validate the status line message of the GET call while retrieving booking ID response
    When User performs the GET call for that "<GetBookingID>" info
    Then validate that the response status line of the GET call while retrieving booking ID is "OK"
    Examples:
      | GetBookingID |
      | 1            |
      | 100          |
      | 12           |

  Scenario Outline: Validate the time taken for GET call while retrieving booking ID info
    When User performs the GET call for that "<GetBookingID>" info
    Then validate that the time taken for response of the GET call while retrieving booking ID is less than "5000" milliseconds
    Examples:
      | GetBookingID |
      | 1            |
      | 100          |
      | 12           |

  Scenario Outline: Validate the datatype of the date fields is Date in the booking info
    When User performs the GET call for that "<GetBookingID>" info
    Then validate that the datatype for Date "bookingdates.checkin" is Date
    And validate that the datatype for Date "bookingdates.checkin" is Date
    Examples:
      | GetBookingID |
      | 2            |
      | 100          |
      | 12           |
