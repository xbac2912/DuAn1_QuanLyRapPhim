package com.example.duan1_quanlyrapphim.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.duan1_quanlyrapphim.R;
import com.example.duan1_quanlyrapphim.adapter.AdapterLichChieu;
import com.example.duan1_quanlyrapphim.dao.DAOLichChieu;
import com.example.duan1_quanlyrapphim.model.LichChieu;

import java.util.ArrayList;

public class fragment_QLLC extends Fragment {
    RecyclerView rvcLichChieu;
    DAOLichChieu daoLichChieu;
    EditText edtSearch;
    AdapterLichChieu adapterLichChieu;
    ArrayList<LichChieu> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ql, container, false);
        rvcLichChieu = view.findViewById(R.id.rcvPhim);
        edtSearch = view.findViewById(R.id.edtSearch);

        daoLichChieu = new DAOLichChieu(getContext());
        list = daoLichChieu.selectAll();
        adapterLichChieu = new AdapterLichChieu(getContext(), list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvcLichChieu.setLayoutManager(linearLayoutManager);
        rvcLichChieu.setAdapter(adapterLichChieu);
        adapterLichChieu.notifyDataSetChanged();

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                handleSearch(s.toString());
            }
        });

        return view;
    }

    private void handleSearch(String query) {
        ArrayList<LichChieu> listSearch = new ArrayList<>();
        for (LichChieu lichChieu : list) {
            if (lichChieu.getTenPhim().toLowerCase().contains(query.toLowerCase()) ||
                    String.valueOf(lichChieu.getMaLichChieu()).contains(query) ||
                    String.valueOf(lichChieu.getMaPhong()).contains(query)) {
                listSearch.add(lichChieu);
            }
        }
        adapterLichChieu = new AdapterLichChieu(getContext(), listSearch);
        rvcLichChieu.setAdapter(adapterLichChieu);
    }
}