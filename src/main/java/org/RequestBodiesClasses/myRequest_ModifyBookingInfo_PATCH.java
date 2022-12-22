package org.RequestBodiesClasses;

import POJO_Classes.POJOForBookingDates_PATCH_Request;
import POJO_Classes.POJOForDates_PATCH_Request;
import POJO_Classes.POJOForNames_PATCH_Request;
import POJO_Classes.POJOForTotPrice_AdditionalNeeds_Dates_PATCH_Request;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import configFileReader.ConfigFileReader;
import io.restassured.RestAssured;

public class myRequest_ModifyBookingInfo_PATCH extends myRequest_ModifyBookingInfo_PUT {

    private void serializeJSONRequest(String patchPayload) {
        configFileReader=new ConfigFileReader();
        String bookingID = respBodyBookingID;
        resp = RestAssured.given(reqspec)
                .auth()
                .preemptive()
                .basic("admin","password123")
                .body(patchPayload)
                .when()
                .patch(configFileReader.getCreateBookingIDPathParam()+"/{bookingID}",bookingID)
                .then()
                .extract()
                .response();
        System.out.println(resp.getBody().asString());
        System.out.println("---------------------------------Step Passed---------------------------------");
    }
    public void modifyPATCHApiCallBasedOnNames(String fname, String lname) {
        POJOForNames_PATCH_Request pojoForNames_patch_request = new POJOForNames_PATCH_Request();
        pojoForNames_patch_request.setFirstname(fname);
        pojoForNames_patch_request.setLastname(lname);
        ObjectMapper om = new ObjectMapper();
        String patch_Payload="";
        try {
            patch_Payload = om.writerWithDefaultPrettyPrinter().writeValueAsString(pojoForNames_patch_request);
            System.out.println(patch_Payload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        serializeJSONRequest(patch_Payload);
    }

    public void modifyPATCHApiCallBasedOnDates(String checkin, String checkout) {
        POJOForDates_PATCH_Request pojoForDates_patch_request = new POJOForDates_PATCH_Request();
        pojoForDates_patch_request.setCheckin(checkin);
        pojoForDates_patch_request.setCheckout(checkout);
        POJOForBookingDates_PATCH_Request pojoForBookingDates_patch_request = new POJOForBookingDates_PATCH_Request();
        pojoForBookingDates_patch_request.setBookingdates(pojoForDates_patch_request);
        ObjectMapper om = new ObjectMapper();
        String patch_Payload="";
        try {
            patch_Payload = om.writerWithDefaultPrettyPrinter().writeValueAsString(pojoForBookingDates_patch_request);
            System.out.println(patch_Payload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        serializeJSONRequest(patch_Payload);
    }

    public void modifyPATCHApiCallBasedOnGivenInfo(Integer totPrice, String checkin, String checkout, String AdditionalNeeds) {
        POJOForDates_PATCH_Request pojoForDates_patch_request = new POJOForDates_PATCH_Request();
        pojoForDates_patch_request.setCheckin(checkin);
        pojoForDates_patch_request.setCheckout(checkout);
        POJOForTotPrice_AdditionalNeeds_Dates_PATCH_Request pojoForTotPrice_additionalNeeds_dates_patch_request = new POJOForTotPrice_AdditionalNeeds_Dates_PATCH_Request();
        pojoForTotPrice_additionalNeeds_dates_patch_request.setTotalprice(totPrice);
        pojoForTotPrice_additionalNeeds_dates_patch_request.setPojoForDates_patch_request(pojoForDates_patch_request);
        pojoForTotPrice_additionalNeeds_dates_patch_request.setAdditionalneeds(AdditionalNeeds);
        ObjectMapper om = new ObjectMapper();
        String patch_Payload="";
        try {
            patch_Payload = om.writerWithDefaultPrettyPrinter().writeValueAsString(pojoForTotPrice_additionalNeeds_dates_patch_request);
            System.out.println(patch_Payload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        serializeJSONRequest(patch_Payload);
    }
}
