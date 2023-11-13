package com.example.duan1_quanlyrapphim.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_quanlyrapphim.R;
import com.example.duan1_quanlyrapphim.model.Phim;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adapterPhim_admin extends RecyclerView.Adapter<adapterPhim_admin.ViewHolder> {
    private final Context context;
    private final ArrayList<Phim> list;

    public adapterPhim_admin(Context context, ArrayList<Phim> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_phim_admin, null);
        return new adapterPhim_admin.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load(list.get(position).getImgPhim()).into(holder.imgPhim);
        holder.tvTenPhim.setText(list.get(position).getTenPhim());
        holder.tvMoTa.setText(list.get(position).getMoTa());
        holder.tvTheLoai.setText(list.get(position).getTenTheLoai());
        holder.tvGiaVe.setText(String.valueOf(list.get(position).getGiaVe()));
        holder.tvGioChieu.setText(list.get(position).getKhoiChieu());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenPhim, tvMoTa, tvTheLoai, tvGiaVe, tvGioChieu;
        ImageView imgPhim, btnEdit, btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhim = itemView.findViewById(R.id.imgAnhPhim);
            tvTenPhim = itemView.findViewById(R.id.txtPhim);
            tvMoTa = itemView.findViewById(R.id.txtMoTa);
            tvTheLoai = itemView.findViewById(R.id.txtTheLoai);
            tvGiaVe = itemView.findViewById(R.id.txtGiaVe);
            tvGioChieu = itemView.findViewById(R.id.txtGioChieu);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
