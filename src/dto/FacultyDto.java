package dto;

public class FacultyDto {

    private String facultyId;
    private String facultyName;
    private String contactInfo;
    private String facultyPassword;

    public FacultyDto() {
    }
    
    public FacultyDto(String facultyId, String facultyName, String contactInfo, String facultyPassword) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.contactInfo = contactInfo;
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
        return "FacultyDto [facultyId=" + facultyId + ", facultyName=" + facultyName + ", contactInfo=" + contactInfo
                + ", facultyPassword=" + facultyPassword + "]";
    }

    
}
