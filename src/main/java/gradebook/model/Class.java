package gradebook.model;

/**
 * The Class method is an offering of a particular course
 * in a particular semester.
 *
 *
 * @author Nirvan Nagar
 * @version 1.0
 *
 */
public class Class {

    private String semester;
    private ClassSections classSections;

    public Class(Course course, String semester, ClassSections classSections) {
        this.semester = semester;
        this.classSections = classSections;
    }

    public int calculateCourseAVG() {

        int semesterCourseTotal = 0;
        int semesterCourseAVG = 0;

        for (int i = 0; i < classSections.getNumSections(); i++) {
            ClassSection section = classSections.getClassAt(i);
            semesterCourseTotal += section.calculateSectionAVG();
        }

        int numSections = classSections.getNumSections();
        semesterCourseAVG = semesterCourseTotal / numSections;

        return semesterCourseAVG;
    }

    public int getNumSections() {
        return classSections.getNumSections();
    }

    public int getTotalStudents() {

        int numStudents = 0;

        for (int i = 0; i < classSections.getNumSections(); i++) {
            ClassSection section = classSections.getClassAt(i);
            numStudents += section.getNumStudents();
        }

        return numStudents;
    }

    public void addSection(ClassSection section) {
        classSections.addSection(section);
    }

    public void deleteSection(ClassSection section) {
        classSections.deleteSection(section);
    }

    public String getSemester() {
        return semester;
    }

}
