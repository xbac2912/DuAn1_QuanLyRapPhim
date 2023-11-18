package com.example.duan1_quanlyrapphim;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.duan1_quanlyrapphim.fragment.fragment_QLP;
import com.example.duan1_quanlyrapphim.fragment.fragment_taikhoan;
import com.example.duan1_quanlyrapphim.fragment.fragment_trangchu;
import com.example.duan1_quanlyrapphim.fragment.fragment_vecuatoi;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class TrangChu_Admin extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu_admin);
        // set hiển thị frgTrangChu
        Fragment fragmentQLTL = new quanLyTheLoai();
        replaceFrg(fragmentQLTL);
        //
        bottomNavigationView = findViewById(R.id.nav_bottom_bar);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                if (item.getItemId() == R.id.nav_the_loai) {
                    fragment = new quanLyTheLoai();
                    replaceFrg(fragment);
                    Toast.makeText(TrangChu_Admin.this, "Trang Chủ", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.nav_phim) {
                    fragment = new fragment_QLP();
                    replaceFrg(fragment);
                    Toast.makeText(TrangChu_Admin.this, "Lịch sử", Toast.LENGTH_SHORT).show();
                }  else if (item.getItemId() == R.id.nav_ve_xem) {
                    fragment = new fragment_taikhoan();
                    replaceFrg(fragment);
                    Toast.makeText(TrangChu_Admin.this, "Tài khoản", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.nav_tai_khoan) {
                    fragment = new fragment_taikhoan();
                    replaceFrg(fragment);
                    Toast.makeText(TrangChu_Admin.this, "Tài khoản", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
    public void replaceFrg(Fragment frg) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_layout, frg).commit();
    }
}
