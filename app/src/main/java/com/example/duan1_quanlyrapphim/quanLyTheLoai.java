package com.example.duan1_quanlyrapphim;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class quanLyTheLoai extends Fragment {

    public quanLyTheLoai() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_quan_ly_danh_sach,container,false);


        return inflater.inflate(R.layout.fragment_quan_ly_danh_sach, container, false);
    }
}