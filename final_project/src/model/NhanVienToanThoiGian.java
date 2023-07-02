package model;

import java.io.Serializable;

public abstract class NhanVienToanThoiGian extends NhanVien implements  Serializable{
	private double phuCap;
	private double thuong;
	private double phat;
	
	//Constructor
    public NhanVienToanThoiGian(String maNhanVien, String hoTen, String soDienThoai, String email, PhongBan phongBan,double phuCap,double thuong,double phat) {
        super(maNhanVien, hoTen, soDienThoai, email, phongBan);
        this.phuCap = phuCap;
        this.thuong = thuong;
        this.phat = phat;
    }

    //begin getter and setter

	public double getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(double phuCap) {
		this.phuCap = phuCap;
	}

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
    public abstract String getLuongThang();
	
	
}
