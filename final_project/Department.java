import java.io.*;
import java.util.*;

public class Department {
    private String departmentID;
    private String departmentName;
    private int numberOfEmployees;

    public Department(String departmentID, String departmentName, int numberOfEmployees) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
}