package model;

import java.io.*;


public class NhanVienKyThuat extends NhanVienToanThoiGian {
    private double luongThang;

    public NhanVienKyThuat(String maNhanVien, String hoTen, String soDienThoai, String email, PhongBan phongBan, double phuCap, double thuong, double phat) {
        super(maNhanVien, hoTen, soDienThoai, email, phongBan, phuCap, thuong, phat);
        this.luongThang = 10000.0;
    }
    
    @Override
	public String getLuongThang() {
		return luongThang + "/" + "thang";
	}


	public void setLuongThang(double luongThang) {
		this.luongThang = luongThang;
	}
	//end getter and setter

	
	@Override
    public double tinhLuong() {
        return luongThang + this.getPhuCap() + this.getThuong() - this.getPhat(); // Lương cho nhân viên kỹ thuật được tính dựa trên lương tháng
    }
}