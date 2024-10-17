package MVC.Ablum.SavaData;

import MVC.Ablum.Login.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteUserAccount {
    private File file = new File("C:\\Module_2\\CaseStudy\\src\\MVC\\Ablum\\Database\\Account.csv");

    public void writeData(List<Account> accountList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            StringBuilder data = new StringBuilder();
            for (Account account : accountList) {
                data.append(account.getUsername()).append(",").append(account.getPassword()).append("\n");
            }
            bufferedWriter.write(data.toString());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public List<Account> readData() {
        List<Account> users = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("File Không tồn tại, tạo mới file.");
            return users;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String username = data[0];
                    String password = data[1];
                    Account account = new Account(username, password);
                    users.add(account);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return users;
    }
}
