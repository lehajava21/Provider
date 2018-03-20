package com.leha.httpprovidertest.httpprovider;

import com.leha.httpprovidertest.dto.AddContactRequest;
import com.leha.httpprovidertest.dto.LoginRequest;
import com.leha.httpprovidertest.dto.RegistrationRequest;

public interface IHttpProvider {
    void registration(RegistrationRequest request);
    void login(LoginRequest request);
    void setContact(String token, AddContactRequest request);
}
