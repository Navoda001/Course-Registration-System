package dto;

public class CoursesDto {
    private String courseId;
    private String courseTitle;
    private int creditHours;
    private String department;
    private String prerequisites;
    private int enrollmentCapacity;
    
    public CoursesDto() {
    }

    public CoursesDto(String courseId, String courseTitle, int creditHours, String department, String prerequisites,
            int enrollmentCapacity) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.creditHours = creditHours;
        this.department = department;
        this.prerequisites = prerequisites;
        this.enrollmentCapacity = enrollmentCapacity;
    }

    public CoursesDto(String courseTitle, int creditHours, String department, String prerequisites,
            int enrollmentCapacity) {
        this.courseTitle = courseTitle;
        this.creditHours = creditHours;
        this.department = department;
        this.prerequisites = prerequisites;
        this.enrollmentCapacity = enrollmentCapacity;
    }

    public CoursesDto(String courseId,String courseTitle){
        this.courseId = courseId;
        this.courseTitle=courseTitle;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public String getDepartment() {
        return department;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public int getEnrollmentCapacity() {
        return enrollmentCapacity;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public void setEnrollmentCapacity(int enrollmentCapacity) {
        this.enrollmentCapacity = enrollmentCapacity;
    }

    @Override
    public String toString() {
        return "CoursesDto [courseId=" + courseId + ", courseTitle=" + courseTitle + ", creditHours=" + creditHours
                + ", department=" + department + ", prerequisites=" + prerequisites + ", enrollmentCapacity="
                + enrollmentCapacity + "]";
    }
    
    
    
}
