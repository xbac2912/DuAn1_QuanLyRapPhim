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
import com.example.duan1_quanlyrapphim.model.TaiKhoan;

public class Dangky extends AppCompatActivity {
    private EditText ed_name, ed_email, ed_cfpass, ed_pass;
    private TextView tv_login;
    daoTaiKhoan daoTaiKhoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);

        ed_name = findViewById(R.id.edt_name);
        ed_email = findViewById(R.id.edt_email);
        ed_cfpass = findViewById(R.id.edt_cfpass);
        ed_pass = findViewById(R.id.edt_pass);
        tv_login = findViewById(R.id.tv_login);
        //
        daoTaiKhoan = new daoTaiKhoan(this);

        tv_login.setOnClickListener(v -> {
            Intent intent = new Intent(this, Dangnhap.class);
            startActivity(intent);
        });
        findViewById(R.id.btn_signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed_name.getText().toString();
                String email = ed_email.getText().toString();
                String pass = ed_pass.getText().toString();
                String cfpass = ed_cfpass.getText().toString();
                if (name.isEmpty() || email.isEmpty() || pass.isEmpty() || cfpass.isEmpty()) {
                    Toast.makeText(Dangky.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    if (daoTaiKhoan.insert(new TaiKhoan(name, email, pass, 1))) {
                        Toast.makeText(Dangky.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Dangky.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}