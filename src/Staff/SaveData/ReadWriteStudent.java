package Staff.SaveData;

import Staff.Model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteStudent {
    private File file = new File("database/students.csv");


    public void writetoFileDirectory(List<Student> studentList, boolean append) {
        try (FileWriter fw = new FileWriter(this.file, append);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (Student student : studentList) {
                bw.write(student.getId() + "," + student.getName() + "," + student.getAge() + ","
                        + student.getGender() + "," + student.getAddress() + "," + student.getPhone() + "," + student.getSalary() + ","
                        + student.getStatus() + "," + student.getClassify());
                bw.newLine();
            }
            System.out.println("Ghi danh sách danh bạ thành công");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
//    private File file = new File("database/students.csv");
//
//    public void WriterStudent(List<Student> students) {
//        try {
//            for (Student student : students) {
//                data += student.getId() + "," + student.getName() + "," + student.getAge() + "," + student.getGender() + "," + student.getGender() + "," + student.getPhone() + "," + student.getSalary() + "," + student.getStatus() + "," + student.getClassify() + "\n";
//            }
//            FileWriter fileWriter = new FileWriter(file);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write(data);
//            bufferedWriter.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

    //        public List<Student> ReaderStudent() {
//        List<Student> studentList = new ArrayList<Student>();
//        try {
//            FileReader fileReader = new FileReader(this.file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] data = line.split(",");
//                int id = Integer.parseInt(data[0]);
//                String name = data[1];
//                int age = Integer.parseInt(data[2]);
//                String gender = data[3];
//                String address = data[4];
//                String phone = data[5];
//                double salary = Double.parseDouble(data[6]);
//                String status = data[7];
//                String classify = data[8];
//                Student student = new Student(id, name, age, gender, address, phone, salary, status, classify);
//                studentList.add(student);
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//        return studentList;
//    }
    public List<Student> readDirectoryFromFile() {
        List<Student> studentList = new ArrayList<>();
        try (FileReader fr = new FileReader(this.file);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] directoryDetails = line.split(",");
                int id = Integer.parseInt(directoryDetails[0]);
                String name = directoryDetails[1];
                int age = Integer.parseInt(directoryDetails[2]);
                String gender = directoryDetails[3];
                String address = directoryDetails[4];
                String phone = directoryDetails[5];
                double salary = Double.parseDouble(directoryDetails[6]);
                String status = directoryDetails[7];
                String classify = directoryDetails[8];
                Student student = new Student(id, name, age, gender, address, phone, salary, status, classify);
                studentList.add(student);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return studentList;
    }
}
