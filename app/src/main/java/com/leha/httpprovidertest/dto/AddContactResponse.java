package com.leha.httpprovidertest.dto;

public class AddContactResponse {
    private String message;

    public AddContactResponse() {
    }

    public AddContactResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
