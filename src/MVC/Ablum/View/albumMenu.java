package MVC.Ablum.View;

import MVC.Ablum.Manager.albumManager;
import MVC.Ablum.Model.Album;
import Staff.Input.Input;

import java.util.List;
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
            System.out.println("4.Xem Tất Cả Album");
            System.out.println("0.Thoát");
            choice = Input.inputnumber();
            switch (choice) {
                case 1:
                    showAddMenu();
                    break;
                case 2:
                    showEditMenu();
                    break;
                case 3:
                    showDeleteMenu();
                    break;
                case 4:
                    showAllAlbumMenu();
                    break;
                case 0:
                    System.out.println("Thoát Thành Công!");
                    break;
                default:
                    System.out.println("Vui Lòng Nhập Lựa Chọn Của Bạn!");
            }
        } while (choice != 0);
    }

    public void showAddMenu() {
        System.out.println("===== Menu Thêm Mới Album =====");
        System.out.println("Nhập Id Album ");
        int id = Input.inputnumber();
        String title;
        do {
            System.out.println("Nhập Tiêu Đề Của Album");
            title = sc.nextLine();
            if (title.isEmpty()) {
                System.out.println("Tiêu Đề Không Được Bỏ Trống.Vui Lòng Nhập Lại!");
            }
        } while (title.isEmpty());
        Album album = new Album(id, title);
        AlbumManager.add(album);
        System.out.println("Thêm Thành Công!");
    }

    public void showAllAlbumMenu() {
        System.out.println("===== Xem Tất Cả Album =====");
        List<Album> albums = AlbumManager.getAll();
        for (Album album : albums) {
            System.out.println(album);
        }
    }

    public void showDeleteMenu() {
        System.out.println("===== Menu Xoá =====");
        System.out.println("Nhập Id Album Muốn Xoá");
        int idDelete = Input.inputnumber();
        int index = AlbumManager.findIndexById(idDelete);
        if (index != -1) {
            System.out.println("Bạn có chắc chắn xoá Ablum này không? (Y/N):");
            String confirm = Input.inputstring().toLowerCase();
            if (confirm.equals("y")) {
                AlbumManager.delete(idDelete);
                System.out.println("Xoá Thành Công!");
            } else {
                System.out.println("Đã Huỷ Xoá Album");
            }
        } else {
            System.out.println("Không Tìm Thấy Album Để Xoá!");

        }
    }

    public void showEditMenu() {
        System.out.println("===== Menu Sửa Album =====");
        System.out.println("Nhập ID Muốn Sửa");
        int idEdit = Input.inputnumber();
        int index = AlbumManager.findIndexById(idEdit);
        if (index == -1) {
            System.out.println("ID Không Tồn Tại!");
            return;
        }
        String title;
        do {
            System.out.println("Nhập Tiêu Đề Muốn Sửa");
            title = sc.nextLine();
            if (title.isEmpty()) {
                System.out.println("Tiêu Đề Không Được Bỏ Trống.Vui Lòng Nhập Lại!");
            }
        } while (title.isEmpty());
        Album album = new Album(idEdit, title);
        AlbumManager.update(idEdit, album);
        System.out.println("Sửa Thành Công!");
    }


}
