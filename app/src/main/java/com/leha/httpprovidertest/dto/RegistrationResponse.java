package com.leha.httpprovidertest.dto;

public class RegistrationResponse {
    private String token;
    private String kind;
    private String etag;

    public RegistrationResponse() {
    }

    public RegistrationResponse(String token, String kind, String etag) {
        this.token = token;
        this.kind = kind;
        this.etag = etag;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }
}
