package com.example.duan1_quanlyrapphim;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Dangnhap extends AppCompatActivity {
    private EditText ed_email, ed_pass;
    private TextView tv_forgetpass, tv_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        ed_email = findViewById(R.id.edt_email);
        ed_pass = findViewById(R.id.edt_pass);
        tv_forgetpass = findViewById(R.id.tv_forgetpass);
        tv_signup = findViewById(R.id.tv_signup);

        tv_signup.setOnClickListener(v -> {
            Intent intent = new Intent(this, Dangky.class);
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
            startActivity(intent, bundle);
        });
    }
}