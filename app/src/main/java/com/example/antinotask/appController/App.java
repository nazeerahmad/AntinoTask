package com.example.antinotask.appController;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.antinotask.network.ApiManger;

public class App extends Application {
    public static ApiManger apiManger;

    @Override
    public void onCreate() {
        super.onCreate();

        apiManger = ApiManger.getApiManagerInstance();
    }


}
