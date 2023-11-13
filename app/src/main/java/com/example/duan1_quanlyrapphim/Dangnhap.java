package com.example.duan1_quanlyrapphim;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1_quanlyrapphim.dao.daoTaiKhoan;

public class Dangnhap extends AppCompatActivity {
    private EditText ed_email, ed_pass;
    private TextView tv_forgetpass, tv_signup;
    daoTaiKhoan daoTaiKhoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        ed_email = findViewById(R.id.edt_email);
        ed_pass = findViewById(R.id.edt_pass);
        tv_forgetpass = findViewById(R.id.tv_forgetpass);
        tv_signup = findViewById(R.id.tv_signup);
        daoTaiKhoan = new daoTaiKhoan(this);

        tv_signup.setOnClickListener(v -> {
            Intent intent = new Intent(this, Dangky.class);
            startActivity(intent);
        });
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ed_email.getText().toString();
                String pass = ed_pass.getText().toString();
                if (daoTaiKhoan.checklogin(email, pass, 1)) {
                    Intent intent = new Intent(Dangnhap.this, TrangChu_User.class);
                    startActivity(intent);
                    Toast.makeText(Dangnhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                } else if (daoTaiKhoan.checklogin(email, pass, 0)) {
                    Intent intent = new Intent(Dangnhap.this, TrangChu_Admin.class);
                    startActivity(intent);
                    Toast.makeText(Dangnhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Dangnhap.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}