package gradebook.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import src.main.java.gradebook.model.ClassSection;
import src.main.java.gradebook.model.GradebookCategory;
import src.main.java.gradebook.model.GradebookItem;
import src.main.java.gradebook.model.GradingScheme;
import src.main.java.gradebook.model.Student;
import src.main.java.gradebook.model.Students;

/**
 * Tests for {@link ClassSection}.
 *
 * @author Nirvan Nagar
 */
@RunWith(JUnit4.class)
public class ClassSectionTest {

    GradingScheme scheme = new GradingScheme(90,80,70,60,0);

    GradebookCategory midterm = new GradebookCategory("Midterm", 20);
    GradebookCategory milestones = new GradebookCategory("Milstones", 60);
    GradebookCategory finalExam = new GradebookCategory("Final Exam", 20);

    GradebookItem item1 = new GradebookItem("Midterm", midterm, 95);
    GradebookItem item2 = new GradebookItem("m1", milestones, 100);
    GradebookItem item3 = new GradebookItem("m2", milestones, 100);
    GradebookItem item4 = new GradebookItem("m3", milestones, 100);
    GradebookItem item5 = new GradebookItem("m4", milestones, 100);
    GradebookItem item6 = new GradebookItem("m5", milestones, 100);
    GradebookItem item7 = new GradebookItem("Final Exam", finalExam, 90);

    GradebookItem item8 = new GradebookItem("Midterm", midterm, 75);
    GradebookItem item9 = new GradebookItem("m1", milestones, 100);
    GradebookItem item10 = new GradebookItem("m2", milestones, 70);
    GradebookItem item11 = new GradebookItem("m3", milestones, 85);
    GradebookItem item12 = new GradebookItem("m4", milestones, 45);
    GradebookItem item13 = new GradebookItem("m5", milestones, 67);
    GradebookItem item14 = new GradebookItem("Final Exam", finalExam, 75);

    GradebookItem item15 = new GradebookItem("Midterm", midterm, 50);
    GradebookItem item16 = new GradebookItem("m1", milestones, 0);
    GradebookItem item17 = new GradebookItem("m2", milestones, 70);
    GradebookItem item18 = new GradebookItem("m3", milestones, 85);
    GradebookItem item19 = new GradebookItem("m4", milestones, 100);
    GradebookItem item20 = new GradebookItem("m5", milestones, 92);
    GradebookItem item21 = new GradebookItem("Final Exam", finalExam, 87);

    GradebookItem item22 = new GradebookItem("Midterm", midterm, 100);
    GradebookItem item23 = new GradebookItem("m1", milestones, 100);
    GradebookItem item24 = new GradebookItem("m2", milestones, 90);
    GradebookItem item25 = new GradebookItem("m3", milestones, 85);
    GradebookItem item26 = new GradebookItem("m4", milestones, 92);
    GradebookItem item27 = new GradebookItem("m5", milestones, 95);
    GradebookItem item28 = new GradebookItem("Final Exam", finalExam, 98);

    @Test
    public void testCalcSectionAVG() {

        Student student = new Student("Nirvan Nagar", scheme);
        student.addGrade(item1);
        student.addGrade(item2);
        student.addGrade(item3);
        student.addGrade(item4);
        student.addGrade(item5);
        student.addGrade(item6);
        student.addGrade(item7);

        Student student2 = new Student("Ron Styner" , scheme);
        student2.addGrade(item8);
        student2.addGrade(item9);
        student2.addGrade(item10);
        student2.addGrade(item11);
        student2.addGrade(item12);
        student2.addGrade(item13);
        student2.addGrade(item14);

        Student student3 = new Student("Jane Smith" , scheme);
        student3.addGrade(item15);
        student3.addGrade(item16);
        student3.addGrade(item17);
        student3.addGrade(item18);
        student3.addGrade(item19);
        student3.addGrade(item20);
        student3.addGrade(item21);

        Student student4 = new Student("Lane Smith" , scheme);
        student4.addGrade(item22);
        student4.addGrade(item23);
        student4.addGrade(item24);
        student4.addGrade(item25);
        student4.addGrade(item26);
        student4.addGrade(item27);
        student4.addGrade(item28);

        Students students = new Students();
        students.addStudent(student);
        students.addStudent(student2);
        students.addStudent(student3);
        students.addStudent(student4);


        ClassSection section = new ClassSection(students);
        section.calculateSectionAVG();

        assertEquals(83, section.calculateSectionAVG());

    }
    
    @Test
    public void testCalcSectionAVGWithDiffScheme() {

        GradingScheme schemeCurve = new GradingScheme(85, 75, 65, 55, 0);

        Student student = new Student("Nirvan Nagar", schemeCurve);
        student.addGrade(item1);
        student.addGrade(item2);
        student.addGrade(item3);
        student.addGrade(item4);
        student.addGrade(item5);
        student.addGrade(item6);
        student.addGrade(item7);

        Student student2 = new Student("Ron Styner" , schemeCurve);
        student2.addGrade(item8);
        student2.addGrade(item9);
        student2.addGrade(item10);
        student2.addGrade(item11);
        student2.addGrade(item12);
        student2.addGrade(item13);
        student2.addGrade(item14);

        Student student3 = new Student("Jane Smith" , schemeCurve);
        student3.addGrade(item15);
        student3.addGrade(item16);
        student3.addGrade(item17);
        student3.addGrade(item18);
        student3.addGrade(item19);
        student3.addGrade(item20);
        student3.addGrade(item21);

        Student student4 = new Student("Lane Smith" , schemeCurve);
        student4.addGrade(item22);
        student4.addGrade(item23);
        student4.addGrade(item24);
        student4.addGrade(item25);
        student4.addGrade(item26);
        student4.addGrade(item27);
        student4.addGrade(item28);

        Students students = new Students();
        students.addStudent(student);
        students.addStudent(student2);
        students.addStudent(student3);
        students.addStudent(student4);


        ClassSection section = new ClassSection(students);
        section.calculateSectionAVG();

        assertEquals(83, section.calculateSectionAVG());

    }

    @Test
    public void testGetNumStudents(){

        GradingScheme schemeCurve = new GradingScheme(85, 75, 65, 55, 0);

        Student student = new Student("Nirvan Nagar", schemeCurve);
        student.addGrade(item1);
        student.addGrade(item2);
        student.addGrade(item3);
        student.addGrade(item4);
        student.addGrade(item5);
        student.addGrade(item6);
        student.addGrade(item7);

        Student student2 = new Student("Ron Styner" , schemeCurve);
        student2.addGrade(item8);
        student2.addGrade(item9);
        student2.addGrade(item10);
        student2.addGrade(item11);
        student2.addGrade(item12);
        student2.addGrade(item13);
        student2.addGrade(item14);

        Student student3 = new Student("Jane Smith" , schemeCurve);
        student3.addGrade(item15);
        student3.addGrade(item16);
        student3.addGrade(item17);
        student3.addGrade(item18);
        student3.addGrade(item19);
        student3.addGrade(item20);
        student3.addGrade(item21);

        Student student4 = new Student("Lane Smith" , schemeCurve);
        student4.addGrade(item22);
        student4.addGrade(item23);
        student4.addGrade(item24);
        student4.addGrade(item25);
        student4.addGrade(item26);
        student4.addGrade(item27);
        student4.addGrade(item28);

        Students students = new Students();
        students.addStudent(student);
        students.addStudent(student2);
        students.addStudent(student3);
        students.addStudent(student4);


        ClassSection section = new ClassSection(students);
        section.calculateSectionAVG();

        assertEquals(4, section.getNumStudents());
    }

}
