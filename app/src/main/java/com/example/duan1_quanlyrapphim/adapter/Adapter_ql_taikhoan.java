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
import com.example.duan1_quanlyrapphim.model.TaiKhoan;

import java.util.ArrayList;

public class Adapter_ql_taikhoan extends RecyclerView.Adapter<Adapter_ql_taikhoan.ViewHolperQLTK> {

    private ArrayList<TaiKhoan> listTK;
    private Context context;

    public Adapter_ql_taikhoan(ArrayList<TaiKhoan> listTK, Context context) {
        this.listTK = listTK;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolperQLTK onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_ql_dskh, null);
        return new Adapter_ql_taikhoan.ViewHolperQLTK(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolperQLTK holder, int position) {
        TaiKhoan taiKhoan = listTK.get(position);
            holder.name_ql_dskh.setText("Họ tên: "+taiKhoan.getTenNguoiDung());
            holder.email_ql_dskh.setText("Email: "+taiKhoan.getEmail());
    }

    @Override
    public int getItemCount() {
        return listTK.size();
    }

    public static class ViewHolperQLTK extends RecyclerView.ViewHolder{
        ImageView img_ql_dskh;
        TextView name_ql_dskh, email_ql_dskh;
        public ViewHolperQLTK(@NonNull View itemView) {
            super(itemView);
//            img_ql_dskh = itemView.findViewById(R.id.img_ql_dskh);
            name_ql_dskh = itemView.findViewById(R.id.name_ql_dskh);
            email_ql_dskh = itemView.findViewById(R.id.email_ql_dskh);
        }
    }
}
