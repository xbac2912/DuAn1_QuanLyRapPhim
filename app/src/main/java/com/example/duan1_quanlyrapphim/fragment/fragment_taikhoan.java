package com.example.duan1_quanlyrapphim.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.duan1_quanlyrapphim.Dangnhap;
import com.example.duan1_quanlyrapphim.R;
import com.example.duan1_quanlyrapphim.TrangChu_User;
import com.google.android.material.textfield.TextInputEditText;

public class fragment_taikhoan extends Fragment {
    TrangChu_User trangChuUser;
    public fragment_taikhoan() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_taikhoan, container, false);
        trangChuUser = (TrangChu_User) getActivity();
        view.findViewById(R.id.btnDangXuat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenDialog_DangXuat();
            }
        });
        view.findViewById(R.id.tvDoiMatKhau).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog_DoiMK();
            }
        });
        return view;
    }
    public void openDialog_DoiMK() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = getLayoutInflater().inflate(R.layout.dialog_doimatkhau, null);
        builder.setView(view);
        Dialog dialog = builder.create();
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        TextInputEditText txtMatKhauCu = view.findViewById(R.id.txtMatKhauCu);
        TextInputEditText txtMatKhauMoi = view.findViewById(R.id.txtMatKhauMoi);
        TextInputEditText txtMatKhauXacNhan = view.findViewById(R.id.txtMatKhauXacNhan);
        String maTK = trangChuUser.getMaTK();
        view.findViewById(R.id.btnHuy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        view.findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String matKhauCu = txtMatKhauCu.getText().toString().trim();
//                matKhauMoi = txtMatKhauMoi.getText().toString().trim();
//                String matKhauXacNhan = txtMatKhauXacNhan.getText().toString().trim();
//
//                if (matKhauCu.isEmpty() || matKhauMoi.isEmpty() || matKhauXacNhan.isEmpty()) {
//                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
//                } else {
//                    if (daoThuThu.checklogin( maTT, matKhauCu)) {
//                        if (matKhauMoi.equals(matKhauXacNhan)) {
//                            dialog.dismiss();
//                            openDialog_XacNhan();
//                        } else {
//                            Toast.makeText(MainActivity.this, "Mật khẩu mới không khớp nhau", Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        Toast.makeText(MainActivity.this, "Mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
//                    }
//                }
            }
        });
    }
    public void OpenDialog_DangXuat() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.warning);
        builder.setTitle("WARNING");
        builder.setMessage("Bạn có muốn đăng xuất không ?");
        builder.setPositiveButton("Đăng xuất", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getContext(), Dangnhap.class));
            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        Dialog dialog = builder.create();
        dialog.show();
    }
}