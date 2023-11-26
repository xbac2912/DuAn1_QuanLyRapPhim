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
import com.example.duan1_quanlyrapphim.model.LichChieu;

import java.util.ArrayList;

public class AdapterLichChieu extends RecyclerView.Adapter<AdapterLichChieu.ViewHolder> {
    private final Context context;
    private final ArrayList<LichChieu> list;

    public AdapterLichChieu(Context context, ArrayList<LichChieu> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_lichchieu, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvMaLichChieu.setText("Mã: " + list.get(position).getMaLichChieu());
        holder.tvTenPhim.setText(list.get(position).getTenPhim());
        holder.tvPhong.setText("Phòng: " + list.get(position).getMaPhong());
        holder.tvNgayChieu.setText(list.get(position).getNgayChieu());
        holder.tvKhungGio.setText(list.get(position).getKhungGio());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMaLichChieu, tvTenPhim, tvPhong, tvNgayChieu, tvKhungGio;
        ImageView btnEdit, btnDelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMaLichChieu = itemView.findViewById(R.id.tvMaLichChieu);
            tvTenPhim = itemView.findViewById(R.id.txtTenPhim);
            tvNgayChieu = itemView.findViewById(R.id.txtNgayChieu);
            tvPhong = itemView.findViewById(R.id.txtPhong);
            tvKhungGio = itemView.findViewById(R.id.txtKhungGio);
        }
    }
}
