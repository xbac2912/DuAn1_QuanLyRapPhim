package com.example.duan1_quanlyrapphim.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.duan1_quanlyrapphim.R;
import com.example.duan1_quanlyrapphim.adapter.adapterPhim_admin;
import com.example.duan1_quanlyrapphim.dao.daoPhim;
import com.example.duan1_quanlyrapphim.dao.daoTheLoai;
import com.example.duan1_quanlyrapphim.model.Phim;
import com.example.duan1_quanlyrapphim.model.TheLoai;

import java.util.ArrayList;
import java.util.Calendar;

public class fragment_QLP extends Fragment {
    RecyclerView recyclerView;
    SearchView searchView;
    daoPhim daoPhim;
    adapterPhim_admin adapterPhim_admin;
    private ArrayList<Phim> list = new ArrayList<>();
    EditText txtAnhPhim, txtTenPhim, txtMoTa, txtGiaVe, txtKhoiChieu;
    Spinner spnLoaiPhim;
    daoTheLoai daoTheLoai;
    int maTheLoai;
    public fragment_QLP() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ql, container, false);
        recyclerView = view.findViewById(R.id.rcvPhim);
        daoPhim = new daoPhim(getContext());
        list = daoPhim.selectAll();
        adapterPhim_admin = new adapterPhim_admin(getContext(), list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterPhim_admin);
        adapterPhim_admin.notifyDataSetChanged();
        for (int i = 0; i< list.size(); i++) {
            adapterPhim_admin.notifyItemChanged(i);
        }
        //
        daoTheLoai = new daoTheLoai(getContext());
        view.findViewById(R.id.btnThem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenDialog_Them();
            }
        });
        return view;
    }
    public void OpenDialog_Them() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = getLayoutInflater().inflate(R.layout.dialog_phim, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        txtAnhPhim = view.findViewById(R.id.txtAnhPhim);
        txtTenPhim = view.findViewById(R.id.txtTenPhim);
        txtMoTa = view.findViewById(R.id.txtMoTa);
        txtGiaVe = view.findViewById(R.id.txtGiaVe);
        txtKhoiChieu = view.findViewById(R.id.txtKhoiChieu);
        spnLoaiPhim = view.findViewById(R.id.spnLoaiPhim);
        ArrayList<TheLoai> listL = new ArrayList<>();
        listL = daoTheLoai.selectAll();
        ArrayList<String> theLoaiArr = new ArrayList<>();
        for (TheLoai x: listL) {
            theLoaiArr.add(x.getTenTL());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, theLoaiArr);
        spnLoaiPhim.setAdapter(adapter);
        spnLoaiPhim.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                maTheLoai = daoTheLoai.getMaLoai(String.valueOf(theLoaiArr.get(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        view.findViewById(R.id.btnThem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String anhPhim = txtAnhPhim.getText().toString();
                String tenPhim = txtTenPhim.getText().toString().trim();
                String moTa = txtMoTa.getText().toString().trim();
                String giaVe = txtGiaVe.getText().toString().trim();
                String khoiChieu = txtKhoiChieu.getText().toString().trim();
                if (daoPhim.insert(new Phim(anhPhim, tenPhim, moTa, Integer.valueOf(giaVe), khoiChieu, 0, maTheLoai))) {
                    list.clear();
                    list.addAll(daoPhim.selectAll());
                    dialog.dismiss();
                    adapterPhim_admin.notifyDataSetChanged();
                    Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        view.findViewById(R.id.btnHuy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}