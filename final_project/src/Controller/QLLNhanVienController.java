package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JOptionPane;

import View.QLLView;

public class QLLNhanVienController implements ActionListener{
	private QLLView view;
	
	
	public QLLNhanVienController(QLLView view) {
		this.view = view;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cmNhanVien = e.getActionCommand();
		JOptionPane.showMessageDialog(this.view, "Ban vua nhan vao: " + cmNhanVien);
		
		if(cmNhanVien.equals("Nhap")) {
			this.view.xoaFormNV();
			
		} else if(cmNhanVien.equals("Chinh Sua")) {
			this.view.model.setLuaChonNV(true);
			this.view.setTextKhiChinhSuaNV();
			this.view.hienThiThongTinThiSinhDaChon();
		
		} else if (cmNhanVien.equals("Luu")) {
			if(this.view.model.getLuaChonNV()) {
				this.view.thucHienCapNhatNhanVien();
			} else {
				try {
					this.view.thucHienThemNhanVien();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			this.view.model.setLuaChonNV(false);
			this.view.setTextKhiChinhSuaNV();
		
		} else if(cmNhanVien.equals("Xoa")) {
			this.view.thucHienXoaNV();
		
		} else if(cmNhanVien.equals("Tim Kiem")) {
			this.view.thucHienTimNV();
			
		} else if(cmNhanVien.equals("Huy")) {
			this.view.thucHienTaiLaiDuLieuNV();
			
		} else if(cmNhanVien.equals("About me")) {
			this.view.hienThiAbout();
		
		} else if(cmNhanVien.equals("Exit")) {
			this.view.thoatKhoiChuongTrinh();
		
		} else if(cmNhanVien.equals("Sort")) {
			this.view.sapXepTheoIdNV();
		
		} else if(cmNhanVien.equals("Phong Ban")) {
			this.view.getCardLayout().show(this.view.getMainPanel(), "Phong Ban");
		
		} else if(cmNhanVien.equals("Nhan Vien")) {
			this.view.getCardLayout().show(this.view.getMainPanel(), "Nhan Vien");
			
		}  else if(cmNhanVien.equals("Bang Luong Nhan Vien")) {
			this.view.getCardLayout().show(this.view.getMainPanel(), "Luong Nhan Vien");
			
		} else if(cmNhanVien.equals("Bang Luong Phong Ban")) {
			this.view.getCardLayout().show(this.view.getMainPanel(), "Luong Phong Ban");
			
		}
	}

}
