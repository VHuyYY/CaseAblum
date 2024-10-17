package MVC.Ablum.Validate;


import MVC.Ablum.Input.Input;

public class RegexUser {

    public static String validateUser() {
        String regex = "^[a-zA-Z0-9]{3,16}$";
        do {
            System.out.println("Nhập Tên Tài Khoản");
            String username = Input.inputString();
            if (username.matches(regex)) {
                return username;
            } else {
                System.out.println("Tên Tài Khoản Sai Định Dạng.Yêu Cầu Từ 3 Đến 16 Ký Tự,Chỉ Bao Gồm Chữ Và Số!");
            }
        } while (true);
    }

    public static String validatePassword() {
        String regex = "^[a-zA-Z0-9]{3,16}$";
        do {
            System.out.println("Nhập Mật Khẩu");
            String password = Input.inputString();
            if (password.matches(regex)) {
                return password;
            } else {
                System.out.println("Tên Mật Khẩu Sai Định Dạng.Yêu Cầu Từ 3 Đến 16 Ký Tự,Chỉ Bao Gồm Chữ Và Số!");
            }
        } while (true);
    }
}
