package gradebook.model;

import java.util.LinkedList;

/**
 * A GradingScheme is an algorithm for computing the "average" score and
 * letter grade for a particular student in a particular section of a
 * particular class based on the student's scores on the GradeBookItems
 * for that class.
 *
 * @author Nirvan Nagar
 *
 */
public class GradingScheme {

    private int gradeA, gradeB, gradeC, gradeD, gradeF;
    private int numberGrade = 0;

    public GradingScheme(int gradeA, int gradeB, int gradeC, int gradeD,
            int gradeF) {

        this.gradeA = gradeA;
        this.gradeB = gradeB;
        this.gradeC = gradeC;
        this.gradeD = gradeD;
        this.gradeF = gradeF;

    }

    public int calculateNumericalGrade(GradebookItems grades) {

        int numericalGrade = 0;
//        int numCategories = grades.getNumGradeCategories();
        LinkedList<GradebookCategory> gradeCategories = grades.getCategories();

        for (int i = 0; i < gradeCategories.size(); i++) {

            GradebookCategory category = gradeCategories.get(i);
            int numOf = grades.numOf(category);
            double categoryAvg = 0;
            double percentWeight = (double) category.getWeightInPercent() / 100;

            for (int j = 0; j < grades.getNumGradeItems(); j++) {

                GradebookItem item = grades.getItemAt(j);
                if (item.getGradebookCategory().equals(category)) {
                    categoryAvg += item.getScore();
                }

            }
            categoryAvg = (categoryAvg / numOf) * percentWeight;

            numericalGrade += categoryAvg;

        }

        numberGrade = numericalGrade;
        return numericalGrade;
    }

    public char calculateLetterGrade() {

        char letterGrade = 0;

        if (numberGrade >= gradeA) {
            letterGrade = 'A';
        } else if (numberGrade >= gradeB) {
            letterGrade = 'B';
        } else if (numberGrade >= gradeC) {
            letterGrade = 'C';
        } else if (numberGrade >= gradeD) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }

        return letterGrade;
    }

    public char calculateLetterGrade(int numGrade) {

        char letterGrade = 0;

        if (numGrade >= gradeA) {
            letterGrade = 'A';
        } else if (numGrade >= gradeB) {
            letterGrade = 'B';
        } else if (numGrade >= gradeC) {
            letterGrade = 'C';
        } else if (numGrade >= gradeD) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }

        return letterGrade;
    }

}
