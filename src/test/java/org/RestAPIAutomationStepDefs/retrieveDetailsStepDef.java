package org.RestAPIAutomationStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.RequestBodiesClasses.*;

import java.text.ParseException;

public class retrieveDetailsStepDef {

    myRequest_HC_GET obj=new myRequest_HC_GET();

    myRequest_CreateBookingID_POST booking_ID = new myRequest_CreateBookingID_POST();

    myRequest_GetBookingID_GET retrieveBookingInfo = new myRequest_GetBookingID_GET();

    myRequest_ModifyBookingInfo_PUT modifyBookingInfo = new myRequest_ModifyBookingInfo_PUT();

    myRequest_ModifyBookingInfo_PATCH modifyPATCHBookingInfo = new myRequest_ModifyBookingInfo_PATCH();

    myRequest_DeleteBookingInfo_DELETE deleteBookingInfo = new myRequest_DeleteBookingInfo_DELETE();

    //*******************************************************Step Def for Health Check API*************************************************//

    @Given("User designs the request body with all required headers with all required details")
    public void user_designs_the_request_body_with_all_required_headers_with_all_required_details()
    {
        obj.start();
    }

    @When("User performs the GET call for that Health check request")
    public void user_performs_the_get_call_for_that_Health_check_request() {
        obj.retrieveApiCall();
    }

    @Then("validate that the response status code is {string}")
    public void validate_that_the_response_status_code_is(String repsonseCode) {
        int code=Integer.parseInt(repsonseCode);
        obj.validateStatusCode(code);
    }

    @Then("validate that the response status line is {string}")
    public void validate_that_the_response_status_line_is(String responseStatusLine) {
        obj.validateStatusMessage(responseStatusLine);
    }

    @Then("validate that the time taken for response is less than {string} milliseconds")
    public void validate_that_the_time_taken_for_response_is_less_than_milliseconds(String responseTime) {
        obj.validateResponseTime(responseTime);
    }

    @Then("validate that the content type of the response is {string}")
    public void validate_that_the_content_type_of_the_response_is(String contentType) {
        obj.validateContentTypeOfResponse(contentType);
    }

    @Then("validate that the body of the response is {string}")
    public void validate_that_the_body_of_the_response_is(String responseBody) {
        obj.validateResponseBody(responseBody);
    }

    //*******************************************************Step Def for Create BookingID API*************************************************//

    @Given("User designs the request body with all required headers with all required details for POST call while creating booking ID")
    public void user_designs_the_request_body_with_all_required_headers_with_all_required_details_for_post_call_while_creating_booking_id() {
        booking_ID.start();
    }

    @When("User performs the POST call for that CreateBookingID request")
    public void user_performs_the_post_call_for_that_create_booking_id_request() {
        booking_ID.recordApiCall();
    }

    @When("User performs the POST call for that CreateBookingID request for PATCH operation")
    public void user_performs_the_post_call_for_that_create_booking_id_request_for_PATCH_operation() {
        booking_ID.recordApiCallForPATCHCallOperation();
    }

    @When("User performs the POST call for that CreateBookingID request for DELETE operation")
    public void user_performs_the_post_call_for_that_create_booking_id_request_for_DELETE_operation() {
        booking_ID.recordApiCallForDELETECallOperation();
    }

    @Then("validate that the response status code of the POST call while creating booking ID is {string}")
    public void validate_that_the_response_status_code_of_the_post_call_while_creating_booking_id_is(String repsonseCode) {
        int code=Integer.parseInt(repsonseCode);
        booking_ID.validateStatusCode(code);
    }

    @Then("validate that the response status line of the POST call while creating booking ID is {string}")
    public void validate_that_the_response_status_line_of_the_post_call_while_creating_booking_id_is(String responseStatusLine) {
        booking_ID.validateStatusMessage(responseStatusLine);
    }

    @Then("validate that the time taken for response of the POST call while creating booking ID is less than {string} milliseconds")
    public void validate_that_the_time_taken_for_response_of_the_post_call_while_creating_booking_id_is_less_than_milliseconds(String responseTime) {
        booking_ID.validateResponseTime(responseTime);
    }

    @Then("validate that the content type of the POST call while creating booking ID is {string}")
    public void validate_that_the_content_type_of_the_post_call_while_creating_booking_id_is(String contentType) {
        booking_ID.validateContentTypeOfResponse(contentType);
    }

    @Then("validate that the body of the response contains booking ID")
    public void validate_that_the_body_of_the_response_contains_booking_id() {
        booking_ID.validateBookingIDFromResponseBody();
    }

    @Then("validate that the body of the response contains checkIn and checkOut times")
    public void validate_that_the_body_of_the_response_contains_check_in_and_check_out_times() {
        booking_ID.validateAndPrintBookingDatesFromResponseBody();
    }

    //*******************************************************Step Def for retrieving BookingID/s API*************************************************//
    @Given("User is passing the ID of the customer to get their required information")
    public void user_is_passing_BookingID_of_customer_to_get_their_required_info() {
        retrieveBookingInfo.start();
    }

    @When("User performs the GET call for that {string} info")
    public void user_performs_the_get_call_for_getting_BookingInfo(String booking_ID) {
        retrieveBookingInfo.retrieveApiCall(String.valueOf(booking_ID));
    }

    @Then("validate that the response status code of the GET call while retrieving booking ID is {string}")
    public void validate_that_the_response_status_code_of_the_get_call_while_retrieving_booking_id_is(String repsonseCode) {
        int code=Integer.parseInt(repsonseCode);
        retrieveBookingInfo.validateStatusCode(code);
    }

    @Then("validate that the response status line of the GET call while retrieving booking ID is {string}")
    public void validate_that_the_response_status_line_of_the_GET_call_while_retrieving_booking_id_is(String responseStatusLine) {
        retrieveBookingInfo.validateStatusMessage(responseStatusLine);
    }

    @Then("validate that the time taken for response of the GET call while retrieving booking ID is less than {string} milliseconds")
    public void validate_that_the_time_taken_for_response_of_the_get_call_while_retrieving_booking_id_is_less_than_milliseconds(String responseTime) {
        retrieveBookingInfo.validateResponseTime(responseTime);
    }

    @Then("validate that the datatype for Date {string} is Date")
    public void validate_that_the_datatype_for_date_field_is_Date(String fieldPath) {
        retrieveBookingInfo.verifyDataTypeOfDateField(fieldPath);
    }

    @When("User performs the GET call for retrieving all info")
    public void user_performs_the_get_call_for_retrieving_BookingInfo() {
        retrieveBookingInfo.retrieveApiCall();
    }

    @Then("validate that total count of booking IDs is more than {string} and list out all the booking IDs from response")
    public void list_out_BookingIDs_from_response(String st) {
        int i = Integer.parseInt(st);
        retrieveBookingInfo.verifyCountAndListBookingIDs(i);
    }

    @When("User performs the GET call for retrieving all info based on the date as query params between {string} and {string}")
    public void user_performs_the_get_call_for_retrieving_BookingInfo_based_on_Dates_as_Query_Params(String checkIN, String checkOut) {
        retrieveBookingInfo.retrieveApiCallBasedOnDatesAsQueryParams(checkIN,checkOut);
    }

    @When("User performs the GET call for that info using BookingID received in response of POST call")
    public void user_performs_get_call_for_bookingID_received_dynamically_in_POST_call_Response() {
        retrieveBookingInfo.retrieveApiCallBasedOnDynamicBooking_IDAfterPOSTCall();
    }

    //*******************************************************Step Def for modifying(PUT) Booking info API*************************************************//
    @Given("User is passing the ID of the customer to modify their required information")
    public void user_is_passing_BookingID_of_customer_to_modify_their_required_info() {
        modifyBookingInfo.start();
    }

    @Then("User runs the modified request body at specified {string} for PUT call for same {string} booking ID")
    public void user_performs_the_put_call_for_getting_modified_BookingInfo(String path,String booking_ID) {
        modifyBookingInfo.modifyApiCall(path,String.valueOf(booking_ID));
    }

    @Then("validate that the response status code of the PUT call while retrieving booking ID is {string}")
    public void validate_that_the_response_status_code_of_the_PUT_call_while_retrieving_booking_info(String repsonseCode) {
        int code=Integer.parseInt(repsonseCode);
        modifyBookingInfo.validateStatusCode(code);
    }

    @Then("validate that the response status line of the PUT call while modifying booking ID is {string}")
    public void validate_that_the_response_status_line_of_the_put_call_while_modifying_booking_id_is(String responseStatusLine) {
        modifyBookingInfo.validateStatusMessage(responseStatusLine);
    }

    @Then("validate that the time taken for response of the PUT call while modifying booking ID is less than {string} milliseconds")
    public void validate_that_the_time_taken_for_response_of_the_put_call_while_modifying_booking_id_is_less_than_milliseconds(String responseTime) {
        modifyBookingInfo.validateResponseTime(responseTime);
    }

    @Then("User runs the serialized modified request body with changed {string} and {string} for PUT call for same {string} booking ID")
    public void user_performs_the_put_call_for_getting_modified_BookingInfo(String fname, String lname, String booking_ID) {
        modifyBookingInfo.modifyApiCallBasedOnNames(fname, lname, String.valueOf(booking_ID));
    }

    @Then("User runs the serialized modified request body with changed dates {string} and {string} for PUT call for same {string} booking ID")
    public void user_performs_the_put_call_with_modified_dates_for_getting_modified_BookingInfo(String checkInDate, String checkOutDate, String booking_ID) {
        modifyBookingInfo.modifyApiCallBasedOnDates(checkInDate, checkOutDate, String.valueOf(booking_ID));
    }

    //*******************************************************Step Def for modifying(PATCH) Booking info API*************************************************//

    @Then("User runs the serialized modified request body with changed {string} and {string} for PATCH call for same booking ID")
    public void user_performs_the_patch_call_for_getting_modified_BookingInfo_based_on_names(String fname, String lname) {
        modifyPATCHBookingInfo.modifyPATCHApiCallBasedOnNames(fname, lname);
    }

    @Then("User runs the serialized modified request body with changed dates {string} and {string} for PATCH call for same booking ID")
    public void user_performs_the_patch_call_for_getting_modified_BookingInfo_based_on_dates(String checkin, String checkout) {
        modifyPATCHBookingInfo.modifyPATCHApiCallBasedOnDates(checkin, checkout);
    }

    @Then("User runs the serialized modified request body with changed info {string}, {string}, {string} and {string} for PATCH call for same booking ID")
    public void user_performs_the_patch_call_for_getting_modified_BookingInfo_based_on_given_Info(String totPrice, String checkin, String checkout, String additionalPrice) {
        int tot_Price = Integer.parseInt(totPrice);
        modifyPATCHBookingInfo.modifyPATCHApiCallBasedOnGivenInfo(tot_Price, checkin, checkout, additionalPrice);
    }

    @Then("validate that the response status code of the PATCH call while retrieving booking ID is {string}")
    public void validate_that_the_response_status_code_of_the_PATCH_call_while_retrieving_booking_info(String repsonseCode) {
        modifyPATCHBookingInfo.validateStatusCode(Integer.parseInt(repsonseCode));
    }

    @Then("validate that the response status line of the PATCH call while modifying booking ID is {string}")
    public void validate_that_the_response_status_line_of_the_PATCH_call_while_modifying_booking_id_is(String responseStatusLine) {
        modifyPATCHBookingInfo.validateStatusMessage(responseStatusLine);
    }

    @Then("validate that the time taken for response of the PATCH call while modifying booking ID is less than {string} milliseconds")
    public void validate_that_the_time_taken_for_response_of_the_PATCH_call_while_modifying_booking_id_is_less_than_milliseconds(String responseTime) {
        modifyPATCHBookingInfo.validateResponseTime(responseTime);
    }

    //*******************************************************Step Def for removing(DELETE) Booking info API*************************************************//


    @Then("User runs the request for removing the Booking ID obtained in POST call using DELETE call")
    public void user_performs_the_delete_call_for_removing_BookingInfo() {
        deleteBookingInfo.deleteBookingInfoRequest();
    }

    @And("validate that the response status code of the DELETE call while retrieving booking ID is {string}")
    public void user_verifies_the_status_code_for_DELETE_call(String repsonseCode) {
        int code=Integer.parseInt(repsonseCode);
        deleteBookingInfo.validateStatusCode(code);
    }

    @And("validate that the response status line of the DELETE call while modifying booking ID is {string}")
    public void user_verifies_the_status_line_for_DELETE_call(String responseStatusline) {
        deleteBookingInfo.validateStatusMessage(responseStatusline);
    }

    @And("validate that the time taken for response of the DELETE call while modifying booking ID is less than {string} milliseconds")
    public void user_verifies_the_status_time_for_DELETE_call(String responseTime) {
        deleteBookingInfo.validateResponseTime(responseTime);
    }
}
