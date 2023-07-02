public class NhanVien {

    private String maNhanVien;
    private String hoTen;
    private double heSoLuong;
    private int soNgayLamViec;

    public NhanVien(String maNhanVien, String hoTen, double heSoLuong, int soNgayLamViec) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.heSoLuong = heSoLuong;
		this.soNgayLamViec = soNgayLamViec;
    }

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

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public double tinhLuong() {
        return heSoLuong * 1000000 * soNgayLamViec / 26;
    }

}