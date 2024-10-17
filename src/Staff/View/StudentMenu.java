package Staff.View;

import Staff.Validate.Regexname;
import Staff.Input.Input;
import Staff.Manager.StudentManager;
import Staff.Model.Student;
import Staff.Validate.RegexPhone;

import java.util.List;
import java.util.Scanner;

public class StudentMenu {
    private StudentManager studentManager = new StudentManager();
    Scanner scanner = new Scanner(System.in);

    public void showStudentMenu() {
        int choice;
        do {
            System.out.println("===== Quản Lý Phân Loại =====");
            System.out.println("1.Thêm Mới Nhân Viên");
            System.out.println("2.Sửa Thông Tin Nhân Viên");
            System.out.println("3.Xóa Thông Tin Nhân Viên");
            System.out.println("4.Hiển Thị Thông Tin Nhân Viên");
            System.out.println("5.Kiểm Tra Từng Loại Nhân Viên");
            System.out.println("6.Thay đổi trạng thái của nhân viên");
            System.out.println("0.Thoát Chương Trình");
            System.out.println("Vui Lòng Nhập Lựa Chọn!");
            choice = Input.inputnumber();
            switch (choice) {
                case 1:
                    showAddStudentMenu();
                    break;
                case 2:
                    break;
                case 3:
                    showDeleteStudentMenu();
                    break;
                case 4:
                    showAllStudentMenu();
                    break;
                case 5:
                    showStudentStatus();
                    break;
                case 6:
                    showEditStatus();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Không có lựa chọn!");
                    return;
            }
        } while (choice != 0);
    }

    public void showAddStudentMenu() {
        System.out.println("===== Thêm Nhân Viên Mới =====");
        System.out.println("Nhập id nhân viên");
        int id = Input.inputnumber();
        System.out.println("Nhập Tên Nhân Viên");
        String name = Regexname.validateName();
        System.out.println("Nhập Tuổi Nhân Viên");
        int age = Input.inputnumber();
        System.out.println("Nhập Giới Tính Nhân Viên");
        String gender = Regexname.validateName();
        System.out.println("Nhập Địa Chi Nhân Viên");
        String address = scanner.nextLine();
        System.out.println("Nhập Số Điện Thoại Nhân Viên");
        String phone = RegexPhone.validatePhone();
        System.out.println("Nhập Lương Mong Muốn");
        int salary = Input.inputnumber();
        System.out.println("Nhập Trạng Thái Nhân Viên");
        String status = Regexname.validateName();
        System.out.println("Nhập Phân Loại Nhân Viên");
        String classify = Regexname.validateName();
        Student student = new Student(id, name, age, gender, address, phone, salary, status, classify);
        studentManager.add(student);
        System.out.println("Thêm Thành Công!");
    }

    public void showDeleteStudentMenu() {
        System.out.println("===== Menu Xóa =====");
        System.out.print("Nhập mã sinh viên muốn xóa: ");
        int idDelete = Input.inputnumber();
        int index = studentManager.findIndexById(idDelete);
        if (index != -1) {
            studentManager.delete(idDelete);
            System.out.println("Xóa sinh viên thành công ");
        } else {
            System.out.println("Không tìm thấy mã sinh viên! ");
        }
    }

    public void showStudentStatus() {
        int choice;
        System.out.println("===== Kiểm Tra Phân Loại Của Nhân Viên =====");
        System.out.println("1.Nhân Viên Full Time");
        System.out.println("2.Nhân Viên Part Time");
        System.out.println("0.Thoát");
        System.out.println("Vui Lòng Nhập Lựa Chọn!");
        choice = Input.inputnumber();
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 0:
                break;
            default:
                System.out.printf("Không Có Lựa Chọn Nào!");
        }
        showAllStudentMenu();
    }

    public void showAllStudentMenu() {
        System.out.println("===== Danh sách Nhân Viên =====");
        List<Student> students = studentManager.getAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }
    public void showEditStatus(){
        System.out.println("===== Thay Đổi Trạng Thái Của Nhân Viên =====");
        System.out.println("Nhập Id Của Nhân Viên");
        int id = Input.inputnumber();
        System.out.println("Nhập Trạng Thái Của Nhân Viên Muốn Thay Đổi");
        String status = Regexname.validateName();
        showAllStudentMenu();
    }
}
