package edu.mobile.ebay.Controller.MessageTemplates;

public class AuthResponseTemplate {

    private final String jwt;

    public AuthResponseTemplate(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}