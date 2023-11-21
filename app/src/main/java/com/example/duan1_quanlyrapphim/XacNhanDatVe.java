package com.example.duan1_quanlyrapphim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.duan1_quanlyrapphim.adapter.adapterNgayChieu;
import com.example.duan1_quanlyrapphim.adapter.adapterSoGhe;
import com.example.duan1_quanlyrapphim.dao.daoPhim;
import com.example.duan1_quanlyrapphim.model.Phim;
import com.example.duan1_quanlyrapphim.model.soGhe;

import java.util.ArrayList;

public class XacNhanDatVe extends AppCompatActivity {
    Toolbar toolbar;
    ArrayList<soGhe> list = new ArrayList<>();
    ArrayList<Phim> listP = new ArrayList<>();
    adapterSoGhe adapterSoGhe;
    adapterNgayChieu adapterNgayChieu;
    RecyclerView rcvSoGhe, rcvNgayChieu;
    daoPhim daoPhim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan_dat_ve);
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
        daoPhim = new daoPhim(this);
        rcvSoGhe = findViewById(R.id.rcvGheNgoi);
        list.add(new soGhe(1, 1, 1));
        list.add(new soGhe(2, 2, 0));
        list.add(new soGhe(3, 3, 1));
        list.add(new soGhe(4, 4, 1));
        list.add(new soGhe(5, 5, 1));
        list.add(new soGhe(6, 6, 1));
        list.add(new soGhe(7, 7, 1));
        list.add(new soGhe(8, 8, 1));
        list.add(new soGhe(9, 9, 1));
        list.add(new soGhe(10, 10, 0));
        list.add(new soGhe(11, 11, 0));
        list.add(new soGhe(12, 12, 0));
        list.add(new soGhe(13, 13, 0));
        list.add(new soGhe(14, 14, 0));
        list.add(new soGhe(15, 15, 1));
        list.add(new soGhe(16, 16, 1));
        list.add(new soGhe(17, 17, 1));
        list.add(new soGhe(18, 18, 1));
        list.add(new soGhe(19, 19, 1));
        list.add(new soGhe(20, 20, 1));
        adapterSoGhe = new adapterSoGhe(this, list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5);
        rcvSoGhe.setLayoutManager(gridLayoutManager);
        rcvSoGhe.setAdapter(adapterSoGhe);
        //
        rcvNgayChieu = findViewById(R.id.rcvNgayChieu);
        String maPhim = getIntent().getStringExtra("maPhim");
        listP = daoPhim.selectKhoiChieu(maPhim);
        adapterNgayChieu = new adapterNgayChieu(this, listP);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rcvNgayChieu.setLayoutManager(linearLayoutManager);
        rcvNgayChieu.setAdapter(adapterNgayChieu);
    }
}