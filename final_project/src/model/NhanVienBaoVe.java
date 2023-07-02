package model;

import java.io.Serializable;

public class NhanVienBaoVe extends NhanVienToanThoiGian implements Serializable {
    private double luongThang;

    public NhanVienBaoVe(String maNhanVien, String hoTen, String soDienThoai, String email, PhongBan phongBan, double phuCap, double thuong, double phat) {
        super(maNhanVien, hoTen, soDienThoai, email, phongBan, phuCap, thuong, phat);
        this.luongThang = 5000.0;
    }
    

    @Override
    public double tinhLuong() {
        return this.luongThang + this.getPhuCap() + this.getThuong() - this.getPhat(); // Lương cho nhân viên bảo vệ được tính dựa trên lương tháng
    }


	@Override
	public String getLuongThang() {
		return luongThang + "/" + "thang";
	}
}
