package model;

import java.io.Serializable;

public class NhanVienThoiVu extends NhanVien implements Serializable {

	private double luongGio;
    private double phuCap, thuong, phat;
    private double gioLamViec;

    public NhanVienThoiVu(String maNhanVien, String hoTen, String soDienThoai, String email, PhongBan phongBan, double phuCap, double thuong, double phat, double gioLamViec) {
        super(maNhanVien, hoTen, soDienThoai, email, phongBan);
        this.luongGio = 50;
        this.phuCap = phuCap;
        this.thuong = thuong;
        this.phat = phat;
        this.gioLamViec = gioLamViec;
    }
    
    

    public double getGioLamViec() {
		return gioLamViec;
	}


	public void setGioLamViec(int gioLamViec) {
		this.gioLamViec = gioLamViec;
	}



	public double getLuongGio() {
		return luongGio;
	}

	public void setLuongGio(double luongGio) {
		this.luongGio = luongGio;
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
    
    public double getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(double phuCap) {
		this.phuCap = phuCap;
	}

	@Override
    public double tinhLuong() {
        return luongGio*(double)gioLamViec +  this.thuong - this.phat; // Lương cho nhân viên thời vụ được tính dựa trên lương giờ làm việc
    }

	@Override
	public String getLuongThang() {
		// TODO Auto-generated method stub
		return null;
	}
}
