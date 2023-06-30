package model;

class BangLuong {
    private String maNhanVien;
    private PhongBan phongBan;
    private double tongLuong;

    public BangLuong(String maNhanVien, PhongBan phongBan, double tongLuong) {
        this.maNhanVien = maNhanVien;
        this.phongBan = phongBan;
        this.tongLuong = tongLuong;
    }

    // Getters và setters

    @Override
    public String toString() {
        return "Ma nhan vien: " + maNhanVien + ", Phong ban: " + phongBan.getTenPhongBan() + ", Tong Luong: " + tongLuong;
    }

    // Getters và setters
	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public double getTongLuong() {
		return tongLuong;
	}

	public void setTongLuong(double tongLuong) {
		this.tongLuong = tongLuong;
	}
}