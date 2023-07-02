package model;

import java.io.Serializable;

public class NhanVienVanHanh extends NhanVienToanThoiGian implements Serializable {
    private double luongThang;


	public NhanVienVanHanh(String maNhanVien, String hoTen, String soDienThoai, String email, PhongBan phongBan, double phuCap,double thuong,double phat) {
        super(maNhanVien, hoTen, soDienThoai, email, phongBan, phuCap, thuong, phat);
        this.luongThang = 8000.0;
    }
	

	@Override
	public String getLuongThang() {
		return luongThang + "/" + "thang";
	}

	public void setLuongThang(double luongThang) {
		this.luongThang = luongThang;
	}

    @Override
    public double tinhLuong() {
        return luongThang + this.getPhuCap() + this.getThuong() - this.getPhat(); // Lương cho nhân viên vận hành được tính dựa trên lương tháng
    }
}