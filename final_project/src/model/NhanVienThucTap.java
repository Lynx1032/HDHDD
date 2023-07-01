package model;

import java.io.*;


public class NhanVienThucTap extends NhanVien implements Serializable{
	private double thuong;
	private double phat;
	
    public NhanVienThucTap(String maNhanVien, String hoTen, String soDienThoai, String email, PhongBan phongBan,double thuong,double phat) {
        super(maNhanVien, hoTen, soDienThoai, email, phongBan);
        this.thuong = thuong;
        this.phat = phat;
    }
    
    //begin getter and setter
    public double getThuong() {
		return thuong;
	}


	public void setThuong(double thuong) {
		this.thuong = thuong;
	}


	public double getPhat() {
		return phat;
	}


	public void setPhat(double phat) {
		this.phat = phat;
	}
	//end getter and setter


	@Override
    public double tinhLuong() {
        return 0 + this.thuong - this.phat; // Nhân viên thực tập không có lương
    }

	@Override
	public String getLuongThang() {
		// TODO Auto-generated method stub
		return null;
	}
}
