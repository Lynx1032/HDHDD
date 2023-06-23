import java.util.ArrayList;

public class PhongBan {

    private String maPhongBan;
    private String tenPhongBan;
    private int soLuongNhanVien;
    private ArrayList<NhanVien> danhSachNhanVien;

    public PhongBan(String maPhongBan, String tenPhongBan, int soLuongNhanVien) {
        this.maPhongBan = maPhongBan;
        this.tenPhongBan = tenPhongBan;
        this.soLuongNhanVien = soLuongNhanVien;
        danhSachNhanVien = new ArrayList<NhanVien>();
    }

    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public int getSoLuongNhanVien() {
        return soLuongNhanVien;
    }

    public void setSoLuongNhanVien(int soLuongNhanVien) {
        this.soLuongNhanVien = soLuongNhanVien;
    }

    public ArrayList<NhanVien> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    public void themNhanVien(NhanVien nhanVien) {
        danhSachNhanVien.add(nhanVien);
    }
	
	public void xoaNhanVien(NhanVien nhanVien) {
        danhSachNhanVien.remove(nhanVien);
    }
	
	public void capNhatNhanVien(NhanVien nhanVien) {
    // This method assumes that the danhSachNhanVien list is already updated
    // with the new NhanVien object. If you need to modify the list, you can
    // implement that logic here.
	}

    public double tinhTongLuong() {
        double tongLuong = 0;
        for (NhanVien nhanVien : danhSachNhanVien) {
            tongLuong += nhanVien.tinhLuong();
        }
        return tongLuong;
    }

    public double tinhLuongTrungBinh() {
        return tinhTongLuong() / danhSachNhanVien.size();
    }

    public NhanVien timNhanVienTheoMa(String maNhanVien) {
        for (NhanVien nhanVien : danhSachNhanVien) {
            if (nhanVien.getMaNhanVien().equals(maNhanVien)) {
                return nhanVien;
            }
        }
        return null;
    }

}