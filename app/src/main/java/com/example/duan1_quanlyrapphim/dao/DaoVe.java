package com.example.duan1_quanlyrapphim.dao;

import static android.service.controls.ControlsProviderService.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1_quanlyrapphim.database.dbHelper;
import com.example.duan1_quanlyrapphim.model.ChiTietVe;
import com.example.duan1_quanlyrapphim.model.Phim;
import com.example.duan1_quanlyrapphim.model.Ve;

import java.util.ArrayList;

public class DaoVe {
    private dbHelper dbHelper;

    public DaoVe(Context context) {
        dbHelper = new dbHelper(context);
    }
//    public ArrayList<Phim> selectAll() {
//        ArrayList<Phim> list = new ArrayList<>();
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        try {
//            Cursor cursor =db.rawQuery("SELECT * FROM ve", null);
//            if (cursor.getCount() > 0) {
//                cursor.moveToFirst();
//                while (!cursor.isAfterLast()) {
//                    Ve ve = new Ve();
//
//                    list.add(ve);
//                    cursor.moveToNext();
//                }
//            }
//        } catch (Exception e) {
//            Log.i(TAG, "Lỗi" + e);
//        }
//        return list;
//    }
public boolean insertVe(Ve ve) {
    SQLiteDatabase db = dbHelper.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put("mave", ve.getMaVe());
    values.put("matk", ve.getMaTK());
    values.put("maphim", ve.getMaPhim());
    values.put("trangthaithanhtoan", ve.getTrangThaiThanhToan());
    long row = db.insert("ve", null, values);
    return (row > 0);
}
    public boolean insertChiTietVe(ChiTietVe chiTietVe) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenphim", chiTietVe.getTenPhim());
        values.put("giave", chiTietVe.getGiaVe());
        values.put("ngaychieu", chiTietVe.getNgayChieu());
        values.put("phongchieu", chiTietVe.getPhongChieu());
        values.put("giochieu", chiTietVe.getGioChieu());
        values.put("ghedachon", chiTietVe.getGheDaChon());
        values.put("hansudung", chiTietVe.getHanSuDung());
        values.put("mave", chiTietVe.getMaVe());
        values.put("malichchieu", chiTietVe.getMaLichChieu());
        values.put("maghe", chiTietVe.getMaGhe());
        long row = db.insert("chitietve", null, values);
        return (row > 0);
    }
    int rowMaVe;
    public boolean checkMaVe(String maVe) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery("SELECT mave FROM ve WHERE ve.mave = ?", new String[] {String.valueOf(maVe)});
            rowMaVe = cursor.getCount();
        } catch (Exception e) {
            Log.i(TAG, "Lỗi" + e);
        }
        return (rowMaVe <= 0) ? true : false;
    }
}
