package com.example.duan1_quanlyrapphim.model;

public class ChiTietVe {
    private int maVeChiTiet;
    private String tenPhim;
    private int giaVe;
    private String ngayChieu;
    private String phongChieu;
    private String gioChieu;
    private int gheDaChon;
    private int hanSuDung;
    private int maVe;
    private int maLichChieu;
    private int maGhe;

    public ChiTietVe() {
    }

    public ChiTietVe(String tenPhim, int giaVe, String ngayChieu, String phongChieu, String gioChieu, int gheDaChon, int hanSuDung, int maVe, int maLichChieu, int maGhe) {
        this.tenPhim = tenPhim;
        this.giaVe = giaVe;
        this.ngayChieu = ngayChieu;
        this.phongChieu = phongChieu;
        this.gioChieu = gioChieu;
        this.gheDaChon = gheDaChon;
        this.hanSuDung = hanSuDung;
        this.maVe = maVe;
        this.maLichChieu = maLichChieu;
        this.maGhe = maGhe;
    }

    public int getMaVeChiTiet() {
        return maVeChiTiet;
    }

    public void setMaVeChiTiet(int maVeChiTiet) {
        this.maVeChiTiet = maVeChiTiet;
    }

    public int getMaVe() {
        return maVe;
    }

    public void setMaVe(int maVe) {
        this.maVe = maVe;
    }

    public int getMaLichChieu() {
        return maLichChieu;
    }

    public void setMaLichChieu(int maLichChieu) {
        this.maLichChieu = maLichChieu;
    }

    public int getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(int maGhe) {
        this.maGhe = maGhe;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public int getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(int giaVe) {
        this.giaVe = giaVe;
    }

    public String getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(String ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public String getPhongChieu() {
        return phongChieu;
    }

    public void setPhongChieu(String phongChieu) {
        this.phongChieu = phongChieu;
    }

    public String getGioChieu() {
        return gioChieu;
    }

    public void setGioChieu(String gioChieu) {
        this.gioChieu = gioChieu;
    }

    public int getGheDaChon() {
        return gheDaChon;
    }

    public void setGheDaChon(int gheDaChon) {
        this.gheDaChon = gheDaChon;
    }

    public int getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(int hanSuDung) {
        this.hanSuDung = hanSuDung;
    }
}
