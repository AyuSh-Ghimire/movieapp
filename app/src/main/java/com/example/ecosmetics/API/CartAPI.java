package com.example.ecosmetics.API;

import com.example.ecosmetics.Model.CartModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface CartAPI {

    @GET("/users/cart")
    Call<List<CartModel>> getbyid(@Header("Authorization") String token);
}
