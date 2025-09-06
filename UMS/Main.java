import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void saveDataToFile(University university) throws IOException {
    FileWriter writer = new FileWriter("university_data.txt", true);

    writer.write("===== UNIVERSITY SNAPSHOT =====\n");
    writer.write("University: " + university.getName() + "\n\n");

    for (Department dept : university.getDepartments()) {
        writer.write("Department: " + dept.getName() + "\n");

        writer.write("  Professors:\n");
        for (Professor prof : dept.getProfessors()) {
            writer.write("    " + prof.getName() + " (Age: " + prof.getAge() + ", Subject: " + prof.getSubject() + ")\n");
        }

        writer.write("  Students:\n");
        for (Student student : dept.getStudents()) {
            writer.write("    " + student.getName() + " (Age: " + student.getAge() + ")\n");
        }

        writer.write("  Courses:\n");
        for (Course course : dept.getCourses()) {
            writer.write("    " + course.getCode() + " - " + course.getTitle() + "\n");
        }

        writer.write("\n");
    }

    writer.write("===================================\n\n");
    writer.close();
}


    public static void main(String[] args) throws Exception {
        System.out.println("\n===== University Management System =====\n");
        Scanner scanner = new Scanner(System.in);

        boolean isAdmin = false;
        boolean isUser = false;
        boolean validinfo = true;
        while (validinfo) {
            System.out.print("Enter username: ");
            String uname = scanner.nextLine();
            System.out.print("Enter password: ");
            String pass = scanner.nextLine();

            if (uname.equals("admin") && pass.equals("admin")) {
                isAdmin = true;
                validinfo = false;
            } else if (uname.equals("user") && pass.equals("user")) {
                isUser = true;
                validinfo = false;
            } else {
                System.out.println("Invalid credentials. Try again.\n");
            }
        }

        
            ArrayList<String> deptNames = new ArrayList<>();
            deptNames.add("Computer Science");
            deptNames.add("Software Engineering");

            University university = new University("GIFT University", deptNames);
            Department cs = university.getDepartments().get(0);
            Department se = university.getDepartments().get(1);

            Professor p1 = new Professor("Shazma Noor", 25, "OOP");
            Professor p2 = new Professor("Tayba Sana", 30, "Database Systems");

            Student s1 = new Student("Kashif", 22);
            Student s2 = new Student("Ali", 20);
            Student s3 = new Student("Ahsan", 17);

            Course c1 = new Course("CS101", "Object Oriented Programming");
            Course c2 = new Course("CS102", "Database Systems");
            Course c3 = new Course("CS103", "Programming Fundamentals");

            se.addCourse(c3);
            se.addProfessor(p1);

            p1.addCourse(c1);
            p1.addCourse(c3);
            p1.addStudent(s1);
            p1.addStudent(s3);

            p2.addCourse(c2);
            p2.addStudent(s2);
            p2.addStudent(s1);

            s1.addCourse(c1);
            s1.addCourse(c2);
            s2.addCourse(c2);
            s3.addCourse(c1);

            cs.addProfessor(p1);
            cs.addProfessor(p2);
            cs.addStudent(s1);
            cs.addStudent(s2);
            cs.addStudent(s3);
            cs.addCourse(c1);
            cs.addCourse(c2);

            if (isAdmin) {

            while (true) {
                System.out.println("\nChoose option:");
                System.out.println("1.  Search Student");
                System.out.println("2.  Search Professor");
                System.out.println("3.  Add Department");
                System.out.println("4.  Add Professor");
                System.out.println("5.  Add Course");
                System.out.println("6.  Add Student");
                System.out.println("7.  Remove Department");
                System.out.println("8.  Remove Professor");
                System.out.println("9.  Remove Course");
                System.out.println("10. Remove Student");
                System.out.println("11. View University Overview");
                System.out.println("12. View All Departments");
                System.out.println("13. View All Professors");
                System.out.println("14. View All Students");
                System.out.println("15. View all courses");
                System.out.println("16. Save data to file");
                System.out.println("17. Exit");
                System.out.print("Enter choice (1 to 17): ");

                String choice = scanner.nextLine();

                if (choice.equals("1")) {
                    System.out.println("\nEnter student name to search: ");
                    String studentName = scanner.nextLine();
                    boolean found = false;
                    for (Department dept : university.getDepartments()) {
                        for (Student s : dept.getStudents()) {
                            if (s.getName().equalsIgnoreCase(studentName)) {
                                System.out.println("---------------------------------------------------");
                                System.out.println("Student " + studentName + " Found in " + dept.getName());
                                System.out.println("---------------------------------------------------");
                                found = true;
                            }
                        }
                    }
                    if (!found) {
                        System.out.println("Student " + studentName + " Not Found");
                    }

                } else if (choice.equals("2")) {
                    System.out.print("\nEnter professor name to search: ");
                    String profName = scanner.nextLine();
                    boolean found = false;
                    for (Department dept : university.getDepartments()) {
                        for (Professor p : dept.getProfessors()) {
                            if (p.getName().equalsIgnoreCase(profName)) {
                                System.out.println("---------------------------------------------------");
                                System.out.println("Professor " + profName + " Found in " + dept.getName());
                                System.out.println("---------------------------------------------------");
                                found = true;
                            }
                        }
                    }
                    if (!found) {
                        System.out.println("Professor " + profName + " Not Found");
                    }

} else if (choice.equals("3")) {
    System.out.print("\nEnter new department name: ");
    String newDeptName = scanner.nextLine();

    boolean exists = false;
    for (Department d : university.getDepartments()) {
        if (d.getName().equalsIgnoreCase(newDeptName)) {
            exists = true;
            break;
        }
    }

    if (exists) {
        System.out.println("Department already exists.");
    } else {
        university.addDepartment(newDeptName);
        System.out.println("Department '" + newDeptName + "' added successfully.");
    }

                } else if (choice.equals("4")) {
                    System.out.print("\nEnter department name to add professor: ");
                    String deptName = scanner.nextLine();
                    Department selectedDept = null;
                    for (Department d : university.getDepartments()) {
                        if (d.getName().equalsIgnoreCase(deptName)) {
                            selectedDept = d;
                            break;
                        }
                    }

                    if (selectedDept != null) {
                        System.out.print("Enter professor name: ");
                        String profName = scanner.nextLine();
                        System.out.print("Enter professor age: ");
                        int profAge = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter professor subject: ");
                        String subject = scanner.nextLine();

                        Professor newProf = new Professor(profName, profAge, subject);
                        selectedDept.addProfessor(newProf);
                        System.out.println("\nProfessor added to " + selectedDept.getName() + " department.");
                    } else {
                        System.out.println("\nDEPARTMENT NOT FOUND.");
                    }

                } else if (choice.equals("5")) {
                    for (Department d : university.getDepartments()) {
                        System.out.println("\nDepartment: " + d.getName());
                    }

                    System.out.print("\nEnter department name to add course: ");
                    String deptName = scanner.nextLine();
                    Department selectedDept = null;
                    for (Department d : university.getDepartments()) {
                        if (d.getName().equalsIgnoreCase(deptName)) {
                            selectedDept = d;
                            break;
                        }
                    }

                    if (selectedDept != null) {
                        System.out.print("\nEnter course code: ");
                        String code = scanner.nextLine();
                        System.out.print("\nEnter course title: ");
                        String title = scanner.nextLine();

                        Course newCourse = new Course(code, title);
                        selectedDept.addCourse(newCourse);
                        System.out.println("\nCourse added to department.");
                    } else {
                        System.out.println("\nDepartment not found.");
                    }

} else if (choice.equals("6")) {
    for (Department d : university.getDepartments()) {
        System.out.println("\nDepartment: " + d.getName());
    }

    System.out.print("Enter department name to add student: ");
    String deptName = scanner.nextLine();
    Department selectedDept = null;

    for (Department d : university.getDepartments()) {
        if (d.getName().equalsIgnoreCase(deptName)) {
            selectedDept = d;
            break;
        }
    }

    if (selectedDept != null) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = Integer.parseInt(scanner.nextLine());

        Student newStudent = new Student(name, age);
        selectedDept.addStudent(newStudent);

        if (!selectedDept.getCourses().isEmpty()) {
            System.out.println("Available courses in this department:");
            for (Course c : selectedDept.getCourses()) {
                System.out.println("- " + c.getTitle());
            }

            System.out.print("How many courses to enroll the student in? ");
            int courseCount = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < courseCount; i++) {
                System.out.print("Enter course title to enroll: ");
                String courseTitle = scanner.nextLine();
                Course matched = null;
                for (Course c : selectedDept.getCourses()) {
                    if (c.getTitle().equalsIgnoreCase(courseTitle)) {
                        matched = c;
                        break;
                    }
                }

                if (matched != null) {
                    newStudent.addCourse(matched);
                    System.out.println("\nEnrolled in: " + matched.getTitle());
                } else {
                    System.out.println("\nCourse not found.");
                }
            }
        } else {
            System.out.println("\nNo courses available in this department to enroll.");
        }

        System.out.println("\nStudent added to department.");
    } else {
        System.out.println("\nDepartment not found.");
    }


                } else if (choice.equals("7")) {
                    System.out.println("\nENTER DEPARTMENT NAME:");
                    String name = scanner.nextLine();
                    university.removeDepartmentByName(name); 

                } else if (choice.equals("8")) {
                    System.out.print("\nEnter department name: ");
                    String deptName = scanner.nextLine();
                    Department selectedDept = null;
                    for (Department d : university.getDepartments()) {
                        if (d.getName().equalsIgnoreCase(deptName)) {
                            selectedDept = d;
                            break;
                        }
                    }

                    if (selectedDept != null) {
                        System.out.print("\nEnter professor name to remove: ");
                        String profName = scanner.nextLine();
                        Professor toRemove = null;
                        for (Professor p : selectedDept.getProfessors()) {
                            if (p.getName().equalsIgnoreCase(profName)) {
                                toRemove = p;
                                break;
                            }
                        }
                        if (toRemove != null) {
                            selectedDept.removeProfessor(toRemove);
                            System.out.println("\nProfessor removed successfully.");
                        } else {
                            System.out.println("\nProfessor not found.");
                        }
                    } else {
                        System.out.println("\nDepartment not found.");
                    }

                } else if (choice.equals("9")) {
                    System.out.print("\nEnter department name: ");
                    String deptName = scanner.nextLine();
                    Department selectedDept = null;
                    for (Department d : university.getDepartments()) {
                        if (d.getName().equalsIgnoreCase(deptName)) {
                            selectedDept = d;
                            break;
                        }
                    }

                    if (selectedDept != null) {
                        System.out.print("\nEnter course title to remove: ");
                        String courseTitle = scanner.nextLine();
                        Course toRemove = null;
                        for (Course c : selectedDept.getCourses()) {
                            if (c.getTitle().equalsIgnoreCase(courseTitle)) {
                                toRemove = c;
                                break;
                            }
                        }

                        if (toRemove != null) {
                            selectedDept.removeCourse(toRemove);
                            System.out.println("\nCourse removed successfully.");
                        } else {
                            System.out.println("\nCourse not found.");
                        }
                    } else {
                        System.out.println("\nDepartment not found.");
                    }

                } else if (choice.equals("10")) {
    System.out.print("\nEnter department name: ");
    String deptName = scanner.nextLine();

    Department selectedDept = null;
    for (Department d : university.getDepartments()) {
        if (d.getName().equalsIgnoreCase(deptName)) {
            selectedDept = d;
            break;
        }
    }

    if (selectedDept != null) {
        System.out.print("\nEnter student name to remove: ");
        String studentName = scanner.nextLine();

        Student toRemove = null;
        for (Student s : selectedDept.getStudents()) {
            if (s.getName().equalsIgnoreCase(studentName)) {
                toRemove = s;
                break;
            }
        }

        if (toRemove != null) {
            selectedDept.removeStudent(toRemove);
            System.out.println("\nStudent removed successfully.");
        } else {
            System.out.println("\nStudent not found.");
        }
    } else {
        System.out.println("\nDepartment not found.");
    }
// Remove student logic
    } else if (choice.equals("11")) {
    // View University Overview
    System.out.println("\n===== UNIVERSITY OVERVIEW =====");
    university.displayInfo();

} else if (choice.equals("12")) {
    // View All Departments
    System.out.println("\n===== ALL DEPARTMENTS =====");
    for (Department d : university.getDepartments()) {
        d.displayInfo();
    }

} else if (choice.equals("13")) {
    // View All Professors
    System.out.println("\n===== ALL PROFESSORS =====");
    for (Department d : university.getDepartments()) {
        System.out.println("Department: " + d.getName());
        for (Professor p : d.getProfessors()) {
            p.displayInfo();
        }
    }

} else if (choice.equals("14")) {
    // View All Students
    System.out.println("\n===== ALL STUDENTS =====");
    for (Department d : university.getDepartments()) {
        System.out.println("Department: " + d.getName());
        for (Student s : d.getStudents()) {
            s.displayInfo();
        }
    }
    } else if (choice.equals("15")) {
    // View All Courses
    System.out.println("\n===== ALL COURSES =====");
    for (Department d : university.getDepartments()) {
        System.out.println("Department: " + d.getName());
        for (Course c : d.getCourses()) {
            c.displayInfo();  
        }
    }
                } else if (choice.equals("16")) {
                    saveDataToFile(university);
                    System.out.println("\n======= DATA SAVED =======");
                }else if (choice.equals("17")) {
                    System.out.println("\nExiting...");
                    break;
                } else {
                    System.out.println("\nInvalid input. Enter 1 to 15.");
                }
            } // end while
        } // end if isAdmin

        if(isUser){

            while(true){
         System.out.println("\n1. View University Overview");
        System.out.println("2. View All Departments");
        System.out.println("3. View All Professors");
        System.out.println("4. View All Students");
        System.out.println("5. View all courses");
        System.out.println("6. Save Data to file");
        System.out.println("7. Exit");
        System.out.print("\nEnter choice (1 to 7): ");

        String choice = scanner.nextLine();
        if(choice.equals("1")){
                // View University Overview
             System.out.println("\n===== UNIVERSITY OVERVIEW =====");
             university.displayInfo();
        }
        else if (choice.equals("2")) {
    // View All Departments
    System.out.println("\n===== ALL DEPARTMENTS =====");
    for (Department d : university.getDepartments()) {
        d.displayInfo();
    }
    } else if (choice.equals("3")) {
    // View All Professors
    System.out.println("\n===== ALL PROFESSORS =====");
    for (Department d : university.getDepartments()) {
        System.out.println("Department: " +d.getName()+"' ");
        for (Professor p : d.getProfessors()) {
            p.displayInfo();
        }
    }


    } else if (choice.equals("4")) {
    // View All Students
    System.out.println("\n===== ALL STUDENTS =====");
    for (Department d : university.getDepartments()) {
        System.out.println("Department: " + d.getName());
        for (Student s : d.getStudents()) {
            s.displayInfo();
        }
    }
    } else if (choice.equals("5")) {
    // View All Courses
    System.out.println("\n===== ALL COURSES =====");
    for (Department d : university.getDepartments()) {
        System.out.println("Department: " +d.getName());
        for (Course c : d.getCourses()) {
            c.displayInfo();  
        }
    }

                } else if (choice.equals("6")) {
                    saveDataToFile(university);
                    System.out.println("\n======= DATA SAVED =======");
                } else if (choice.equals("7")) {
                    System.out.println("\nExiting...");
                    break;
                }else {
                    System.out.println("\nInvalid input. Enter 1 to 6.");
                }
            }//loop true
            }//isuer
    } // end main
}
