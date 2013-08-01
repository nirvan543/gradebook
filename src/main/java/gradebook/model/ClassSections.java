package gradebook.model;

import java.util.ArrayList;

/**
 * ClassSections is a class for the sole purpose
 * of storing class sections.
 *
 * @author Nirvan Nagar
 *
 */
public class ClassSections {

    private ArrayList<ClassSection> sections;

    public ClassSections() {
        this.sections = new ArrayList<ClassSection>();
    }

    public void addSection(ClassSection section) {
        sections.add(section);
    }

    public void deleteSection(ClassSection section) {
        sections.remove(section);
    }

    public ClassSection getClassAt(int index) {
        return sections.get(index);
    }

    public int getNumSections() {
        return sections.size();
    }

}
