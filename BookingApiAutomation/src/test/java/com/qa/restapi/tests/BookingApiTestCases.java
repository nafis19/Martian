package com.qa.restapi.tests;

import java.util.Date;

import org.testng.annotations.Test;

import com.qa.restapi.base.AuthenticationApi;
import com.qa.restapi.base.BookingApi;
import com.qa.restapi.base.PingApi;
import com.qa.restapi.base.UpdateBookingApi;
import com.qa.restapi.payload.Authentication;
import com.qa.restapi.payload.AuthenticationResponse;
import com.qa.restapi.payload.Booking;
import com.qa.restapi.payload.BookingDates;

import io.restassured.response.Response;

import static com.qa.restapi.util.TestUtil.DEFAULT_PASSWORD;
import static com.qa.restapi.util.TestUtil.DEFAULT_USER_NAME;
import static org.assertj.core.api.Assertions.assertThat;

public class BookingApiTestCases {
	
	
	//checking the site is up
	@Test(priority=1)
    public void healthCheckTest() {
		
        Response response = PingApi.healthCheck();

        assertThat(response.getStatusCode() == 201).isTrue();
    }
	
	
	//Creating token
    @Test(priority=2)
    public void createTokenTest() {
    	
    	Authentication auth = new Authentication.Builder()
                .setUserName(DEFAULT_USER_NAME)
                .setPassword(DEFAULT_PASSWORD)
                .build();

        Response response = AuthenticationApi.createToken(auth);

        assertThat(response.getStatusCode() == 200).isTrue();
    }

    
    // Getting booking IDs
    @Test(priority=3)
    public void getBookingIdsTest() {
    	
        Response response = BookingApi.getBookingIds();

        assertThat(response.getStatusCode() == 200).isTrue();
    }

    @Test(priority=4)
    public void getBookingTest() {
    	
        Response response = BookingApi.getBooking(2, "application/json");

        assertThat(response.getStatusCode() == 200).isTrue();
    }


    
    
    //Creating a booking
    @Test(priority=5)
    public void createBookingTest() {
    	
        BookingDates dates = new BookingDates.Builder()
                .setCheckin(new Date())
                .setCheckout(new Date())
                .build();

        Booking payload = new Booking.Builder()
                .setFirstName("Hello")
                .setLastName("Martian")
                .setTotalPrice(5200)
                .setDepositPaid(true)
                .setBookingDates(dates)
                .setAdditionalNeeds("Breakfast")
                .build();

        Response response = BookingApi.createBooking(payload);

        assertThat(response.getStatusCode() == 200).isTrue();
    }

    
    //update a booking
    @Test(priority=6)
    public void updateBookingTest() {
    	
    	int id = 2;
    	
     	Authentication auth = new Authentication.Builder()
                .setUserName(DEFAULT_USER_NAME)
                .setPassword(DEFAULT_PASSWORD)
                .build();

        BookingDates dates = new BookingDates.Builder()
                .setCheckin(new Date())
                .setCheckout(new Date())
                .build();

        Booking payload = new Booking.Builder()
                .setFirstName("Mars")
                .setLastName("Martian")
                .setTotalPrice(5000)
                .setDepositPaid(true)
                .setBookingDates(dates)
                .setAdditionalNeeds("None")
                .build();
        
        Response response2 = UpdateBookingApi.updateBooking(id, auth, payload);

        assertThat(response2.getStatusCode() == 200).isTrue();
    }
    
    //Delete a booking
    @Test(priority=7)
    public void deleteBookingTest() {

        Authentication auth = new Authentication.Builder()
                .setUserName(DEFAULT_USER_NAME)
                .setPassword(DEFAULT_PASSWORD)
                .build();

        AuthenticationResponse authResponse = AuthenticationApi.createToken(auth).as(AuthenticationResponse.class);

        Response response = BookingApi.deleteBooking(4, authResponse.getToken());

        assertThat(response.getStatusCode() == 201).isTrue();
    }
    

    @Test(priority=8)
    public void getBookingIdAfterDeleteTest() {
    	
        Response response = BookingApi.getBooking(4, "application/json");

        assertThat(response.getStatusCode() == 404).isTrue();
    }
	
	

}
