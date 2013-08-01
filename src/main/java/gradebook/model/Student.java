package gradebook.model;

/**
 * A student is a person taking a particular class and can receive
 * grades for GradebookItems.
 *
 * @author Nirvan Nagar
 *
 */
public class Student {

    private String fullName;
    private GradingScheme gradingScheme;
    private GradebookItems grades;

    public Student(String fullName) {
       this(fullName, new GradingScheme(90, 80, 70, 60, 0));
    }

    public Student(String fullName, GradingScheme gradingScheme) {
        this.fullName = fullName;
        this.gradingScheme = gradingScheme;
        grades = new GradebookItems();
    }

    public void addGrade(GradebookItem grade) {
        grades.addGrade(grade);
    }

    public void deleteGrade(GradebookItem grade) {
        grades.deleteGrade(grade);
    }

    public int calculateAVG() {

       int numericalGrade = gradingScheme.calculateNumericalGrade(grades);

       return numericalGrade;
    }

    public char calculateLetterGrade() {

        char letterGrade = 0;
        int numericalGrade = 0;

        if (grades.isEmpty()) {
            letterGrade = 'F';
        } else {
            numericalGrade = gradingScheme.calculateNumericalGrade(grades);
            letterGrade = gradingScheme.calculateLetterGrade(numericalGrade);
        }

        return letterGrade;
    }

    public char calculateLetterGrade(int grade) {

        char letterGrade = gradingScheme.calculateLetterGrade(grade);

        return letterGrade;
    }

    public String getName() {
        return fullName;
    }

}
