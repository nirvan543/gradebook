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
	private String specialOp;

    public GradebookCategory(String categoryName, int weightInPercent, String specialOp) {
        this.categoryName = categoryName;
        this.weightInPercent = weightInPercent;
		this.specialOp = specialOp;
    }

    public int getWeightInPercent() {
        return weightInPercent;
    }

    public String getCategoryName() {
        return categoryName;
    }
	
	public String get

}
