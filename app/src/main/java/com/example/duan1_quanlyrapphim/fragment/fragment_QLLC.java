package com.example.duan1_quanlyrapphim.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duan1_quanlyrapphim.R;
import com.example.duan1_quanlyrapphim.adapter.AdapterLichChieu;
import com.example.duan1_quanlyrapphim.dao.daoLichChieu;
import com.example.duan1_quanlyrapphim.model.LichChieu;

import java.util.ArrayList;

public class fragment_QLLC extends Fragment {
    RecyclerView rvcLichChieu;
    daoLichChieu daoLichChieu;
    AdapterLichChieu adapterLichChieu;
    ArrayList<LichChieu> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ql, container, false);
        rvcLichChieu = view.findViewById(R.id.rcvPhim);
        daoLichChieu = new daoLichChieu(getContext());
        list = daoLichChieu.getData();
        adapterLichChieu = new AdapterLichChieu(getContext(), list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvcLichChieu.setLayoutManager(linearLayoutManager);
        rvcLichChieu.setAdapter(adapterLichChieu);
        adapterLichChieu.notifyDataSetChanged();
        return view;
    }
}