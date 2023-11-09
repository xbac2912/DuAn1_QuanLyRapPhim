package com.example.duan1_quanlyrapphim.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    private static final String dbName = "QLRP";
    private static final int version = 1;

    public dbHelper(@Nullable Context context) {
        super(context, dbName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Bảng account
        String tb_account = "CREATE TABLE account(" +
                "matk INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tennguoidung TEXT NOT NULL, " +
                "email TEXT NOT NULL, " +
                "matkhau TEXT NOT NULL, " +
                "vaitro INTEGER NOT NULL)";
        String data_account = "INSERT INTO account VALUES " +
                "( 1, 'admin', 'admin@gmail.com', 'admin', 0)," +
                "( 2, 'user', 'user@gmail.com', 'user', 1)";
        db.execSQL(tb_account);
        db.execSQL(data_account);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion != oldVersion) {
            db.execSQL("");
        }
    }
}
