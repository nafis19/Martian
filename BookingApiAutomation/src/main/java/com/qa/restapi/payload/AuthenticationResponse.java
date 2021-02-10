package com.qa.restapi.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationResponse {
	
    @JsonProperty
    private String token;

    public String getToken() {
        return token;
    }

}
