import java.util.ArrayList;
import java.util.Collections;

public class Department implements Functional<Department> {
    private String name;
    private ArrayList<Professor> professors;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public Department(String name) {
        this.name = name;
        this.professors = new ArrayList<>();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addProfessor(Professor p) {
        Professor[] profArray = professors.toArray(new Professor[0]);
        if (!Utility.linearSearch(profArray, p)) {
            professors.add(p);
        }
    }

    public void addStudent(Student s) {
        Student[] studentArray = students.toArray(new Student[0]);
        if (!Utility.linearSearch(studentArray, s)) {
            students.add(s);
        }
    }

    public void addCourse(Course c) {
        Course[] courseArray = courses.toArray(new Course[0]);
        if (!Utility.linearSearch(courseArray, c)) {
            courses.add(c);
        }
    }

    public void removeProfessor(Professor p) {
        professors.remove(p);
        for (Course c : p.getCourses()) {
            boolean stillUsed = false;
            for (Professor other : professors) {
                if (other.getCourses().contains(c)) {
                    stillUsed = true;
                    break;
                }
            }
            if (!stillUsed) courses.remove(c);
        }

        for (Student s : p.getStudents()) {
            boolean stillTaught = false;
            for (Professor other : professors) {
                if (other.getStudents().contains(s)) {
                    stillTaught = true;
                    break;
                }
            }
            if (!stillTaught) students.remove(s);
        }
    }

    public void removeStudent(Student s) {
        students.remove(s);
    }

    public void removeCourse(Course c) {
        courses.remove(c);
    }

    public ArrayList<Professor> getProfessors() {
        Collections.sort(professors);
        return professors;
    }

    public ArrayList<Student> getStudents() {
        Collections.sort(students);
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    @Override
    public void displayInfo() {
        System.out.println("\nDepartment: " + name);
        System.out.println("Professors: " + professors.size());
        System.out.println("Students: " + students.size());
        System.out.println("Courses: " + courses.size());
    }
}
