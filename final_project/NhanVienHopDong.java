public class NhanVienHopDong extends NhanVien {
    private int thoiHanHopDong;

    public NhanVienHopDong(String maNhanVien, String hoTen, String soDienThoai, String email, PhongBan phongBan, int thoiHanHopDong) {
        super(maNhanVien, hoTen, soDienThoai, email, phongBan);
        this.thoiHanHopDong = thoiHanHopDong;
    }

    public int getThoiHanHopDong() {
        return thoiHanHopDong;
    }

    public void setThoiHanHopDong(int thoiHanHopDong) {
        this.thoiHanHopDong = thoiHanHopDong;
    }

    @Override
    public double tinhLuong() {
        return getLuongNhanVien() + getPhuCap() + getThuong() - getPhat();
    }
}