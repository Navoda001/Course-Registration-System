package dto;

public class StudentDto {
    private String studentId;
    private String studentName;
    private String userName;
    private String studentDOB;
    private String contactInfo;
    private String studentPassword;

    public StudentDto() {
    }

    public StudentDto(String studentId, String studentName, String userName, String studentDOB, String contactInfo,
            String studentPassword) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.userName = userName;
        this.studentDOB = studentDOB;
        this.contactInfo = contactInfo;
        this.studentPassword = studentPassword;
    }

    public StudentDto( String studentName, String userName, String studentDOB, String contactInfo,
            String studentPassword) {
        this.studentName = studentName;
        this.userName = userName;
        this.studentDOB = studentDOB;
        this.contactInfo = contactInfo;
        this.studentPassword = studentPassword;
    }

    public StudentDto(String userName,String studentPassword) {
        this.userName = userName;
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

    public String getContactInfo() {
        return contactInfo;
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

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "StudentDto [studentId=" + studentId + ", studentName=" + studentName + ", userName=" + userName
                + ", studentDOB=" + studentDOB + ", contactInfo=" + contactInfo + ", studentPassword=" + studentPassword
                + "]";
    }

}
