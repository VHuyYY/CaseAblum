package Staff.View;

import Staff.Input.Input;

public class MainMenu {
    //ClazzMenu clazzMenu = new ClazzMenu();
    StudentMenu studentMenu = new StudentMenu();


    public void showMainMenu() {
        int choice;
        do {
            System.out.println("===== Menu Chính =====");
            //System.out.println("1. Quản Lí Trạng Thái Nhân Viên");
            System.out.println("1. Quản Lí Nhân Viên");
            System.out.println("0. Thoát");
            System.out.println("Chọn Một Lựa Chọn Của Bạn!");
            choice = Input.inputnumber();
            switch (choice) {
                case 1:
                    studentMenu.showStudentMenu();
                    //clazzMenu.showClazzMenu();
                    break;
                case 2:
                    //studentMenu.showStudentMenu();
                    break;
                case 0:
                    System.out.printf("Thoát Chương Trình\n");
                    break;
                default:
                    System.out.println("Lựa Chọn Không Hợp Lệ!");
                    break;
            }
        } while (choice != 0);
    }
}


