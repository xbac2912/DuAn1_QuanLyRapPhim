package com.example.duan1_quanlyrapphim.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.duan1_quanlyrapphim.R;
import com.example.duan1_quanlyrapphim.TrangChu_User;

public class fragment_vecuatoi extends Fragment {
    TrangChu_User trangChuUser;
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
        return view;
    }
}