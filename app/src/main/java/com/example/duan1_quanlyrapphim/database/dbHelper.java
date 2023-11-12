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
                "( 1, 'admin', 'admin@gmail.com', '123', 0)," +
                "( 2, 'user', 'user@gmail.com', 'user', 1)";
        db.execSQL(tb_account);
        db.execSQL(data_account);
        //Bảng thể loại
        String tb_theloai = "CREATE TABLE theloai(" +
                "matheloai INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "imgtheloai TEXT NOT NULL, " +
                "tentheloai TEXT NOT NULL)";
        String data_theloai = "INSERT INTO theloai VALUES " +
                "( 1, 'https://i.ytimg.com/vi/fVWlCV9_n7w/maxresdefault.jpg', 'Hành Động')," +
                "( 2, 'https://i.ytimg.com/vi/RGU2J4Qi2kk/maxresdefault.jpg', 'Hoạt Hình')," +
                "( 3, 'https://bau.vn/wp-content/uploads/2021/07/phim-tinh-cam-my.jpg', 'Lãng Mạn')," +
                "( 4, 'https://bapcai.vn/wp-content/uploads/2021/07/truyen-hai-huoc-8.jpg', 'Hài Hước')";
        db.execSQL(tb_theloai);
        db.execSQL(data_theloai);
        //Bảng phim
        String tb_phim = "CREATE TABLE phim(" +
                "maphim INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "imgphim TEXT NOT NULL, " +
                "tenphim TEXT NOT NULL, " +
                "mota TEXT NOT NULL, " +
                "giave INTEGER NOT NULL, " +
                "khoichieu TEXT NOT NULL, " +
                "matheloai TEXT REFERENCES theloai(matheloai))";
        String data_phim = "INSERT INTO phim VALUES " +
                "( 1, 'https://i.ytimg.com/vi/fVWlCV9_n7w/maxresdefault.jpg', 'Hành Động', 'Phim hay', 100000, '2023/12/29', 1)," +
                "( 2, 'https://i.ytimg.com/vi/RGU2J4Qi2kk/maxresdefault.jpg', 'Hoạt Hình', 'Phim hay', 600000, '2023/12/28', 2)," +
                "( 3, 'https://i.ytimg.com/vi/RGU2J4Qi2kk/maxresdefault.jpg', 'Hoạt Hình 1', 'Phim hay', 600000, '2023/12/28', 2)," +
                "( 4, 'https://i.ytimg.com/vi/RGU2J4Qi2kk/maxresdefault.jpg', 'Hoạt Hình 2', 'Phim hay', 600000, '2023/12/28', 2)," +
                "( 5, 'https://i.ytimg.com/vi/RGU2J4Qi2kk/maxresdefault.jpg', 'Hoạt Hình 3', 'Phim hay', 600000, '2023/12/28', 2)," +
                "( 6, 'https://i.ytimg.com/vi/RGU2J4Qi2kk/maxresdefault.jpg', 'Hoạt Hình 4', 'Phim hay', 600000, '2023/12/28', 2)," +
                "( 7, 'https://i.ytimg.com/vi/RGU2J4Qi2kk/maxresdefault.jpg', 'Hoạt Hình 5', 'Phim hay', 600000, '2023/12/28', 2)," +
                "( 8, 'https://i.ytimg.com/vi/RGU2J4Qi2kk/maxresdefault.jpg', 'Hoạt Hình 6', 'Phim hay', 600000, '2023/12/28', 2)," +
                "( 9, 'https://bau.vn/wp-content/uploads/2021/07/phim-tinh-cam-my.jpg', 'Lãng Mạn', 'Phim hay', 70000, '2023/12/24', 3)," +
                "( 10, 'https://bau.vn/wp-content/uploads/2021/07/phim-tinh-cam-my.jpg', 'Lãng Mạn 1', 'Phim hay', 70000, '2023/12/24', 3)," +
                "( 11, 'https://bau.vn/wp-content/uploads/2021/07/phim-tinh-cam-my.jpg', 'Lãng Mạn 2', 'Phim hay', 70000, '2023/12/24', 3)," +
                "( 12, 'https://bau.vn/wp-content/uploads/2021/07/phim-tinh-cam-my.jpg', 'Lãng Mạn 3', 'Phim hay', 70000, '2023/12/24', 3)," +
                "( 13, 'https://bau.vn/wp-content/uploads/2021/07/phim-tinh-cam-my.jpg', 'Lãng Mạn 4', 'Phim hay', 70000, '2023/12/24', 3)," +
                "( 14, 'https://bau.vn/wp-content/uploads/2021/07/phim-tinh-cam-my.jpg', 'Lãng Mạn 5', 'Phim hay', 70000, '2023/12/24', 3)," +
                "( 15, 'https://bapcai.vn/wp-content/uploads/2021/07/truyen-hai-huoc-8.jpg', 'Hài Hước', 'Phim hay', 90000, '2023/12/23', 4)";
        db.execSQL(tb_phim);
        db.execSQL(data_phim);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion != oldVersion) {
            db.execSQL("");
        }
    }
}
