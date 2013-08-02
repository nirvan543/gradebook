package gradebook.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import src.main.java.gradebook.model.GradebookCategory;
import src.main.java.gradebook.model.GradebookItem;
import src.main.java.gradebook.model.GradebookItems;
import src.main.java.gradebook.model.GradingScheme;

/**
 * Tests for {@link GradingScheme}.
 *
 * @author Nirvan Nagar
 */
@RunWith(JUnit4.class)
public class GradingSchemeTest {

    GradebookCategory midterm = new GradebookCategory("Midterm", 20);
    GradebookItem item1 = new GradebookItem("Midterm", midterm, 95);

    GradebookCategory milestones = new GradebookCategory("Milstones", 60);
    GradebookItem item2 = new GradebookItem("m1", milestones, 100);
    GradebookItem item3 = new GradebookItem("m2", milestones, 100);
    GradebookItem item4 = new GradebookItem("m3", milestones, 100);
    GradebookItem item5 = new GradebookItem("m4", milestones, 100);
    GradebookItem item6 = new GradebookItem("m5", milestones, 100);

    GradebookCategory finalExam = new GradebookCategory("Final Exam", 20);
    GradebookItem item7 = new GradebookItem("Final Exam", finalExam, 90);

    @Test
    public void testNumericalGrade() {
           GradebookItems items = new GradebookItems();
           items.addGrade(item1);
           items.addGrade(item2);
           items.addGrade(item3);
           items.addGrade(item4);
           items.addGrade(item5);
           items.addGrade(item6);
           items.addGrade(item7);

           GradingScheme schema = new GradingScheme(90, 80, 70, 60, 0);
           int numericalGrade = schema.calculateNumericalGrade(items);

           assertEquals(97, numericalGrade);
    }

    @Test
    public void testLetterGrade() {
           GradebookItems items = new GradebookItems();
           items.addGrade(item1);
           items.addGrade(item2);
           items.addGrade(item3);
           items.addGrade(item4);
           items.addGrade(item5);
           items.addGrade(item6);
           items.addGrade(item7);

           GradingScheme schema = new GradingScheme(90, 80, 70, 60, 0);
           int numericalGrade = schema.calculateNumericalGrade(items);
           char letterGrade = schema.calculateLetterGrade(numericalGrade);

           assertEquals(97, numericalGrade);
           assertEquals('A', letterGrade);
           assertEquals('A', schema.calculateLetterGrade());
    }
    
    @Test
    public void testNumericalWithAlternateScheme(){
        GradebookCategory midterm = new GradebookCategory("Midterm", 20);
        GradebookItem exam = new GradebookItem("Midterm", midterm, 95);

        GradebookCategory milestones = new GradebookCategory("Milstones", 60);
        GradebookItem mStone1 = new GradebookItem("m1", milestones, 100);
        GradebookItem mStone2 = new GradebookItem("m2", milestones, 100);
        GradebookItem mStone3 = new GradebookItem("m3", milestones, 100);
        GradebookItem mStone4 = new GradebookItem("m4", milestones, 100);
        GradebookItem mStone5 = new GradebookItem("m5", milestones, 100);

        GradebookCategory finalExam = new GradebookCategory("Final Exam", 20);
        GradebookItem finalTest =new GradebookItem("Final Exam", finalExam, 25);

        GradebookItems grades = new GradebookItems();
        grades.addGrade(exam);
        grades.addGrade(mStone1);
        grades.addGrade(mStone2);
        grades.addGrade(mStone3);
        grades.addGrade(mStone4);
        grades.addGrade(mStone5);
        grades.addGrade(finalTest);

        GradingScheme schema = new GradingScheme(85, 75, 65, 55, 0);
        int numGrade = schema.calculateNumericalGrade(grades);

        assertEquals(84, numGrade);
    }
    
    @Test
    public void testLetterWithAlternateScheme(){
        GradebookCategory midterm = new GradebookCategory("Midterm", 20);
        GradebookItem exam = new GradebookItem("Midterm", midterm, 95);

        GradebookCategory milestones = new GradebookCategory("Milstones", 60);
        GradebookItem mStone1 = new GradebookItem("m1", milestones, 100);
        GradebookItem mStone2 = new GradebookItem("m2", milestones, 100);
        GradebookItem mStone3 = new GradebookItem("m3", milestones, 100);
        GradebookItem mStone4 = new GradebookItem("m4", milestones, 100);
        GradebookItem mStone5 = new GradebookItem("m5", milestones, 100);

        GradebookCategory finalExam = new GradebookCategory("Final Exam", 20);
        GradebookItem finalTest =new GradebookItem("Final Exam", finalExam, 25);

        GradebookItems grades = new GradebookItems();
        grades.addGrade(exam);
        grades.addGrade(mStone1);
        grades.addGrade(mStone2);
        grades.addGrade(mStone3);
        grades.addGrade(mStone4);
        grades.addGrade(mStone5);
        grades.addGrade(finalTest);

        GradingScheme schema = new GradingScheme(85, 75, 65, 55, 0);
        int numGrade = schema.calculateNumericalGrade(grades);

        assertEquals('B', schema.calculateLetterGrade(numGrade));
    }

}