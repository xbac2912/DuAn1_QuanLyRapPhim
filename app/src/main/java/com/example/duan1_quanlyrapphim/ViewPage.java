package com.example.duan1_quanlyrapphim;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.duan1_quanlyrapphim.fragment.fragment_phimdaxem;
import com.example.duan1_quanlyrapphim.fragment.fragment_phimsapxem;

public class ViewPage extends FragmentStateAdapter {
    public ViewPage(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new fragment_phimsapxem();
            case 1: return new fragment_phimdaxem();
        }
        return new fragment_phimsapxem();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
