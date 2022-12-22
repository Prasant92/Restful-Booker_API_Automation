@test=Get_Booking_IDs_based_On_Dates
Feature: Validate various scenarios for the GET call while retrieving booking IDs based on CheckIn and CheckOut of the Restful Booker API

  Background: User is trying to retrieve the information of the customer by performing GET call
    Given User is passing the ID of the customer to get their required information

  Scenario Outline: Validate the status code of the GET call while retrieving booking ID response
    When User performs the GET call for retrieving all info based on the date as query params between "<checkIN>" and "<checkOut>"
    Then validate that the response status code of the GET call while retrieving booking ID is "200"
    Examples:
      |checkIN|checkOut|
      |2020-01-01|2022-01-01|
      |2015-01-01|2021-01-01|
      |2011-01-01|2018-01-01|
      |2017-01-01|2018-01-01|

  Scenario Outline: Validate the status line message of the GET call while retrieving booking ID response
    When User performs the GET call for retrieving all info based on the date as query params between "<checkIN>" and "<checkOut>"
    Then validate that the response status line of the GET call while retrieving booking ID is "OK"
    Examples:
      | checkIN    | checkOut   |
      | 2020-01-01 | 2022-01-01 |
      | 2015-01-01 | 2021-01-01 |
      | 2011-01-01 | 2018-01-01 |
      | 2017-01-01 | 2018-01-01 |

  Scenario Outline: Validate the time taken for GET call while retrieving booking ID info
    When User performs the GET call for retrieving all info based on the date as query params between "<checkIN>" and "<checkOut>"
    Then validate that the time taken for response of the GET call while retrieving booking ID is less than "5000" milliseconds
    Examples:
      | checkIN    | checkOut   |
      | 2020-01-01 | 2022-01-01 |
      | 2015-01-01 | 2021-01-01 |
      | 2011-01-01 | 2018-01-01 |
      | 2017-01-01 | 2018-01-01 |

  Scenario Outline: Validate the count of Booking IDs and list out all the Booking IDs from the JSON response
    When User performs the GET call for retrieving all info based on the date as query params between "<checkIN>" and "<checkOut>"
    Then validate that total count of booking IDs is more than "1000" and list out all the booking IDs from response
    Examples:
      | checkIN    | checkOut   |
      | 2020-01-01 | 2022-01-01 |
      | 2015-01-01 | 2021-01-01 |
      | 2011-01-01 | 2018-01-01 |
      | 2017-01-01 | 2018-01-01 |