package Staff.Validate;

import Staff.Input.Input;

public class Regexname {
    public static String validateName() {
        String regex = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯàáâãèéêệìíòóôõùúăđĩũữơưỲỴÝỶỹ]+( [A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯàáâãèệêìíòóôõùúăđĩũữơưỲỴÝỶỹ]+)*$";
        do {

            //System.out.print("Nhập Tên Nhân Viên: ");
            String name = Input.inputstring();
            if (name.matches(regex)) {
                return name;
            } else {
                System.out.println("Tên sai định dạng! Yêu cầu nhập lại.");
            }
        } while (true);
    }

}
