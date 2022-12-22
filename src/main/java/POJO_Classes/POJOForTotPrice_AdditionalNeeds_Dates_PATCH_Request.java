package POJO_Classes;

public class POJOForTotPrice_AdditionalNeeds_Dates_PATCH_Request {

    private int totalprice;
    private POJOForDates_PATCH_Request pojoForDates_patch_request;
    private String additionalneeds;

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public POJOForDates_PATCH_Request getPojoForDates_patch_request() {
        return pojoForDates_patch_request;
    }

    public void setPojoForDates_patch_request(POJOForDates_PATCH_Request pojoForDates_patch_request) {
        this.pojoForDates_patch_request = pojoForDates_patch_request;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}
