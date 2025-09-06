public class Course implements Functional<Course> {
    private String code;
    private String title;

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
    return code;
}

public String getTitle() {
    return title;
}


    @Override
    public void displayInfo() {
        System.out.println("Course Code: " + code + ", Title: " + title);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Course) {
            Course c = (Course) obj;
            return this.title.equals(c.title);
        }
        return false;
    }

    @Override
    public String toString() {
        return title;
    }
}
