package com.example.a2ndmission;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import model.user;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerview_recyclerview;
    private TextView recyclerview_nodata;
    private UserRVAdapter adapter;
    private ArrayList<user> datauser;
    private FloatingActionButton recyclerview_FAB_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setupRecyclerView();
        setListener();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == 200){
                user UserBaru = data.getParcelableExtra("UserBaru");
                datauser.add(UserBaru);
                adapter.notifyDataSetChanged();
            }
        }
        if(!datauser.isEmpty()){
            recyclerview_nodata.setVisibility(View.GONE);
        }
    }

    private void setListener() {
        recyclerview_FAB_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), InputUserActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        recyclerview_recyclerview.setLayoutManager(manager);
        recyclerview_recyclerview.setAdapter(adapter);
    }

    private void initView() {
        recyclerview_recyclerview = findViewById(R.id.recyclerview_recyclerview);
        recyclerview_nodata = findViewById(R.id.recyclerview_nodata);
        recyclerview_FAB_add = findViewById(R.id.recyclerview_FAB_add);
        datauser = new ArrayList<user>();
        adapter = new UserRVAdapter(this, datauser);
    }
}