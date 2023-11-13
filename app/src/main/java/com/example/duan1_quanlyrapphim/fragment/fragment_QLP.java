package com.example.duan1_quanlyrapphim.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.duan1_quanlyrapphim.R;
import com.example.duan1_quanlyrapphim.adapter.adapterPhim_admin;
import com.example.duan1_quanlyrapphim.dao.daoPhim;
import com.example.duan1_quanlyrapphim.model.Phim;

import java.util.ArrayList;

public class fragment_QLP extends Fragment {
    RecyclerView recyclerView;
    ImageButton btnThem;
    SearchView searchView;
    daoPhim daoPhim;
    adapterPhim_admin adapterPhim_admin;
    private ArrayList<Phim> list = new ArrayList<>();
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
        return view;
    }
}