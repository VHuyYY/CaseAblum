package MVC.Ablum.View;

import MVC.Ablum.Input.Input;

public class MainMenu {
    songMenu SongMenu = new songMenu();
    albumMenu AlbumMenu = new albumMenu();

    public void showMainMenu() {
        int choice;
        do {
            System.out.println("===== Menu Chính =====");
            System.out.println("1.Quản Lí Album");
            System.out.println("2.Quản Lí Bài Hát");
            System.out.println("0.Thoát");
            System.out.println("Vui Lòng Nhập Lựa Chọn Của Bạn!");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:
                    AlbumMenu.showAlbumMenu();
                    break;
                case 2:
                    SongMenu.showSongMenu();
                    break;
                case 0:
                    System.out.println("Thoát Thành Công!");
                    break;
                default:
                    System.out.println("Không Có Lựa Chọn Nào!");
                    break;
            }
        } while (choice != 0);
    }
}
