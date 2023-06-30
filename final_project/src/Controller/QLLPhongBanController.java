package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.QLLView;

public class QLLPhongBanController implements ActionListener {
	private QLLView view;
	
	public QLLPhongBanController(QLLView view) {
		this.view = view;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmPhongBan = e.getActionCommand();
		JOptionPane.showMessageDialog(this.view, "Ban vua nhan vao" + cmPhongBan);
		
		if(cmPhongBan.equals("Nhap")) {
			this.view.xoaFormPB();
		
		} else if(cmPhongBan.equals("Chinh Sua")) {
			this.view.model.setLuaChonPB(true);
			this.view.hienThiThongTinPhongBanDaChon();
			
		} else if(cmPhongBan.equals("Luu")) {
			if(this.view.model.getLuaChonPB()) {
				this.view.thucHienCapNhatPhongBan();
			} else {
				this.view.thucHienThemPhongBan();
				
			}
			this.view.model.setLuaChonPB(false);
		
		} else if(cmPhongBan.equals("Xoa")) {
			this.view.thucHienXoaPB();
		
		} else if(cmPhongBan.equals("Tim Kiem")) {
			this.view.thucHienTimPB();
			
		} else if(cmPhongBan.equals("Huy")) {
			this.view.thucHienTaiLaiDuLieuPB();
			
		} else if(cmPhongBan.equals("Sort")) {
			this.view.sapXepTheoIdPB();
		}
		
	}

}
