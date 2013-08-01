package gradebook.model;

import java.util.ArrayList;

/**
 * A course is a defined semester-long treatment of a set of material within
 * a larger subject, .e.g. CS 2340 Objects and Design.
 *
 * @author Nirvan Nagar
 *
 */
public class Course {

    private String subject, courseName, courseID;
    private int courseNumber;
    private ArrayList<Course> prereqs;
    private ArrayList<Class> classes;
    private int historicalCourseAVG;


    public Course(String subject, int courseNumber, String courseName) {
        this(subject, courseNumber, courseName, null);
    }

    public Course(String subject, int courseNumber, String courseName,
            ArrayList<Course> preCourses) {

        this.subject = subject;
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.courseID = subject + " " + courseNumber;

        if (preCourses != null) {
            this.prereqs = new ArrayList<Course>();

            for (int i = 0; i < preCourses.size(); i++) {

                Course course = preCourses.get(i);
                prereqs.add(course);

            }

        } else {
            this.prereqs = null;
        }

        classes = new ArrayList<Class>();

        historicalCourseAVG = 0;

    }

    public int calculateHistoricalAVG() {

        int historicalGradeTotal = 0;

        for (int i = 0; i < classes.size(); i++) {
            Class aClass = classes.get(i);
            historicalGradeTotal += aClass.calculateCourseAVG();
        }

        historicalCourseAVG = historicalGradeTotal / classes.size();

        return historicalCourseAVG;
    }

    public void addClass(Class newClass) {
        classes.add(newClass);
    }

    public String getSubject() {
        return subject;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public String displayCoursePreReqs() {

        String preReqs = "";

        if (prereqs == null) {
            preReqs = "This course has no prerequisite.";
        } else {
            for (int i = 0; i < prereqs.size(); i++) {
                Course course = prereqs.get(i);
                preReqs += course.getCourseID() + "\n";
            }
        }

        return preReqs;
    }

}
