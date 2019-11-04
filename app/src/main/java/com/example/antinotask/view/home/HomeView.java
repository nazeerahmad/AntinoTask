package com.example.antinotask.view.home;

import com.example.antinotask.models.User;

import java.util.List;

public interface HomeView {

    void showHideProgress(boolean show);
    void handleError(String msg);
    void setRecyclerData(List<User> userList);

}
