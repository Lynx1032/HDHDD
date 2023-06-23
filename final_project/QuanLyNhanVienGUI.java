import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class QuanLyNhanVienGUI extends JFrame {

    private JPanel contentPane;
    private JTextField tfMaNhanVien;
    private JTextField tfHoTen;
    private JTextField tfHeSoLuong;
    private JTextField tfSoNgayLamViec;
    private JTable tableNhanVien;
    private JTable tableBangLuong;
    private ArrayList<NhanVien> danhSachNhanVien;
    private PhongBan phongBan;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QuanLyNhanVienGUI frame = new QuanLyNhanVienGUI();
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
    public QuanLyNhanVienGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setTitle("Quản lý nhân viên");

        // Initialize danhSachNhanVien array list
        danhSachNhanVien = new ArrayList<NhanVien>();

        // Initialize phongBan object
        PhongBanGUI phongBanGUI = new PhongBanGUI();
        phongBanGUI.setVisible(true);
        phongBan = phongBanGUI.getPhongBan();

        // Initialize GUI components
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblMaNhanVien = new JLabel("Mã nhân viên:");
        lblMaNhanVien.setBounds(10, 10, 100, 20);
        contentPane.add(lblMaNhanVien);

        tfMaNhanVien = new JTextField();
        tfMaNhanVien.setBounds(120, 10, 250, 20);
        contentPane.add(tfMaNhanVien);
        tfMaNhanVien.setColumns(10);

        JLabel lblHoTen = new JLabel("Họ tên:");
        lblHoTen.setBounds(10, 40, 100, 20);
        contentPane.add(lblHoTen);

        tfHoTen = new JTextField();
        tfHoTen.setBounds(120, 40, 250, 20);
        contentPane.add(tfHoTen);
        tfHoTen.setColumns(10);

        JLabel lblHeSoLuong = new JLabel("Hệ số lương:");
        lblHeSoLuong.setBounds(10, 70, 100, 20);
        contentPane.add(lblHeSoLuong);

        tfHeSoLuong = new JTextField();
        tfHeSoLuong.setBounds(120, 70, 250, 20);
        contentPane.add(tfHeSoLuong);
        tfHeSoLuong.setColumns(10);

        JLabel lblSoNgayLamViec = new JLabel("Số ngày làm việc:");
        lblSoNgayLamViec.setBounds(10, 100, 100, 20);
        contentPane.add(lblSoNgayLamViec);

        tfSoNgayLamViec = new JTextField();
        tfSoNgayLamViec.setBounds(120, 100, 250, 20);
        contentPane.add(tfSoNgayLamViec);
        tfSoNgayLamViec.setColumns(10);

        JButton btnThemNhanVien = new JButton("Thêm nhân viên");
        btnThemNhanVien.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String maNhanVien = tfMaNhanVien.getText();
                String hoTen = tfHoTen.getText();
                double heSoLuong = Double.parseDouble(tfHeSoLuong.getText());
                int soNgayLamViec = Integer.parseInt(tfSoNgayLamViec.getText());
                NhanVien nhanVien = new NhanVien(maNhanVien, hoTen, heSoLuong);
                nhanVien.setSoNgayLamViec(soNgayLamViec);
                danhSachNhanVien.add(nhanVien);
                hienThiDanhSachNhanVien();
            }
        });
        btnThemNhanVien.setBounds(107 130, 120, 30);
        contentPane.add(btnThemNhanVien);

        JButton btnHienThiDanhSachNhanVien = new JButton("Hiển thị danh sách nhân viên");
        btnHienThiDanhSachNhanVien.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hienThiDanhSachNhanVien();
            }
        });
        btnHienThiDanhSachNhanVien.setBounds(10, 170, 250, 30);
        contentPane.add(btnHienThiDanhSachNhanVien);

        JButton btnTinhBangLuong = new JButton("Tính bảng lương");
        btnTinhBangLuong.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hienThiBangLuong();
            }
        });
        btnTinhBangLuong.setBounds(270, 170, 250, 30);
        contentPane.add(btnTinhBangLuong);

        JScrollPane scrollPaneNhanVien = new JScrollPane();
        scrollPaneNhanVien.setBounds(10, 210, 500, 300);
        contentPane.add(scrollPaneNhanVien);

        tableNhanVien = new JTable();
        tableNhanVien.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Mã nhân viên", "Họ tên", "Hệ số lương", "Số ngày làm việc", "Lương" }
        ));
        scrollPaneNhanVien.setViewportView(tableNhanVien);

        JScrollPane scrollPaneBangLuong = new JScrollPane();
        scrollPaneBangLuong.setBounds(520, 210, 250, 300);
        contentPane.add(scrollPaneBangLuong);

        tableBangLuong = new JTable();
        tableBangLuong.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Phòng ban", "Tổng lương" }
        ));
        scrollPaneBangLuong.setViewportView(tableBangLuong);
    }

    /**
     * Display a table of all employees in the current department along with their salaries.
     */
    private void hienThiDanhSachNhanVien() {
        DefaultTableModel model = (DefaultTableModel) tableNhanVien.getModel();
        model.setRowCount(0); // clear table
        for (NhanVien nhanVien : danhSachNhanVien) {
            Object[] row = {
                nhanVien.getMaNhanVien(),
                nhanVien.getHoTen(),
                nhanVien.getHeSoLuong(),
                nhanVien.getSoNgayLamViec(),
                nhanVien.tinhLuong()
            };
            model.addRow(row);
        }
    }

    /**
     * Display a table of the total salary of all employees in the current department.
     */
    private void hienThiBangLuong() {
        DefaultTableModel model = (DefaultTableModel) tableBangLuong.getModel();
        model.setRowCount(0); // clear table
        Object[] row = {
            phongBan.getTenPhongBan(),
            phongBan.tinhTongLuong()
        };
        model.addRow(row);
    }

}