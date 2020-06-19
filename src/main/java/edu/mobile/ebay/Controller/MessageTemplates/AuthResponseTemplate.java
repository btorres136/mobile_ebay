package edu.mobile.ebay.Controller.MessageTemplates;

public class AuthResponseTemplate {

    private final String access_token;
    private final String token_type;

    public AuthResponseTemplate(String access_token, String token_type) {
        this.access_token = access_token;
        this.token_type = token_type;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getToken_type() {
        return token_type;
    }
}