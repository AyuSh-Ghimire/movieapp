package com.example.ecosmetics.API;

import com.example.ecosmetics.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class LoginAPI {
//for login
    @POST("users/login")
    Call<Void>login(@Body User user);


}
