import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class EmployeeManagementSystemGUI {

    private JFrame frame;
    private JPanel panel;
    private JTable departmentTable, employeeTable;
    private DefaultTableModel departmentTableModel, employeeTableModel;

    public EmployeeManagementSystemGUI() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Quản lý nhân viên");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000, 600));
        frame.setLocationRelativeTo(null);

        panel = new JPanel(new BorderLayout());

        // create department table
        departmentTableModel = new DefaultTableModel(new Object[] { "MÃ PHÒNG BAN", "TÊN PHÒNG BAN",
                "SÔ NHÂN VIÊN" }, 0);
        departmentTable = new JTable(departmentTableModel);
        JScrollPane departmentScrollPane = new JScrollPane(departmentTable);
        departmentScrollPane.setPreferredSize(new Dimension(500, 200));

        // create employee table
        employeeTableModel = new DefaultTableModel(new Object[] { "MÃ NHÂN VIÊN", "HỌ TÊN", "SĐT",
                "Email", "MÃ PHÒNG BAN", "VỊ TRÍ", "LƯƠNG CƠ BẢN", "PHỤ CẤP", "THƯỞNG", "PHẠT", "TỔNG" }, 0);
        employeeTable = new JTable(employeeTableModel);
        JScrollPane employeeScrollPane = new JScrollPane(employeeTable);
        employeeScrollPane.setPreferredSize(new Dimension(900, 200));

        // add tables to panel
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(departmentScrollPane, BorderLayout.WEST);
        tablePanel.add(employeeScrollPane, BorderLayout.EAST);
        panel.add(tablePanel, BorderLayout.NORTH);

        // add buttons to panel
        JPanel buttonPanel = new JPanel();
        //JButton listDepartmentBtn = new JButton("Xem danh sách phòng ban");
		//JButton listEmployeeBtn = new JButton("Xem danh sách nhân viên");
		JButton addDepartmentBtn = new JButton("Thêm phòng ban");
		JButton addEmployeeBtn = new JButton("Thêm nhân viên");
		JButton editDepartmentBtn = new JButton("Chỉnh sửa phòng ban");
		JButton editEmployeeBtn = new JButton("Chỉnh sửa nhân viên");
		JButton deleteDepartmentBtn = new JButton("Xóa phòng ban");
		JButton deleteEmployeeBtn = new JButton("Xóa nhân viên");
		JButton searchDepartmentIDBtn = new JButton("Tìm kiếm theo mã phòng ban");
		JButton searchEmployeeIDBtn = new JButton("Tìm kiếm theo mã nhân viên");
		JButton listAllEmployeeInDepartmentBtn = new JButton("Xem tất cả nhân viên của phòng ban");
		JButton listAllBtn = new JButton("Xem tất cả");
		//buttonPanel.add(listDepartmentBtn);
        //buttonPanel.add(listEmployeeBtn);
        buttonPanel.add(addDepartmentBtn);
        buttonPanel.add(addEmployeeBtn);
        buttonPanel.add(editDepartmentBtn);
        buttonPanel.add(editEmployeeBtn);
        buttonPanel.add(deleteDepartmentBtn);
        buttonPanel.add(deleteEmployeeBtn);
        buttonPanel.add(searchDepartmentIDBtn);
        buttonPanel.add(searchEmployeeIDBtn);
        buttonPanel.add(listAllEmployeeInDepartmentBtn);
		buttonPanel.add(listAllBtn);
        panel.add(buttonPanel, BorderLayout.CENTER);

        // add import/export button to panel
        JPanel importExportPanel = new JPanel();
        JButton importDepartmentBtn = new JButton("Nhập danh sách phòng ban từ file text");
        JButton exportDepartmentBtn = new JButton("Xuất danh sách phòng ban vào file text");
		JButton importEmployeeBtn = new JButton("Nhập danh sách nhân viên từ file text");
        JButton exportEmployeeBtn = new JButton("Xuất danh sách nhân viên vào file text");
        importExportPanel.add(importDepartmentBtn);
        importExportPanel.add(exportDepartmentBtn);
		importExportPanel.add(importEmployeeBtn);
		importExportPanel.add(exportEmployeeBtn);
		
        panel.add(importExportPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
		
		addDepartmentBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Prompt user to enter information about person
                String dID = JOptionPane.showInputDialog(frame, "Nhập mã phòng ban:");
                String dName = JOptionPane.showInputDialog(frame, "Nhập tên phòng ban:");
                int dNOE = Integer.parseInt(JOptionPane.showInputDialog(frame, "Nhập số lượng nhân viên:"));
                
                // Create person object with entered information
                //Department department = new Department(dID, dName, dNOE);
                
                // Add person object to table model
                departmentTableModel.addRow(new Object[] { dID, dName, dNOE });
            }
        });
		
        addEmployeeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Prompt user to enter information about employee
                String eID = JOptionPane.showInputDialog(frame, "Nhập mã nhân viên:");
                String fullName = JOptionPane.showInputDialog(frame, "Nhập họ và tên:");
                String phoneNumber = JOptionPane.showInputDialog(frame, "Nhập số điện thoại:");
                String email = JOptionPane.showInputDialog(frame, "Nhập email:");
                String dID = JOptionPane.showInputDialog(frame, "Nhập mã phòng ban:");
                String position = JOptionPane.showInputDialog(frame, "Nhập chức vụ:");
                String salaries = JOptionPane.showInputDialog(frame, "Nhập lương cơ bản:");
                String allowances = JOptionPane.showInputDialog(frame, "Nhập phụ cấp:");
                String bonuses = JOptionPane.showInputDialog(frame, "Nhập thưởng:");
                String penalties = JOptionPane.showInputDialog(frame, "Nhập phạt:");

                // Calculate total payment
                int tong = Integer.parseInt(salaries) + Integer.parseInt(allowances) + Integer.parseInt(bonuses)
                        - Integer.parseInt(penalties);

                // Create new employee object and add to employee table model
                Object[] employeeData = { eID, fullName, phoneNumber, email, dID, position, salaries, allowances,
                        bonuses, penalties, tong };
                employeeTableModel.addRow(employeeData);
            }
        });
		
		editDepartmentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected row in department table
                int selectedRow = departmentTable.getSelectedRow();

                // Check if a row is selected
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(frame, "Vui lòng chọn phòng ban để chỉnh sửa");
                    return;
                }

                // Prompt user to enter new information about department
                String newDID = JOptionPane.showInputDialog(frame, "Nhập mã phòng ban mới:");
                String newDName = JOptionPane.showInputDialog(frame, "Nhập tên phòng ban mới:");
                String newNumEmployees = JOptionPane.showInputDialog(frame, "Nhập số lượng nhân viên mới:");

                // Update department table model with new information
                departmentTableModel.setValueAt(newDID, selectedRow, 0);
                departmentTableModel.setValueAt(newDName, selectedRow, 1);
                departmentTableModel.setValueAt(newNumEmployees, selectedRow, 2);
            }
        });
		
        editEmployeeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected row in employee table
                int selectedRow = employeeTable.getSelectedRow();

                // Check if a row is selected
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(frame, "Vui lòng chọn nhân viên để chỉnh sửa");
                    return;
                }

                // Prompt user to enter new information about employee
                String newEID = JOptionPane.showInputDialog(frame, "Nhập mã nhân viên mới:");
                String newFullName = JOptionPane.showInputDialog(frame, "Nhập họ và tên mới:");
                String newPhoneNumber = JOptionPane.showInputDialog(frame, "Nhập số điện thoại mới:");
                String newEmail = JOptionPane.showInputDialog(frame, "Nhập email mới:");
                String newDID = JOptionPane.showInputDialog(frame, "Nhập mã phòng ban mới:");
                String newPosition = JOptionPane.showInputDialog(frame, "Nhập chức vụ mới:");
                String newSalaries = JOptionPane.showInputDialog(frame, "Nhập lương cơ bản mới:");
                String newAllowances = JOptionPane.showInputDialog(frame, "Nhập phụ cấp mới:");
                String newBonuses = JOptionPane.showInputDialog(frame, "Nhập thưởng mới:");
                String newPenalties = JOptionPane.showInputDialog(frame, "Nhập phạt mới:");

                // Calculate new total payment
                int newTong = Integer.parseInt(newSalaries) + Integer.parseInt(newAllowances)
                        + Integer.parseInt(newBonuses) - Integer.parseInt(newPenalties);

                // Update employee table model with new information
                employeeTableModel.setValueAt(newEID, selectedRow, 0);
                employeeTableModel.setValueAt(newFullName, selectedRow, 1);
				employeeTableModel.setValueAt(newPhoneNumber, selectedRow, 2);
				employeeTableModel.setValueAt(newEmail, selectedRow, 3);
				employeeTableModel.setValueAt(newDID, selectedRow, 4);
				employeeTableModel.setValueAt(newPosition, selectedRow, 5);
				employeeTableModel.setValueAt(newSalaries, selectedRow, 6);
				employeeTableModel.setValueAt(newAllowances, selectedRow, 7);
				employeeTableModel.setValueAt(newBonuses, selectedRow, 8);
				employeeTableModel.setValueAt(newPenalties, selectedRow, 9);
				employeeTableModel.setValueAt(newTong, selectedRow, 10);
			}
		});
		
		deleteDepartmentBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Get selected row in department table
				int selectedRow = departmentTable.getSelectedRow();

				// Check if a row is selected
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(frame, "Vui lòng chọn phòng ban để xóa");
					return;
				}

				// Remove selected department from department table model
				departmentTableModel.removeRow(selectedRow);
			}
		});
		
		deleteEmployeeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Get selected row in employee table
				int selectedRow = employeeTable.getSelectedRow();

				// Check if a row is selected
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(frame, "Vui lòng chọn nhân viên để xóa");
					return;
				}

				// Remove selected employee from employee table model
				employeeTableModel.removeRow(selectedRow);
			}
		});
		
		searchDepartmentIDBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Prompt user to enter department ID to search for
				String searchID = JOptionPane.showInputDialog(frame, "Nhập mã phòng ban cần tìm:");

				// Search for department with the given ID in department table model
				for (int i = 0; i < departmentTableModel.getRowCount(); i++) {
					String dID = (String) departmentTableModel.getValueAt(i, 0);
					if (dID.equals(searchID)) {
						// Select row in department table and scroll to it
						departmentTable.setRowSelectionInterval(i, i);
						departmentTable.scrollRectToVisible(departmentTable.getCellRect(i, 0, true));
						return;
					}
				}

				// If department with the given ID is not found, show error message
				JOptionPane.showMessageDialog(frame, "Không tìm thấy phòng ban với mã " + searchID);
			}
		});
		
		searchEmployeeIDBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Prompt user to enter employee ID to search for
				String searchID = JOptionPane.showInputDialog(frame, "Nhập mã nhân viên cần tìm:");

				// Search for employee with the given ID in employee table model
				for (int i = 0; i < employeeTableModel.getRowCount(); i++) {
					String eID = (String) employeeTableModel.getValueAt(i, 0);
					if (eID.equals(searchID)) {
						// Select row in employee table and scroll to it
						employeeTable.setRowSelectionInterval(i, i);
						employeeTable.scrollRectToVisible(employeeTable.getCellRect(i, 0, true));
						return;
					}
				}

				// If employee with the given ID is not found, show error message
				JOptionPane.showMessageDialog(frame, "Không tìm thấy nhân viên với mã " + searchID);
			}
		});
		
		listAllEmployeeInDepartmentBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Get selected row in department table
				int selectedRow = departmentTable.getSelectedRow();

				// Check if a row is selected
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(frame, "Vui lòng chọn phòng ban để xem danh sách nhân viên");
					return;
				}

				// Get department ID from selected row in department table
				String dID = (String) departmentTableModel.getValueAt(selectedRow, 0);

				// Create a list to store all employees in the selected department
				java.util.List<String> employeeList = new ArrayList<>();

				// Search for employees in the selected department in employee table model
				for (int i = 0; i < employeeTableModel.getRowCount(); i++) {
					String eDID = (String) employeeTableModel.getValueAt(i, 4);
					if (eDID.equals(dID)) {
						String eName = (String) employeeTableModel.getValueAt(i, 1);
						employeeList.add(eName);
					}
				}

				// If there are no employees in the selected department, show message
				if (employeeList.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Phòng ban không có nhân viên nào");
					return;
				}

				// Display a list of all employees in the selected department
				StringBuilder message = new StringBuilder("Danh sách nhân viên trong phòng ban " + dID + ":\n");
				for (String employee : employeeList) {
					message.append("- ").append(employee).append("\n");
				}
				JOptionPane.showMessageDialog(frame, message.toString());
			}
		});
		
		listAllBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Create a StringBuilder to store the message
				StringBuilder message = new StringBuilder();

				// Append all department data to the message
				message.append("Danh sách phòng ban:\n");
				for (int i = 0; i < departmentTableModel.getRowCount(); i++) {
					String dID = (String) departmentTableModel.getValueAt(i, 0);
					String dName = (String) departmentTableModel.getValueAt(i, 1);
					message.append("- Phòng ban ").append(dID).append(": ").append(dName).append("\n");
				}
				message.append("\n");

				// Append all employee data to the message
				message.append("Danh sách nhân viên:\n");
				for (int i = 0; i < employeeTableModel.getRowCount(); i++) {
					String eID = (String) employeeTableModel.getValueAt(i, 0);
					String eName = (String) employeeTableModel.getValueAt(i, 1);
					String eDID = (String) employeeTableModel.getValueAt(i, 4);
					String ePosition = (String) employeeTableModel.getValueAt(i, 5);
					message.append("- Nhân viên ").append(eID).append(": ").append(eName).append(", làm việc tại phòng ban ")
						   .append(eDID).append(", chức vụ ").append(ePosition).append("\n");
				}

				// Show the message in a dialog box
				JOptionPane.showMessageDialog(frame, message.toString());
			}
		});
		
		importDepartmentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					try {
						BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
						String line;
						DefaultTableModel model = (DefaultTableModel) departmentTable.getModel();
						while ((line = reader.readLine()) != null) {
							String[] parts = line.split(",");
							model.addRow(parts);
						}
						reader.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		
		exportDepartmentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					try {
						PrintWriter writer = new PrintWriter(selectedFile);
						for (int i = 0; i < departmentTable.getRowCount(); i++) {
							for (int j = 0; j < departmentTable.getColumnCount(); j++) {
								writer.print(departmentTable.getValueAt(i, j));
								if (j != departmentTable.getColumnCount() - 1) {
									writer.print(",");
								}
							}
							writer.println();
						}
						writer.close();
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		
		importEmployeeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					try {
						BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
						String line;
						DefaultTableModel model = (DefaultTableModel) employeeTable.getModel();
						while ((line = reader.readLine()) != null) {
							String[] parts = line.split(",");
							model.addRow(parts);
						}
						reader.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		
		exportEmployeeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					try {
						PrintWriter writer = new PrintWriter(selectedFile);
						for (int i = 0; i < employeeTable.getRowCount(); i++) {
							for (int j = 0; j < employeeTable.getColumnCount(); j++) {
								writer.print(employeeTable.getValueAt(i, j));
								if (j != employeeTable.getColumnCount() - 1) {
									writer.print(",");
								}
							}
							writer.println();
						}
						writer.close();
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		
	}

    public static void main(String[] args) {
        new EmployeeManagementSystemGUI();
    }
}