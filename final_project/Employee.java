import java.io.*;
import java.util.*;

public class Employee {
    private String employeeID;
    private String name;
    private String phoneNumber;
    private String email;
    private String employeeDepartmentID;
    private String jobPosition;
    private double salary;
    private double allowance;
    private double bonus;
    private double penalty;

    public Employee(String employeeID, String name, String phoneNumber, String email,
                    String employeeDepartmentID, String jobPosition, double allowance, double bonus, double penalty) {
        this.employeeID = employeeID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.employeeDepartmentID = employeeDepartmentID;
        this.jobPosition = jobPosition;
        this.salary = salary;
        this.allowance = allowance;
        this.bonus = bonus;
        this.penalty = penalty;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeDepartmentID() {
        return employeeDepartmentID;
    }

    public void setEmployeeDepartmentID(String employeeDepartmentID) {
        this.employeeDepartmentID = employeeDepartmentID;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
        //this.salary = jobPosition.getSalary();
    }

    public double getSalary() {
		return this.salary = calSalary(jobPosition);
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public double getTotalSalary() {
        return this.salary + this.allowance + this.bonus - this.penalty;
    }
	
	public double calSalary(String jobPosition) {
		if (jobPosition == "ThucTap") {
			salary = 0;
		}
		if (jobPosition == "Sale") {
			salary = 6000000;
		}
		if (jobPosition == "VanHanh") {
			salary = 8000000;
		}
		if (jobPosition == "KyThuat") {
			salary = 10000000;
		}
		if (jobPosition == "BaoVe") {
			salary = 5000000;
		}
		
		return salary;
	}
}