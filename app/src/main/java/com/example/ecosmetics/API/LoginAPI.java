package com.example.ecosmetics.API;

import com.example.ecosmetics.Model.LoginResponse;
import com.example.ecosmetics.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

    public interface LoginAPI {
    //for login
    @POST("/users/login")
    Call<LoginResponse>login(@Body User user);

    @POST("/users/signup")
    Call<Void>register(@Body User regUser);


}
