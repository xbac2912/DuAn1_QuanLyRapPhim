package com.example.duan1_quanlyrapphim.dao;

import static android.service.controls.ControlsProviderService.TAG;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1_quanlyrapphim.database.dbHelper;
import com.example.duan1_quanlyrapphim.model.LichChieu;
import com.example.duan1_quanlyrapphim.model.Phim;

import java.util.ArrayList;

public class daoLichChieu {
    private final dbHelper dbHelper;

    public daoLichChieu(Context context) {
        dbHelper = new dbHelper(context);
    }
    public ArrayList<LichChieu> selectAll(String maPhim) {
        ArrayList<LichChieu> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor =db.rawQuery("SELECT * FROM lichchieu INNER JOIN phong ON lichchieu.maphong = phong.maphong INNER JOIN khunggio ON lichchieu.makhunggio = khunggio.makhunggio INNER JOIN phim ON lichchieu.maphim = phim.maphim WHERE phim.maphim=?", new String[]{maPhim});
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    LichChieu lichChieu = new LichChieu();
                    lichChieu.setMaLichChieu(cursor.getInt(0));
                    lichChieu.setNgayChieu(cursor.getString(1));
                    lichChieu.setMaPhong(cursor.getInt(2));
                    lichChieu.setMaKhungGio(cursor.getInt(3));
                    lichChieu.setMaPhim(cursor.getInt(4));
                    lichChieu.setKhungGio(cursor.getString(8));
                    lichChieu.setTenPhim(cursor.getString(11));
                    list.add(lichChieu);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Lỗi" + e);
        }
        return list;
    }
    public ArrayList<LichChieu> KhungGio(String maPhim ,String ngay) {
        ArrayList<LichChieu> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor =db.rawQuery("SELECT khunggio, malichchieu FROM lichchieu INNER JOIN phong ON lichchieu.maphong = phong.maphong INNER JOIN khunggio ON lichchieu.makhunggio = khunggio.makhunggio INNER JOIN phim ON lichchieu.maphim = phim.maphim WHERE phim.maphim=? AND lichchieu.ngaychieu=?", new String[]{ maPhim, ngay});
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    LichChieu lichChieu = new LichChieu();
                    lichChieu.setKhungGio(cursor.getString(0));
                    lichChieu.setMaLichChieu(cursor.getInt(1));
                    list.add(lichChieu);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Lỗi" + e);
        }
        return list;
    }
    String phong;
    public String getPhong(String maPhim, String maLichChieu) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor =db.rawQuery("SELECT sophong FROM lichchieu INNER JOIN phong ON lichchieu.maphong = phong.maphong INNER JOIN khunggio ON lichchieu.makhunggio = khunggio.makhunggio INNER JOIN phim ON lichchieu.maphim = phim.maphim WHERE phim.maphim=? AND lichchieu.malichchieu=?", new String[]{maPhim, maLichChieu});
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    phong = cursor.getString(0);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Lỗi" + e);
        }
        return phong;
    }
    String gioChieu;
    public String getGioChieu(String maPhim, String maLichChieu) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor =db.rawQuery("SELECT khunggio FROM lichchieu INNER JOIN phong ON lichchieu.maphong = phong.maphong INNER JOIN khunggio ON lichchieu.makhunggio = khunggio.makhunggio INNER JOIN phim ON lichchieu.maphim = phim.maphim WHERE phim.maphim=? AND lichchieu.malichchieu=?", new String[]{maPhim, maLichChieu});
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    gioChieu = cursor.getString(0);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Lỗi" + e);
        }
        return gioChieu;
    }
    public ArrayList<LichChieu> getData() {
        ArrayList<LichChieu> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor =db.rawQuery("SELECT * FROM lichchieu INNER JOIN phong ON lichchieu.maphong = phong.maphong INNER JOIN khunggio ON lichchieu.makhunggio = khunggio.makhunggio INNER JOIN phim ON lichchieu.maphim = phim.maphim", null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    LichChieu lichChieu = new LichChieu();
                    lichChieu.setMaLichChieu(cursor.getInt(0));
                    lichChieu.setNgayChieu(cursor.getString(1));
                    lichChieu.setMaPhong(cursor.getInt(2));
                    lichChieu.setMaKhungGio(cursor.getInt(3));
                    lichChieu.setMaPhim(cursor.getInt(4));
                    lichChieu.setKhungGio(cursor.getString(8));
                    lichChieu.setTenPhim(cursor.getString(11));
                    list.add(lichChieu);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Lỗi" + e);
        }
        return list;
    }
}
