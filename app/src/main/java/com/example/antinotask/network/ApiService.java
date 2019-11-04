package com.example.antinotask.network;

import com.example.antinotask.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/cardData")
    Call<List<User>> getUser();

}
