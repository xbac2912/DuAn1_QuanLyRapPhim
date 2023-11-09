package com.example.duan1_quanlyrapphim.model;

public class TaiKhoan {
    private int maTK;
    private String tenNguoiDung;
    private String email;
    private String matKhau;
    private int vaiTro;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenNguoiDung, String email, String matKhau, int vaiTro) {
        this.tenNguoiDung = tenNguoiDung;
        this.email = email;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public int getMaTK() {
        return maTK;
    }

    public void setMaTK(int maTK) {
        this.maTK = maTK;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(int vaiTro) {
        this.vaiTro = vaiTro;
    }
}
