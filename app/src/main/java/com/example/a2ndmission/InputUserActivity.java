package com.example.a2ndmission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import model.user;

public class InputUserActivity extends AppCompatActivity {

    private TextInputLayout inputuser_name, inputuser_age, inputuser_address;
    private Button inputuser_button;
    private ImageView type_image;
    private TextView textedit_name, textedit_age, textedit_address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputuser);
        initView();
        setListener();
        back();
    }

    private void back() {
        type_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setListener() {
        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            inputuser_button.setText("Update");
            textedit_name.setText(bundle.getString("name"));
            textedit_age.setText(String.valueOf(bundle.getInt("age")));
            textedit_address.setText(bundle.getString("address"));
        }else{
            inputuser_button.setText("Save Data");
        }
        inputuser_button.setOnClickListener(new View.OnClickListener() {
            final LoadingDialog loadingDialog = new LoadingDialog(InputUserActivity.this);
            @Override
            public void onClick(View v) {
                if(bundle ==null) {
                    String name = inputuser_name.getEditText().getText().toString().trim();
                    int age = Integer.parseInt(inputuser_age.getEditText().getText().toString().trim());
                    String address = inputuser_address.getEditText().getText().toString().trim();
                    user dataUser = new user(name, address, age);
                    loadingDialog.startLoadingDialog();
                    Intent intent = new Intent();
                    intent.putExtra("UserBaru", dataUser);
                    setResult(200, intent);
                    finish();
                }else{
                    String name = inputuser_name.getEditText().getText().toString().trim();
                    int age = Integer.parseInt(inputuser_age.getEditText().getText().toString().trim());
                    String address = inputuser_address.getEditText().getText().toString().trim();
                    user dataUser = new user(name,address,age);
                    loadingDialog.startLoadingDialog();
                    Intent intent = new Intent();
                    intent.putExtra("EditUser", dataUser);
                    setResult(200, intent);
                    finish();
                }
            }
        });
    }

    private void initView() {
        inputuser_name = findViewById(R.id.inputuser_name);
        inputuser_age = findViewById(R.id.inputuser_age);
        inputuser_address = findViewById(R.id.inputuser_address);
        textedit_name = findViewById(R.id.textedit_name);
        textedit_age = findViewById(R.id.textedit_age);
        textedit_address = findViewById(R.id.textedit_address);
        inputuser_button = findViewById(R.id.inputuser_button);
        type_image = findViewById(R.id.type_image);
    }
}