import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StaffSalaryManagerGUI extends JFrame implements ActionListener {
    private static final String FILENAME = "staff_salary.txt";
    private static List<StaffSalary> staffSalaryList = new ArrayList<>();
    private static DefaultTableModel tableModel;
    private static JTable table;

    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel salaryLabel;
    private JTextField salaryTextField;

    public StaffSalaryManagerGUI() {
    setTitle("Staff Salary Manager");
    setSize(600, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    loadFromFile();

    tableModel = new DefaultTableModel(new String[]{"Name", "Salary"}, 0);
    table = new JTable(tableModel);
    JScrollPane scrollPane = new JScrollPane(table);

    nameLabel = new JLabel("Name:");
    nameTextField = new JTextField();
    salaryLabel = new JLabel("Salary:");
    salaryTextField = new JTextField();

    JButton addButton = new JButton("Add");
    addButton.addActionListener(this);

    JButton editButton = new JButton("Edit");
    editButton.addActionListener(this);

    JButton deleteButton = new JButton("Delete");
    deleteButton.addActionListener(this);

    JButton sortButton = new JButton("Sort by Salary");
    sortButton.addActionListener(this);

    JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
    inputPanel.add(nameLabel);
    inputPanel.add(nameTextField);
    inputPanel.add(salaryLabel);
    inputPanel.add(salaryTextField);

    JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
    buttonPanel.add(addButton);
    buttonPanel.add(editButton);
    buttonPanel.add(deleteButton);
    buttonPanel.add(sortButton);
    buttonPanel.setPreferredSize(new Dimension(0, 50)); // Set a preferred size for the button panel

    JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
    mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    mainPanel.add(inputPanel, BorderLayout.NORTH);
    mainPanel.add(buttonPanel, BorderLayout.CENTER);
    mainPanel.add(scrollPane, BorderLayout.SOUTH);

    setContentPane(mainPanel);

    setVisible(true);
}

    public static void main(String[] args) {
        new StaffSalaryManagerGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Add")) {
            String name = nameTextField.getText().trim();
            String salaryStr = salaryTextField.getText().trim();
            if (!name.isEmpty() && !salaryStr.isEmpty()) {
                double salary = Double.parseDouble(salaryStr);
                StaffSalary staffSalary = new StaffSalary(name, salary);
                staffSalaryList.add(staffSalary);
                tableModel.addRow(new Object[]{staffSalary.getName(), staffSalary.getSalary()});
                nameTextField.setText("");
                salaryTextField.setText("");
            }
        } else if (action.equals("Edit")) {
            int selectedIndex = table.getSelectedRow();
            if (selectedIndex >= 0) {
                StaffSalary selectedStaffSalary = staffSalaryList.get(selectedIndex);
                String name = selectedStaffSalary.getName();
                double salary = selectedStaffSalary.getSalary();
                String newName = JOptionPane.showInputDialog(this, "Enter new name:", name);
                String newSalaryStr = JOptionPane.showInputDialog(this, "Enter new salary:", salary);
                if (newName != null && newSalaryStr != null && !newName.trim().isEmpty() && !newSalaryStr.trim().isEmpty()) {
                    double newSalary = Double.parseDouble(newSalaryStr);
                    selectedStaffSalary.setName(newName.trim());
                    selectedStaffSalary.setSalary(newSalary);
                    tableModel.setValueAt(newName.trim(), selectedIndex, 0);
                    tableModel.setValueAt(newSalary, selectedIndex, 1);
                }
            }
        } else if (action.equals("Delete")) {
            int selectedIndex = table.getSelectedRow();
            if (selectedIndex >= 0) {
                staffSalaryList.remove(selectedIndex);
                tableModel.removeRow(selectedIndex);
            }
        } else if (action.equals("Sort by Salary")) {
            Collections.sort(staffSalaryList, Comparator.comparingDouble(StaffSalary::getSalary));
            tableModel.setRowCount(0);
            for(StaffSalary staffSalary : staffSalaryList) {
                tableModel.addRow(new Object[]{staffSalary.getName(), staffSalary.getSalary()});
            }
        }
        saveToFile();
    }

    private void loadFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader("staff_salary.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                String name = parts[0].trim();
                double salary = Double.parseDouble(parts[1].trim());
                StaffSalary staffSalary = new StaffSalary(name, salary);
                staffSalaryList.add(staffSalary);
                tableModel.addRow(new Object[]{staffSalary.getName(), staffSalary.getSalary()});
            }
        }
    } catch (FileNotFoundException e) {
        try {
            FileWriter writer = new FileWriter("staff_salary.txt");
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (StaffSalary staffSalary : staffSalaryList) {
                writer.write(staffSalary.getName() + "," + staffSalary.getSalary() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}