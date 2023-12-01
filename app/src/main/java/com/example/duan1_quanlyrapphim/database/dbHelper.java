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
                "trangthai int NOT NULL, " +
                "matheloai INTEGER REFERENCES theloai(matheloai))";
        String data_phim = "INSERT INTO phim VALUES " +
                "( 1, 'https://i.ytimg.com/vi/fVWlCV9_n7w/maxresdefault.jpg', 'Hành Động', 'Phim hay', 100000, '2023/12/29', 0, 1)," +
                "( 2, 'https://i.ytimg.com/vi/RGU2J4Qi2kk/maxresdefault.jpg', 'Hoạt Hình', 'Phim hay', 600000, '2023/12/28', 0, 2)," +
                "( 3, 'https://i.ytimg.com/vi/RGU2J4Qi2kk/maxresdefault.jpg', 'Hoạt Hình 1', 'Phim hay', 600000, '2023/12/28', 0, 2)," +
                "( 4, 'https://i.ytimg.com/vi/RGU2J4Qi2kk/maxresdefault.jpg', 'Hoạt Hình 2', 'Phim hay', 600000, '2023/12/28', 0, 2)," +
                "( 5, 'https://i.ytimg.com/vi/RGU2J4Qi2kk/maxresdefault.jpg', 'Hoạt Hình 3', 'Phim hay', 600000, '2023/12/28', 0, 2)," +
                "( 6, 'https://i.ytimg.com/vi/RGU2J4Qi2kk/maxresdefault.jpg', 'Hoạt Hình 4', 'Phim hay', 600000, '2023/12/28', 0, 2)," +
                "( 7, 'https://i.ytimg.com/vi/RGU2J4Qi2kk/maxresdefault.jpg', 'Hoạt Hình 5', 'Phim hay', 600000, '2023/12/28', 0, 2)," +
                "( 8, 'https://i.ytimg.com/vi/RGU2J4Qi2kk/maxresdefault.jpg', 'Hoạt Hình 6', 'Phim hay', 600000, '2023/12/28', 0, 2)," +
                "( 9, 'https://bau.vn/wp-content/uploads/2021/07/phim-tinh-cam-my.jpg', 'Lãng Mạn', 'Phim hay', 70000, '2023/12/24', 0, 3)," +
                "( 10, 'https://bau.vn/wp-content/uploads/2021/07/phim-tinh-cam-my.jpg', 'Lãng Mạn 1', 'Phim hay', 70000, '2023/12/24', 0, 3)," +
                "( 11, 'https://bau.vn/wp-content/uploads/2021/07/phim-tinh-cam-my.jpg', 'Lãng Mạn 2', 'Phim hay', 70000, '2023/12/24', 0, 3)," +
                "( 12, 'https://bau.vn/wp-content/uploads/2021/07/phim-tinh-cam-my.jpg', 'Lãng Mạn 3', 'Phim hay', 70000, '2023/12/24', 0, 3)," +
                "( 13, 'https://bau.vn/wp-content/uploads/2021/07/phim-tinh-cam-my.jpg', 'Lãng Mạn 4', 'Phim hay', 70000, '2023/12/24', 0, 3)," +
                "( 14, 'https://bau.vn/wp-content/uploads/2021/07/phim-tinh-cam-my.jpg', 'Lãng Mạn 5', 'Phim hay', 70000, '2023/12/24', 0, 3)," +
                "( 15, 'https://bapcai.vn/wp-content/uploads/2021/07/truyen-hai-huoc-8.jpg', 'Hài Hước', 'Phim hay', 90000, '2023/12/23', 0, 4)";
        db.execSQL(tb_phim);
        db.execSQL(data_phim);
        //Bảng phòng
        String tb_phong = "CREATE TABLE phong(" +
                "maphong INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "sophong TEXT NOT NULL)";
        String data_phong = "INSERT INTO phong VALUES " +
                "( 1, 'Phòng 1')," +
                "( 2, 'Phòng 2')," +
                "( 3, 'Phòng 3')," +
                "( 4, 'Phòng 4')";
        db.execSQL(tb_phong);
        db.execSQL(data_phong);
        //Bảng khung giờ
        String tb_khunggio = "CREATE TABLE khunggio(" +
                "makhunggio INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "khunggio TEXT NOT NULL)";
        String data_khunggio = "INSERT INTO khunggio VALUES " +
                "( 1, '13h - 15h')," +
                "( 2, '15h - 17h')," +
                "( 3, '17h - 19h')," +
                "( 4, '19h - 21h')," +
                "( 5, '21h - 23h')";
        db.execSQL(tb_khunggio);
        db.execSQL(data_khunggio);
        //Bảng lịch chiếu
        String tb_lichchieu = "CREATE TABLE lichchieu(" +
                "malichchieu INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "ngaychieu TEXT NOT NULL, " +
                "maphong INTEGER REFERENCES phong(maphong), " +
                "makhunggio INTEGER REFERENCES khunggio(makhunggio), " +
                "maphim INTEGER REFERENCES phim(maphim))";
        String data_lichchieu = "INSERT INTO lichchieu VALUES " +
                "( 1, '2023/11/25', 1, 1, 1)," +
                "( 2, '2023/11/26', 1, 2, 1)," +
                "( 3, '2023/11/27', 2, 2, 2)," +
                "( 4, '2023/11/27', 3, 3, 3)," +
                "( 5, '2023/11/23', 4, 4, 4)";
        db.execSQL(tb_lichchieu);
        db.execSQL(data_lichchieu);
        //Bảng vé phim
        String tb_vephim = "CREATE TABLE ve(" +
                "mave INTEGER PRIMARY KEY, " +
                "matk INTEGER REFERENCES account(matk), " +
                "maphim INTEGER REFERENCES phim(maphim), " +
                "trangthaithanhtoan INTEGER NOT NULL)";
        String data_vephim = "INSERT INTO ve VALUES " +
                "( 120213, 1, 1, 0)," +
                "( 123123, 2, 2, 0)," +
                "( 231239, 3, 3, 0)," +
                "( 912891, 4, 4, 0)";
        db.execSQL(tb_vephim);
        db.execSQL(data_vephim);
        //Bảng chi tiết vé phim
        String tb_chitetve = "CREATE TABLE chitietve(" +
                "mavechitiet INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tenphim TEXT NOT NULL, " +
                "giave INTEGER NOT NULL, " +
                "ngaychieu TEXT NOT NULL, " +
                "phongchieu TEXT NOT NULL, " +
                "giochieu TEXT NOT NULL, " +
                "ghedachon INTEGER NOT NULL, " +
                "hansudung INTEGER NOT NULL," +
                "mave INTEGER REFERENCES ve(mave)," +
                "malichchieu INTEGER REFERENCES lichchieu(malichchieu)," +
                "maghe INTEGER REFERENCES ghe(maghe))";
        String data_chitietve = "INSERT INTO chitietve VALUES " +
                "( 0, 'Hành Động', 100000, '2023/11/20', 1, '13h - 15h', 6, 0, 1, 6)," +
                "( 1, 'Hành Động', 100000, '2023/11/20', 1, '13h - 15h', 10, 0, 1, 10)," +
                "( 2, 'Hành Động', 100000, '2023/11/20', 1, '13h - 15h', 14, 0, 1, 14)," +
                "( 3, 'Hành Động', 100000, '2023/11/20', 1, '13h - 15h', 17, 0, 1, 17)";
        db.execSQL(tb_chitetve);
//        db.execSQL(data_chitietve);
        String tb_ghe = "CREATE TABLE ghe(" +
                "maghe INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "soghe INTEGER NOT NULL, " +
                "trangthai INTEGER NOT NULL, " +
                "malichchieu INTEGER REFERENCES lichchieu(malichchieu))";
        String data_ghe = "INSERT INTO ghe VALUES " +
                "( 1, 1, 1, 1)," +
                "( 2, 2, 1, 1)," +
                "( 3, 3, 1, 1)," +
                "( 4, 4, 1, 1)," +
                "( 5, 5, 1, 1)," +
                "( 6, 6, 1, 1)," +
                "( 7, 7, 1, 1)," +
                "( 8, 8, 1, 1)," +
                "( 9, 9, 1, 1)," +
                "( 10, 10, 1, 1)," +
                "( 11, 11, 1, 1)," +
                "( 12, 12, 1, 1)," +
                "( 13, 13, 1, 1)," +
                "( 14, 14, 1, 1)," +
                "( 15, 15, 1, 1)," +
                "( 16, 16, 1, 1)," +
                "( 17, 17, 1, 1)," +
                "( 18, 18, 1, 1)," +
                "( 19, 19, 1, 1)," +
                "( 20, 20, 1, 1)";
        db.execSQL(tb_ghe);
        db.execSQL(data_ghe);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion != oldVersion) {
            db.execSQL("");
        }
    }
}
