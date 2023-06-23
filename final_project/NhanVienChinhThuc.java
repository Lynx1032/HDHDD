public class NhanVienChinhThuc extends NhanVien {
    private String loaiHopDong;

    public NhanVienChinhThuc(String maNhanVien, String hoTen, String soDienThoai, String email, PhongBan phongBan, String loaiHopDong) {
        super(maNhanVien, hoTen, soDienThoai, email, phongBan);
        this.loaiHopDong = loaiHopDong;
    }

    public String getLoaiHopDong() {
        return loaiHopDong;
    }

    public void setLoaiHopDong(String loaiHopDong) {
        this.loaiHopDong = loaiHopDong;
    }

    @Override
    public double tinhLuong() {
        return getLuongNhanVien() + getPhuCap() + getThuong() - getPhat();
    }
}