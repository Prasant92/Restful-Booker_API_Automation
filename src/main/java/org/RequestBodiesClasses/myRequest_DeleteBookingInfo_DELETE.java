package org.RequestBodiesClasses;

import configFileReader.ConfigFileReader;
import io.restassured.RestAssured;

public class myRequest_DeleteBookingInfo_DELETE extends myRequest_GetBookingID_GET {

    public void deleteBookingInfoRequest() {
        configFileReader=new ConfigFileReader();
        String bookingID = respBodyBookingID;
        resp = RestAssured.given(reqspec)
                .auth()
                .preemptive()
                .basic("admin","password123")
                .when()
                .delete(configFileReader.getCreateBookingIDPathParam()+"/{bookingID}",bookingID)
                .then()
                .extract()
                .response();
        System.out.println(resp.getBody().asString());
        System.out.println("---------------------------------Step Passed---------------------------------");
    }
}