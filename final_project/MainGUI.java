import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class MainGUI extends JFrame {

    private JPanel contentPane;
    private JTextField tfMaPhongBan;
    private JTextField tfTenPhongBan;
    private JTextField tfSoLuongNhanVien;
    private JTextField tfHoTen;
    private JTextField tfMaNhanVien;
    private JTextField tfHeSoLuong;
    private JTextField tfSoNgayLamViec;
    private JTable tableNhanVien;
    private JTable tableBangLuong;
    private PhongBan phongBan = null;
    private ArrayList<NhanVien> danhSachNhanVien = new ArrayList<NhanVien>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainGUI frame = new MainGUI();
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
    public MainGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panelPhongBan = new JPanel();
        contentPane.add(panelPhongBan, BorderLayout.NORTH);

        JLabel labelMaPhongBan = new JLabel("Mã phòng ban:");
		panelPhongBan.add(labelMaPhongBan);

		tfMaPhongBan = new JTextField();
		panelPhongBan.add(tfMaPhongBan);
		tfMaPhongBan.setColumns(10);

        JLabel labelTenPhongBan = new JLabel("Tên phòng ban:");
		panelPhongBan.add(labelTenPhongBan);

		tfTenPhongBan = new JTextField();
		panelPhongBan.add(tfTenPhongBan);
		tfTenPhongBan.setColumns(10);

        JLabel labelSoLuongNhanVien = new JLabel("Số lượng nhân viên:");
		panelPhongBan.add(labelSoLuongNhanVien);

		tfSoLuongNhanVien = new JTextField();
		panelPhongBan.add(tfSoLuongNhanVien);
		tfSoLuongNhanVien.setColumns(10);

        JButton btnTaoPhongBan = new JButton("Tạo phòng ban");
        btnTaoPhongBan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String maPhongBan = tfMaPhongBan.getText();
                String tenPhongBan = tfTenPhongBan.getText();
                int soLuongNhanVien = Integer.parseInt(tfSoLuongNhanVien.getText());
                phongBan = new PhongBan(maPhongBan, tenPhongBan, soLuongNhanVien);
            }
        });
        panelPhongBan.add(btnTaoPhongBan);
		
		JPanel panelNhanVien = new JPanel();
		contentPane.add(panelNhanVien, BorderLayout.WEST);
		
		JLabel labelHoTen = new JLabel("Họ và tên:");
		panelNhanVien.add(labelHoTen);

        tfHoTen = new JTextField();
        panelNhanVien.add(tfHoTen);
        tfHoTen.setColumns(10);

		JLabel labelMaNhanVien = new JLabel("Mã NV:");
		panelNhanVien.add(labelMaNhanVien);
		
        tfMaNhanVien = new JTextField();
        panelNhanVien.add(tfMaNhanVien);
        tfMaNhanVien.setColumns(10);
		
		JLabel labelHeSoLuong = new JLabel("Hệ số lương:");
		panelNhanVien.add(labelHeSoLuong);

        tfHeSoLuong = new JTextField();
        panelNhanVien.add(tfHeSoLuong);
        tfHeSoLuong.setColumns(10);
		
		JLabel labelSoNgayLamViec = new JLabel("Số ngày làm việc:");
		panelNhanVien.add(labelSoNgayLamViec);

        tfSoNgayLamViec = new JTextField();
        panelNhanVien.add(tfSoNgayLamViec);
        tfSoNgayLamViec.setColumns(10);
		
		JPanel buttonPanel = new JPanel();
		panelNhanVien.add(buttonPanel);

        JButton btnThemNhanVien = new JButton("Thêm nhân viên");
        btnThemNhanVien.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String hoTen = tfHoTen.getText();
                String maNhanVien = tfMaNhanVien.getText();
                double heSoLuong = Double.parseDouble(tfHeSoLuong.getText());
                int soNgayLamViec = Integer.parseInt(tfSoNgayLamViec.getText());
                NhanVien nhanVien = new NhanVien(maNhanVien, hoTen, heSoLuong, soNgayLamViec);
                danhSachNhanVien.add(nhanVien);
                phongBan.themNhanVien(nhanVien);
                hienThiDanhSachNhanVien();
            }
        });
        buttonPanel.add(btnThemNhanVien);
		
		JButton btnXoaNhanVien = new JButton("Xóa nhân viên");
		btnXoaNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = tableNhanVien.getSelectedRow();
				if (selectedIndex != -1) {
					NhanVien nhanVien = danhSachNhanVien.get(selectedIndex);
					danhSachNhanVien.remove(selectedIndex);
					phongBan.xoaNhanVien(nhanVien);
					hienThiDanhSachNhanVien();
				}
			}
		});
		buttonPanel.add(btnXoaNhanVien);
		
		
		JButton btnSuaNhanVien = new JButton("Sửa nhân viên");
		btnSuaNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = tableNhanVien.getSelectedRow();
				if (selectedIndex != -1) {
					NhanVien nhanVien = danhSachNhanVien.get(selectedIndex);
					String hoTen = tfHoTen.getText();
					double heSoLuong = Double.parseDouble(tfHeSoLuong.getText());
					int soNgayLamViec = Integer.parseInt(tfSoNgayLamViec.getText());
					nhanVien.setHoTen(hoTen);
					nhanVien.setHeSoLuong(heSoLuong);
					nhanVien.setSoNgayLamViec(soNgayLamViec);
					phongBan.capNhatNhanVien(nhanVien);
					hienThiDanhSachNhanVien();
				}
			}
		});
		buttonPanel.add(btnSuaNhanVien);
		
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelNhanVien.setLayout(new GridLayout(8, 2));
		
		
		
		panelNhanVien.add(buttonPanel, BorderLayout.SOUTH);

        JScrollPane scrollPaneNhanVien = new JScrollPane();
        contentPane.add(scrollPaneNhanVien, BorderLayout.CENTER);

        tableNhanVien = new JTable();
        tableNhanVien.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Mã nhân viên", "Họ tên", "Hệ số lương", "Số ngày làm việc", "Lương" }
        ) {
            Class[] columnTypes = new Class[] { String.class, String.class, Double.class, Integer.class, Double.class };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
            boolean[] columnEditables = new boolean[] { false, false, false, false, false };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPaneNhanVien.setViewportView(tableNhanVien);

        JPanel panelBangLuong = new JPanel();
        contentPane.add(panelBangLuong, BorderLayout.SOUTH);

        JButton btnXuatFile = new JButton("Xuất file");
        btnXuatFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files", "txt");
                fileChooser.setFileFilter(filter);
                int result = fileChooser.showSaveDialog(MainGUI.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    try {
                        FileWriter writer = new FileWriter(fileToSave);
                        writer.write("THÔNG TIN PHÒNG BAN\n");
                        writer.write("Mã phòng ban: " + phongBan.getMaPhongBan() + "\n");
                        writer.write("Tên phòng ban: " + phongBan.getTenPhongBan() + "\n");
                        writer.write("Số lượng nhân viên: " + phongBan.getSoLuongNhanVien() + "\n\n");
                        writer.write("THÔNG TIN NHÂN VIÊN\n");
                        writer.write("Mã nhân viên\tHọ tên\tHệ số lương\tSố ngày làm việc\tLương\n");
                        for (NhanVien nhanVien : danhSachNhanVien) {
                            writer.write(nhanVien.getMaNhanVien() + "\t" + nhanVien.getHoTen() + "\t" + nhanVien.getHeSoLuong() + "\t" + nhanVien.getSoNgayLamViec() + "\t" + nhanVien.tinhLuong() + "\n");
                        }
                        writer.write("\nBẢNG TỔNG LƯƠNG\n");
                        DecimalFormat df = new DecimalFormat("#,###.##");
                        //writer.write("Tổng lương của công ty trong 1 tháng: " + df.format(PhongBan.tinhTongLuongCuaCongTy()) + " VND\n");
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        panelBangLuong.add(btnXuatFile);

        JScrollPane scrollPaneBangLuong = new JScrollPane();
        panelBangLuong.add(scrollPaneBangLuong);

        tableBangLuong = new JTable();
        tableBangLuong.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Phòng ban", "Tổng lương" }
        ) {
            Class[] columnTypes = new Class[] { String.class, Double.class };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
            boolean[] columnEditables = new boolean[] { false, false };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPaneBangLuong.setViewportView(tableBangLuong);
		tableBangLuong.getColumnModel().getColumn(0).setResizable(false);
		tableBangLuong.getColumnModel().getColumn(1).setResizable(false);
		panelBangLuong.add(scrollPaneBangLuong);
	}
	
	private void hienThiDanhSachNhanVien() {
    DefaultTableModel model = (DefaultTableModel) tableNhanVien.getModel();
    model.setRowCount(0);
    for (NhanVien nhanVien : danhSachNhanVien) {
        Object[] row = new Object[5];
        row[0] = nhanVien.getMaNhanVien();
        row[1] = nhanVien.getHoTen();
        row[2] = nhanVien.getHeSoLuong();
        row[3] = nhanVien.getSoNgayLamViec();
        row[4] = nhanVien.tinhLuong();
        model.addRow(row);
    }
    hienThiBangLuong();
}

private void hienThiBangLuong() {
    DefaultTableModel model = (DefaultTableModel) tableBangLuong.getModel();
    model.setRowCount(0);
    Object[] row = new Object[2];
    row[0] = phongBan.getTenPhongBan();
    row[1] = phongBan.tinhTongLuong();
    model.addRow(row);
}
}