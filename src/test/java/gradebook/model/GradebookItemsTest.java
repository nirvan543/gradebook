package gradebook.model;

import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import src.main.java.gradebook.model.GradebookCategory;
import src.main.java.gradebook.model.GradebookItem;
import src.main.java.gradebook.model.GradebookItems;

/**
 * Tests for {@link GradebookItems}.
 *
 * @author Nirvan Nagar
 */
@RunWith(JUnit4.class)
public class GradebookItemsTest {

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
    public void testAddGrade() {
        GradebookItems items = new GradebookItems();
        items.addGrade(item1);
        items.addGrade(item2);
        items.addGrade(item3);
        items.addGrade(item4);
        items.addGrade(item5);
        items.addGrade(item6);
        items.addGrade(item7);

        ArrayList<GradebookItem> expected = new ArrayList<GradebookItem>();
        expected.add(item1);
        expected.add(item2);
        expected.add(item3);
        expected.add(item4);
        expected.add(item5);
        expected.add(item6);
        expected.add(item7);

        assertEquals(expected, items.getGrades());
    }

    @Test
    public void testNumGradeCategories(){

        GradebookItems items = new GradebookItems();
        items.addGrade(item1);
        items.addGrade(item2);
        items.addGrade(item3);
        items.addGrade(item4);
        items.addGrade(item5);
        items.addGrade(item6);
        items.addGrade(item7);

        assertEquals(3, items.getNumGradeCategories());

    }

    @Test
    public void testNumGrades(){

        GradebookItems items = new GradebookItems();
        items.addGrade(item1);
        items.addGrade(item2);
        items.addGrade(item3);
        items.addGrade(item4);
        items.addGrade(item5);
        items.addGrade(item6);
        items.addGrade(item7);

        assertEquals(7, items.getNumGradeItems());

    }

    @Test 
    public void testNumOf(){
        GradebookItems items = new GradebookItems();
        items.addGrade(item1);
        items.addGrade(item2);
        items.addGrade(item3);
        items.addGrade(item4);
        items.addGrade(item5);
        items.addGrade(item6);
        items.addGrade(item7);

        assertEquals(5, items.numOf(milestones));
    }

    @Test
    public void testDelete(){
        GradebookItems items = new GradebookItems();
        items.addGrade(item1);
        items.addGrade(item2);
        items.addGrade(item3);
        items.addGrade(item4);
        items.addGrade(item5);
        items.addGrade(item6);
        items.addGrade(item7);

        items.deleteGrade(item2);

        assertEquals(4, items.numOf(milestones));
        assertEquals(3, items.getNumGradeCategories());

        items.deleteGrade(item3);
        items.deleteGrade(item4);
        items.deleteGrade(item5);
        items.deleteGrade(item6);

        assertEquals(2, items.getNumGradeCategories());
        assertEquals(0, items.numOf(milestones));
    }

    @Test
    public void testDeleteWithOneItem(){
        GradebookItems items = new GradebookItems();
        items.addGrade(item1);
        items.addGrade(item2);
        items.addGrade(item3);
        items.addGrade(item4);
        items.addGrade(item5);
        items.addGrade(item6);
        items.addGrade(item7);

        items.deleteGrade(item1);

        assertEquals(0, items.numOf(midterm));
        assertEquals(2, items.getNumGradeCategories());
    }

}
