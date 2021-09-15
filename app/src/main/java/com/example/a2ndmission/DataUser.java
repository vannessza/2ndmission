package com.example.a2ndmission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import model.user;

public class DataUser extends AppCompatActivity {
    private TextView card_profile_name, card_profile_age, card_profile_address;
    private ImageView card_profile_edit, card_profile_delete, card_profile_back;
    private ArrayList<user> ListUser;
    public int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_user);
        initview();
        setListener();
        back();
        Edit();
        delete();
    }

    private void delete() {
        card_profile_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int choose) {
                        switch (choose){
                            case DialogInterface.BUTTON_POSITIVE:

                                ListUser.remove()
                        }
                    }
                };

            }
        });
    }

    private void Edit() {
        card_profile_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), InputUserActivity.class);
                Bundle bundle = getIntent().getExtras();
                intent.putExtra("name",bundle.getString("name"));
                intent.putExtra("age",bundle.getInt("age"));
                intent.putExtra("address",bundle.getString("address"));
                startActivity(intent);
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

    private void setListener() {
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        int age = bundle.getInt("age");
        String address = bundle.getString("address");

        card_profile_name.setText(name);
        card_profile_age.setText(String.valueOf(age));
        card_profile_address.setText(address);
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
        ListUser = new ArrayList<user>();
    }
}