package Staff.Validate;

import Staff.Input.Input;

public class RegexPhone {
    public static String validatePhone() {
        String phone = "";
        String regex = "^[+]{0}[0-9]{10}$";
        do {

            String phoneNumber = Input.inputstring();
            if (phoneNumber.matches(regex)) {
                return phoneNumber;
            } else {
                System.out.println("Phone Sai Định Dạng! Yêu Cầu Từ 0 đến 10 số!");
            }
        } while (true);
    }
}
