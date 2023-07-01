//package View;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
import Controller.QLLNhanVienController;
import Controller.QLLPhongBanController;
import model.QLLModel;
import model.PhongBan;
import model.NhanVien;
import model.NhanVienBaoVe;
import model.NhanVienKinhDoanh;
import model.NhanVienKyThuat;
import model.NhanVienThoiVu;
import model.NhanVienThucTap;
import model.NhanVienVanHanh;
import model.NhanVienToanThoiGian;
*/
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;


public class QLLView extends JFrame {
	
//	private JFrame frame;
//	
	public QLLModel model;
//
//	private CardLayout cardLayout;
//	private JPanel contentPane;
	
    private JPanel mainPanel;
    private CardLayout cardLayout;

	
	//BEGIN CAC THANH PHAN GIAO DIEN CUA GUI NHAN VIEN
	private JScrollPane scrollPane_nhanVien;
	private JTable table_nhanVien;
	
	private JTextField textField_Filter_maNhanVien;
	private JTextField textField_Info_IDNhanVien;
	private JTextField textField_Info_HoTen;
	private JTextField textField_Info_SoDienThoai;
	private JTextField textField_Info_Email;
	private JTextField textField_Info_PhuCap;
	private JTextField textField_Info_Thuong;
	private JTextField textField_Info_Phat;
	private JTextField textField_Info_SoGio;

	private JComboBox<String> comboBox_Filter_PhongBan;
	private JComboBox<String> comboBox_Info_PhongBan;

	private JButton btn_Filter_TimKiem;
	private JButton btn_Filter_Huy;

	private JLabel label_Filter_PhongBan;
	private JLabel lblMaNhanVien;
	private JLabel lblId;
	private JLabel label_Info_HoTen;
	private JLabel lblSoDienThoai;
	private JLabel label_Info_Email;
	private JLabel lblPhuCap;
	private JLabel label_Info_Thuong;
	private JLabel lable_Info_Phat;
	private JLabel label_Info_SoGio;
	
	private JButton btn_Function_Nhap;
	private JButton btn_Function_ChinhSua;
	private JButton btn_Function_Luu;
	private JButton btn_Function_Xoa;
	private JButton btn_table_SapXep;
	//END 
	
	
	//CAC THANH PHAN GIAO DIEN CUA PHONG BAN GUI
	private JScrollPane scrollPane_phongBan;
	private JTable table_phongBan;

	
	private JTextField textField_PB_Filter_MaPhongBan;
	private JTextField textField_PB_Info_MaPhongBan;
	private JTextField textField_PB_Info_TenPhongBan;
	
	private JButton btn_PB_Filter_TimKiem;
	private JButton btn_PB_Filter_Huy;
	private JButton btn_PB_table_SapXep;
	private JButton btn_PB_Function_Nhap;
	private JButton btn_PB_Function_ChinhSua;
	private JButton btn_PB_Function_Luu;
	private JButton btn_PB_Function_Xoa;

	private JLabel label_PB_Filter_MaPhongBan;
	private JLabel lable_PB_Info_MaPhongBan;
	private JLabel label_PB_Info_TenPhongBan;
	private JTable table_LNV;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane_LPB;
	private JTable table_LPB;
	private JComboBox comboBox_LPB_PhongBan;
	
	//END


	//Begin Getter And Setter
	public JPanel getMainPanel() {
		return this.mainPanel;
	}
	
	public CardLayout getCardLayout() {
		return this.cardLayout;
	}
	
	//End Getter and Setter
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLLView frame = new QLLView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLLView() {
		JFrame frame = new JFrame("Quan Ly Nhan Vien");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 740);
		
		this.model = new QLLModel();
		
		mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);
		
		
		JPanel panelChung = new JPanel();
		JPanel panelPhongBan = new JPanel();
		JPanel panelNhanVien = new JPanel();

		
		ActionListener actionNV = new QLLNhanVienController(this);
		ActionListener actionPB = new QLLPhongBanController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu Menu_File = new JMenu("File");
		
		Menu_File.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(Menu_File);
		
		JMenuItem Menu_File_Open = new JMenuItem("Open");
		Menu_File_Open.addActionListener(actionNV);
		Menu_File_Open.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Menu_File.add(Menu_File_Open);
		
		JMenuItem Menu_File_Save = new JMenuItem("Save");
		Menu_File_Save.addActionListener(actionNV);
		Menu_File_Save.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Menu_File.add(Menu_File_Save);
		
		JSeparator separator_1 = new JSeparator();
		Menu_File.add(separator_1);
		
		JMenuItem Menu_File_Exit = new JMenuItem("Exit");
		Menu_File_Exit.addActionListener(actionNV);
		Menu_File_Exit.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Menu_File.add(Menu_File_Exit);
		
		JMenu Menu_About = new JMenu("About");
		Menu_About.addActionListener(actionNV);
		
		JMenu Menu_View = new JMenu("View");
		Menu_View.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(Menu_View);
		
		JMenuItem Menu_View_PhongBan = new JMenuItem("Phong Ban");
		Menu_View_PhongBan.addActionListener(actionNV);
		Menu_View_PhongBan.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		Menu_View.add(Menu_View_PhongBan);
		
		JMenuItem Menu_View_NhanVien = new JMenuItem("Nhan Vien");
		Menu_View_NhanVien.addActionListener(actionNV);
		Menu_View_NhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		Menu_View.add(Menu_View_NhanVien);
		
		JMenuItem Menu_View_BangLuongNV = new JMenuItem("Bang Luong Nhan Vien");
		Menu_View_BangLuongNV.addActionListener(actionNV);
		Menu_View_BangLuongNV.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		Menu_View.add(Menu_View_BangLuongNV);
		
		JMenuItem Menu_View_BangLuongPB = new JMenuItem("Bang Luong Phong Ban");
		Menu_View_BangLuongPB.addActionListener(actionNV);
		Menu_View_BangLuongPB.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		Menu_View.add(Menu_View_BangLuongPB);
		Menu_About.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(Menu_About);
		
		JMenuItem Menu_About_AboutMe = new JMenuItem("About me");
		Menu_About_AboutMe.addActionListener(actionNV);
		Menu_About_AboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Menu_About.add(Menu_About_AboutMe);
		//contentPane = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPanel);
		panelNhanVien.setLayout(null);
		
		label_Filter_PhongBan = new JLabel("Phong Ban:");
		label_Filter_PhongBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_Filter_PhongBan.setBounds(30, 10, 140, 38);
		panelNhanVien.add(label_Filter_PhongBan);
		
		comboBox_Filter_PhongBan = new JComboBox<String>();
		ArrayList<PhongBan> listPhongBan = this.model.getDanhSachPhongBan();
		comboBox_Filter_PhongBan.addItem("");
		for(PhongBan phongBan : listPhongBan) {
			comboBox_Filter_PhongBan.addItem(phongBan.getTenPhongBan());
		}
		comboBox_Filter_PhongBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_Filter_PhongBan.setBounds(171, 10, 176, 38);
		panelNhanVien.add(comboBox_Filter_PhongBan);
		
		lblMaNhanVien = new JLabel("Ma Nhan Vien:");
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNhanVien.setBounds(480, 10, 140, 38);
		panelNhanVien.add(lblMaNhanVien);
		
		textField_Filter_maNhanVien = new JTextField();
		textField_Filter_maNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_Filter_maNhanVien.setBounds(622, 10, 176, 38);
		textField_Filter_maNhanVien.setColumns(10);
		panelNhanVien.add(textField_Filter_maNhanVien);
		
		btn_Filter_TimKiem = new JButton("Tim Kiem");
		btn_Filter_TimKiem.addActionListener(actionNV);
		btn_Filter_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Filter_TimKiem.setBounds(912, 10, 120, 40);
		panelNhanVien.add(btn_Filter_TimKiem);
		
		btn_Filter_Huy = new JButton("Huy");
		btn_Filter_Huy.addActionListener(actionNV);
		btn_Filter_Huy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Filter_Huy.setBounds(1126, 10, 120, 40);
		panelNhanVien.add(btn_Filter_Huy);
		
//		JSeparator Separator_below_Filter = new JSeparator();
//		Separator_below_Filter.setBounds(10, 72, 1271, 2);
//		panelChung.add(Separator_below_Filter);
		
		
		table_nhanVien = new JTable();
		table_nhanVien.setRowHeight(25);
		table_nhanVien.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Ho Va Ten", "So Dien Thoai", "Email", "Phong Ban", "Luong", "Phu Cap", "Thuong", "Phat", "Tong Luong"
			}
		));
		scrollPane_nhanVien = new JScrollPane(table_nhanVien);
		scrollPane_nhanVien.setBounds(30, 119, 1216, 249);
		panelNhanVien.add(scrollPane_nhanVien);
		
//		JSeparator separator = new JSeparator();
//		separator.setBounds(10, 396, 1271, 2);
//		panelChung.add(separator);
		
		lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(30, 465, 125, 40);
		panelNhanVien.add(lblId);
		
		textField_Info_IDNhanVien = new JTextField();
		textField_Info_IDNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Info_IDNhanVien.setBounds(156, 465, 176, 40);
		textField_Info_IDNhanVien.setColumns(10);
		panelNhanVien.add(textField_Info_IDNhanVien);
		
		label_Info_HoTen = new JLabel("Ho va Ten:");
		label_Info_HoTen.setHorizontalAlignment(SwingConstants.CENTER);
		label_Info_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_Info_HoTen.setBounds(30, 530, 140, 40);
		panelNhanVien.add(label_Info_HoTen);
		
		textField_Info_HoTen = new JTextField();
		textField_Info_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Info_HoTen.setColumns(10);
		textField_Info_HoTen.setBounds(156, 531, 176, 40);
		panelNhanVien.add(textField_Info_HoTen);
		
		textField_Info_SoDienThoai = new JTextField();
		textField_Info_SoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Info_SoDienThoai.setColumns(10);
		textField_Info_SoDienThoai.setBounds(631, 400, 176, 40);
		panelNhanVien.add(textField_Info_SoDienThoai);
		
		lblSoDienThoai = new JLabel("So Dien Thoai:");
		lblSoDienThoai.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoDienThoai.setBounds(490, 400, 140, 40);
		panelNhanVien.add(lblSoDienThoai);
		
		textField_Info_Email = new JTextField();
		textField_Info_Email.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Info_Email.setColumns(10);
		textField_Info_Email.setBounds(631, 466, 176, 40);
		panelNhanVien.add(textField_Info_Email);
		
		label_Info_Email = new JLabel("Email:");
		label_Info_Email.setHorizontalAlignment(SwingConstants.CENTER);
		label_Info_Email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_Info_Email.setBounds(490, 465, 125, 40);
		panelNhanVien.add(label_Info_Email);
		
		JLabel label_Info_PhongBan = new JLabel("Phong Ban:");
		label_Info_PhongBan.setHorizontalAlignment(SwingConstants.CENTER);
		label_Info_PhongBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_Info_PhongBan.setBounds(30, 400, 125, 40);
		panelNhanVien.add(label_Info_PhongBan);
		
		comboBox_Info_PhongBan = new JComboBox<String>();
		comboBox_Info_PhongBan.addItem("");
		for(PhongBan phongBan : listPhongBan) {
			comboBox_Info_PhongBan.addItem(phongBan.getTenPhongBan());
		}
		
			comboBox_Info_PhongBan.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(comboBox_Info_PhongBan.getItemCount() > 0) {
						if(!comboBox_Info_PhongBan.getSelectedItem().equals("Thoi Vu")) {
							textField_Info_SoGio.setEditable(false);
							textField_Info_SoGio.setText("");
						
						} else {
							textField_Info_SoGio.setEditable(true);
						}
						
						//set ô Phụ cấp
						if(comboBox_Info_PhongBan.getSelectedItem().equals("Thoi Vu") || comboBox_Info_PhongBan.getSelectedItem().equals("Thuc Tap")) {
							textField_Info_PhuCap.setEditable(false);
							textField_Info_PhuCap.setText("0");
							
						} else {
							textField_Info_PhuCap.setEditable(true);
						}
						
						
						if (comboBox_Info_PhongBan.getSelectedItem().equals("Thoi Vu")) {
							setHaiKyTuDauCuaID("TV");
						
						} else if(comboBox_Info_PhongBan.getSelectedItem().equals("Thuc Tap")) {
							setHaiKyTuDauCuaID("TT");
						
						} else if(comboBox_Info_PhongBan.getSelectedItem().equals("Kinh Doanh")) {
							setHaiKyTuDauCuaID("KD");
						
						} else if(comboBox_Info_PhongBan.getSelectedItem().equals("Van Hanh")){
							setHaiKyTuDauCuaID("VH");
							
						} else if(comboBox_Info_PhongBan.getSelectedItem().equals("Ky Thuat")){
							setHaiKyTuDauCuaID("KT");
							
						} else if(comboBox_Info_PhongBan.getSelectedItem().equals("Bao Ve")){
							setHaiKyTuDauCuaID("BV");
							
						}
					}
//					//set ô số giờ
//					if(!comboBox_Info_PhongBan.getSelectedItem().equals("Thoi Vu")) {
//						textField_Info_SoGio.setEditable(false);
//						textField_Info_SoGio.setText("");
//					
//					} else {
//						textField_Info_SoGio.setEditable(true);
//					}
//					
//					//set ô Phụ cấp
//					if(comboBox_Info_PhongBan.getSelectedItem().equals("Thoi Vu") || comboBox_Info_PhongBan.getSelectedItem().equals("Thuc Tap")) {
//						textField_Info_PhuCap.setEditable(false);
//						textField_Info_PhuCap.setText("0");
//						
//					} else {
//						textField_Info_PhuCap.setEditable(true);
//					}
//					
//					
//					if (comboBox_Info_PhongBan.getSelectedItem().equals("Thoi Vu")) {
//						setHaiKyTuDauCuaID("TV");
//					
//					} else if(comboBox_Info_PhongBan.getSelectedItem().equals("Thuc Tap")) {
//						setHaiKyTuDauCuaID("TT");
//					
//					} else if(comboBox_Info_PhongBan.getSelectedItem().equals("Kinh Doanh")) {
//						setHaiKyTuDauCuaID("KD");
//					
//					} else if(comboBox_Info_PhongBan.getSelectedItem().equals("Van Hanh")){
//						setHaiKyTuDauCuaID("VH");
//						
//					} else if(comboBox_Info_PhongBan.getSelectedItem().equals("Ky Thuat")){
//						setHaiKyTuDauCuaID("KT");
//						
//					} else if(comboBox_Info_PhongBan.getSelectedItem().equals("Bao Ve")){
//						setHaiKyTuDauCuaID("BV");
//						
//					}
				}
			});
		
		//Kiểm tra có được nhập vào ô phụ cấp
//		comboBox_Info_PhongBan.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				//set ô số giờ
//				if(!comboBox_Info_PhongBan.getSelectedItem().equals("Thoi Vu")) {
//					textField_Info_SoGio.setEditable(false);
//					textField_Info_SoGio.setText("");
//				
//				} else {
//					textField_Info_SoGio.setEditable(true);
//				}
//				
//				//set ô Phụ cấp
//				if(comboBox_Info_PhongBan.getSelectedItem().equals("Thoi Vu") || comboBox_Info_PhongBan.getSelectedItem().equals("Thuc Tap")) {
//					textField_Info_PhuCap.setEditable(false);
//					textField_Info_PhuCap.setText("0");
//					
//				} else {
//					textField_Info_PhuCap.setEditable(true);
//				}
//				
//				
//				if (comboBox_Info_PhongBan.getSelectedItem().equals("Thoi Vu")) {
//					setHaiKyTuDauCuaID("TV");
//				
//				} else if(comboBox_Info_PhongBan.getSelectedItem().equals("Thuc Tap")) {
//					setHaiKyTuDauCuaID("TT");
//				
//				} else if(comboBox_Info_PhongBan.getSelectedItem().equals("Kinh Doanh")) {
//					setHaiKyTuDauCuaID("KD");
//				
//				} else if(comboBox_Info_PhongBan.getSelectedItem().equals("Van Hanh")){
//					setHaiKyTuDauCuaID("VH");
//					
//				} else if(comboBox_Info_PhongBan.getSelectedItem().equals("Ky Thuat")){
//					setHaiKyTuDauCuaID("KT");
//					
//				} else if(comboBox_Info_PhongBan.getSelectedItem().equals("Bao Ve")){
//					setHaiKyTuDauCuaID("BV");
//					
//				}
//			}
//		});
		//System.out.println(comboBox_Info_PhongBan.getItemAt(1)); Test index.
		
		comboBox_Info_PhongBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_Info_PhongBan.setBounds(156, 400, 176, 40);
		panelNhanVien.add(comboBox_Info_PhongBan);
		
		lblPhuCap = new JLabel("Phu Cap:");
		lblPhuCap.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhuCap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhuCap.setBounds(490, 530, 125, 40);
		panelNhanVien.add(lblPhuCap);
		
		textField_Info_PhuCap = new JTextField();
		textField_Info_PhuCap.setText(0 + "");
		textField_Info_PhuCap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Info_PhuCap.setColumns(10);
		textField_Info_PhuCap.setBounds(631, 531, 176, 40);
		panelNhanVien.add(textField_Info_PhuCap);
		
		label_Info_Thuong = new JLabel("Thuong:");
		label_Info_Thuong.setHorizontalAlignment(SwingConstants.CENTER);
		label_Info_Thuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_Info_Thuong.setBounds(947, 400, 125, 40);
		panelNhanVien.add(label_Info_Thuong);
		
		textField_Info_Thuong = new JTextField();
		textField_Info_Thuong.setText(0 + "");
		textField_Info_Thuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Info_Thuong.setColumns(10);
		textField_Info_Thuong.setBounds(1070, 400, 176, 40);
		panelNhanVien.add(textField_Info_Thuong);
		
		lable_Info_Phat = new JLabel("Phat:");
		lable_Info_Phat.setHorizontalAlignment(SwingConstants.CENTER);
		lable_Info_Phat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lable_Info_Phat.setBounds(947, 465, 125, 40);
		panelNhanVien.add(lable_Info_Phat);
		
		textField_Info_Phat = new JTextField();
		textField_Info_Phat.setText(0 + "");
		textField_Info_Phat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Info_Phat.setColumns(10);
		textField_Info_Phat.setBounds(1070, 465, 176, 40);
		panelNhanVien.add(textField_Info_Phat);
		
		btn_Function_Nhap = new JButton("Nhap");
		btn_Function_Nhap.addActionListener(actionNV);
		btn_Function_Nhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Function_Nhap.setBounds(30, 600, 140, 40);
		panelNhanVien.add(btn_Function_Nhap);
		
		btn_Function_ChinhSua = new JButton("Chinh Sua");
		btn_Function_ChinhSua.addActionListener(actionNV);
		btn_Function_ChinhSua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Function_ChinhSua.setBounds(387, 600, 140, 40);
		panelNhanVien.add(btn_Function_ChinhSua);
		
		btn_Function_Luu = new JButton("Luu");
		btn_Function_Luu.addActionListener(actionNV);
		btn_Function_Luu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Function_Luu.setBounds(745, 600, 140, 40);
		panelNhanVien.add(btn_Function_Luu);
		
		btn_Function_Xoa = new JButton("Xoa");
		btn_Function_Xoa.addActionListener(actionNV);
		btn_Function_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Function_Xoa.setBounds(1106, 600, 140, 40);
		panelNhanVien.add(btn_Function_Xoa);
		
//		JSeparator separator_ = new JSeparator();
//		separator_.setBounds(10, 622, 1271, 2);
//		panelChung.add(separator_);
		
		label_Info_SoGio = new JLabel("So Gio:");
		label_Info_SoGio.setHorizontalAlignment(SwingConstants.CENTER);
		label_Info_SoGio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_Info_SoGio.setBounds(947, 530, 125, 40);
		panelNhanVien.add(label_Info_SoGio);
		
		textField_Info_SoGio = new JTextField();
		textField_Info_SoGio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Info_SoGio.setColumns(10);
		textField_Info_SoGio.setBounds(1070, 530, 176, 40);
		panelNhanVien.add(textField_Info_SoGio);
		
		JComboBox<String> comboBox_Table_HienThi = new JComboBox<String>();
		String[] HienThiList = {"Phong Ban" ,"Nhan Vien", "Luong Nhan Vien", "Luong Phong Ban"};
		int hienThiLength = HienThiList.length;
		for(int i = 0; i < hienThiLength; i++) {
			comboBox_Table_HienThi.addItem(HienThiList[i]);
		}
		
		comboBox_Table_HienThi.setSelectedItem("Phong Ban");
		comboBox_Table_HienThi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String truongHopDuocHienThi = (String) comboBox_Table_HienThi.getSelectedItem();
				cardLayout.show(mainPanel, truongHopDuocHienThi);
				
			}
		});

		comboBox_Table_HienThi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_Table_HienThi.setBounds(161, 84, 174, 40);
		panelChung.add(comboBox_Table_HienThi);
		
		
		JLabel label_Table_HienThi = new JLabel("Hiển Thị:");
		label_Table_HienThi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_Table_HienThi.setBounds(51, 84, 100, 37);
		panelChung.add(label_Table_HienThi);
		
		btn_table_SapXep = new JButton("Sort");
		btn_table_SapXep.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btn_table_SapXep.addActionListener(actionNV);
		btn_table_SapXep.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_table_SapXep.setBounds(1126, 69, 120, 40);
		panelNhanVien.add(btn_table_SapXep);
		
		panelPhongBan.setLayout(null);
		

		
		//UI 's Department		/UI 's Department		/UI 's Department UI 's Department		/UI 's Department		/UI 's Department
		//UI 's Department		/UI 's Department		/UI 's Department
		//UI 's Department		/UI 's Department		/UI 's Department UI 's Department		/UI 's Department		/UI 's Department
		//UI 's Department		/UI 's Department		/UI 's Department
		//UI 's Department		/UI 's Department		/UI 's Department UI 's Department		/UI 's Department		/UI 's Department
		//UI 's Department		/UI 's Department		/UI 's Department
		label_PB_Filter_MaPhongBan = new JLabel("Ma Phong Ban:");
		label_PB_Filter_MaPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_PB_Filter_MaPhongBan.setBounds(199, 13, 140, 40);
		panelPhongBan.add(label_PB_Filter_MaPhongBan);
		
		textField_PB_Filter_MaPhongBan = new JTextField();
		textField_PB_Filter_MaPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_PB_Filter_MaPhongBan.setColumns(10);
		textField_PB_Filter_MaPhongBan.setBounds(354, 13, 176, 40);
		panelPhongBan.add(textField_PB_Filter_MaPhongBan);
		
		btn_PB_Filter_TimKiem = new JButton("Tim Kiem");
		btn_PB_Filter_TimKiem.addActionListener(actionPB);
		btn_PB_Filter_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_PB_Filter_TimKiem.setBounds(680, 15, 140, 40);
		panelPhongBan.add(btn_PB_Filter_TimKiem);
		
		btn_PB_Filter_Huy = new JButton("Huy");
		btn_PB_Filter_Huy.addActionListener(actionPB);
		btn_PB_Filter_Huy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_PB_Filter_Huy.setBounds(908, 17, 140, 40);
		panelPhongBan.add(btn_PB_Filter_Huy);
		
		btn_PB_table_SapXep = new JButton("Sort");
		btn_PB_table_SapXep.addActionListener(actionPB);
		btn_PB_table_SapXep.setBounds(550, 179, 51, 21);
		btn_PB_table_SapXep.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_PB_table_SapXep.setBounds(1105, 84, 136, 40);
		panelPhongBan.add(btn_PB_table_SapXep);
		
		table_phongBan = new JTable();
		table_phongBan.setRowHeight(25);
		table_phongBan.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Ten Phong Ban", "So Luong Nhan Vien"
			}
		));
		scrollPane_phongBan = new JScrollPane(this.table_phongBan);
		scrollPane_phongBan.setBounds(20, 134, 1234, 245);
		panelPhongBan.add(scrollPane_phongBan);
		
		lable_PB_Info_MaPhongBan = new JLabel("Ma Phong Ban:");
		lable_PB_Info_MaPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lable_PB_Info_MaPhongBan.setBounds(199, 476, 140, 40);
		panelPhongBan.add(lable_PB_Info_MaPhongBan);
		
		textField_PB_Info_MaPhongBan = new JTextField();
		textField_PB_Info_MaPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_PB_Info_MaPhongBan.setColumns(10);
		textField_PB_Info_MaPhongBan.setBounds(354, 476, 176, 40);
		panelPhongBan.add(textField_PB_Info_MaPhongBan);
		
		label_PB_Info_TenPhongBan = new JLabel("Ten Phong Ban:");
		label_PB_Info_TenPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_PB_Info_TenPhongBan.setBounds(680, 476, 145, 40);
		panelPhongBan.add(label_PB_Info_TenPhongBan);
		
		btn_PB_Function_Nhap = new JButton("Nhap");
		btn_PB_Function_Nhap.addActionListener(actionPB);
		btn_PB_Function_Nhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_PB_Function_Nhap.setBounds(20, 605, 140, 40);
		panelPhongBan.add(btn_PB_Function_Nhap);
		
		btn_PB_Function_ChinhSua = new JButton("Chinh Sua");
		btn_PB_Function_ChinhSua.addActionListener(actionPB);
		btn_PB_Function_ChinhSua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_PB_Function_ChinhSua.setBounds(378, 605, 140, 40);
		panelPhongBan.add(btn_PB_Function_ChinhSua);
		
		btn_PB_Function_Luu = new JButton("Luu");
		btn_PB_Function_Luu.addActionListener(actionPB);
		btn_PB_Function_Luu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_PB_Function_Luu.setBounds(747, 605, 140, 40);
		panelPhongBan.add(btn_PB_Function_Luu);
		
		btn_PB_Function_Xoa = new JButton("Xoa");
		btn_PB_Function_Xoa.addActionListener(actionPB);
		btn_PB_Function_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_PB_Function_Xoa.setBounds(1114, 605, 140, 40);
		panelPhongBan.add(btn_PB_Function_Xoa);

        // Thêm các giao diện vào mainPanel với tên duy nhất
        mainPanel.add(panelPhongBan, "Phong Ban");
        
        JSeparator separator_2_PB_belowFilter = new JSeparator();
        separator_2_PB_belowFilter.setBounds(20, 72, 1256, 2);
        panelPhongBan.add(separator_2_PB_belowFilter);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 400, 1256, 2);
        panelPhongBan.add(separator);
        
        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(10, 584, 1256, 2);
        panelPhongBan.add(separator_3);
        
        textField_PB_Info_TenPhongBan = new JTextField();
        textField_PB_Info_TenPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField_PB_Info_TenPhongBan.setBounds(845, 476, 176, 40);
        textField_PB_Info_TenPhongBan.setColumns(10);
        panelPhongBan.add(textField_PB_Info_TenPhongBan);
        mainPanel.add(panelNhanVien, "Nhan Vien");
        
        JSeparator separator_1_below_filter = new JSeparator();
        separator_1_below_filter.setBounds(10, 57, 1256, 2);
        panelNhanVien.add(separator_1_below_filter);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(10, 585, 1256, 2);
        panelNhanVien.add(separator_2);
        cardLayout.show(mainPanel, "Phong Ban");
        
        JPanel panelLuongNV = new JPanel();
        mainPanel.add(panelLuongNV, "Luong Nhan Vien");
        panelLuongNV.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("DANH SACH LUONG TOAN CONG TY");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel.setBounds(386, 42, 424, 73);
        panelLuongNV.add(lblNewLabel);
        
        table_LNV = new JTable();
        table_LNV.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Ma Nhan Vien", "Ho Va Ten", "Tong Luong"
        	}
        ));
        table_LNV.setBounds(0, 0, 1, 1);
        panelLuongNV.add(table_LNV);
        
        JScrollPane scrollPane_LNV_ScrollPane = new JScrollPane(table_LNV);
        scrollPane_LNV_ScrollPane.setBounds(160, 151, 945, 412);
        panelLuongNV.add(scrollPane_LNV_ScrollPane);
        
        
        JPanel panelLuongPB = new JPanel();
        mainPanel.add(panelLuongPB, "Luong Phong Ban");
        panelLuongPB.setLayout(null);
        
        lblNewLabel_1 = new JLabel("DANH SACH LUONG THEO PHONG BAN");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel_1.setBounds(402, 45, 433, 100);
        panelLuongPB.add(lblNewLabel_1);
        
        table_LPB = new JTable();
        table_LPB.setFont(new Font("Tahoma", Font.PLAIN, 10));
        table_LPB.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Ma Nhan Vien", "Ho va Ten", "Phong Ban", "Tong Luong"
        	}
        ));
        table_LPB.setBounds(0, 0, 1, 1);
        panelLuongPB.add(table_LPB);
        
        scrollPane_LPB = new JScrollPane(table_LPB);
        scrollPane_LPB.setBounds(143, 188, 983, 373);
        panelLuongPB.add(scrollPane_LPB);
        
        comboBox_LPB_PhongBan = new JComboBox();
        comboBox_LPB_PhongBan.setBounds(143, 125, 190, 45);
        panelLuongPB.add(comboBox_LPB_PhongBan);
        
        JButton btn_LPB_Table_Sort = new JButton("Sort");
        btn_LPB_Table_Sort.setFont(new Font("Tahoma", Font.PLAIN, 24));
        btn_LPB_Table_Sort.setBounds(987, 125, 140, 45);
        panelLuongPB.add(btn_LPB_Table_Sort);
        

		

	}
	
	public void hienThiUIPhongBan() {
		
//		this.btn_PB_Filter_Huy.setVisible(true);
		
//		this.contentPane.add(btn_PB_Filter_TimKiem);
//		this.contentPane.add(btn_PB_Filter_Huy);
//		this.contentPane.add(btn_PB_table_SapXep);
//		this.contentPane.add(btn_PB_Function_Nhap);
//		this.contentPane.add(btn_PB_Function_ChinhSua);
//		this.contentPane.add(btn_PB_Function_Luu);
//		this.contentPane.add(btn_PB_Function_Xoa);
//		
//		this.contentPane.add(lable_PB_Info_MaPhongBan);
//		this.contentPane.add(label_PB_Info_TenPhongBan);
//		this.contentPane.add(label_PB_Filter_MaPhongBan);
//		
//		this.contentPane.add(textField_PB_Filter_MaPhongBan);
//		this.contentPane.add(textField_PB_Info_MaPhongBan);
//		this.contentPane.add(textField_PB_Info_TenPhongBan);
//		
//		this.contentPane.add(scrollPane_phongBan);
//		this.contentPane.add(table_phongBan);
		}
	
	public void setTextKhiChinhSuaNV() {
		if(this.model.getLuaChonNV()) {
			this.textField_Info_IDNhanVien.setEditable(false);
			this.comboBox_Info_PhongBan.setEditable(false);
			this.comboBox_Info_PhongBan.setEnabled(false);
		
		} else {
			this.textField_Info_IDNhanVien.setEditable(true);
			this.comboBox_Info_PhongBan.setEditable(true);
			this.comboBox_Info_PhongBan.setEnabled(true);
		}
		
	}
	
	public void setTextKhiChinhSuaPB() {
		if(this.model.getLuaChonPB()) {
			this.textField_PB_Info_MaPhongBan.setEditable(false);
			
		} else {
			this.textField_PB_Info_MaPhongBan.setEditable(true);
		}
	}
	
	public void taiLaiDanhSachPB() {
		if(comboBox_Filter_PhongBan.getItemCount() > 0) {
			this.comboBox_Filter_PhongBan.removeAllItems();
			this.comboBox_Info_PhongBan.removeAllItems();
		}
		
		ArrayList<PhongBan> phongBan = this.model.getDanhSachPhongBan();
		comboBox_Filter_PhongBan.addItem("");
		comboBox_Info_PhongBan.addItem("");
		
		for(PhongBan pb : phongBan) {
			comboBox_Filter_PhongBan.addItem(pb.getTenPhongBan());
			comboBox_Info_PhongBan.addItem(pb.getTenPhongBan());
		}
	}

	public void xoaFormNV() {
		this.textField_Info_IDNhanVien.setText("");
		this.textField_Info_HoTen.setText("");
		this.textField_Info_SoDienThoai.setText("");
		this.textField_Info_Email.setText("");
		this.comboBox_Info_PhongBan.setSelectedIndex(0);
		this.textField_Info_PhuCap.setText("0");
		this.textField_Info_Thuong.setText("0");
		this.textField_Info_Phat.setText("0");
		this.textField_Info_SoGio.setText("");
		
	}
	
	
	// set 2 ky tu dau cua ma nhan vien
	public void setHaiKyTuDauCuaID (String haiKyTuDau) {
		String chuoi =  textField_Info_IDNhanVien.getText();
		if(chuoi.length() >= 2) {
			String haiKyTu = chuoi.substring(0, 2);
			if(haiKyTu.equals("TV") || haiKyTu.equals("TT") || haiKyTu.equals("KD") || haiKyTu.equals("VH") || haiKyTu.equals("KT") || haiKyTu.equals("BV")) {
				String chuoiMoi = chuoi.substring(2);
				textField_Info_IDNhanVien.setText(haiKyTuDau + chuoiMoi);						
			
			} else {
				textField_Info_IDNhanVien.setText(haiKyTuDau + chuoi);
			}
		
		} else {
			textField_Info_IDNhanVien.setText(haiKyTuDau + chuoi);
		}
	}
	

	//Bat Dau Thuc Hien Them Nhan Vien
	public void thucHienThemNhanVien() {
		String maNhanVien = this.textField_Info_IDNhanVien.getText();
		String hoTen = this.textField_Info_HoTen.getText();
		String soDienThoai = this.textField_Info_SoDienThoai.getText();
		String eMail = this.textField_Info_Email.getText();
		String tenPhong = this.comboBox_Info_PhongBan.getSelectedItem() + "";
		PhongBan phongBan = this.model.getPhongBanByTen(tenPhong);
		
//		if(!this.comboBox_Info_PhongBan.getSelectedItem().equals("ThoiVu")) {
//			this.textField_Info_PhuCap.setEditable(true);
//		}
		
		double phuCap = Double.valueOf(this.textField_Info_PhuCap.getText());
		double thuong = Double.valueOf(this.textField_Info_Thuong.getText());
		double phat = Double.valueOf(this.textField_Info_Phat.getText());
		

		
		
		if(phongBan.getTenPhongBan().equals("Thuc Tap")) {
			NhanVienThucTap nvThucTap = new NhanVienThucTap(maNhanVien, hoTen, soDienThoai, eMail, phongBan, thuong, phat);
			this.themNhanVienThucTap(nvThucTap);
			
		} else if(phongBan.getTenPhongBan().equals("Thoi Vu")) {
			double gioLamViec = Double.valueOf(this.textField_Info_SoGio.getText());
			NhanVienThoiVu nvThoiVu = new NhanVienThoiVu(maNhanVien,hoTen, soDienThoai, eMail, phongBan, phuCap, thuong, phat, gioLamViec);
			this.themNhanVienThoiVu(nvThoiVu);
		
		} else if(phongBan.getTenPhongBan().equals("Kinh Doanh")) {
			NhanVienToanThoiGian nvKinhDoanh = new NhanVienKinhDoanh(maNhanVien, hoTen, soDienThoai, eMail, phongBan, phuCap, thuong, phat);
			this.themNhanVienChinhThuc(nvKinhDoanh);
			
		} else if(phongBan.getTenPhongBan().equals("Van Hanh")) {
			NhanVienToanThoiGian nvVanHanh = new NhanVienVanHanh(maNhanVien, hoTen, soDienThoai, eMail, phongBan, phuCap, thuong, phat);
			this.themNhanVienChinhThuc(nvVanHanh);
			
		} else if(phongBan.getTenPhongBan().equals("Ky Thuat")) {
			NhanVienToanThoiGian nvKyThuat = new NhanVienKyThuat(maNhanVien, hoTen, soDienThoai, eMail, phongBan, phuCap, thuong, phat);
			this.themNhanVienChinhThuc(nvKyThuat);
			
		} else if(phongBan.getTenPhongBan().equals("Bao Ve")) {
			NhanVienToanThoiGian nvBaoVe = new NhanVienBaoVe(maNhanVien, hoTen, soDienThoai, eMail, phongBan, phuCap, thuong, phat);
			this.themNhanVienChinhThuc(nvBaoVe);
		
		}	
	}
	
	//Bat Dau Thuc Hien Cap Nhat Nhan Vien
	public void thucHienCapNhatNhanVien() {
		String maNhanVien = this.textField_Info_IDNhanVien.getText();
		String hoTen = this.textField_Info_HoTen.getText();
		String soDienThoai = this.textField_Info_SoDienThoai.getText();
		String eMail = this.textField_Info_Email.getText();
		int indexPhong = this.comboBox_Info_PhongBan.getSelectedIndex() - 1;
		String tenPhong = this.comboBox_Info_PhongBan.getSelectedItem() + "";
		PhongBan phongBan = this.model.getPhongBanByTen(tenPhong);
		
//		if(!this.comboBox_Info_PhongBan.getSelectedItem().equals("ThoiVu")) {
//			this.textField_Info_PhuCap.setEditable(true);
//		}
		
		double phuCap = Double.valueOf(this.textField_Info_PhuCap.getText());
		double thuong = Double.valueOf(this.textField_Info_Thuong.getText());
		double phat = Double.valueOf(this.textField_Info_Phat.getText());
		

		
		
		if(phongBan.getTenPhongBan().equals("Thuc Tap")) {
			NhanVienThucTap nvThucTap = new NhanVienThucTap(maNhanVien, hoTen, soDienThoai, eMail, phongBan, thuong, phat);
			this.capNhatNhanVienThucTap(nvThucTap);
			
		} else if(phongBan.getTenPhongBan().equals("Thoi Vu")) {
			double gioLamViec = Double.valueOf(this.textField_Info_SoGio.getText());
			NhanVienThoiVu nvThoiVu = new NhanVienThoiVu(maNhanVien,hoTen, soDienThoai, eMail, phongBan, phuCap, thuong, phat, gioLamViec);
			this.capNhatNhanVienThoiVu(nvThoiVu);
		
		} else if(phongBan.getTenPhongBan().equals("Kinh Doanh")) {
			NhanVienToanThoiGian nvKinhDoanh = new NhanVienKinhDoanh(maNhanVien, hoTen, soDienThoai, eMail, phongBan, phuCap, thuong, phat);
			this.capNhatNhanVienChinhThuc(nvKinhDoanh);
			
		} else if(phongBan.getTenPhongBan().equals("Van Hanh")) {
			NhanVienToanThoiGian nvVanHanh = new NhanVienVanHanh(maNhanVien, hoTen, soDienThoai, eMail, phongBan, phuCap, thuong, phat);
			this.capNhatNhanVienChinhThuc(nvVanHanh);
			
		} else if(phongBan.getTenPhongBan().equals("Ky Thuat")) {
			NhanVienToanThoiGian nvKyThuat = new NhanVienKyThuat(maNhanVien, hoTen, soDienThoai, eMail, phongBan, phuCap, thuong, phat);
			this.capNhatNhanVienChinhThuc(nvKyThuat);
			
		} else if(phongBan.getTenPhongBan().equals("Bao Ve")) {
			NhanVienToanThoiGian nvBaoVe = new NhanVienBaoVe(maNhanVien, hoTen, soDienThoai, eMail, phongBan, phuCap, thuong, phat);
			this.capNhatNhanVienChinhThuc(nvBaoVe);
		
		}
	}
	

	
	//Them nvThucTap
	private void themNhanVienThucTap(NhanVienThucTap nvThucTap) {
		DefaultTableModel model_table = (DefaultTableModel) table_nhanVien.getModel();
		if (!this.model.kiemTraTonTai(nvThucTap)) {
			this.model.themNhanVien(nvThucTap);
			this.themNhanVienThucTapVaoTable(nvThucTap);
			this.thucHienTaiLaiDuLieuPB();
			
		} else {
			JOptionPane.showMessageDialog(this, "ID nhan vien nay da ton tai");
		}
	}
	
	//Cap Nhat Nhan Vien Thuc Tap
	private void capNhatNhanVienThucTap(NhanVienThucTap nvThucTap) {
		DefaultTableModel model_table = (DefaultTableModel) table_nhanVien.getModel();
		this.model.updateNhanVien(nvThucTap);
		int soLuongDong = model_table.getRowCount();
		
		for(int i = 0; i < soLuongDong; i++) {
			String id = model_table.getValueAt(i, 0) + "";
			
			if(id.equals(nvThucTap.getMaNhanVien())){
				model_table.setValueAt(nvThucTap.getMaNhanVien() + "", i, 0);
				model_table.setValueAt(nvThucTap.getHoTen() + "", i, 1);
				model_table.setValueAt(nvThucTap.getSoDienThoai() + "", i, 2);
				model_table.setValueAt(nvThucTap.getEmail() + "", i, 3);
				model_table.setValueAt(nvThucTap.getPhongBan().getTenPhongBan() + "", i, 4);
				model_table.setValueAt(0 + "", i, 5);
				model_table.setValueAt(0 + "", i, 6);
				model_table.setValueAt(nvThucTap.getThuong() + "", i, 7);
				model_table.setValueAt(nvThucTap.getPhat() + "", i, 8);
				model_table.setValueAt(nvThucTap.tinhLuong() + "", i, 9);
			}
		}
	}
	
	//Them nvThoiVu
	private void themNhanVienThoiVu(NhanVienThoiVu nvThoiVu) {
		DefaultTableModel model_table = (DefaultTableModel) table_nhanVien.getModel();
		if (!this.model.kiemTraTonTai(nvThoiVu)) {
			this.model.themNhanVien(nvThoiVu);
			this.themNhanVienThoiVuVaoTable(nvThoiVu);
			this.thucHienTaiLaiDuLieuPB();
		
		} else {
			JOptionPane.showMessageDialog(this, "ID nhan vien nay da ton tai");
		}
		
	}
	
	
	//Cap Nhat nvThoiVu
	private void capNhatNhanVienThoiVu(NhanVienThoiVu nvThoiVu) {
		DefaultTableModel model_table = (DefaultTableModel) table_nhanVien.getModel();
		this.model.updateNhanVien(nvThoiVu);
		int soLuongDong = model_table.getRowCount();
		
		for(int i = 0; i < soLuongDong; i++) {
			String id = model_table.getValueAt(i, 0) + "";
			
			if(id.equals(nvThoiVu.getMaNhanVien())){
				model_table.setValueAt(nvThoiVu.getMaNhanVien() + "", i, 0);
				model_table.setValueAt(nvThoiVu.getHoTen() + "", i, 1);
				model_table.setValueAt(nvThoiVu.getSoDienThoai() + "", i, 2);
				model_table.setValueAt(nvThoiVu.getEmail() + "", i, 3);
				model_table.setValueAt(nvThoiVu.getPhongBan().getTenPhongBan() + "", i, 4);
				model_table.setValueAt(50.0 + "/ngay", i, 5);
				model_table.setValueAt(nvThoiVu.getThuong() + "", i, 7);
				model_table.setValueAt(nvThoiVu.getPhat() + "", i, 8);
				model_table.setValueAt(nvThoiVu.tinhLuong() + "", i, 9);
			}
		}
	}
	
	
	//Them Nhan Vien Chinh Thuc
	private void themNhanVienChinhThuc(NhanVienToanThoiGian nvToanTG) {
		DefaultTableModel model_table = (DefaultTableModel) table_nhanVien.getModel();
		if (!this.model.kiemTraTonTai(nvToanTG)) {
			this.model.themNhanVien(nvToanTG);
			this.themNhanVienChinhThucVaoTable(nvToanTG);
			this.thucHienTaiLaiDuLieuPB();
		
		} else {
			JOptionPane.showMessageDialog(this, "ID nhan vien nay da ton tai");
		}
		
	}
	
	//Cap Nhat Nhan Vien Chinh Thuc
	private void capNhatNhanVienChinhThuc(NhanVienToanThoiGian nvToanTG) {
		DefaultTableModel model_table = (DefaultTableModel) table_nhanVien.getModel();
		this.model.updateNhanVien(nvToanTG);
		int soLuongDong = model_table.getRowCount();
		
		for(int i = 0; i < soLuongDong; i++) {
			String id = model_table.getValueAt(i, 0) + "";
			
			if(id.equals(nvToanTG.getMaNhanVien())){
				model_table.setValueAt(nvToanTG.getMaNhanVien() + "", i, 0);
				model_table.setValueAt(nvToanTG.getHoTen() + "", i, 1);
				model_table.setValueAt(nvToanTG.getSoDienThoai() + "", i, 2);
				model_table.setValueAt(nvToanTG.getEmail() + "", i, 3);
				model_table.setValueAt(nvToanTG.getPhongBan().getTenPhongBan() + "", i, 4);
		
				model_table.setValueAt(nvToanTG.getPhuCap() + "", i, 6);
				model_table.setValueAt(nvToanTG.getThuong() + "", i, 7);
				model_table.setValueAt(nvToanTG.getPhat() + "", i, 8);

				if(nvToanTG.getPhongBan().getTenPhongBan().equals("Kinh Doanh")) {
					model_table.setValueAt(200 + "/ngay", i, 5);
					model_table.setValueAt(200*30 + nvToanTG.getPhuCap() + nvToanTG.getThuong() - nvToanTG.getPhat() + "", i, 9);
				
				} else if(nvToanTG.getPhongBan().getTenPhongBan().equals("Van Hanh")) {
					model_table.setValueAt(8000 + "/thang", i, 5);
					model_table.setValueAt(8000 + nvToanTG.getPhuCap() + nvToanTG.getThuong() - nvToanTG.getPhat() + "", i, 9);
					
				} else if(nvToanTG.getPhongBan().getTenPhongBan().equals("Ky Thuat")) {
					model_table.setValueAt(10000 + "/thang", i, 5);
					model_table.setValueAt(10000 + nvToanTG.getPhuCap() + nvToanTG.getThuong() - nvToanTG.getPhat() + "", i, 9);
				
				} else if(nvToanTG.getPhongBan().getTenPhongBan().equals("Ky Thuat")) {
					model_table.setValueAt(5000 + "/thang", i, 5);
					model_table.setValueAt(5000 + nvToanTG.getPhuCap() + nvToanTG.getThuong() - nvToanTG.getPhat() + "", i, 9);
				}
				//model_table.setValueAt(nvToanTG. + "", i, 9);
			}
		}
	}

	//them nhan vien CHINH THUC vao table
	private void themNhanVienChinhThucVaoTable(NhanVienToanThoiGian nvToanTG) {
		DefaultTableModel model_table = (DefaultTableModel) table_nhanVien.getModel();
		model_table.addRow(new Object[] {
				nvToanTG.getMaNhanVien(),
				nvToanTG.getHoTen(),
				nvToanTG.getSoDienThoai(),
				nvToanTG.getEmail(),
				nvToanTG.getPhongBan().getTenPhongBan(),
				nvToanTG.getLuongThang(),
				nvToanTG.getPhuCap(),
				nvToanTG.getThuong(),
				nvToanTG.getPhat(),
				nvToanTG.tinhLuong()
		});
		
	}

	//them nhan vien THOI VU vao table
	private void themNhanVienThoiVuVaoTable(NhanVienThoiVu nvThoiVu) {
		DefaultTableModel model_table = (DefaultTableModel) table_nhanVien.getModel();
		model_table.addRow(new Object[] {
				nvThoiVu.getMaNhanVien(),
				nvThoiVu.getHoTen(),
				nvThoiVu.getSoDienThoai(),
				nvThoiVu.getEmail(),
				nvThoiVu.getPhongBan().getTenPhongBan(),
				nvThoiVu.getLuongGio() + "/gio",
				nvThoiVu.getPhuCap(),
				nvThoiVu.getThuong(),
				nvThoiVu.getPhat(),
				nvThoiVu.tinhLuong()
		});
		
	}
	
	//them nhan vien THUC TAP vao table
	private void themNhanVienThucTapVaoTable(NhanVienThucTap nvThucTap) {
		DefaultTableModel model_table = (DefaultTableModel) table_nhanVien.getModel();
		model_table.addRow(new Object[] {
				nvThucTap.getMaNhanVien(),
				nvThucTap.getHoTen(),
				nvThucTap.getSoDienThoai(),
				nvThucTap.getEmail(),
				nvThucTap.getPhongBan().getTenPhongBan(),
				0+ "",
				0+ "",
				nvThucTap.getThuong(),
				nvThucTap.getPhat(),
				nvThucTap.tinhLuong()
		});
		
	}
	
	//Lay Du Lieu Tu Table Tai Row Dang Selected
	public NhanVien getNhanVienDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table_nhanVien.getModel();
		int i_row = table_nhanVien.getSelectedRow();
		
		
		if(model_table.getValueAt(i_row, 4).equals("Thuc Tap")) {
			String maNhanVien = model_table.getValueAt(i_row, 0)+ "";
			String hoTen = model_table.getValueAt(i_row, 1)+ "";
			String soDienThoai = model_table.getValueAt(i_row, 2)+ "";
			String eMail = model_table.getValueAt(i_row, 3)+ "";
			
			PhongBan phongBan = this.model.getPhongBanByTen(model_table.getValueAt(i_row, 4) + "");
			
			//double phuCap = Float.valueOf(model_table.getValueAt(i_row, 6)+ "");
			double phuCap = 0;
			double thuong = Float.valueOf(model_table.getValueAt(i_row, 7)+ "");
			double phat = Float.valueOf(model_table.getValueAt(i_row, 8)+ "");
			
			NhanVienThucTap nvThucTap = new NhanVienThucTap(maNhanVien, hoTen, soDienThoai, eMail, phongBan, thuong, phat);
			return nvThucTap;
		
		}else if(model_table.getValueAt(i_row, 4).equals("Thoi Vu")) {
			String maNhanVien = model_table.getValueAt(i_row, 0)+ "";
			String hoTen = model_table.getValueAt(i_row, 1)+ "";
			String soDienThoai = model_table.getValueAt(i_row, 2)+ "";
			String eMail = model_table.getValueAt(i_row, 3)+ "";
			
			PhongBan phongBan = this.model.getPhongBanByTen(model_table.getValueAt(i_row, 4) + "");
			
			//double phuCap = Float.valueOf(model_table.getValueAt(i_row, 6)+ "");
			double phuCap = 0;
			double thuong = Double.valueOf(model_table.getValueAt(i_row, 7)+ "");
			double phat = Double.valueOf(model_table.getValueAt(i_row, 8)+ "");
			double gioLamViec = (Double.valueOf(model_table.getValueAt(i_row, 9)+ "") + phat - thuong )/50;
			
			NhanVienThoiVu nvThoiVu = new NhanVienThoiVu(maNhanVien, hoTen, soDienThoai, eMail, phongBan, phuCap, thuong, phat, gioLamViec);
			return nvThoiVu;
			
		
		}else if(model_table.getValueAt(i_row, 4).equals("Kinh Doanh") || model_table.getValueAt(i_row, 4).equals("Van Hanh") || model_table.getValueAt(i_row, 4).equals("Ky Thuat") || model_table.getValueAt(i_row, 4).equals("Bao Ve")) {
			String maNhanVien = model_table.getValueAt(i_row, 0)+ "";
			String hoTen = model_table.getValueAt(i_row, 1)+ "";
			String soDienThoai = model_table.getValueAt(i_row, 2)+ "";
			String eMail = model_table.getValueAt(i_row, 3)+ "";
			
			PhongBan phongBan = this.model.getPhongBanByTen(model_table.getValueAt(i_row, 4) + "");
			
			double phuCap = Double.valueOf(model_table.getValueAt(i_row, 6)+ "");
			//double phuCap = 0;
			double thuong = Double.valueOf(model_table.getValueAt(i_row, 7)+ "");
			double phat = Double.valueOf(model_table.getValueAt(i_row, 8)+ "");
			
			if(model_table.getValueAt(i_row, 4).equals("Kinh Doanh")) {
				NhanVienToanThoiGian nvKinhDoanh = new NhanVienKinhDoanh(maNhanVien, hoTen, soDienThoai, eMail, phongBan, phuCap, thuong, phat);
				return nvKinhDoanh;
				
			} else if(model_table.getValueAt(i_row, 4).equals("Van Hanh")) {
				NhanVienToanThoiGian nvVanHanh = new NhanVienVanHanh(maNhanVien, hoTen, soDienThoai, eMail, phongBan, phuCap, thuong, phat);
				return nvVanHanh;
				
			} else if(model_table.getValueAt(i_row, 4).equals("Ky Thuat")) {
				NhanVienToanThoiGian nvKyThuat = new NhanVienKyThuat(maNhanVien, hoTen, soDienThoai, eMail, phongBan, phuCap, thuong, phat);
				return nvKyThuat;
				
			} else if(model_table.getValueAt(i_row, 4).equals("Bao Ve")) {
				NhanVienToanThoiGian nvBaoVe = new NhanVienBaoVe(maNhanVien, hoTen, soDienThoai, eMail, phongBan, phuCap, thuong, phat);
				return nvBaoVe;
			}
			
		}
		return null;
	};
	
	//Hien Thi Thong Tin Thi Sinh Da Chon Vao Cac O TextField
	public void hienThiThongTinThiSinhDaChon() {
		
		NhanVien nv = getNhanVienDangChon();
		
		//Gán dữ liệu nhân viên thực tập vào table
		if(nv.getPhongBan().getTenPhongBan().equals("Thuc Tap")) {
			NhanVienThucTap nvThucTap = (NhanVienThucTap) getNhanVienDangChon();
			this.textField_Info_IDNhanVien.setText(nvThucTap.getMaNhanVien() + "");
			this.textField_Info_HoTen.setText(nvThucTap.getHoTen() + "");
			this.textField_Info_SoDienThoai.setText(nvThucTap.getSoDienThoai() + "");
			this.textField_Info_Email.setText(nvThucTap.getEmail() + "");
			this.comboBox_Info_PhongBan.setSelectedItem(nvThucTap.getPhongBan().getTenPhongBan());
			
			this.textField_Info_PhuCap.setText("0");
			this.textField_Info_Thuong.setText(nvThucTap.getThuong() + "");
			this.textField_Info_Phat.setText(nvThucTap.getPhat() + "");
		
			
		//Gán dữ liệu nhân viên thời vụ vào table	
		} else if(nv.getPhongBan().getTenPhongBan().equals("Thoi Vu")) {
			NhanVienThoiVu nvThoiVu = (NhanVienThoiVu) getNhanVienDangChon();
			this.textField_Info_IDNhanVien.setText(nvThoiVu.getMaNhanVien() + "");
			this.textField_Info_HoTen.setText(nvThoiVu.getHoTen() + "");
			this.textField_Info_SoDienThoai.setText(nvThoiVu.getSoDienThoai() + "");
			this.textField_Info_Email.setText(nvThoiVu.getEmail() + "");
			this.comboBox_Info_PhongBan.setSelectedItem(nvThoiVu.getPhongBan().getTenPhongBan());
			
			this.textField_Info_PhuCap.setText("0");
			this.textField_Info_Thuong.setText(nvThoiVu.getThuong() + "");
			this.textField_Info_Phat.setText(nvThoiVu.getPhat() + "");
			this.textField_Info_SoGio.setText(nvThoiVu.getGioLamViec() + "");
			
			
		//Gán dữ liệu nhân viên chính thức (toàn thời gian) vào table	
		} else if(nv.getPhongBan().getTenPhongBan().equals("Kinh Doanh") || nv.getPhongBan().getTenPhongBan().equals("Van Hanh") || nv.getPhongBan().getTenPhongBan().equals("Ky Thuat") || nv.getPhongBan().getTenPhongBan().equals("Bao Ve")) {
			NhanVienToanThoiGian nvToanTG = (NhanVienToanThoiGian) getNhanVienDangChon();
			this.textField_Info_IDNhanVien.setText(nvToanTG.getMaNhanVien() + "");
			this.textField_Info_HoTen.setText(nvToanTG.getHoTen() + "");
			this.textField_Info_SoDienThoai.setText(nvToanTG.getSoDienThoai() + "");
			this.textField_Info_Email.setText(nvToanTG.getEmail() + "");
			this.comboBox_Info_PhongBan.setSelectedItem(nvToanTG.getPhongBan().getTenPhongBan());
			
			this.textField_Info_PhuCap.setText(nvToanTG.getPhuCap() + "");
			this.textField_Info_Thuong.setText(nvToanTG.getThuong() + "");
			this.textField_Info_Phat.setText(nvToanTG.getPhat() + "");
			
		}
		
	}

	//Xoa nhan vien khoi danh sach
	public void thucHienXoaNV() {
		DefaultTableModel model_table = (DefaultTableModel) table_nhanVien.getModel();	//DefaultTableModel là lớp con của table. 
		int i_row = table_nhanVien.getSelectedRow();
		
		int luaChon = JOptionPane.showConfirmDialog(this, "Ban chac chan xoa dong nay!");
		if(luaChon == JOptionPane.YES_OPTION) {
			NhanVien nv = getNhanVienDangChon();
			this.model.xoaNhanVien(nv);
			model_table.removeRow(i_row);
		}
		this.thucHienTaiLaiDuLieuPB();
		
	}

	//Function tải lại table
	public void thucHienTaiLaiDuLieuNV() {
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel) table_nhanVien.getModel();
			int soLuongDong = model_table.getRowCount();
			
			if(soLuongDong == 0) 
				break;
			else 
				try {
					model_table.removeRow(0);
					
				} catch(Exception e) {
					e.printStackTrace();
					
				}
		}
		for(NhanVien nhanVien : this.model.getDanhSachNhanVien()) {
			if(nhanVien.getPhongBan().getTenPhongBan().equals("Thuc Tap")) {
				NhanVienThucTap nvThucTap = (NhanVienThucTap) nhanVien;
				this.themNhanVienThucTapVaoTable(nvThucTap);
				
			} else if(nhanVien.getPhongBan().getTenPhongBan().equals("Thoi Vu")) {
				NhanVienThoiVu nvThoiVu = (NhanVienThoiVu) nhanVien;
				this.themNhanVienThoiVuVaoTable(nvThoiVu);
				
			} else if(nhanVien.getPhongBan().getTenPhongBan().equals("Kinh Doanh") || nhanVien.getPhongBan().getTenPhongBan().equals("Van Hanh") || nhanVien.getPhongBan().getTenPhongBan().equals("Ky Thuat") || nhanVien.getPhongBan().getTenPhongBan().equals("Bao Ve")) {
				NhanVienToanThoiGian nvToanTG = (NhanVienToanThoiGian) nhanVien;
				this.themNhanVienChinhThucVaoTable(nvToanTG);
				
			}

		}
		
	}
	
	
	
	//Tim kiem sử dụng bộ loc
	public void thucHienTimNV() {
		
		//Goi ham HuyTimKiem()
		this.thucHienTaiLaiDuLieuNV();
		
		
		//Thuc hien tim kiem
		String phong = this.comboBox_Filter_PhongBan.getSelectedItem() + "";
		String maNhanVienTimKiem = this.textField_Filter_maNhanVien.getText();
		
		DefaultTableModel model_table = (DefaultTableModel) table_nhanVien.getModel();
		int soLuongDong = model_table.getRowCount();
		
		Set<String> idCuaNhanVienCanXoa = new TreeSet<String>();
		
		if(phong.length() > 0) {
			PhongBan phongBanDaChon = this.model.getPhongBanByTen(phong);
			for(int i = 0; i < soLuongDong; i++) {
				String tenPhong = model_table.getValueAt(i, 4) + "";
				String id = model_table.getValueAt(i, 0) + "";
				
				if(!tenPhong.equals(phongBanDaChon.getTenPhongBan())) {
					//idCuaNhanVienCanXoa.add(Integer.valueOf(id));
					idCuaNhanVienCanXoa.add(id);
				}
			}
		}
		
		if(maNhanVienTimKiem.length() > 0) {
			for(int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				
				if(!id.equals(maNhanVienTimKiem)) {
					idCuaNhanVienCanXoa.add(id);
					//idCuaNhanVienCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		
		for(String idCanXoa : idCuaNhanVienCanXoa) {
			System.out.println(idCanXoa);
			soLuongDong = model_table.getRowCount();
			
			for(int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				System.out.println("idTrongTable: " + idTrongTable);
				
				if(idTrongTable.equals(idCanXoa)) {
					System.out.println("Đã xóa: " + i);
					
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					break;
				}		
			}
		}
	}

	//Hiện thông báo khi nhấn vào About me
	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Đây là chương trình quản lý lương nhân viên supper supper cùi!!!");
		
	}

	//Exit chương trình
	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
				this,
				"Thoát Chương Trình", "Không!",
				JOptionPane.YES_NO_OPTION);
		
		if(luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}

//	themNhanVienVaoTableChinhThuc
//	themNhanVienVaoTableThoiVu
//	themNhanVienVaoTableThucTap

	public void sapXepTheoIdNV() {
		DefaultTableModel model_table = (DefaultTableModel) table_nhanVien.getModel();
		this.model.sapXepNhanVienTheoMaNhanVien();
		System.out.println(this.model.getDanhSachNhanVien());
		
		model_table.setRowCount(0);
		
		for(NhanVien nhanVien : this.model.getDanhSachNhanVien()) {
			if(nhanVien.getPhongBan().getTenPhongBan().equals("Kinh Doanh") || nhanVien.getPhongBan().getTenPhongBan().equals("Van Hanh") || nhanVien.getPhongBan().getTenPhongBan().equals("Ky Thuat") || nhanVien.getPhongBan().getTenPhongBan().equals("Bao Ve")) {
				this.themNhanVienChinhThucVaoTable((NhanVienToanThoiGian)nhanVien);
			
			} else if(nhanVien.getPhongBan().getTenPhongBan().equals("Thuc Tap")) {
				this.themNhanVienThucTapVaoTable((NhanVienThucTap) nhanVien);
				
			} else if(nhanVien.getPhongBan().getTenPhongBan().equals("Thoi Vu")) {
				this.themNhanVienThoiVuVaoTable((NhanVienThoiVu) nhanVien);
				
			}
		}
		
	}

	
	
	//Bat Dau Set View Phong Ban
	public void xoaFormPB() {
		this.textField_PB_Info_MaPhongBan.setText("");
		this.textField_PB_Info_TenPhongBan.setText("");
	}
	
	private void themPhongBanVaoTable(PhongBan phongBan) {
		DefaultTableModel model_table = (DefaultTableModel) table_phongBan.getModel();
		model_table.addRow(new Object[] {
				phongBan.getMaPhongBan(),
				phongBan.getTenPhongBan(),
				phongBan.getSoLuongNhanVien()
		});
	}
	
	private void themPhongBan(PhongBan phongBan) {
		if(!this.model.kiemTraTonTaiPB(phongBan)) {
			this.model.themPhongBan(phongBan);
			this.themPhongBanVaoTable(phongBan);
			
		} else {
			JOptionPane.showMessageDialog(this, "Ma phong ban da ton tai");
		}
	}

	public void thucHienThemPhongBan() {
		String maPhongBan = this.textField_PB_Info_MaPhongBan.getText();
		String tenPhongBan = this.textField_PB_Info_TenPhongBan.getText();
		
		PhongBan phongBan = new PhongBan(maPhongBan, tenPhongBan, 0);
		this.themPhongBan(phongBan);
		this.taiLaiDanhSachPB();
	}
	
	private PhongBan getPhongBanDaChon() {
		DefaultTableModel model_table = (DefaultTableModel) table_phongBan.getModel();
		int i_row = table_phongBan.getSelectedRow();
		String maPhongBan = model_table.getValueAt(i_row, 0) + "";
		String tenPhongBan = model_table.getValueAt(i_row, 1) + "";
		int soLuongNhanVien = Integer.valueOf(model_table.getValueAt(i_row, 2) + "");
		
		PhongBan phongBan = new PhongBan(maPhongBan, tenPhongBan, soLuongNhanVien);
		return phongBan;
	}

	//Hien Thi Thong Tin Phong Ban Da Chon, Cac Thong Tin Se Duoc Hien Len TextField Tuong Ung
	public void hienThiThongTinPhongBanDaChon() {
		PhongBan pb = getPhongBanDaChon();
		
		this.textField_PB_Info_MaPhongBan.setText(pb.getMaPhongBan() + "");
		this.textField_PB_Info_TenPhongBan.setText(pb.getTenPhongBan()  + "");
	}
	
	private void capNhatPhongBan(PhongBan phongBan) {
		DefaultTableModel model_table = (DefaultTableModel) table_phongBan.getModel();
		this.model.updatePhongBan(phongBan);
		this.taiLaiDanhSachPB();
		int soLuongDong = model_table.getRowCount();
		
		for(int i = 0; i < soLuongDong; i++) {
			String id = model_table.getValueAt(i, 0) + "";
			
			if(id.equals(phongBan.getMaPhongBan())){
				model_table.setValueAt(phongBan.getMaPhongBan() + "", i, 0);
				model_table.setValueAt(phongBan.getTenPhongBan() + "", i, 1);
				model_table.setValueAt(phongBan.getSoLuongNhanVien() + "", i, 2);
			}
		}	
	}

	//Thuc Hien Cap Nhat Phong Ban
	public void thucHienCapNhatPhongBan() {
		String maPhongBan = this.textField_PB_Info_MaPhongBan.getText();
		String tenPhongBan = this.textField_PB_Info_TenPhongBan.getText();
		
		PhongBan phongBan = new PhongBan(maPhongBan, tenPhongBan);
		this.capNhatPhongBan(phongBan);
		
	}

	//Thuc Hien Xoa Phong Ban
	public void thucHienXoaPB() {
		DefaultTableModel model_table = (DefaultTableModel) table_phongBan.getModel();	//DefaultTableModel là lớp con của table. 
		int i_row = table_phongBan.getSelectedRow();
		
		int luaChon = JOptionPane.showConfirmDialog(this, "Ban chac chan xoa dong nay!");
		if(luaChon == JOptionPane.YES_OPTION) {
			PhongBan pb = getPhongBanDaChon();
			if(pb.getSoLuongNhanVien() > 0) {
				JOptionPane.showMessageDialog(this, "Khong the xoa! Phong ban nay co nhan vien.");
			} else {
				this.model.xoaPhongBan(pb.getMaPhongBan());
				model_table.removeRow(i_row);
			}
		}
		this.taiLaiDanhSachPB();
		
	}
	
	//Thuc Hien Tai Lai Du Lieu Phong Ban
	public void thucHienTaiLaiDuLieuPB() {
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel) table_phongBan.getModel();
			int soLuongDong = model_table.getRowCount();
			
			if(soLuongDong == 0) 
				break;
			else 
				try {
					model_table.removeRow(0);
					
				} catch(Exception e) {
					e.printStackTrace();
					
				}
		}
		for(PhongBan phongBan : this.model.getDanhSachPhongBan()) {
			this.themPhongBanVaoTable(phongBan);
		}
	}
	
	//Bat Dau Thuc Hien Tim Kiem Kiem PB
	public void thucHienTimPB() {
		this.thucHienTaiLaiDuLieuPB();
		
		//Thuc hien Tim Kiems
		String maPhongBanTimKiem = this.textField_PB_Filter_MaPhongBan.getText();
		
		DefaultTableModel model_table = (DefaultTableModel) table_phongBan.getModel();
		int soLuongDong = model_table.getRowCount();
		
		Set<String> idCuaPhongBanCanXoa = new TreeSet<String>();
		
		if(maPhongBanTimKiem.length() > 0) {
			for(int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				
				if(!id.equals(maPhongBanTimKiem)) {
					idCuaPhongBanCanXoa.add(id);
				}
			}
		}
		
		for(String idCanXoa : idCuaPhongBanCanXoa) {
			soLuongDong = model_table.getRowCount();
			
			for(int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				
				if(idTrongTable.equals(idCanXoa)) {
					model_table.removeRow(i);
					break;
				}
			}
		}
		
	}

	public void sapXepTheoIdPB() {
		DefaultTableModel model_table = (DefaultTableModel) table_phongBan.getModel();
		this.model.sapXepPhongBanTheoMaPhongBan();
		
		model_table.setRowCount(0);
		for(PhongBan pb : this.model.getDanhSachPhongBan()) {
			this.themPhongBanVaoTable(pb);
		}	
	}
}
