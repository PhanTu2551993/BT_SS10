package ra.business.implement;

import ra.business.config.InputMethods;
import ra.business.design.CRUD;
import ra.business.entity.Employee;

import java.util.Scanner;

public class EmployeeImplement implements CRUD {
    private static Employee[] employees = new Employee[100];
    private int size = 0;
    @Override
    public void create() {
        if (size == 100){
            System.err.println("mảng đầy");
        }else {
            // logic thêm mới
            // ta 1 đối tượng student
            Employee newEmplyee = new Employee();
            newEmplyee.inputData();
            // thêm vào mang
            employees[size] = newEmplyee;
            size++; // tăng số lương
        }
    }

    @Override
    public void display() {
        if (size == 0){
            System.err.println("Danh sách nhân viên trống");
        }else {
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i]);
            }
        }
    }

    @Override
    public void showInfo() {
        if (size == 0){
            System.err.println("Danh sách nhân viên trống");
        }else {
            System.out.println("Nhâp mã nhân viên cần tìm");
            int inputID = Integer.parseInt(new Scanner(System.in).nextLine());
            boolean check = false;
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId() == inputID){
                    check = true;
                    employees[i].displayData();
                }
            }
            if (!check){
                System.out.println("Không có mã nhân viên cần tìm");
            }
        }
    }

    @Override
    public void search() {
        System.out.println("Nhập tên nhân viên muốn tìm");
        String inputName = new Scanner(System.in).nextLine();
        boolean check = false;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeName().contains(inputName)){
                employees[i].displayData();
                check=true;
            }
        }
        if (!check){
            System.out.println("Không có mã nhân viên cần tìm");
        }
    }

    @Override
    public void sortAZ() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (employees[i].getEmployeeName().compareTo(employees[j].getEmployeeName()) < 0 ){
                    Employee temp = employees[i];
                    employees[i]=employees[j];
                    employees[j]=temp;
                }
            }
        }
        System.out.println("Danh sách bai hát sau khi sắp xếp theo tên");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    @Override
    public void edit() {
        if (size == 0){
            System.err.println("Danh sách nhân viên trống");
        }else {
            System.out.println("Nhâp mã nhân viên muốn cập nhật");
            int inputID = Integer.parseInt(new Scanner(System.in).nextLine());
            boolean check = false;
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId() == inputID){
                    check = true;
                    employees[i].displayData();
                }
            }
            if (!check){
                System.out.println("Không có mã nhân viên cần tìm");
            }
        }
    }


    @Override
    public void delete() {
        System.out.println("Nhập mã nhân viên muốn xóa");
        byte deleteID = InputMethods.getByte();
        boolean check = false;
        for (int i = 0; i < size; i++) {
            if (employees[i] != null && employees[i].getEmployeeId() == deleteID) {
                check = true;
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                size--;
                System.out.println("Đã xóa nhân viên có ID: " + deleteID);
                break;
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy nhân viên có ID: " + deleteID);
        }

    }

}
