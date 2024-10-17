package MVC.Ablum.View;

import MVC.Ablum.Manager.albumManager;
import Staff.Input.Input;

import java.util.Scanner;

public class albumMenu {
    private albumManager AlbumManager = new albumManager();
    Scanner sc = new Scanner(System.in);

    public void showAlbumMenu() {
        int choice;
        do {
            System.out.println("===== Menu Album Bài Hát =====");
            System.out.println("1.Thêm Mới Album");
            System.out.println("2.Sửa Album");
            System.out.println("3.Xoá Album");
            System.out.println("5.Xem Tất Cả Album");
            System.out.println("6.Tìm Kiếm Album");
            System.out.println("0.Thoát");
            choice = Input.inputnumber();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    System.out.println("Thoát Thành Công!");
                    break;
                default:
                    System.out.println("Vui Lòng Nhập Lựa Chọn Của Bạn!");
            }
        } while (choice != 0);
    }
}
