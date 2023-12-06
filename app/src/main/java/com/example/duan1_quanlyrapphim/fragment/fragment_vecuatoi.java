package com.example.duan1_quanlyrapphim.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.duan1_quanlyrapphim.R;
import com.example.duan1_quanlyrapphim.TrangChu_User;
import com.example.duan1_quanlyrapphim.adapter.AdapterChiTietVe;
import com.example.duan1_quanlyrapphim.dao.DaoVe;
import com.example.duan1_quanlyrapphim.model.ChiTietVe;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class fragment_vecuatoi extends Fragment {
    TrangChu_User trangChuUser;
    RecyclerView rcvVeCuaToi;
    TextView tvChuaCoVe;
    DaoVe daoVe;
    AdapterChiTietVe adapterChiTietVe;
    ArrayList<ChiTietVe> list = new ArrayList<>();
    public fragment_vecuatoi() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vecuatoi, container, false);
        trangChuUser = (TrangChu_User) getActivity();
        String matk = trangChuUser.getMaTK();
        tvChuaCoVe = view.findViewById(R.id.tvChuaCove);
        rcvVeCuaToi = view.findViewById(R.id.rcvVeCuaToi);
        daoVe = new DaoVe(getContext());
        list = daoVe.selectAll(matk);
        adapterChiTietVe = new AdapterChiTietVe(getContext(), list, "user");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcvVeCuaToi.setLayoutManager(linearLayoutManager);
        rcvVeCuaToi.setAdapter(adapterChiTietVe);
        if (list.size() == 0) {
            tvChuaCoVe.setVisibility(View.VISIBLE);
        } else {
            tvChuaCoVe.setVisibility(View.INVISIBLE);
        }
        adapterChiTietVe.notifyDataSetChanged();
        return view;
    }
}