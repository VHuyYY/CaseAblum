package MVC.Ablum.View;

import MVC.Ablum.Input.Input;
import MVC.Ablum.Manager.albumManager;
import MVC.Ablum.Manager.songManager;
import MVC.Ablum.Model.Album;
import MVC.Ablum.Model.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static MVC.Ablum.Manager.songManager.*;

public class songMenu {
    private songManager SongManager = new songManager();
    private albumManager AlbumManager = new albumManager();

    Scanner sc = new Scanner(System.in);

    public void showSongMenu() {
        int choice;
        do {
            System.out.println("===== Menu Bài Hát =====");
            System.out.println("1.Thêm Bài Hát");
            System.out.println("2.Sửa Bài Hát");
            System.out.println("3.Xóa Bài Hát");
            System.out.println("4.Xem Tất Cả");
            System.out.println("5.Tìm Kiếm Bài Hát");
            System.out.println("6.Tìm Kiếm Tiêu Đề Album");
            System.out.println("0.Thoát");
            System.out.println("Vui Lòng Nhập Lựa Chọn Của Bạn!");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:
                    showAddMẹnu();
                    break;
                case 2:
                    showEditSongMenu();
                    break;
                case 3:
                    showDeleteMenu();
                    break;
                case 4:
                    showAllMenu();
                    break;
                case 5:
                    showSearchMenu();
                    break;
                case 6:
                    searchTitleMenu();
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


    public void searchTitleMenu() {
        System.out.println("===== Tìm Kiếm Album Theo Tiêu Đề");
        System.out.println("Danh Sách Các Tiêu Đề");
        List<Album> albumList = AlbumManager.getAll();
        for (Album album : albumList) {
            System.out.println("ID " + album.getId() + "Tiêu Đề " + album.getTitle());
        }
        System.out.println("Nhập Tiêu Đề");
        String idGenre = sc.nextLine();
        List<Song> songs = SongManager.searchAlbum(idGenre);
        songs.forEach(System.out::println);
    }

    public void showAddMẹnu() {
        System.out.println("===== Menu Thêm Mới =====");
        System.out.println("Nhập Id Bài Hát");
        int ID = Input.inputNumber();
        String songname;
        do {
            System.out.println("Nhập Tên Bài Hát");
            songname = sc.nextLine();
            if (songname.isEmpty()) {
                System.out.println("Tên Bài Hát Không Được Để Trống.Vui Lòng Nhập Lại!");
            }
        } while (songname.isEmpty());

        String writter;
        do {
            System.out.println("Nhập Tên Tác Giả");
            writter = sc.nextLine();
            if (writter.isEmpty()) {
                System.out.println("Tên tác giả không được để trống vui lòng nhập lại");
            }
        } while (writter.isEmpty());

        System.out.println("Nhập Năm Sáng Tác");
        int year = Input.inputNumber();
        String genre;
        do {
            System.out.println("Nhập Thể Loại Bài Hát");
            genre = sc.nextLine();
            if (genre.isEmpty()) {
                System.out.println("Thể Loại Không Được Để Trống.Vui Lòng Nhập Lại!");
            }
        } while (genre.isEmpty());
        System.out.println("Thêm Thành Công!");
        Song song = new Song(ID, songname, writter, year, genre);
        SongManager.add(song);
    }

    public void showAllMenu() {
        System.out.println("===== Hiển Thị Tất Cả Bài Hát =====");
        List<Song> songs = SongManager.getAll();
        for (Song song : songs) {
            System.out.println(song);
        }
    }


    public void showDeleteMenu() {
        System.out.println("===== Menu Xoá =====");
        System.out.println("Nhập ID Bài Hát Cần Xoá:");
        int idDelete = Input.inputNumber();
        int index = SongManager.findIndexById(idDelete);
        if (index != -1) {
            System.out.println("Bạn có chắc chắn muốn xoá bài hát này không? (Y/N): ");
            String confirm = Input.inputString().toLowerCase();
            if (confirm.equals("y")) {
                SongManager.delete(idDelete);
                System.out.println("Xoá Thành Công!");
            } else {
                System.out.println("Đã Huỷ Xoá Bài Hát!");
            }
        } else {
            System.out.println("Không Tìm Thấy Bài Hát Để Xoá!");
        }
    }

    public void showEditSongMenu() {
        System.out.println("===== Menu Sửa Bài Hát =====");
        System.out.println("Nhập Id Cần Sửa Bài Hát");
        int idEdit = Input.inputNumber();
        int index = SongManager.findIndexById(idEdit);
        if (index == -1) {
            System.out.println("Id Không Tồn Tại!");
            return;
        }

        String songname;
        do {
            System.out.println("Nhập Tên Bài Hát Cần Sửa");
            songname = sc.nextLine();
            if (songname.isEmpty()) {
                System.out.println("Tên Bài Hát Không Được Bỏ Trống.Vui Lòng Nhập Lại!");
            }
        } while (songname.isEmpty());
        String write;
        do {
            System.out.println("Nhập Tên Tác Giả Cần Sửa");
            write = sc.nextLine();
            if (write.isEmpty()) {
                System.out.println("Tên Tác Giả Không Được Bỏ Trống.Vui Lòng Nhập Lại!");
            }
        } while (write.isEmpty());
        System.out.println("Nhập Năm Bài Hát Cần Sửa");
        int year = Input.inputNumber();
        String genre;
        do {
            System.out.println("Nhập Thể Loại Bài Hát");
            genre = sc.nextLine();
            if (genre.isEmpty()) {
                System.out.println("Tên Thể Loại Không Được Bỏ Trống.Vui Lòng Nhâp Lại!");
            }
        } while (genre.isEmpty());
        Song song = new Song(idEdit, songname, write, year, genre);
        SongManager.update(idEdit, song);
        System.out.println("Sửa Bài Hát Thành Công!");
    }

    public void showSearchMenu() {
        int choice;
        do {
            System.out.println("===== Tìm Kiếm Bài Hát =====");
            System.out.println("1.Tìm Kiếm Bài Hát Theo Tên");
            System.out.println("2.Tìm Kiếm Bài Hát Theo Thể Loại");
            System.out.println("0.Thoát");
            System.out.println("Nhập Sự Lựa Chọn Của Bạn");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:
                    showSearchName();
                    break;
                case 2:
                    showSearchGenre();
                    break;
                case 0:
                    System.out.println("Thoát Thành Công!");
                    break;
                default:
                    System.out.println("Không Có Lựa Chọn Nào!");
            }
        } while (choice != 0);
    }

    public void showSearchName() {
        System.out.println("===== Tìm Kiếm Theo Tên Bài Hát =====");
        System.out.println("Nhập Tên Bài Hát Cần Tìm Kiếm");
        String songName = sc.nextLine();
        List<Song> songArrayList = SongManager.searchName(songName);
        for (int i = 0; i < songArrayList.size(); i++) {
            System.out.println(songArrayList.get(i).toString());
        }
    }

    public void showSearchGenre() {
        System.out.println("===== Tìm Kiếm Thể Loại Bài Hát =====");
        System.out.println("Nhập Thể Loại Bài Hát Cần Tìm Kiếm");
        String genre = sc.nextLine();
        List<Song> songArrayList = SongManager.searchGenre(genre);
        for (int i = 0; i < songArrayList.size(); i++) {
            System.out.println(songArrayList.get(i).toString());
        }
    }
}
