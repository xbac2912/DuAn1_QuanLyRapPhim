package com.example.duan1_quanlyrapphim.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_quanlyrapphim.R;
import com.example.duan1_quanlyrapphim.XacNhanDatVe;
import com.example.duan1_quanlyrapphim.dao.DaoGheNgoi;
import com.example.duan1_quanlyrapphim.model.soGhe;

import java.util.ArrayList;

public class adapterSoGhe extends RecyclerView.Adapter<adapterSoGhe.ViewHolder> {
    private final Context context;
    private final ArrayList<soGhe> list;
    DaoGheNgoi daoGheNgoi;
    soGhe soGhe;
    XacNhanDatVe xacNhanDatVe;

    public adapterSoGhe(Context context, ArrayList<soGhe> list, Activity activity) {
        this.context = context;
        this.list = list;
        xacNhanDatVe = (XacNhanDatVe) activity;
        daoGheNgoi = new DaoGheNgoi(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_soghe, null);
        return new adapterSoGhe.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvSoGhe.setText(String.valueOf(list.get(position).getSoGhe()));
        if (list.get(position).getTrangThai() == 0) {
            holder.layout.setBackground(new ColorDrawable(Color.parseColor("#FF0000")));
        } else if (list.get(position).getTrangThai() == 1) {
            holder.layout.setBackground(new ColorDrawable(Color.parseColor("#4D000000")));
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soGhe = list.get(position);
                if (soGhe.getTrangThai() == 1) {
                    soGhe.setTrangThai(2);
                    daoGheNgoi.UpdateTT(soGhe, 2);
                    holder.layout.setBackground(new ColorDrawable(Color.parseColor("#52DF13")));
                } else if (soGhe.getTrangThai() == 2) {
                    soGhe.setTrangThai(1);
                    daoGheNgoi.UpdateTT(soGhe, 1);
                    holder.layout.setBackground(new ColorDrawable(Color.parseColor("#4D000000")));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSoGhe;
        CardView cardView;
        LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSoGhe = itemView.findViewById(R.id.tvSoGhe);
            cardView = itemView.findViewById(R.id.card_view);
            layout = itemView.findViewById(R.id.line1);
        }
    }
}
