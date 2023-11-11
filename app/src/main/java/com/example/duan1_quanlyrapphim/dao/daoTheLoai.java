package com.example.duan1_quanlyrapphim.dao;

import static android.service.controls.ControlsProviderService.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1_quanlyrapphim.database.dbHelper;
import com.example.duan1_quanlyrapphim.model.TaiKhoan;
import com.example.duan1_quanlyrapphim.model.TheLoai;

import java.util.ArrayList;

public class daoTheLoai {
    private final dbHelper dbHelper;

    public daoTheLoai(Context context) {
        dbHelper = new dbHelper(context);
    }
    public ArrayList<TheLoai> selectAll() {
        ArrayList<TheLoai> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor =db.rawQuery("SELECT * FROM theloai", null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    TheLoai theloai = new TheLoai();
                    theloai.setMaTheLoai(cursor.getInt(0));
                    theloai.setImgTheLoai(cursor.getString(1));
                    theloai.setTenTheLoai(cursor.getString(2));
                    list.add(theloai);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Lỗi" + e);
        }
        return list;
    }
    public boolean insert(TheLoai tl) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("matheloai", tl.getMaTheLoai());
        values.put("imgtheloai", tl.getImgTheLoai());
        values.put("tentheloai", tl.getTenTheLoai());
        long row = db.insert("theloai", null, values);
        return (row > 0);
    }
    public boolean update(TheLoai tl) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("matheloai", tl.getMaTheLoai());
        values.put("imgtheloai", tl.getImgTheLoai());
        values.put("tentheloai", tl.getTenTheLoai());
        long row = db.update("theloai", values, "matheloai = ?", new String[]{String.valueOf(tl.getMaTheLoai())});
        return (row > 0);
    }
}
