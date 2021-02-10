package com.qa.restapi.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Authentication {

    @JsonProperty("username")
    private String userName;

    @JsonProperty("password")
    private String password;

    private Authentication(String name, String pass) {
        userName = name;
        password = pass;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder {
        private String userName, password;

        public Builder setUserName(String name) {
            userName = name;
            return this;
        }

        public Builder setPassword(String pass) {
            password = pass;
            return this;
        }

        public Authentication build() {
            return new Authentication(userName, password);
        }
    }
}
