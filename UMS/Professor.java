import java.util.ArrayList;
import java.util.Collections;

public class Professor extends Person implements Functional<Professor>, Comparable<Professor> {
    private String subject;
    private ArrayList<Course> courses;
    private ArrayList<Student> students;

    public Professor(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        Course[] courseArray = courses.toArray(new Course[0]);
        if (!Utility.linearSearch(courseArray, course)) {
            courses.add(course);
        }
    }

    public void addStudent(Student student) {
        Student[] studentArray = students.toArray(new Student[0]);
        if (!Utility.linearSearch(studentArray, student)) {
            students.add(student);
        }
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public int getAge() {
    return age;
}

public String getSubject() {
    return subject;
}

public String getName() {
    return name;
}


    @Override
    public void displayInfo() {
        System.out.println("\nProfessor: " + name + ", Age: " + age + ", Subject: " + subject);
        System.out.print("Courses: ");
        Collections.sort(courses, (a, b) -> a.getTitle().compareTo(b.getTitle()));
        for (Course c : courses) {
            System.out.print("'"+c.getTitle() + "' ");
        }
        System.out.println();
        System.out.print("Students: ");
        Collections.sort(students);
        for (Student s : students) {
            System.out.print("'" + s.getName() + "' ");
        }
        System.out.println();
    }

    @Override
    public int compareTo(Professor other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Professor p) {
            return this.name.equals(p.name);
        }
        return false;
    }
}
