package com.example.antinotask.view.home;

import com.example.antinotask.appController.App;
import com.example.antinotask.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {
    private HomeView view;

    public HomePresenter(HomeView view) {
        this.view = view;
    }

    public void callUser(){
        view.showHideProgress(true);
        App.apiManger.getUsers(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                view.showHideProgress(false);
                if(response.isSuccessful() && response.body()!=null){
                    view.setRecyclerData(response.body());
                }else {
                    view.handleError(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                    view.showHideProgress(false);
                    view.handleError(t.getLocalizedMessage());
            }
        });

    }


}
