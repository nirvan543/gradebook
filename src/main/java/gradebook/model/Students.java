package gradebook.model;

import java.util.ArrayList;
/**
 * Students has the sole purpose of storing Student objects.
 *
 * @author Nirvan Nagar
 *
 */
public class Students {

    private ArrayList<Student> students;

    public Students() {
        students = new ArrayList<Student>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public Student getStudentAt(int index) {
        return students.get(index);
    }

    public int numStudents() {
        return students.size();
    }

}
