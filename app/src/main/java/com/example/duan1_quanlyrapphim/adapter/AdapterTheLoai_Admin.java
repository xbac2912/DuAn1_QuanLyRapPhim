package com.example.duan1_quanlyrapphim.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan1_quanlyrapphim.R;
import com.example.duan1_quanlyrapphim.model.TheLoai;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterTheLoai_Admin extends BaseAdapter {
    private List<TheLoai> list;
    private Context context;

    public AdapterTheLoai_Admin(List<TheLoai> genreList, Context context) {
        this.list = genreList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_theloai,parent,false);
            holder = new ViewHolder();
            holder.imgAnhTheLoai = convertView.findViewById(R.id.imgAnhTheLoai);
            holder.tvTenLoai = convertView.findViewById(R.id.txtTenLoai);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        TheLoai theLoai = list.get(position);
        holder.tvTenLoai.setText(theLoai.getTenTL());

        Picasso.get().load(theLoai.getImgURL()).into(holder.imgAnhTheLoai);
        return convertView;
    }
    static class ViewHolder{
        ImageView imgAnhTheLoai;
        TextView tvTenLoai;
    }
}
