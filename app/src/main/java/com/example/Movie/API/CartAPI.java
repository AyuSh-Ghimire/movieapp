package com.example.Movie.API;

import com.example.Movie.Model.CartModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface CartAPI {

    @GET("/users/cart")
    Call<List<CartModel>> getbyid(@Header("Authorization") String token);
}
