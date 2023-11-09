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
import com.example.duan1_quanlyrapphim.model.TheLoai;

import java.util.ArrayList;

public class adapterTheLoai extends RecyclerView.Adapter<adapterTheLoai.ViewHolder>{
    private final Context context;
    private final ArrayList<TheLoai> list;

    public adapterTheLoai(Context context, ArrayList<TheLoai> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_theloai, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTenTheLoai.setText(list.get(position).getTenTheLoai());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenTheLoai;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenTheLoai = itemView.findViewById(R.id.tvTenTheLoai);
        }
    }
}
