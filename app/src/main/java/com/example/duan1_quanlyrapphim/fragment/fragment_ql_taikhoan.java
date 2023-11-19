package com.example.duan1_quanlyrapphim.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_quanlyrapphim.R;
import com.example.duan1_quanlyrapphim.adapter.Adapter_ql_taikhoan;
import com.example.duan1_quanlyrapphim.dao.daoTaiKhoan;
import com.example.duan1_quanlyrapphim.model.TaiKhoan;

import java.util.ArrayList;

public class fragment_ql_taikhoan extends Fragment {

    ArrayList<TaiKhoan> listTk;
    RecyclerView rc_ql_dskh;
    daoTaiKhoan daotaikhoan;
    Adapter_ql_taikhoan adapter_ql;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ql_taikhoan,container,false);
        rc_ql_dskh = v.findViewById(R.id.rc_ql_dskh);
        daotaikhoan = new daoTaiKhoan(getContext());
        listTk = daotaikhoan.selectAll();
        adapter_ql = new Adapter_ql_taikhoan(listTk,getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());

        rc_ql_dskh.setLayoutManager(manager);
        rc_ql_dskh.setAdapter(adapter_ql);
        return v;

    }

}
