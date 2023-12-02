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
    public ArrayList<ChiTietVe> selectAll(String matk) {
        ArrayList<ChiTietVe> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor =db.rawQuery("SELECT * FROM chitietve INNER JOIN ve ON chitietve.mave = ve.mave INNER JOIN account ON ve.matk = account.matk WHERE ve.matk=?", new String[]{matk});
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    ChiTietVe chiTietVe = new ChiTietVe();
                    chiTietVe.setMaVeChiTiet(cursor.getInt(0));
                    chiTietVe.setTenPhim(cursor.getString(1));
                    chiTietVe.setGiaVe(cursor.getInt(2));
                    chiTietVe.setNgayChieu(cursor.getString(3));
                    chiTietVe.setPhongChieu(cursor.getString(4));
                    chiTietVe.setGioChieu(cursor.getString(5));
                    chiTietVe.setGheDaChon(cursor.getInt(6));
                    chiTietVe.setHanSuDung(cursor.getInt(7));
                    chiTietVe.setMaVe(cursor.getInt(8));
                    chiTietVe.setMaLichChieu(cursor.getInt(9));
                    chiTietVe.setMaGhe(cursor.getInt(10));
                    chiTietVe.setEmail(cursor.getString(17));
                    list.add(chiTietVe);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Lỗi" + e);
        }
        return list;
    }
    public ArrayList<ChiTietVe> selectAll1() {
        ArrayList<ChiTietVe> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor =db.rawQuery("SELECT * FROM chitietve INNER JOIN ve ON chitietve.mave = ve.mave INNER JOIN account ON ve.matk = account.matk", null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    ChiTietVe chiTietVe = new ChiTietVe();
                    chiTietVe.setMaVeChiTiet(cursor.getInt(0));
                    chiTietVe.setTenPhim(cursor.getString(1));
                    chiTietVe.setGiaVe(cursor.getInt(2));
                    chiTietVe.setNgayChieu(cursor.getString(3));
                    chiTietVe.setPhongChieu(cursor.getString(4));
                    chiTietVe.setGioChieu(cursor.getString(5));
                    chiTietVe.setGheDaChon(cursor.getInt(6));
                    chiTietVe.setHanSuDung(cursor.getInt(7));
                    chiTietVe.setMaVe(cursor.getInt(8));
                    chiTietVe.setMaLichChieu(cursor.getInt(9));
                    chiTietVe.setMaGhe(cursor.getInt(10));
                    chiTietVe.setEmail(cursor.getString(17));
                    list.add(chiTietVe);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Lỗi" + e);
        }
        return list;
    }
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
        values.put("mavechitiet", chiTietVe.getMaVeChiTiet());
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
    int rowMaCT;
    public boolean checkMaCT(String maCT) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery("SELECT mavechitiet FROM chitietve WHERE chitietve.mavechitiet = ?", new String[] {String.valueOf(maCT)});
            rowMaCT = cursor.getCount();
        } catch (Exception e) {
            Log.i(TAG, "Lỗi" + e);
        }
        return (rowMaCT <= 0) ? true : false;
    }
}
