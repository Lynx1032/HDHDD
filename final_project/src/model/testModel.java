package model;

public class testModel {
	public static void main(String[] args) {
        QLLModel quanLyLuong = new QLLModel();

        // Thêm phòng ban
        PhongBan pb1 = new PhongBan("PB001", "Phong Ke Toan", 5);
        PhongBan pb2 = new PhongBan("PB002", "Phong Kinh doanh", 10);
        quanLyLuong.themPhongBan(pb1);
        quanLyLuong.themPhongBan(pb2);

        // Thêm nhân viên
        NhanVien nv1 = new NhanVienThucTap("NV001", "Nguyen Van A", "0123456789", "nva@gmail.com", pb1, 100, 10);
        NhanVien nv2 = new NhanVienKinhDoanh("NV002", "Nguyen Van B", "0987654321", "nvb@gmail.com", pb2, 100, 100, 10);
        NhanVien nv3 = new NhanVienVanHanh("NV003", "Nguyen Van C", "0123456789", "nvc@gmail.com", pb1, 100, 100, 5);
     
        quanLyLuong.themNhanVien(nv2);
        quanLyLuong.themNhanVien(nv3);
        quanLyLuong.themNhanVien(nv1);

        // Sắp xếp phòng ban và nhân viên theo mã
        quanLyLuong.sapXepPhongBanTheoMaPhongBan();
        quanLyLuong.sapXepNhanVienTheoMaNhanVien();

        // Hiển thị danh sách phòng ban và nhân viên
        System.out.println("Danh sach phong ban:");
        for (PhongBan phongBan : quanLyLuong.getDanhSachPhongBan()) {
            System.out.println(phongBan);
        }

        System.out.println("\nDanh sach nhan vien:");
        for (NhanVien nhanVien : quanLyLuong.getDanhSachNhanVien()) {
            System.out.println(nhanVien);
        }

        // Lập bảng lương và hiển thị
        quanLyLuong.lapBangLuongTheoThang();
        System.out.println("\nDanh sach luong cong ty:");
        quanLyLuong.lapDanhSachLuongCongTy();

        // Hiển thị danh sách lương theo phòng ban
        System.out.println("\nDanh sach luong theo phong ban PB001:");
        quanLyLuong.lapDanhSachLuongTheoPhongBan("PB001");
    }
}
