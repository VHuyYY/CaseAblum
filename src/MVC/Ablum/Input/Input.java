package MVC.Ablum.Input;

import java.util.Scanner;

public class Input {
    private static Scanner input = new Scanner(System.in);

    public static int inputNumber() {
        do {
            try {
                String dataInput = input.nextLine();
                int number = Integer.parseInt(dataInput);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Định Dạng Không Hợp Lệ! Vui Lòng Nhập Lại Số");
            }
        } while (true);
    }

    public static String inputString() {
        String dataInput = input.nextLine();
        return dataInput;
    }
}
