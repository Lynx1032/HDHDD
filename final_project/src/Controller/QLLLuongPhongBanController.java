package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.QLLView;

public class QLLLuongPhongBanController implements ActionListener {
	private QLLView view;
	
	public QLLLuongPhongBanController(QLLView view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmLuongPB = e.getActionCommand();
		JOptionPane.showMessageDialog(view, "Ban da nhan vao: " + cmLuongPB);
		
		if(cmLuongPB.equals("Sort")) {
			this.view.model.sapXepBangLuongTheoTongLuong();
			this.view.thucHienTaiLaiDuLieuBL();
		
		} else if(cmLuongPB.equals("Filter")) {
			this.view.thucHienLocPB();
			
		} else if(cmLuongPB.equals("Huy")) {
			this.view.thucHienTaiLaiDuLieuBL();
		}
	}

}
