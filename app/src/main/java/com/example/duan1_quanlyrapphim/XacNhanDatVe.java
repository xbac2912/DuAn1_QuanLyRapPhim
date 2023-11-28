package com.example.duan1_quanlyrapphim;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1_quanlyrapphim.adapter.AdapterKhungGio;
import com.example.duan1_quanlyrapphim.adapter.adapterNgayChieu;
import com.example.duan1_quanlyrapphim.adapter.adapterSoGhe;
import com.example.duan1_quanlyrapphim.dao.DaoGheNgoi;
import com.example.duan1_quanlyrapphim.dao.DAOLichChieu;
import com.example.duan1_quanlyrapphim.dao.daoPhim;
import com.example.duan1_quanlyrapphim.model.LichChieu;
import com.example.duan1_quanlyrapphim.model.soGhe;

import java.util.ArrayList;

public class XacNhanDatVe extends AppCompatActivity {
    Toolbar toolbar;
    ArrayList<soGhe> listSoGhe = new ArrayList<>();
    ArrayList<LichChieu> listLichChieu = new ArrayList<>();
    ArrayList<LichChieu> listKhungGio= new ArrayList<>();
    adapterSoGhe adapterSoGhe;
    adapterNgayChieu adapterNgayChieu;
    AdapterKhungGio adapterKhungGio;
    RecyclerView rcvSoGhe, rcvNgayChieu, rcvKhungGio;
    DAOLichChieu daoLichChieu;
    daoPhim daoPhim;
    DaoGheNgoi daoGheNgoi;
    TextView tvTenPhim, tvGiaVe;
    String maPhim;
    String Ngay, MaLichChieu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan_dat_ve);
        tvTenPhim = findViewById(R.id.tvTenPhim);
        tvGiaVe = findViewById(R.id.tvGiaVe);
        //
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Xác Nhận Đặt Vé");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        daoLichChieu = new DAOLichChieu(this);
        daoPhim = new daoPhim(this);
        daoGheNgoi = new DaoGheNgoi(this);
        maPhim = getIntent().getStringExtra("maPhim");
        //
        listSoGhe = daoGheNgoi.selectAll("");
        rcvSoGhe = findViewById(R.id.rcvGheNgoi);
        adapterSoGhe = new adapterSoGhe(this, listSoGhe, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5);
        rcvSoGhe.setLayoutManager(gridLayoutManager);
        rcvSoGhe.setAdapter(adapterSoGhe);
        //
        rcvNgayChieu = findViewById(R.id.rcvNgayChieu);
        listLichChieu = daoLichChieu.selectAll(maPhim);
        tvTenPhim.setText(daoPhim.getTenPhim(maPhim));
        tvGiaVe.setText(daoPhim.getGiaVe(maPhim)+" VNĐ/Vé");
        adapterNgayChieu = new adapterNgayChieu(this, listLichChieu, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rcvNgayChieu.setLayoutManager(linearLayoutManager);
        rcvNgayChieu.setAdapter(adapterNgayChieu);
        //
        rcvKhungGio = findViewById(R.id.rcvKhungGio);
        listKhungGio = daoLichChieu.KhungGio(maPhim, "");
        adapterKhungGio = new AdapterKhungGio(this, listKhungGio, this);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rcvKhungGio.setLayoutManager(linearLayoutManager1);
        rcvKhungGio.setAdapter(adapterKhungGio);
        //
        findViewById(R.id.btnDatVe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenDialog_XacNhanDatVe(maPhim);
//                if ( > 0) {
//                    OpenDialog_XacNhanDatVe(maPhim);
//                } else {
//                    Toast.makeText(XacNhanDatVe.this, "Vui lòng chọn lịch và ghế xem phim", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
    public void getKhungGio(String maPhim ,String ngay) {
        listKhungGio.clear();
        listKhungGio.addAll(daoLichChieu.KhungGio( maPhim, ngay));
        Ngay = ngay;
        adapterKhungGio.notifyDataSetChanged();
    }
    public void getSoGhe(String maLichChieu) {
        listSoGhe.clear();
        listSoGhe.addAll(daoGheNgoi.selectAll(maLichChieu));
        MaLichChieu = maLichChieu;
        adapterSoGhe.notifyDataSetChanged();
    }
    public void OpenDialog_XacNhanDatVe(String maPhim) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_xacnhandatve, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        //
        TextView txtTenPhim = view.findViewById(R.id.txtTenPhim);
        TextView txtNgayChieu = view.findViewById(R.id.txtKhoiChieu);
        TextView txtPhong = view.findViewById(R.id.txtPhong);
        TextView txtGioChieu= view.findViewById(R.id.txtGioChieu);
        TextView txtGhe = view.findViewById(R.id.txtGhe);
        TextView txtThanhToan = view.findViewById(R.id.txtThanhToan);
        TextView txtTongTien = view.findViewById(R.id.txtTongTien);

        txtTenPhim.setText(daoPhim.getTenPhim(maPhim));
        txtNgayChieu.setText(Ngay);
        txtPhong.setText(daoLichChieu.getPhong(maPhim, MaLichChieu));
//        Toast.makeText(this, "" + daoLichChieu.getPhong(maPhim, MaLichChieu), Toast.LENGTH_SHORT).show();
        txtGioChieu.setText(daoLichChieu.getGioChieu(maPhim, MaLichChieu));
//        Toast.makeText(this, ""+daoLichChieu.getGioChieu(maPhim, MaLichChieu), Toast.LENGTH_SHORT).show();
        Log.d("XacNhanDatVe", "Selected seats: " + daoGheNgoi.gheDaChon(MaLichChieu, 2));
        txtGhe.setText(String.valueOf(daoGheNgoi.gheDaChon(MaLichChieu, 2)));
        Toast.makeText(this, ""+String.valueOf(daoGheNgoi.gheDaChon(MaLichChieu, 2)), Toast.LENGTH_SHORT).show();
        txtThanhToan.setText("Tiền mặt");
        txtTongTien.setText(String.valueOf(Integer.valueOf(daoPhim.getGiaVe(maPhim))));
        view.findViewById(R.id.btnXacNhan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        view.findViewById(R.id.btnHuy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
    public ArrayList<soGhe> gheDaChon(ArrayList<soGhe> listSoGhe) {
        return listSoGhe;
    }
}