package gradebook.model;

/**
 * A ClassSection is a section of a class with a list of students
 * enrolled in a particular class.
 *
 * @author Nirvan Nagar
 *
 */
public class ClassSection {

    private Students students;

    public ClassSection(Students students) {
        this.students = students;
    }

    public int calculateSectionAVG() {

        int sectionTotal = 0;
        int sectionAVG = 0;

        for (int i = 0; i < students.numStudents(); i++) {
            Student student = students.getStudentAt(i);
            sectionTotal += student.calculateAVG();
        }

        sectionAVG = (sectionTotal / students.numStudents());

        return sectionAVG;
    }

    public int getNumStudents() {
        return students.numStudents();
    }

    public Students getStudents() {
        return students;
    }

}
