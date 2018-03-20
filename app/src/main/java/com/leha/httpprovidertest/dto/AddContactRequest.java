package com.leha.httpprovidertest.dto;

public class AddContactRequest {
    private String address;
    private String description;
    private String email;
    private String fullName;
    private String phoneNumber;

    public AddContactRequest() {
    }

    public AddContactRequest(String address, String description, String email, String fullName, String phoneNumber) {
        this.address = address;
        this.description = description;
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
