package com.leha.httpprovidertest.httpprovider;

import com.leha.httpprovidertest.dto.AddContactRequest;
import com.leha.httpprovidertest.dto.AddContactResponse;
import com.leha.httpprovidertest.dto.LoginRequest;
import com.leha.httpprovidertest.dto.LoginResponse;
import com.leha.httpprovidertest.dto.RegistrationRequest;
import com.leha.httpprovidertest.dto.RegistrationResponse;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HttpProvider implements IHttpProvider{

    public static final String BASE_URL = "https://telranstudentsproject.appspot.com/_ah/api/contactsApi/v1/";
    private Api api;
    private IHttpClient client;

    private Subscription registrationSubscription;
    private Subscription loginSubscription;
    private Subscription setContactSubscription;

    public HttpProvider(IHttpClient client){
        this.client = client;

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();

        api = retrofit.create(Api.class);
    }

    @Override
    public void registration(RegistrationRequest request){
        registrationSubscription = api.registration(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RegistrationResponse>() {
                    @Override
                    public void onCompleted() {
                        registrationSubscription.unsubscribe();
                    }

                    @Override
                    public void onError(Throwable e) {
                        client.onRegistrationError(e.getMessage());
                    }

                    @Override
                    public void onNext(RegistrationResponse response) {
                        client.onRegistrationResponse(response);
                    }
                });
    }

    @Override
    public void login(LoginRequest request){
        loginSubscription = api.login(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginResponse>() {

                    @Override
                    public void onCompleted() {
                        loginSubscription.unsubscribe();
                    }

                    @Override
                    public void onError(Throwable e) {
                        client.onLoginError(e.getMessage());
                    }

                    @Override
                    public void onNext(LoginResponse response) {
                        client.onLoginResponse(response);
                    }
                });
    }

    @Override
    public void setContact(String token,AddContactRequest request){
        setContactSubscription = api.setContact(token,request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AddContactResponse>() {
                    @Override
                    public void onCompleted() {
                        setContactSubscription.unsubscribe();
                    }

                    @Override
                    public void onError(Throwable e) {
                        client.onSetContactError(e.getMessage());
                    }

                    @Override
                    public void onNext(AddContactResponse response) {
                        client.onSetContactResponse(response);
                    }
                });
    }

}
