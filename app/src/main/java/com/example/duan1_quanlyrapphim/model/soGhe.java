package com.example.duan1_quanlyrapphim.model;

public class soGhe {
    private int maGhe;
    private int SoGhe;
    private int trangThai;

    public soGhe() {
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public soGhe(int maGhe, int soGhe, int trangThai) {
        this.maGhe = maGhe;
        SoGhe = soGhe;
        this.trangThai = trangThai;
    }

    public int getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(int maGhe) {
        this.maGhe = maGhe;
    }

    public int getSoGhe() {
        return SoGhe;
    }

    public void setSoGhe(int soGhe) {
        SoGhe = soGhe;
    }
}
