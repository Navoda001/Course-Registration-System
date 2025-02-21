package entity;

public class AcademicRecordEntity {

    private String studentId;
    private String courseId;
    private String semester;
    private String grade;
    
    public AcademicRecordEntity() {
    }

    public AcademicRecordEntity(String studentId, String courseId, String semester, String grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.semester = semester;
        this.grade = grade;
    }

    public AcademicRecordEntity(String courseId, String semester, String grade) {
        this.courseId = courseId;
        this.semester = semester;
        this.grade = grade;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "AcademicRecordEntity [studentId=" + studentId + ", courseId=" + courseId + ", semester=" + semester
                + ", grade=" + grade + "]";
    }

    
}
