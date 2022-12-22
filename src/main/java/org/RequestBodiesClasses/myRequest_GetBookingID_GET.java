package org.RequestBodiesClasses;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class myRequest_GetBookingID_GET extends myRequest_CreateBookingID_POST {

    //This function is used to retrieve the customer info based on their booking ID
    public void retrieveApiCall(String bookingID)
    {
        resp= RestAssured.given(reqspec)
                .when()
                .get(configFileReader.getCreateBookingIDPathParam()+"/{bookingID}",bookingID)
                .then()
                .extract()
                .response();

        System.out.println("---------------------------------Step Passed---------------------------------");
    }

    //This function is used to retrieve all the existing booking IDs
    public void retrieveApiCall()
    {
        resp = RestAssured.given(reqspec)
                .when()
                .get(configFileReader.getCreateBookingIDPathParam())
                .then()
                .extract()
                .response();

        System.out.println("---------------------------------Step Passed---------------------------------");
    }

    //This function is used to retrieve the customer info based on their booking ID which is received in the post call
    public void retrieveApiCallBasedOnDynamicBooking_IDAfterPOSTCall()
    {
        String bookingID = respBodyBookingID;
        resp = RestAssured.given(reqspec)
                .when()
                .get(configFileReader.getCreateBookingIDPathParam()+"/{bookingID}", bookingID)
                .then()
                .extract()
                .response();

        System.out.println("---------------------------------Step Passed---------------------------------");
    }

    //This function verifies whether the given dates are in Date type or not
    public void verifyDataTypeOfDateField(String fieldPath) {
        System.out.println(resp.getBody().prettyPrint());
        if(!(resp.getBody().prettyPrint().equalsIgnoreCase("Not Found"))) {
            if (LocalDate.parse(resp.jsonPath().get(fieldPath)) instanceof LocalDate)
                System.out.println("The field value is " + resp.jsonPath().getString(fieldPath));
        }
    }

    /* Function to get the JSON response having Arraylist of Map objects and parse through it to get the required field value */
    public void verifyCountAndListBookingIDs(int total) {
        resp = RestAssured.given(reqspec)
                .when()
                .get(configFileReader.getCreateBookingIDPathParam());
        JsonPath jsonPath = resp.jsonPath();
        List<String> count = jsonPath.getList("$");
        System.out.println("Size of ArrayList is: "+count.size());
        List<Integer> bookingIds = jsonPath.getList("bookingid");
        for(Integer i:bookingIds) {
            System.out.println(i);
        }
    }

    //Function for retrieving the response based on dates query param
    public void retrieveApiCallBasedOnDatesAsQueryParams(String checkIn, String checkOut) {
        HashMap<String,Object> hm_dates = new HashMap<>();
        hm_dates.put("checkin",checkIn);
        hm_dates.put("checkout",checkOut);
        resp = (Response) RestAssured.given(reqspec)
                .queryParams(hm_dates)
                .when()
                .get(configFileReader.getCreateBookingIDPathParam())
                .then()
                .extract()
                .response();
    }
}
