package com.example.antinotask.network;

import com.example.antinotask.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManger {
    private final  String BASE_URL ="http://demo8716682.mockable.io";
    private static ApiService service;
    private static ApiManger apiManger;

    public ApiManger() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ApiService.class);
    }

    public static ApiManger getApiManagerInstance(){
        if(apiManger == null){
            apiManger = new ApiManger();
        }
        return apiManger;
    }

    public  void getUsers(Callback<List<User>> callback){
        Call<List<User>> usersCall = service.getUser();
        usersCall.enqueue(callback);

    }
}
