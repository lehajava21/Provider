package com.leha.httpprovidertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.leha.httpprovidertest.dto.AddContactRequest;
import com.leha.httpprovidertest.dto.AddContactResponse;
import com.leha.httpprovidertest.dto.LoginRequest;
import com.leha.httpprovidertest.dto.LoginResponse;
import com.leha.httpprovidertest.dto.RegistrationRequest;
import com.leha.httpprovidertest.dto.RegistrationResponse;
import com.leha.httpprovidertest.httpprovider.Api;
import com.leha.httpprovidertest.httpprovider.HttpProvider;
import com.leha.httpprovidertest.httpprovider.IHttpClient;
import com.leha.httpprovidertest.httpprovider.IHttpProvider;

import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity implements IHttpClient{

    private IHttpProvider provider;
    private String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2YXN5YUBnbWFpbC5jb20ifQ.JW3KEjuWuXVWDCQPm_FoZef5i3w54ntADvRgW7B_WSnZwK0D51PJYah1BE-8jsplj6L-gj-sAUPnLImPk4ABYg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        provider = new HttpProvider(this);

        RegistrationRequest request = new RegistrationRequest("vasya@gmail.com","vasya123");
        provider.registration(request);
/*
        LoginRequest request = new LoginRequest("vasya@gmail.com","vasya123");
        provider.login(request);
*/
/*
        AddContactRequest request1 = new AddContactRequest("Qwerty",
                "programmer",
                "vasya@gmail.com",
                "Muflon",
                "123456");
        provider.setContact(token,request1);
*/
    }

    @Override
    public void onRegistrationResponse(RegistrationResponse response) {
        token = response.getToken();
        Log.i("TAG",response.getToken());
    }

    @Override
    public void onRegistrationError(String error) {
        Log.i("TAG","REGISTER " + error);
    }

    @Override
    public void onLoginResponse(LoginResponse response) {
        token = response.getToken();
        Log.i("TAG",response.getToken());
    }

    @Override
    public void onLoginError(String error) {
        Log.i("TAG","LOGIN " + error);
    }

    @Override
    public void onSetContactResponse(AddContactResponse response) {
        Log.i("TAG",response.getMessage());
    }

    @Override
    public void onSetContactError(String error) {
        Log.i("TAG","SET " + error);
    }
}
