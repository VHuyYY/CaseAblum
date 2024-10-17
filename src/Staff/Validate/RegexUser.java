package Staff.Validate;

import Staff.Input.Input;

public class RegexUser {
    public static String validateUserName() {
        String regex = "^[a-zA-Z0-9]{4,16}$";
        do {
            System.out.print("Nhập tên tài khoản: ");
            String username = Input.inputstring();
            if (username.matches(regex)) {
                return username;
            } else {
                System.out.println("Tên tài khoản sai định dạng! Yêu cầu từ 4 đến 16 ký tự, chỉ bao gồm chữ và số.");
            }
        } while (true);
    }

    public static String validatePassword() {
        String regex = "^[a-zA-Z0-9@#$%^&+=]{4,16}$";
        do {
            System.out.print("Nhập mật khẩu: ");
            String password = Input.inputstring();
            if (password.matches(regex)) {
                return password;
            } else {
                System.out.println("Mật khẩu sai định dạng! Yêu cầu từ 4 đến 16 ký tự, bao gồm chữ, số và ký tự đặc biệt.");
            }
        } while (true);
    }
}