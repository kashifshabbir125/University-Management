import java.util.ArrayList;

public class University implements Functional<University> {
    private String name;
    private ArrayList<Department> departments;

    public University(String name, ArrayList<String> deptNames) {
        this.name = name;
        this.departments = new ArrayList<>();
        for (String d : deptNames) {
            departments.add(new Department(d));
        }
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }
public void removeDepartmentByName(String deptName) {
    Department toRemove = null;
    for (Department d : departments) {
        if (d.getName().equalsIgnoreCase(deptName)) {
            toRemove = d;
            break;
        }
    }

    if (toRemove != null) {
        departments.remove(toRemove);
        System.out.println("Department removed successfully.");
    } else {
        System.out.println("Department not found.");
    }
}
public void addDepartment(String deptName) {
    Department newDept = new Department(deptName);
    departments.add(newDept);
}

public String getName() {
    return name;
}




    @Override
    public void displayInfo() {
        System.out.println("\nUniversity Name: " + name + ", Departments: " + departments.size());
    }
}
