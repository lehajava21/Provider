package com.leha.httpprovidertest.httpprovider;

import com.leha.httpprovidertest.dto.AddContactResponse;
import com.leha.httpprovidertest.dto.LoginResponse;
import com.leha.httpprovidertest.dto.RegistrationResponse;

public interface IHttpClient {
    void onRegistrationResponse(RegistrationResponse response);
    void onRegistrationError(String error);
    void onLoginResponse(LoginResponse response);
    void onLoginError(String error);
    void onSetContactResponse(AddContactResponse response);
    void onSetContactError(String error);
}
