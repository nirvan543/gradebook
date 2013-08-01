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

    private int[] schemeType;
    private int numberGrade = 0;
//    private String specialOp;

    public GradingScheme(int A, int B, int C, int D, int F) {

        schemeType = new int[5];

        schemeType[0] = A;
        schemeType[1] = B;
        schemeType[2] = C;
        schemeType[3] = D;
        schemeType[4] = F;
//        specialOp = "none";

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

        if (numberGrade >= schemeType[0]) {
            letterGrade = 'A';
        } else if (numberGrade >= schemeType[1]) {
            letterGrade = 'B';
        } else if (numberGrade >= schemeType[2]) {
            letterGrade = 'C';
        } else if (numberGrade >= schemeType[3]) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }

        return letterGrade;
    }

    public char calculateLetterGrade(int numGrade) {

        char letterGrade = 0;

        if (numGrade >= schemeType[0]) {
            letterGrade = 'A';
        } else if (numGrade >= schemeType[1]) {
            letterGrade = 'B';
        } else if (numGrade >= schemeType[2]) {
            letterGrade = 'C';
        } else if (numGrade >= schemeType[3]) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }

        return letterGrade;
    }

}
