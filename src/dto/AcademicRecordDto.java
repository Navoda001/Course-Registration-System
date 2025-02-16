package dto;

public class AcademicRecordDto {

    private String studentId;
    private String courseId;
    private String semester;
    private String grade;
    
    public AcademicRecordDto() {
    }

    public AcademicRecordDto(String studentId, String courseId, String semester, String grade) {
        this.studentId = studentId;
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
        return "AcademicRecordDto [studentId=" + studentId + ", courseId=" + courseId + ", semester=" + semester
                + ", grade=" + grade + "]";
    }

    

}
