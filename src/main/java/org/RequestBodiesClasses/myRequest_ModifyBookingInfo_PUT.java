package org.RequestBodiesClasses;

import POJO_Classes.BookingDates_POJO;
import POJO_Classes.BookingInfo_POJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import configFileReader.ConfigFileReader;
import io.restassured.RestAssured;

import java.io.File;

public class myRequest_ModifyBookingInfo_PUT extends myRequest_GetBookingID_GET {

    public void modifyApiCall(String requestPath,String bookingID) {
        File f=new File(requestPath);
        configFileReader=new ConfigFileReader();
        resp= RestAssured.given(reqspec)
                .auth()
                .preemptive()
                .basic("admin","password123")
                .body(f)
                .when()
                .put(configFileReader.getCreateBookingIDPathParam()+"/{bookingID}",bookingID)
                .then()
                .extract()
                .response();
        System.out.println(resp.getBody().asString());
        System.out.println("---------------------------------Step Passed---------------------------------");
    }

    public void modifyApiCallBasedOnNames(String fname, String lname, String bookingID) {
        BookingDates_POJO bookingDatesPojo = new BookingDates_POJO();
        bookingDatesPojo.setCheckin("2018-10-11");
        bookingDatesPojo.setCheckout("2019-11-11");
        BookingInfo_POJO bookingInfoPojo = new BookingInfo_POJO();
        bookingInfoPojo.setFirstname(fname);
        bookingInfoPojo.setLastname(lname);
        bookingInfoPojo.setTotalprice(111);
        bookingInfoPojo.setDepositpaid(true);
        bookingInfoPojo.setAdditionalneeds("Dinner");
        bookingInfoPojo.setBookingdates(bookingDatesPojo);
        ObjectMapper om = new ObjectMapper();
        String putPayload="";
        try {
                putPayload = om.writerWithDefaultPrettyPrinter().writeValueAsString(bookingInfoPojo);
                System.out.println(putPayload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        configFileReader=new ConfigFileReader();
        resp= RestAssured.given(reqspec)
                .auth()
                .preemptive()
                .basic("admin","password123")
                .body(putPayload)
                .when()
                .put(configFileReader.getCreateBookingIDPathParam()+"/{bookingID}",bookingID)
                .then()
                .extract()
                .response();
        System.out.println(resp.getBody().asString());
        System.out.println("---------------------------------Step Passed---------------------------------");
    }

    public void modifyApiCallBasedOnDates(String checkInDate, String checkOutDate, String bookingID) {
        BookingDates_POJO bookingDatesPojo = new BookingDates_POJO();
        bookingDatesPojo.setCheckin(checkInDate);
        bookingDatesPojo.setCheckout(checkOutDate);
        BookingInfo_POJO bookingInfoPojo = new BookingInfo_POJO();
        bookingInfoPojo.setFirstname("Diane");
        bookingInfoPojo.setLastname("Liu");
        bookingInfoPojo.setTotalprice(111);
        bookingInfoPojo.setDepositpaid(true);
        bookingInfoPojo.setAdditionalneeds("Dinner");
        bookingInfoPojo.setBookingdates(bookingDatesPojo);
        ObjectMapper om = new ObjectMapper();
        String putPayload="";
        try {
            putPayload = om.writerWithDefaultPrettyPrinter().writeValueAsString(bookingInfoPojo);
            System.out.println(putPayload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        configFileReader=new ConfigFileReader();
        resp= RestAssured.given(reqspec)
                .auth()
                .preemptive()
                .basic("admin","password123")
                .body(putPayload)
                .when()
                .put(configFileReader.getCreateBookingIDPathParam()+"/{bookingID}",bookingID)
                .then()
                .extract()
                .response();
        System.out.println(resp.getBody().asString());
        System.out.println("---------------------------------Step Passed---------------------------------");
    }
}
