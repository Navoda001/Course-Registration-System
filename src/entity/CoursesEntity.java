package entity;

public class CoursesEntity {

    private String courseId;
    private String courseTitle;
    private int creditHours;
    private String department;
    private String prerequisites;
    private int enrollmentCapacity;
    
    public CoursesEntity() {
    }

    public CoursesEntity(String courseId, String courseTitle, int creditHours, String department, String prerequisites,
            int enrollmentCapacity) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.creditHours = creditHours;
        this.department = department;
        this.prerequisites = prerequisites;
        this.enrollmentCapacity = enrollmentCapacity;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public int getEnrollmentCapacity() {
        return enrollmentCapacity;
    }

    public void setEnrollmentCapacity(int enrollmentCapacity) {
        this.enrollmentCapacity = enrollmentCapacity;
    }

    @Override
    public String toString() {
        return "CoursesEntity [courseId=" + courseId + ", courseTitle=" + courseTitle + ", creditHours=" + creditHours
                + ", department=" + department + ", prerequisites=" + prerequisites + ", enrollmentCapacity="
                + enrollmentCapacity + "]";
    }

    
}
