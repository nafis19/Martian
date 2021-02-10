package com.qa.restapi.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateBooking {
	
	 @JsonProperty("firstname")
	    private String firstName;

	    @JsonProperty("lastname")
	    private String lastName;

	    @JsonProperty("totalprice")
	    private int totalPrice;

	    @JsonProperty("depositpaid")
	    private boolean depositPaid;

	    @JsonProperty("bookingdates")
	    private BookingDates bookingDates;

	    @JsonProperty("additionalneeds")
	    private String additionalNeeds;

	    private UpdateBooking(String firstName, String lastName, int totalPrice, boolean depositPaid, BookingDates bookingDates, String additionalNeeds) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.totalPrice = totalPrice;
	        this.depositPaid = depositPaid;
	        this.bookingDates = bookingDates;
	        this.additionalNeeds = additionalNeeds;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public int getTotalPrice() {
	        return totalPrice;
	    }

	    public boolean isDepositPaid() {
	        return depositPaid;
	    }

	    public BookingDates getBookingDates() {
	        return bookingDates;
	    }

	    public String getAdditionalNeeds() {
	        return additionalNeeds;
	    }

	    public static class Builder{
	        private String firstName, lastName, additionalNeeds;
	        private int totalPrice;
	        private boolean depositPaid;
	        private BookingDates bookingDates;

	        public Builder setFirstName(String firstName) {
	            this.firstName = firstName;
	            return this;
	        }

	        public Builder setLastName(String lastName) {
	            this.lastName = lastName;
	            return this;
	        }

	        public Builder setTotalPrice(int totalPrice) {
	            this.totalPrice = totalPrice;
	            return this;
	        }

	        public Builder setDepositPaid(boolean depositPaid) {
	            this.depositPaid = depositPaid;
	            return this;
	        }

	        public Builder setBookingDates(BookingDates bookingDates) {
	            this.bookingDates = bookingDates;
	            return this;
	        }

	        public Builder setAdditionalNeeds(String additionalNeeds) {
	            this.additionalNeeds = additionalNeeds;
	            return this;
	        }

	        public UpdateBooking build() {
	            return new UpdateBooking(firstName, lastName, totalPrice, depositPaid, bookingDates, additionalNeeds);
	        }
	    }

}
