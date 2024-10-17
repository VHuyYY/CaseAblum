package MVC.Ablum.Manager;

import MVC.Ablum.Login.Account;
import MVC.Ablum.SavaData.ReadAndWriteUserAccount;

import java.util.List;

public class UserAccountManager {
    private List<Account> userAccounts;
    private ReadAndWriteUserAccount readAndWriteUserAccount = new ReadAndWriteUserAccount();
    public UserAccountManager() {
        this.userAccounts = readAndWriteUserAccount.readData();
    }
    private Account findUserByName(String username) {
        for (Account userAccount : userAccounts) {
            if (userAccount.getUsername().equals(username)) {
                return userAccount;
            }
        }
        return null;
    }
    public void registerUser(Account userAccount) {
        if (findUserByName(userAccount.getUsername()) == null) {
            userAccounts.add(userAccount);
            readAndWriteUserAccount.writeData(userAccounts);
            System.out.println("Đăng Ký Thành Công!");
        }else {
            System.out.println("Tên Đăng Nhập Đã Tồn Tại!");
        }
    }
    public Account loginUser(String username, String password) {
        for (Account userAccount : userAccounts) {
            if (userAccount.getUsername().equals(username) && userAccount.getPassword().equals(password)) {
                System.out.println("Đăng Nhập Thành Công!");
                return userAccount;
            }
        }
        System.out.println("Tên Đăng Nhập Hoặc Mật Khẩu Không Đúng!");
        return null;
    }
    public void DeleteUser(String username) {
        Account userAccount = findUserByName(username);
        if (userAccount != null) {
            userAccounts.remove(userAccount);
            readAndWriteUserAccount.writeData(userAccounts);
            System.out.println("Xoá Tài Khoản Thành Công!");
        }else {
            System.out.println("Tài Khoản Không Tồn Tại");
        }
    }
}
