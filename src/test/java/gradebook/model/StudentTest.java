package gradebook.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import src.main.java.gradebook.model.GradebookCategory;
import src.main.java.gradebook.model.GradebookItem;
import src.main.java.gradebook.model.GradingScheme;
import src.main.java.gradebook.model.Student;

/**
 * Tests for {@link Student}.
 *
 * @author Nirvan Nagar
 */
@RunWith(JUnit4.class)
public class StudentTest {

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
    public void testNumericalAVG() {
        GradingScheme scheme = new GradingScheme(90,80,70,60,0);
        String name = "Nirvan Nagar";
        Student student = new Student(name, scheme);
        student.addGrade(item1);
        student.addGrade(item2);
        student.addGrade(item3);
        student.addGrade(item4);
        student.addGrade(item5);
        student.addGrade(item6);
        student.addGrade(item7);

        assertEquals(97, student.calculateAVG());
    }

    @Test
    public void testLetterAVG() {
        GradingScheme scheme = new GradingScheme(90,80,70,60,0);
        String name = "Nirvan Nagar";
        Student student = new Student(name, scheme);
        student.addGrade(item1);
        student.addGrade(item2);
        student.addGrade(item3);
        student.addGrade(item4);
        student.addGrade(item5);
        student.addGrade(item6);
        student.addGrade(item7);

        assertEquals('A', student.calculateLetterGrade(97));
    }

    @Test
    public void deleteGrade(){
        GradingScheme scheme = new GradingScheme(90,80,70,60,0);
        String name = "Nirvan Nagar";
        Student student = new Student(name, scheme);
        student.addGrade(item1);
        student.addGrade(item2);
        student.addGrade(item3);
        student.addGrade(item4);
        student.addGrade(item5);
        student.addGrade(item6);
        student.addGrade(item7);

        student.deleteGrade(item2);

        assertEquals(97, student.calculateAVG());
        assertEquals('A', student.calculateLetterGrade(97));
    }

}
