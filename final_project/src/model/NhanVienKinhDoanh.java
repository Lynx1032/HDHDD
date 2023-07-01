package model;

public class NhanVienKinhDoanh extends NhanVienToanThoiGian {
    private double luongNgay;

    public NhanVienKinhDoanh(String maNhanVien, String hoTen, String soDienThoai, String email, PhongBan phongBan, double phuCap,double thuong,double phat) {
        super(maNhanVien, hoTen, soDienThoai, email, phongBan, phuCap, thuong, phat);
        this.luongNgay = 200.0;
    }

    @Override
    public double tinhLuong() {
        return luongNgay * 30 + this.getPhuCap() + this.getThuong() - this.getPhat(); // Lương cho nhân viên kinh doanh được tính dựa trên lương ngày làm việc
    }

	@Override
	public String getLuongThang() {
		return luongNgay + "/" + "ngay";
	}
}
