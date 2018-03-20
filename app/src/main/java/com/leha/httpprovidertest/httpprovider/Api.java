package com.leha.httpprovidertest.httpprovider;

import com.leha.httpprovidertest.dto.AddContactRequest;
import com.leha.httpprovidertest.dto.AddContactResponse;
import com.leha.httpprovidertest.dto.LoginRequest;
import com.leha.httpprovidertest.dto.LoginResponse;
import com.leha.httpprovidertest.dto.RegistrationRequest;
import com.leha.httpprovidertest.dto.RegistrationResponse;

import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

public interface Api {
    @POST("registration")
    Observable<RegistrationResponse> registration(@Body RegistrationRequest request);

    @POST("login")
    Observable<LoginResponse> login(@Body LoginRequest request);

    @POST("setContact")
    Observable<AddContactResponse> setContact(
            @Header("Authorization") String token,@Body AddContactRequest request);
}
