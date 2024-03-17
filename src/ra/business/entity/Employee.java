package ra.business.entity;

import ra.business.config.InputMethods;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    public static int nextId = 0;
    public  int employeeId;
    private String employeeName;
    private Date bod;
    private String phone;
    private String address;
    private double salary;
    private double kpi;

    public Employee() {
        // id tự tăng
        this.employeeId = ++nextId;
    }

    public Employee(int employeeId, String employeeName, Date bod, String phone, String address, double salary, double kpi) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.bod = bod;
        this.phone = phone;
        this.address = address;
        this.salary = salary;
        this.kpi = kpi;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getBod() {
        return bod;
    }

    public void setBod(Date bod) {
        this.bod = bod;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getKpi() {
        return kpi;
    }

    public void setKpi(double kpi) {
        this.kpi = kpi;
    }

    public void  inputData(){
        // nhap ten
        System.out.println("Nhâp thông tin nhân viên thứ "+nextId);
        System.out.println("Nhập mã nhân viên");
        this.employeeId = Integer.parseInt(InputMethods.getString());
        System.out.println("Nhập tên nhân viên");
        this.employeeName = InputMethods.getString();
        System.out.println("Nhập ngày sinh nhân viên");
        this.bod = InputMethods.getDate();
        System.out.println("Nhập địa chỉ nhân viên");
        this.address = InputMethods.getString();
        System.out.println("Nhập sđt nhân viên");
        this.phone = InputMethods.getString();
        System.out.println("Nhập lương cơ bản nhân viên");
        this.salary = InputMethods.getDouble();
        System.out.println("Nhập KPI nhân viên");
        this.kpi = InputMethods.getDouble();
    }
    public void displayData(){
        System.out.println(toString());
    }
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", bod=" + bod +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", kpi=" + kpi +
                '}';
    }
}
