package com.example.a2ndmission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import model.user;
import model.usersave;

public class DataUser extends AppCompatActivity {
    private TextView card_profile_name, card_profile_age, card_profile_address;
    private ImageView card_profile_edit, card_profile_delete, card_profile_back;
    private ArrayList<user> ListUser= usersave.savelist;
    public int pos;
    public user use;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_user);
        initview();
        back();
        Edit();
        delete();
        use = getIntent().getParcelableExtra("datauser");
        pos = getIntent().getIntExtra("pos",0);

        card_profile_name.setText(use.getName());
        card_profile_age.setText(String.valueOf(use.getAge()));
        card_profile_address.setText(use.getAddress());
    }

    private void delete() {
        card_profile_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListUser.remove(pos);
                Log.d("test", String.valueOf(pos));

                Toast.makeText(DataUser.this, "Delete Seccess", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(DataUser.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

    private void Edit() {
        card_profile_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),InputUserActivity.class);
                intent.putExtra("data", use);
                intent.putExtra("pos", pos);
                startActivity(intent);
                finish();
            }
        });
    }

    private void back() {
        card_profile_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void setBundle() {
    }

    private void initview() {
        card_profile_name = findViewById(R.id.card_profile_name);
        card_profile_age = findViewById(R.id.card_profile_age);
        card_profile_address = findViewById(R.id.card_profile_address);
        card_profile_edit = findViewById(R.id.card_profile_edit);
        card_profile_delete = findViewById(R.id.card_profile_delete);
        card_profile_back = findViewById(R.id.card_profile_back);
    }
}