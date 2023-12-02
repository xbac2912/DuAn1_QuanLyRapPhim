package com.example.duan1_quanlyrapphim.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_quanlyrapphim.R;
import com.example.duan1_quanlyrapphim.model.ChiTietVe;

import java.util.ArrayList;

public class AdapterChiTietVe extends RecyclerView.Adapter<AdapterChiTietVe.ViewHolder> {
    private final Context context;
    private final ArrayList<ChiTietVe> list;

    public AdapterChiTietVe(Context context, ArrayList<ChiTietVe> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_lichsu_admin, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvMaChiTietVe.setText(String.valueOf(list.get(position).getMaVeChiTiet()));
        holder.tvEmail.setText(String.valueOf(list.get(position).getEmail()));
        holder.tvTenPhim.setText(String.valueOf(list.get(position).getTenPhim()));
        holder.tvKhoiChieu.setText(String.valueOf(list.get(position).getNgayChieu()));
        holder.tvPhongChieu.setText(String.valueOf(list.get(position).getPhongChieu()));
        holder.tvGioChieu.setText(String.valueOf(list.get(position).getGioChieu()));
        holder.tvGheDaChon.setText(String.valueOf(list.get(position).getGheDaChon()));
        holder.tvThanhToan.setText("Tiền mặt");
        holder.tvTongTien.setText(String.valueOf(list.get(position).getGiaVe()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMaChiTietVe, tvEmail, tvTenPhim, tvKhoiChieu, tvPhongChieu, tvGioChieu, tvGheDaChon, tvThanhToan, tvTongTien;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMaChiTietVe = itemView.findViewById(R.id.txtMa);
            tvEmail = itemView.findViewById(R.id.txtEmail);
            tvTenPhim = itemView.findViewById(R.id.txtTenPhim);
            tvKhoiChieu = itemView.findViewById(R.id.txtKhoiChieu);
            tvPhongChieu = itemView.findViewById(R.id.txtPhong);
            tvGioChieu = itemView.findViewById(R.id.txtGioChieu);
            tvGheDaChon = itemView.findViewById(R.id.txtGhe);
            tvThanhToan = itemView.findViewById(R.id.txtThanhToan);
            tvTongTien = itemView.findViewById(R.id.txtTongTien);
        }
    }
}
