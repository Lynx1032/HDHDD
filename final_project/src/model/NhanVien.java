package model;

public abstract class NhanVien {
    private String maNhanVien;
    private String hoTen;
    private String soDienThoai;
    private String email;
    private PhongBan phongBan;

    public NhanVien(String maNhanVien, String hoTen, String soDienThoai, String email, PhongBan phongBan) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.phongBan = phongBan;
    }

    
    public abstract double tinhLuong();

    
 // Getters và setters

    public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	@Override
    public String toString() {
        return "Ma nhan vien: " + maNhanVien + ", Ho ten: " + hoTen + ", So dien thoai: " + soDienThoai +
                ", Email: " + email + ", Phong ban: " + phongBan.getTenPhongBan();
    }


	public abstract String getLuongThang();
}