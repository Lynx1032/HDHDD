package model;

import java.util.*;

public class QLLModel {
    private ArrayList<PhongBan> danhSachPhongBan;
    private ArrayList<NhanVien> danhSachNhanVien;
    private ArrayList<BangLuong> danhSachBangLuong;
    private boolean luaChonNV;
    private boolean luaChonPB;
    private String tenFile;
    

    public QLLModel() {
        danhSachPhongBan = new ArrayList<>();
        danhSachNhanVien = new ArrayList<>();
        danhSachBangLuong = new ArrayList<>();
        this.tenFile = "";
    }
    

    //begin getter and setter
    
    //getter and setter tenFile;
	public String getTenFile() {
		return tenFile;
	}


	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	
	public boolean getLuaChonNV() {
		return this.luaChonNV;
	}
	
	public void setLuaChonNV(boolean luaChonNV) {
		this.luaChonNV = luaChonNV;
	}
	
	public boolean getLuaChonPB() {
		return this.luaChonPB;
	}
	
	public void setLuaChonPB(boolean luaChonPB) {
		this.luaChonPB = luaChonPB;
	}
	
	
    // Getters và setters cho danh sách phòng ban, nhân viên và bảng lương
    public ArrayList<PhongBan> getDanhSachPhongBan() {
        return danhSachPhongBan;
    }

    public void setDanhSachPhongBan(ArrayList<PhongBan> danhSachPhongBan) {
        this.danhSachPhongBan = danhSachPhongBan;
    }

    public ArrayList<NhanVien> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    public void setDanhSachNhanVien(ArrayList<NhanVien> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }

    public ArrayList<BangLuong> getDanhSachBangLuong() {
        return danhSachBangLuong;
    }

    public void setDanhSachBangLuong(ArrayList<BangLuong> danhSachBangLuong) {
        this.danhSachBangLuong = danhSachBangLuong;
    }
    //end getter and setter


	
	// Phương thức quản lý phòng ban

	public void themPhongBan(PhongBan phongBan) {
        danhSachPhongBan.add(phongBan);
    }

    public void suaThongTinPhongBan(String maPhongBan, String tenPhongBan, int soLuongNhanVien) {
        for (PhongBan phongBan : danhSachPhongBan) {
            if (phongBan.getMaPhongBan().equals(maPhongBan)) {
                phongBan.setTenPhongBan(tenPhongBan);
                phongBan.setSoLuongNhanVien(soLuongNhanVien);
                break;
            }
        }
    }

    public void xoaPhongBan(String maPhongBan) {
        for (PhongBan phongBan : danhSachPhongBan) {
            if (phongBan.getMaPhongBan().equals(maPhongBan)) {
                danhSachPhongBan.remove(phongBan);
                break;
            }
        }
    }

    public PhongBan timKiemPhongBan(String maPhongBan) {
        for (PhongBan phongBan : danhSachPhongBan) {
            if (phongBan.getMaPhongBan().equals(maPhongBan)) {
                return phongBan;
            }
        }
        return null;
    }

    public void sapXepPhongBanTheoMaPhongBan() {
        Collections.sort(danhSachPhongBan, new Comparator<PhongBan>() {
            @Override
            public int compare(PhongBan pb1, PhongBan pb2) {
                return pb1.getMaPhongBan().compareTo(pb2.getMaPhongBan());
            }
        });
    }

    public void xemDanhSachNhanVienPhongBan(String maPhongBan) {
        for (NhanVien nhanVien : danhSachNhanVien) {
            if (nhanVien.getPhongBan().getMaPhongBan().equals(maPhongBan)) {
                System.out.println(nhanVien);
            }
        }
    }
    
    //Chắp Vá từ class PhongBan
    public ArrayList<PhongBan> getDSPhongBan(){
    	//String[] arr_phongBan = {"Thuc Tap", "Thoi Vu", "Kinh Doanh", "Van Hanh", "Ky Thuat", "Bao Ve"};
    	ArrayList<String> arr_phongBan = new ArrayList<>();
    	for(PhongBan pb : this.danhSachPhongBan) {
    		arr_phongBan.add(pb.getTenPhongBan());
    	}
    	
    	int i = 0;
    	ArrayList<PhongBan> listPhongBan = new ArrayList<PhongBan>();
    	for(String tenPhong : arr_phongBan) {
    		PhongBan p = new PhongBan(i + "", tenPhong);
    		listPhongBan.add(p);
    	}
    	return listPhongBan;
    }
    
    public PhongBan getPhongBanById(int indexPhong) {
		return this.getDSPhongBan().get(indexPhong);
	}
    
    public PhongBan getPhongBanByTen(String tenPhong) {
		ArrayList<PhongBan> listPhong = this.getDSPhongBan();
		for(PhongBan phong : listPhong) {
			if(phong.getTenPhongBan().equals(tenPhong)) {
				return phong;
			}
		}
		return null;
	}
    
    

    // Phương thức quản lý nhân viên

    public void themNhanVien(NhanVien nhanVien) {
        this.danhSachNhanVien.add(nhanVien);
        if(nhanVien.getPhongBan().getTenPhongBan().equals("Thuc Tap")) {
        	for(PhongBan pb : danhSachPhongBan) {
        		if(pb.getTenPhongBan().equals("Thuc Tap")) {
        			danhSachPhongBan.remove(pb);
        			pb.setSoLuongNhanVien(pb.getSoLuongNhanVien() + 1);
        			danhSachPhongBan.add(pb);
        			break;
        		}
        	}
        } else if(nhanVien.getPhongBan().getTenPhongBan().equals("Thoi Vu")) {
        	for(PhongBan pb : danhSachPhongBan) {
        		if(pb.getTenPhongBan().equals("Thoi Vu")) {
        			danhSachPhongBan.remove(pb);
        			pb.setSoLuongNhanVien(pb.getSoLuongNhanVien() + 1);
        			danhSachPhongBan.add(pb);
        			break;
        		}
        	}
        } else if(nhanVien.getPhongBan().getTenPhongBan().equals("Kinh Doanh")) {
        	for(PhongBan pb : danhSachPhongBan) {
        		if(pb.getTenPhongBan().equals("Kinh Doanh")) {
        			danhSachPhongBan.remove(pb);
        			pb.setSoLuongNhanVien(pb.getSoLuongNhanVien() + 1);
        			danhSachPhongBan.add(pb);
        			break;
        		}
        	}
        } else if(nhanVien.getPhongBan().getTenPhongBan().equals("Van Hanh")) {
        	for(PhongBan pb : danhSachPhongBan) {
        		if(pb.getTenPhongBan().equals("Van Hanh")) {
        			danhSachPhongBan.remove(pb);
        			pb.setSoLuongNhanVien(pb.getSoLuongNhanVien() + 1);
        			danhSachPhongBan.add(pb);
        			break;
        		}
        	}
        } else if(nhanVien.getPhongBan().getTenPhongBan().equals("Ky Thuat")) {
        	for(PhongBan pb : danhSachPhongBan) {
        		if(pb.getTenPhongBan().equals("Ky Thuat")) {
        			danhSachPhongBan.remove(pb);
        			pb.setSoLuongNhanVien(pb.getSoLuongNhanVien() + 1);
        			danhSachPhongBan.add(pb);
        			break;
        		}
        	}
        } else if(nhanVien.getPhongBan().getTenPhongBan().equals("Bao Ve")) {
        	for(PhongBan pb : danhSachPhongBan) {
        		if(pb.getTenPhongBan().equals("Bao Ve")) {
        			danhSachPhongBan.remove(pb);
        			pb.setSoLuongNhanVien(pb.getSoLuongNhanVien() + 1);
        			danhSachPhongBan.add(pb);
        			break;
        		}
        	}
        }
    }
    
    public void updateNhanVien(NhanVien nhanVien) {
    	for(NhanVien nv : danhSachNhanVien) {
    		if(nv.getMaNhanVien().equals(nhanVien.getMaNhanVien())) {
    			danhSachNhanVien.remove(nv);
    			danhSachNhanVien.add(nhanVien);
    		}
    	}
    }

    public void suaThongTinNhanVien(String maNhanVien, String hoTen, String soDienThoai, String email) {
        for (NhanVien nhanVien : danhSachNhanVien) {
            if (nhanVien.getMaNhanVien().equals(maNhanVien)) {
                nhanVien.setHoTen(hoTen);
                nhanVien.setSoDienThoai(soDienThoai);
                nhanVien.setEmail(email);
                break;
            }
        }
    }

    public void xoaNhanVien(NhanVien nhanVien) {
        for(NhanVien nv : this.danhSachNhanVien) {
        	
        	if(nv.getMaNhanVien().equals(nhanVien.getMaNhanVien())) {
        		this.danhSachNhanVien.remove(nv);
        		if(nhanVien.getPhongBan().getTenPhongBan().equals("Thuc Tap")) {
                	for(PhongBan pb : danhSachPhongBan) {
                		if(pb.getTenPhongBan().equals("Thuc Tap")) {
                			pb.setSoLuongNhanVien(pb.getSoLuongNhanVien() - 1);
                		}
                	}
                } else if(nhanVien.getPhongBan().getTenPhongBan().equals("Thoi Vu")) {
                	for(PhongBan pb : danhSachPhongBan) {
                		if(pb.getTenPhongBan().equals("Thoi Vu")) {
                			pb.setSoLuongNhanVien(pb.getSoLuongNhanVien() - 1);
                		}
                	}
                } else if(nhanVien.getPhongBan().getTenPhongBan().equals("Kinh Doanh")) {
                	for(PhongBan pb : danhSachPhongBan) {
                		if(pb.getTenPhongBan().equals("Kinh Doanh")) {
                			pb.setSoLuongNhanVien(pb.getSoLuongNhanVien() - 1);
                		}
                	}
                } else if(nhanVien.getPhongBan().getTenPhongBan().equals("Van Hanh")) {
                	for(PhongBan pb : danhSachPhongBan) {
                		if(pb.getTenPhongBan().equals("Van Hanh")) {
                			pb.setSoLuongNhanVien(pb.getSoLuongNhanVien() - 1);
                		}
                	}
                } else if(nhanVien.getPhongBan().getTenPhongBan().equals("Ky Thuat")) {
                	for(PhongBan pb : danhSachPhongBan) {
                		if(pb.getTenPhongBan().equals("Ky Thuat")) {
                			pb.setSoLuongNhanVien(pb.getSoLuongNhanVien() - 1);
                		}
                	}
                } else if(nhanVien.getPhongBan().getTenPhongBan().equals("Bao Ve")) {
                	for(PhongBan pb : danhSachPhongBan) {
                		if(pb.getTenPhongBan().equals("Bao Ve")) {
                			pb.setSoLuongNhanVien(pb.getSoLuongNhanVien() - 1);
                		}
                	}
                }
        		break;
        	}
        }
    }

    public NhanVien timKiemNhanVien(String maNhanVien) {
        for (NhanVien nhanVien : danhSachNhanVien) {
            if (nhanVien.getMaNhanVien().equals(maNhanVien)) {
                return nhanVien;
            }
        }
        return null;
    }

    public void sapXepNhanVienTheoMaNhanVien() {
        Collections.sort(danhSachNhanVien, new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien nv1, NhanVien nv2) {
                return nv1.getMaNhanVien().compareTo(nv2.getMaNhanVien());
            }
        });
    }
    
    
	public boolean kiemTraTonTai(NhanVienToanThoiGian nvToanTG) {
		for(NhanVien nv : danhSachNhanVien) {
			if(nv.getMaNhanVien().equals(nvToanTG.getMaNhanVien())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean kiemTraTonTai(NhanVienThucTap nvThucTap) {
		for(NhanVien nv : danhSachNhanVien) {
			if(nv.getMaNhanVien().equals(nvThucTap.getMaNhanVien())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean kiemTraTonTai(NhanVienThoiVu nvThoiVu) {
		for(NhanVien nv : danhSachNhanVien) {
			if(nv.getMaNhanVien().equals(nvThoiVu.getMaNhanVien())) {
				return true;
			}
		}
		return false;
	}


    // Phương thức quản lý bảng lương

    public void lapBangLuongTheoThang() {
        danhSachBangLuong.clear();
        for (NhanVien nhanVien : danhSachNhanVien) {
            double tongLuong = nhanVien.tinhLuong();
            BangLuong bangLuong = new BangLuong(nhanVien.getMaNhanVien(), nhanVien.getPhongBan(), tongLuong);
            danhSachBangLuong.add(bangLuong);
        }
    }

    public void lapDanhSachLuongCongTy() {
        for (BangLuong bangLuong : danhSachBangLuong) {
            System.out.println(bangLuong);
        }
    }

    public void lapDanhSachLuongTheoPhongBan(String maPhongBan) {
        List<BangLuong> danhSachLuongTheoPhongBan = new ArrayList<>();
        for (BangLuong bangLuong : danhSachBangLuong) {
            if (bangLuong.getPhongBan().getMaPhongBan().equals(maPhongBan)) {
                danhSachLuongTheoPhongBan.add(bangLuong);
            }
        }
        Collections.sort(danhSachLuongTheoPhongBan, new Comparator<BangLuong>() {
            @Override
            public int compare(BangLuong bl1, BangLuong bl2) {
                return Double.compare(bl1.getTongLuong(), bl2.getTongLuong());
            }
        });
        for (BangLuong bangLuong : danhSachLuongTheoPhongBan) {
            System.out.println(bangLuong);
        }
    }
    
    public void sapXepBangLuongTheoTongLuong() {
    	Collections.sort(danhSachBangLuong, new Comparator<BangLuong>() {
            @Override
            public int compare(BangLuong bl1, BangLuong bl2) {
                return Double.compare(bl1.getTongLuong(), bl2.getTongLuong());
            }
        });
    }


	public boolean kiemTraTonTaiPB(PhongBan phongBan) {
		for(PhongBan pb : danhSachPhongBan) {
			if(pb.getMaPhongBan().equals(phongBan.getMaPhongBan())) {
				return true;
			}
		}
		return false;
	}


	public void updatePhongBan(PhongBan phongBan) {
		for (PhongBan pb : danhSachPhongBan) {
			if(pb.getMaPhongBan().equals(phongBan.getMaPhongBan())) {
				danhSachPhongBan.remove(pb);
				danhSachPhongBan.add(phongBan);
				break;
			}
		}
		
	}


}
