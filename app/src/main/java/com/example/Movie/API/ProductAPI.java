package com.example.Movie.API;

import com.example.Movie.Model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductAPI {

    @GET("users/skinproduct")
    Call<List<Product>>getAllProduct();
}
