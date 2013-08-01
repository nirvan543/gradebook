package gradebook.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import src.main.java.gradebook.model.GradebookCategory;
import src.main.java.gradebook.model.GradebookItem;
import src.main.java.gradebook.model.GradebookItems;

/**
 * Tests for {@link GradebookItem}.
 *
 * @author Nirvan Nagar
 */
@RunWith(JUnit4.class)
public class GradebookItemTest {

    GradebookCategory midterm = new GradebookCategory("Midterm", 20);
    GradebookItem item1 = new GradebookItem("Midterm", midterm, 95);

    GradebookCategory milestones = new GradebookCategory("Milstones", 60);
    GradebookItem item2 = new GradebookItem("m1", milestones, 100);
    GradebookItem item3 = new GradebookItem("m2", milestones, 100);
    GradebookItem item4 = new GradebookItem("m3", milestones, 100);
    GradebookItem item5 = new GradebookItem("m4", milestones, 100);
    GradebookItem item6 = new GradebookItem("m5", milestones, 100);

    GradebookCategory finalExam = new GradebookCategory("Final Exam", 20);
    GradebookItem item7 = new GradebookItem("Final Exam", finalExam, 80);


    @Test
    public void testItemName() {
        assertEquals("Midterm", item1.getItemName());
    }

    @Test
    public void testGetScore(){
        assertEquals(95, item1.getScore());
    }

    @Test
    public void testGradebookCategory(){
        assertEquals(midterm, item1.getGradebookCategory());
    }

}
