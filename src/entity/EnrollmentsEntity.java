package entity;

public class EnrollmentsEntity {

    private String studentId;
    private String courseId;
    private String semester;
    private String enrollmentDate;
    private int academicYear;
    
    public EnrollmentsEntity() {
    }

    public EnrollmentsEntity(String studentId, String courseId, String semester, String enrollmentDate,
            int academicYear) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.semester = semester;
        this.enrollmentDate = enrollmentDate;
        this.academicYear = academicYear;
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

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    @Override
    public String toString() {
        return "EnrollmentsEntity [studentId=" + studentId + ", courseId=" + courseId + ", semester=" + semester
                + ", enrollmentDate=" + enrollmentDate + ", academicYear=" + academicYear + "]";
    }

    
}
