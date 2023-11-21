package com.example.duan1_quanlyrapphim.dao;

import static android.service.controls.ControlsProviderService.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1_quanlyrapphim.database.dbHelper;
import com.example.duan1_quanlyrapphim.model.TaiKhoan;

import java.util.ArrayList;

public class daoTaiKhoan {
    private final dbHelper dbHelper;

    public daoTaiKhoan(Context context) {
        dbHelper = new dbHelper(context);
    }
    public ArrayList<TaiKhoan> selectAll() {
        ArrayList<TaiKhoan> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor =db.rawQuery("SELECT * FROM account WHERE account.vaitro=1", null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    TaiKhoan taiKhoan = new TaiKhoan();
                    taiKhoan.setMaTK(cursor.getInt(0));
                    taiKhoan.setTenNguoiDung(cursor.getString(1));
                    taiKhoan.setEmail(cursor.getString(2));
                    taiKhoan.setMatKhau(cursor.getString(3));
                    taiKhoan.setVaiTro(cursor.getInt(4));
                    list.add(taiKhoan);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Lỗi" + e);
        }
        return list;
    }
    public boolean insert(TaiKhoan tk) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tennguoidung", tk.getTenNguoiDung());
        values.put("email", tk.getEmail());
        values.put("matkhau", tk.getMatKhau());
        values.put("vaitro", tk.getVaiTro());
        long row = db.insert("account", null, values);
        return (row > 0);
    }
    public boolean update(TaiKhoan tk) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tennguoidung", tk.getTenNguoiDung());
        values.put("email", tk.getEmail());
        values.put("matkhau", tk.getMatKhau());
        values.put("vaitro", tk.getVaiTro());
        long row = db.update("account", values, "matk = ?", new String[]{String.valueOf(tk.getMaTK())});
        return (row > 0);
    }
    public boolean checklogin(String username, String password, int vaiTro) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM account WHERE email=? and matkhau=? and vaitro=?", new String[] {username, password, String.valueOf(vaiTro)});
        if (cursor.getCount() != 0)
            return true;
        else
            return false;
    }
}
