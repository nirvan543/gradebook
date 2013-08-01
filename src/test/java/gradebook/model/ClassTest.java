package gradebook.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import src.main.java.gradebook.model.ClassSection;
import src.main.java.gradebook.model.ClassSections;
import src.main.java.gradebook.model.Course;
import src.main.java.gradebook.model.GradebookCategory;
import src.main.java.gradebook.model.GradebookItem;
import src.main.java.gradebook.model.GradingScheme;
import src.main.java.gradebook.model.Student;
import src.main.java.gradebook.model.Students;
import src.main.java.gradebook.model.Class;

/**
 * Tests for {@link Class}.
 *
 * @author Nirvan Nagar
 */
@RunWith(JUnit4.class)
public class ClassTest {

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
    public void testSemster() {
        Student student1 = new Student("Nirvan Nagar", scheme);
        Student student2 = new Student("Sonya Sinha", scheme);

        Student student3 = new Student("Ryan Paul", scheme);
        Student student4 = new Student("Jennifer Springston", scheme);

        Students studentList1 = new Students();
        Students studentList2 = new Students();

        studentList1.addStudent(student1);
        studentList1.addStudent(student2);

        studentList2.addStudent(student3);
        studentList2.addStudent(student4);

        ClassSection sectionA = new ClassSection(studentList1);
        ClassSection sectionB = new ClassSection(studentList2);

        ClassSections classSections = new ClassSections();
        classSections.addSection(sectionA);
        classSections.addSection(sectionB);

        Course cs2340 = new Course("CS", 2340, "Object and Design");
        Class aClass = new Class(cs2340, "Summer 2013", classSections);

        assertEquals("Summer 2013", aClass.getSemester());
    }

    @Test
    public void testTotalStudents() {
        Student student1 = new Student("Nirvan Nagar", scheme);
        Student student2 = new Student("Sonya Sinha", scheme);

        Student student3 = new Student("Ryan Paul", scheme);
        Student student4 = new Student("Jennifer Springston", scheme);

        Students studentList1 = new Students();
        Students studentList2 = new Students();

        studentList1.addStudent(student1);
        studentList1.addStudent(student2);

        studentList2.addStudent(student3);
        studentList2.addStudent(student4);

        ClassSection sectionA = new ClassSection(studentList1);
        ClassSection sectionB = new ClassSection(studentList2);

        ClassSections classSections = new ClassSections();
        classSections.addSection(sectionA);
        classSections.addSection(sectionB);

        Course cs2340 = new Course("CS", 2340, "Object and Design");
        Class aClass = new Class(cs2340, "Summer 2013", classSections);

        assertEquals(4, aClass.getTotalStudents());
    }

    @Test
    public void testSemesterClassAVG() {
        Student student1 = new Student("Nirvan Nagar", scheme);
        Student student2 = new Student("Sonya Sinha", scheme);

        Student student3 = new Student("Ryan Paul", scheme);
        Student student4 = new Student("Jennifer Springston", scheme);

        student1.addGrade(item1);
        student1.addGrade(item2);
        student1.addGrade(item3);
        student1.addGrade(item4);
        student1.addGrade(item5);
        student1.addGrade(item6);
        student1.addGrade(item7);

        student2.addGrade(item8);
        student2.addGrade(item9);
        student2.addGrade(item10);
        student2.addGrade(item11);
        student2.addGrade(item12);
        student2.addGrade(item13);
        student2.addGrade(item14);

        student3.addGrade(item15);
        student3.addGrade(item16);
        student3.addGrade(item17);
        student3.addGrade(item18);
        student3.addGrade(item19);
        student3.addGrade(item20);
        student3.addGrade(item21);

        student4.addGrade(item22);
        student4.addGrade(item23);
        student4.addGrade(item24);
        student4.addGrade(item25);
        student4.addGrade(item26);
        student4.addGrade(item27);
        student4.addGrade(item28);

        Students studentList1 = new Students();
        Students studentList2 = new Students();

        studentList1.addStudent(student1);
        studentList1.addStudent(student2);

        studentList2.addStudent(student3);
        studentList2.addStudent(student4);

        ClassSection sectionA = new ClassSection(studentList1);
        ClassSection sectionB = new ClassSection(studentList2);

        ClassSections classSections = new ClassSections();
        classSections.addSection(sectionA);
        classSections.addSection(sectionB);

        Course cs2340 = new Course("CS", 2340, "Object and Design");
        Class aClass = new Class(cs2340, "Summer 2013", classSections);

        assertEquals(2, aClass.getNumSections());
        assertEquals(4, aClass.getTotalStudents());
        assertEquals(83, aClass.calculateCourseAVG());
    }

}
