package com.example.duan1_quanlyrapphim;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Dangky extends AppCompatActivity {
    private EditText ed_name, ed_email, ed_cfpass, ed_pass;
    private TextView tv_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);

        ed_name = findViewById(R.id.edt_name);
        ed_email = findViewById(R.id.edt_email);
        ed_cfpass = findViewById(R.id.edt_cfpass);
        ed_pass = findViewById(R.id.edt_pass);
        tv_login = findViewById(R.id.tv_login);

        tv_login.setOnClickListener(v -> {
            Intent intent = new Intent(this, Dangnhap.class);
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
            startActivity(intent, bundle);
        });

    }
}