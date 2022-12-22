package org.RequestBodiesClasses;

import POJO_Classes.BookingDates_POJO;
import POJO_Classes.BookingInfo_POJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import configFileReader.ConfigFileReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.File;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class myRequest_CreateBookingID_POST {

    public static RequestSpecBuilder reqspecbuild=null;
    public static RequestSpecification reqspec=null;
    public static ResponseSpecBuilder respspecbuild=null;
    public static ResponseSpecification respspec=null;
    public static Response resp=null;
    public int respCode=0;
    public int respTime=0;
    public String respStatLine="";
    public String contentType="";
    public static String respBodyBookingID="";
    public String check_in="";
    public String check_out="";

    ConfigFileReader configFileReader;

    //This function is used for building the request as input to be processed and response as output
    public void start()
    {
        configFileReader=new ConfigFileReader();
        reqspecbuild =new RequestSpecBuilder()
                .setBaseUri(configFileReader.getBaseURI())
                .setContentType(ContentType.JSON)
                .addHeader("Accept", String.valueOf(ContentType.JSON))
                .log(LogDetail.ALL);
        reqspec=reqspecbuild.build();

        respspecbuild=new ResponseSpecBuilder()
                .log(LogDetail.ALL);
        respspec=respspecbuild.build();

        System.out.println("---------------------------------Step Passed---------------------------------");
    }

    //This function is used to create the customer bookingID based on their basic info
    public void recordApiCall()
    {
        File f=new File("src/main/resources/BookingID_Creation_POST_ReqBody.json");
        configFileReader=new ConfigFileReader();
        resp= RestAssured.given(reqspec)
                .body(f)
                .when()
                .post(configFileReader.getCreateBookingIDPathParam())
                .then()
                .extract()
                .response();

        System.out.println("---------------------------------Step Passed---------------------------------");
    }

    //This function is used to create the customer bookingID based on their basic info
    public void recordApiCallForPATCHCallOperation()
    {
        File f=new File("src/main/resources/BookingID_Creation_For_PATCH_ReqBody.json");
        configFileReader=new ConfigFileReader();
        resp= RestAssured.given(reqspec)
                .body(f)
                .when()
                .post(configFileReader.getCreateBookingIDPathParam())
                .then()
                .extract()
                .response();

        System.out.println("---------------------------------Step Passed---------------------------------");
    }

    public void recordApiCallForDELETECallOperation()
    {
        File f=new File("src/main/resources/BookingID_Creation_For_DELETE_ReqBody.json");
        configFileReader=new ConfigFileReader();
        resp= RestAssured.given(reqspec)
                .body(f)
                .when()
                .post(configFileReader.getCreateBookingIDPathParam())
                .then()
                .extract()
                .response();

        System.out.println("---------------------------------Step Passed---------------------------------");
    }

    //This function verifies response code as per the type of the status code ID
    public void validateStatusCode(int statusCode)
    {
        respCode= resp.getStatusCode();
        System.out.println("The response code for scenario is "+respCode);
        if(respCode==statusCode)
        {
            System.out.println(resp.getBody().prettyPrint());
            System.out.println(resp.getHeaders().asList());
        }
        System.out.println("---------------------------------Step Passed---------------------------------");
    }

    //This function retrieves the booking ID after successful POST response is obtained
    public void validateBookingIDFromResponseBody()
    {
        System.out.println(resp.getBody().prettyPrint());
        respBodyBookingID= resp.path("bookingid").toString();
        System.out.println("The booking ID of the response is "+respBodyBookingID);
        System.out.println("---------------------------------Step Passed---------------------------------");
    }

    //This function intends to verify the booking Dates and checks that check in date must be less than check out
    public void validateAndPrintBookingDatesFromResponseBody()
    {
        System.out.println(resp.getBody().prettyPrint());
        check_in= resp.jsonPath().getString("booking.bookingdates.checkin");
        check_out= resp.jsonPath().getString("booking.bookingdates.checkout");
        System.out.println(check_in+" "+check_out);
        LocalDate ld_checkin=LocalDate.parse(check_in);
        LocalDate ld_checkout=LocalDate.parse(check_out);
        if(ld_checkin.isBefore(ld_checkout))
            System.out.println("The Check in date is "+ld_checkin+" and Check out date is "+ld_checkout);
    }

    //This function verifies the content type of response for any method(GET,POST...)
    public void validateContentTypeOfResponse(String contentResponseBody)
    {
        System.out.println(resp.getBody().prettyPrint());
        contentType=resp.getContentType();
        if(contentType.equals(contentResponseBody))
        {
            System.out.println("The content type of response body is "+contentType);
        }
        System.out.println("---------------------------------Step Passed---------------------------------");
    }

    //This function verifies the response time of response for any method(GET,POST...)
    public void validateResponseTime(String responseTime)
    {
        System.out.println(resp.getBody().prettyPrint());
        int rTime=Integer.parseInt(responseTime);
        respTime= (int) resp.getTimeIn(TimeUnit.MILLISECONDS);
        if(respTime<=rTime)
        {
            System.out.println("The response time is: "+resp.getTimeIn(TimeUnit.SECONDS)+" seconds");
        }
        System.out.println("---------------------------------Step Passed---------------------------------");
    }

    //This function verifies the various status messages of response for any method(GET,POST...)
    public void validateStatusMessage(String statusLine)
    {
        System.out.println(resp.getBody().prettyPrint());
        respStatLine = resp.statusLine().toUpperCase().substring(13);
        System.out.println("The response status message for scenario is "+respStatLine);
        switch(respStatLine)
        {
            case "OK":
                System.out.println("The response status line is: "+resp.statusLine());
                break;
            case "CREATED":
                System.out.println("The response status line is: "+resp.statusLine());
                break;
            case "BAD REQUEST":
                System.out.println("The response status line is: "+resp.statusLine());
                break;
            case "UNAUTHORIZED":
                System.out.println("The response status line is: "+resp.statusLine());
                break;
            case "FORBIDDEN":
                System.out.println("The response status line is: "+resp.statusLine());
                break;
            case "FILE NOT FOUND":
                System.out.println("The response status line is: "+resp.statusLine());
                break;
            case "METHOD NOT ALLOWED":
                System.out.println("The response status line is: "+resp.statusLine());
                break;
            case "INTERNAL SERVER ERROR":
                System.out.println("The response status line is: "+resp.statusLine());
                break;
            default:
                System.out.println("Not a response code");
        }
        System.out.println("---------------------------------Step Passed---------------------------------");
    }
}
