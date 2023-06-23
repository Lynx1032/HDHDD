import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PhongBanGUI extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField tfMaPhongBan;
    private JTextField tfTenPhongBan;
    private JTextField tfSoLuongNhanVien;
    private PhongBan phongBan;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            PhongBanGUI dialog = new PhongBanGUI();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public PhongBanGUI() {
        setBounds(100, 100, 450, 300);
        setTitle("Thông tin phòng ban");
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblMaPhongBan = new JLabel("Mã phòng ban:");
        lblMaPhongBan.setBounds(10, 10, 100, 20);
        contentPanel.add(lblMaPhongBan);

        tfMaPhongBan = new JTextField();
        tfMaPhongBan.setBounds(120, 10, 250, 20);
        contentPanel.add(tfMaPhongBan);
        tfMaPhongBan.setColumns(10);

        JLabel lblTenPhongBan = new JLabel("Tên phòng ban:");
        lblTenPhongBan.setBounds(10, 40, 100, 20);
        contentPanel.add(lblTenPhongBan);

        tfTenPhongBan = new JTextField();
        tfTenPhongBan.setBounds(120, 40, 250, 20);
        contentPanel.add(tfTenPhongBan);
        tfTenPhongBan.setColumns(10);

        JLabel lblSoLuongNhanVien = new JLabel("Số lượng nhân viên:");
        lblSoLuongNhanVien.setBounds(10, 70, 100, 20);
        contentPanel.add(lblSoLuongNhanVien);

        tfSoLuongNhanVien = new JTextField();
        tfSoLuongNhanVien.setBounds(120, 70, 250, 20);
        contentPanel.add(tfSoLuongNhanVien);
        tfSoLuongNhanVien.setColumns(10);

        JButton btnXacNhan = new JButton("Xác nhận");
        btnXacNhan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String maPhongBan = tfMaPhongBan.getText();
                String tenPhongBan = tfTenPhongBan.getText();
                int soLuongNhanVien = Integer.parseInt(tfSoLuongNhanVien.getText());
                phongBan = new PhongBan(maPhongBan, tenPhongBan, soLuongNhanVien);
                dispose();
            }
        });
        btnXacNhan.setBounds(120, 120, 100, 30);
        contentPanel.add(btnXacNhan);
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

}