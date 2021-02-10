package com.qa.restapi.base;

import io.restassured.response.Response;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import com.qa.restapi.payload.Authentication;


public class AuthenticationApi extends BaseApi{

    protected static final String AUTH_ENDPOINT = BASE_ENDPOINT + "auth/";

    public static Response createToken(Authentication payload) {
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(AUTH_ENDPOINT);
    }
}
