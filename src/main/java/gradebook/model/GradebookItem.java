package gradebook.model;

/**
 * A GradebookItem is an item for which a student receives a score.
 *
 * @author Nirvan Nagar
 *
 */
public class GradebookItem {

    private String itemName;
    private GradebookCategory gradeCategory;
    private int score;

    public GradebookItem(String itemName, GradebookCategory gradeCategory,
            int score) {
        this.itemName = itemName;
        this.gradeCategory = gradeCategory;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getItemName() {
        return itemName;
    }

    public GradebookCategory getGradebookCategory() {
        return gradeCategory;
    }

}
