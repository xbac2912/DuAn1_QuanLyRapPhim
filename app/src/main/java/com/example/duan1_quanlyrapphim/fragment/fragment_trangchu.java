package com.example.duan1_quanlyrapphim.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.duan1_quanlyrapphim.R;
import com.example.duan1_quanlyrapphim.adapter.adapterTheLoai;
import com.example.duan1_quanlyrapphim.model.TheLoai;

import java.util.ArrayList;

public class fragment_trangchu extends Fragment {
    ArrayList<SlideModel> imageList = new ArrayList<>();
    ArrayList<TheLoai> list = new ArrayList<>();
    RecyclerView rcvTheLoai;
    adapterTheLoai adapterTheLoai;
    public fragment_trangchu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trangchu, container, false);
        imageList.add(new SlideModel("https://i.ytimg.com/vi/fVWlCV9_n7w/maxresdefault.jpg", "The animal population decreased by 58 percent in 42 years.", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://i.ytimg.com/vi/2K8EpM-piDw/maxresdefault.jpg", "Elephants and tigers may become extinct.", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://i.ytimg.com/vi/Gah3ahVcCWQ/maxresdefault.jpg", "And people do that.", ScaleTypes.CENTER_CROP));
        ImageSlider imageSlider = view.findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);
        //
        list.add(new TheLoai("Hành động"));
        list.add(new TheLoai("Hoạt hình"));
        list.add(new TheLoai("Lãng mạn"));
        list.add(new TheLoai("Hành động"));
        list.add(new TheLoai("Hoạt hình"));
        list.add(new TheLoai("Lãng mạn"));
        list.add(new TheLoai("Hành động"));
        list.add(new TheLoai("Hoạt hình"));
        list.add(new TheLoai("Lãng mạn"));

        rcvTheLoai = view.findViewById(R.id.rcvTheLoai);
        adapterTheLoai = new adapterTheLoai(getContext(), list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rcvTheLoai.setLayoutManager(layoutManager);
        rcvTheLoai.setAdapter(adapterTheLoai);


        return view;
    }
}