package Staff.Manager;

import Staff.Model.Student;
import Staff.SaveData.ReadWriteStudent;

import java.util.List;

public class StudentManager implements Imanager<Student> {
    List<Student> studentList;
    ReadWriteStudent readWriteStudent = new ReadWriteStudent();

    public StudentManager() {
        this.studentList = this.readWriteStudent.readDirectoryFromFile();
    }

    @Override
    public void add(Student student) {
        studentList.add(student);
        readWriteStudent.writetoFileDirectory(studentList,true);
    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        studentList.remove(index);
        readWriteStudent.writetoFileDirectory(studentList,false);
    }

    @Override
    public void update(int id, Student student) {
        int index = findIndexById(id);
        studentList.set(index, student);
        readWriteStudent.writetoFileDirectory(studentList,false);
    }

    @Override
    public List<Student> getAll() {
        this.studentList = this.readWriteStudent.readDirectoryFromFile();
        return this.studentList;
    }
    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < this.studentList.size(); i++) {
            if (this.studentList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
    // private List<Student> students;
}
