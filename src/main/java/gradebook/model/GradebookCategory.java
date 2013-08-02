package gradebook.model;

/**
 * A GraadebookCategory is a named or tag applied to GradeBookItems,
 * or named group to which GradebookItems can belong.
 *
 * @author Nirvan Nagar
 *
 */
public class GradebookCategory {

    private String categoryName;
    private int weightInPercent;
    private boolean dropLowest, replaceWithAVG;

    public GradebookCategory(String categoryName, int weightInPercent) {
        this.categoryName = categoryName;
        this.weightInPercent = weightInPercent;
        this.dropLowest = false;
        this.replaceWithAVG = false;
    }

    public GradebookCategory(String categoryName, int weightInPercent,
                boolean dropLowest, boolean replaceWithAVG) {
        this.categoryName = categoryName;
        this.weightInPercent = weightInPercent;
        this.dropLowest = dropLowest;
        this.replaceWithAVG = false;
    }


    public int getWeightInPercent() {
        return weightInPercent;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public boolean dropLowest() {
        return dropLowest;
    }

    public boolean replaceWithAVG() {
        return replaceWithAVG;
    }

}
