package gradebook.model;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A GradebookItems has the sole purpose of storing GradebookItems.
 *
 * @author Nirvan Nagar
 *
 */
public class GradebookItems {

    private ArrayList<GradebookItem> grades;
    private LinkedList<GradebookCategory> categories;

    public GradebookItems() {
        grades = new ArrayList<GradebookItem>();
        categories = new LinkedList<GradebookCategory>();
    }


    public void addGrade(GradebookItem grade) {
        grades.add(grade);
        if (!categories.contains(grade.getGradebookCategory())) {
            categories.add(grade.getGradebookCategory());
        }
    }

    public void deleteGrade(GradebookItem grade) {
        grades.remove(grade);
        if (numOf(grade.getGradebookCategory()) == 0) {
            categories.remove(grade.getGradebookCategory());
        }
    }

    public GradebookItem getItemAt(int index) {
        return grades.get(index);
    }

    public int numOf(GradebookCategory category) {

        int numOf = 0;

        for (int i = 0; i < grades.size(); i++) {

            GradebookCategory aCategory = grades.get(i).getGradebookCategory();

            if (aCategory.equals(category)) {
                numOf += 1;
            }

        }

        return numOf;
    }

    public LinkedList<GradebookCategory> getCategories() {
        return categories;
    }

    public int getNumGradeCategories() {
        return categories.size();
    }

    public int getNumGradeItems() {
        return grades.size();
    }

    public ArrayList<GradebookItem> getGrades() {
        return grades;
    }

    public boolean isEmpty() {
        return grades.isEmpty();
    }

}
