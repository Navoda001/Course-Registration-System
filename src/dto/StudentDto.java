package dto;

public class StudentDto {
    private String studentId;
    private String studentName;
    private String studentDOB;
    private String ProgramOfStudy;
    private String contactInfo;
    private String academicYear;
    private String studentPassword;

    public StudentDto() {
    }

    public StudentDto(String studentId, String studentName, String studentDOB, String programOfStudy,
            String contactInfo, String academicYear, String studentPassword) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentDOB = studentDOB;
        ProgramOfStudy = programOfStudy;
        this.contactInfo = contactInfo;
        this.academicYear = academicYear;
        this.studentPassword = studentPassword;
    }


    public String getStudentId() {
        return studentId;
    }



    public String getStudentName() {
        return studentName;
    }



    public String getStudentDOB() {
        return studentDOB;
    }



    public String getProgramOfStudy() {
        return ProgramOfStudy;
    }



    public String getContactInfo() {
        return contactInfo;
    }



    public String getAcademicYear() {
        return academicYear;
    }



    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }



    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }



    public void setStudentDOB(String studentDOB) {
        this.studentDOB = studentDOB;
    }



    public void setProgramOfStudy(String programOfStudy) {
        ProgramOfStudy = programOfStudy;
    }



    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }



    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }


    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    @Override
    public String toString() {
        return "StudentDto [studentId=" + studentId + ", studentName=" + studentName + ", studentDOB=" + studentDOB
                + ", ProgramOfStudy=" + ProgramOfStudy + ", contactInfo=" + contactInfo + ", academicYear="
                + academicYear + ", studentPassword=" + studentPassword + "]";
    }

    
}
