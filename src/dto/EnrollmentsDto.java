package dto;

public class EnrollmentsDto {

    private String studentId;
    private String courseId;
    private String semester;
    private String enrollmentDate;
    
    public EnrollmentsDto() {
    }

    public EnrollmentsDto(String studentId, String courseId, String semester, String enrollmentDate) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.semester = semester;
        this.enrollmentDate = enrollmentDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "EnrollmentsDto [studentId=" + studentId + ", courseId=" + courseId + ", semester=" + semester
                + ", enrollmentDate=" + enrollmentDate + "]";
    }
    
}
