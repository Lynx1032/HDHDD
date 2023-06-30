package model;

import java.util.ArrayList;


public class PhongBan {
    private String maPhongBan;
    private String tenPhongBan;
    private int soLuongNhanVien;
     
    

    public PhongBan(String maPhongBan, String tenPhongBan) {
        this.maPhongBan = maPhongBan;
        this.tenPhongBan = tenPhongBan;
    }
    
    public PhongBan(String maPhongBan, String tenPhongBan, int soLuongNhanVien) {
        this.maPhongBan = maPhongBan;
        this.tenPhongBan = tenPhongBan;
        this.soLuongNhanVien = soLuongNhanVien;
    }

    // Getters và setters

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
	

    @Override
    public String toString() {
        return "Ma phong ban: " + maPhongBan + ", Ten Phong ban: " + tenPhongBan + ", so luong nhan vien: " + soLuongNhanVien;
    }
    
//    public static ArrayList<PhongBan> getDSPhongBan(){
//    	String[] arr_phongBan = {"Thuc Tap", "Thoi Vu", "Kinh Doanh", "Van Hanh", "Ky Thuat", "Bao Ve"};
//    	
//    	int i = 0;
//    	ArrayList<PhongBan> listPhongBan = new ArrayList<PhongBan>();
//    	for(String tenPhong : arr_phongBan) {
//    		PhongBan p = new PhongBan(i + "", tenPhong);
//    		listPhongBan.add(p);
//    	}
//    	return listPhongBan;
//    }
//
//	public static PhongBan getPhongBanById(int indexPhong) {
//		return PhongBan.getDSPhongBan().get(indexPhong);
//	}
//	
//	public static PhongBan getPhongBanByTen(String tenPhong) {
//		ArrayList<PhongBan> listPhong = PhongBan.getDSPhongBan();
//		for(PhongBan phong : listPhong) {
//			if(phong.getTenPhongBan().equals(tenPhong)) {
//				return phong;
//			}
//		}
//		return null;
//	}
}