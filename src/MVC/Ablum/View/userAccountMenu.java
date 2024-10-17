package MVC.Ablum.View;


import MVC.Ablum.Input.Input;
import MVC.Ablum.Login.Account;
import MVC.Ablum.Manager.UserAccountManager;
import MVC.Ablum.Validate.RegexUser;

public class userAccountMenu {
    private UserAccountManager userAccountManager = new UserAccountManager();
    private Account loggedInUser;

    public void displayMenu() {
        int choice;
        do {
            System.out.println("===== Trang Chủ =====");
            System.out.println("1.Đăng Nhập");
            System.out.println("2.Đăng Ký");
            System.out.println("3.Xoá Tài Khoản");
            System.out.println("0.Thoát");
            System.out.println("Vui Lòng Nhập Lựa Chọn Của Bạn!");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:
                    loginAccount();
                    break;
                case 2:
                    registerAccount();
                    break;
                case 3:
                    DeleteUser();
                    break;
                case 0:
                    System.out.println("Thoát Thành Công");
                    break;
                default:
                    System.out.println("Không Có Sự Lựa Chọn Nào!");
            }
        } while (choice != 0);
    }

    private void registerAccount() {
        System.out.println("===== Đăng Ký Tài Khoản =====");
        String username = RegexUser.validateUser();
        String password = RegexUser.validatePassword();
        Account account = new Account(username, password);
        userAccountManager.registerUser(account);
    }

    private void loginAccount() {
        System.out.println("===== Đăng Nhập Tài Khoản =====");
        String usernam = RegexUser.validateUser();
        String password = RegexUser.validatePassword();
        loggedInUser = userAccountManager.loginUser(usernam, password);
        if (loggedInUser != null) {
            navigateToMainMenu();
        }else {
            System.out.println("Đăng Nhập Không Thành Công.Vui Lòng Thử Lại!");
        }
    }
    private void DeleteUser(){
        if (loggedInUser != null) {
            userAccountManager.DeleteUser(loggedInUser.getUsername());
            loggedInUser = null;
        }else {
            System.out.println("Bạn Chưa Đăng Nhập");
        }
    }
    public boolean isUserLoggedIn(){
        return loggedInUser != null;
    }
    private void navigateToMainMenu() {
        MainMenu menu = new MainMenu();
        menu.showMainMenu();
    }
}

