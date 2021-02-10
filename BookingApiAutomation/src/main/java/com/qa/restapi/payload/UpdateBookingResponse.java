package com.qa.restapi.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateBookingResponse {
	
    @JsonProperty("bookingid")
    private int bookingId;

    @JsonProperty
    private Booking booking;

    public int getBookingId() {
        return bookingId;
    }

    public Booking getBooking() {
        return booking;
    }

}
