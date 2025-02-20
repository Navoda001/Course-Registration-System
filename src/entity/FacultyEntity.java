package entity;

public class FacultyEntity {

    private String facultyId;
    private String facultyName;
    private String userName;
    private String contactInfo;
    private String facultyPassword;
    
    public FacultyEntity() {
    }

    public FacultyEntity(String facultyId, String facultyName, String userName, String contactInfo,
            String facultyPassword) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.userName = userName;
        this.contactInfo = contactInfo;
        this.facultyPassword = facultyPassword;
    }
    public FacultyEntity(String userName,String facultyPassword) {
        this.userName = userName;
        this.facultyPassword = facultyPassword;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getFacultyPassword() {
        return facultyPassword;
    }

    public void setFacultyPassword(String facultyPassword) {
        this.facultyPassword = facultyPassword;
    }
    @Override
    public String toString() {
        return "FacultyEntity [facultyId=" + facultyId + ", facultyName=" + facultyName + ", userName=" + userName
                + ", contactInfo=" + contactInfo + ", facultyPassword=" + facultyPassword + "]";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    
}
