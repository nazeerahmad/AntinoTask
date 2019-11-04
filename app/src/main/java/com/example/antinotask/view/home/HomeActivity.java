package com.example.antinotask.view.home;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.antinotask.R;
import com.example.antinotask.Utils;
import com.example.antinotask.adapters.RecyclerHomeAdapter;
import com.example.antinotask.models.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomeView,RecyclerHomeAdapter.ClickListener{

    @BindView(R.id.recycler)
    RecyclerView recycler;
    private HomePresenter presenter;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        dialog = getDialog();
        presenter = new HomePresenter(this);
        presenter.callUser();


    }


    @Override
    public void showHideProgress(boolean show) {
        if (show && dialog!=null) {
            dialog.show();
        } else{
            dialog.dismiss();
        }
    }

    private Dialog getDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(R.layout.progress);
        builder.setCancelable(false);
        return  builder.create();

    }
    @Override
    public void handleError(String msg) {
        Utils.showDialogMessage(this,"title",msg);
    }

    @Override
    public void setRecyclerData(List<User> userList) {
        RecyclerHomeAdapter adapter =new RecyclerHomeAdapter(userList,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View view, int position) {

    }
}
