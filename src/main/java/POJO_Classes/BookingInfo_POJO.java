package POJO_Classes;

public class BookingInfo_POJO {

    private String firstname;
    private String lastname;
    private float totalprice;
    private boolean depositpaid;
    BookingDates_POJO bookingDates;
    private String additionalneeds;



    // Getter Methods

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public float getTotalprice() {
        return totalprice;
    }

    public boolean getDepositpaid() {
        return depositpaid;
    }

    public BookingDates_POJO getBookingdates() {
        return bookingDates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    // Setter Methods

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public void setBookingdates(BookingDates_POJO bookingDatesPojo) {
        this.bookingDates = bookingDatesPojo;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}
