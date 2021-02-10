package com.qa.restapi.base;

import static io.restassured.RestAssured.given;

import com.qa.restapi.payload.Authentication;
import com.qa.restapi.payload.Booking;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateBookingApi extends BaseApi {
	
	protected static final String UPDATE_BOOKING_ENDPOINT = BASE_ENDPOINT + "booking/";

    public static Response getBookingIds() {
        return given()
                .get(UPDATE_BOOKING_ENDPOINT);
    }

    public static Response getBooking(int id, String mediaType) {
        return given()
                .header("Accept", mediaType)
                .get(UPDATE_BOOKING_ENDPOINT + Integer.toString(id));
    }

    public static Response updateBooking(int id, Authentication auth, Booking payload) {
        return given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + auth)
                .body(payload)
                .when()
                .put(UPDATE_BOOKING_ENDPOINT + Integer.toString(id));
    }

	public static Response updateBooking(Booking payload) {
		// TODO Auto-generated method stub
		return null;
	}



}
