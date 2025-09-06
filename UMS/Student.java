import java.util.ArrayList;
import java.util.Collections;

public class Student extends Person implements Functional<Student>, Comparable<Student> {
    private ArrayList<Course> courses;

    public Student(String name, int age) {
        super(name, age);
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        Course[] courseArray = courses.toArray(new Course[0]);
        if (!Utility.linearSearch(courseArray, course)) {
            courses.add(course);
        }
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public int getAge() {
    return age;
}

public String getName() {
    return name;
}


    @Override
    public void displayInfo() {
        System.out.println("\nStudent: " + name + ", Age: " + age);
        System.out.print("Courses: ");
        Collections.sort(courses, (a, b) -> a.getTitle().compareTo(b.getTitle()));
        for (Course c : courses) {
            System.out.print("'" + c.getTitle() + "' ");
        }
        System.out.println();
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student s) {
            return this.name.equals(s.name);
        }
        return false;
    }
}
