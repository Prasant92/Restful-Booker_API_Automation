package org.RequestBodiesClasses;

import configFileReader.ConfigFileReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;

public class myRequest_HC_GET {

    RequestSpecBuilder reqspecbuild=null;
    RequestSpecification reqspec=null;
    ResponseSpecBuilder respspecbuild=null;
    ResponseSpecification respspec=null;
    Response resp=null;
    int respCode=0;
    int respTime=0;
    String respStatLine="";
    String respBody="";
    String contentType="";

    ConfigFileReader configFileReader;

    //This function is used for building the request as input to be processed and response as output
    public void start()
    {
        configFileReader=new ConfigFileReader();
        reqspecbuild =new RequestSpecBuilder()
                .setBaseUri(configFileReader.getBaseURI())
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL);
        reqspec=reqspecbuild.build();

        respspecbuild=new ResponseSpecBuilder()
                .log(LogDetail.ALL);
        respspec=respspecbuild.build();

        System.out.println("---------------------------------Step Passed---------------------------------");
    }

    //This function is used to retrieve the response of health check
    public void retrieveApiCall()
    {
        configFileReader = new ConfigFileReader();
        resp = RestAssured.given(reqspec)
                .when()
                .get(configFileReader.getPingHealthCheckPathParam())
                .then()
                .extract()
                .response();

        System.out.println("---------------------------------Step Passed---------------------------------");
    }

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

    public void validateResponseBody(String responseBody)
    {
        respBody=resp.getBody().prettyPrint();
        if(responseBody.equals(respBody))
        {
            System.out.println("The response body is "+respBody);
        }
        System.out.println("---------------------------------Step Passed---------------------------------");
    }

    public void validateContentTypeOfResponse(String contentResponseBody)
    {
        contentType=resp.getContentType();
        if(contentType.equals(contentResponseBody))
        {
            System.out.println("The content type of response body is "+contentType);
        }
        System.out.println("---------------------------------Step Passed---------------------------------");
    }

    public void validateResponseTime(String responseTime)
    {
        int rTime=Integer.parseInt(responseTime);
        respTime= (int) resp.getTimeIn(TimeUnit.MILLISECONDS);
        if(respTime<=rTime)
        {
            System.out.println("The response time is: "+resp.getTimeIn(TimeUnit.SECONDS)+" seconds");
        }
        System.out.println("---------------------------------Step Passed---------------------------------");
    }

    public void validateStatusMessage(String statusLine)
    {
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
