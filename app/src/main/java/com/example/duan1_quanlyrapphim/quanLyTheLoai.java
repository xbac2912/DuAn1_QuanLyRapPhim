package com.example.duan1_quanlyrapphim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.duan1_quanlyrapphim.adapter.AdapterTheLoai_Admin;
import com.example.duan1_quanlyrapphim.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class quanLyTheLoai extends Fragment {
    private List<TheLoai> list;


    public quanLyTheLoai() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_quan_ly_danh_sach,container,false);

        list = new ArrayList<>();
        list.add(new TheLoai("https://i.ytimg.com/vi/2K8EpM-piDw/maxresdefault.jpg","Hành động"));
        list.add(new TheLoai("https://photo2.tinhte.vn/data/attachment-files/2021/07/5557920_CV.jpg","Trinh thám"));

        ListView listView = v.findViewById(R.id.listTL);
        AdapterTheLoai_Admin adapter = new AdapterTheLoai_Admin(list,getContext());
        listView.setAdapter(adapter);

        return v;
    }
}