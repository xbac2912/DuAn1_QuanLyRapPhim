package com.example.duan1_quanlyrapphim.model;

public class TheLoai {
    private int maTheLoai;
    private String imgTheLoai;
    private String tenTheLoai;

    public TheLoai(int maTheLoai, String imgTheLoai, String tenTheLoai) {
        this.maTheLoai = maTheLoai;
        this.imgTheLoai = imgTheLoai;
        this.tenTheLoai = tenTheLoai;
    }

    public TheLoai() {
    }

    public int getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(int maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getImgTheLoai() {
        return imgTheLoai;
    }

    public void setImgTheLoai(String imgTheLoai) {
        this.imgTheLoai = imgTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }
}
