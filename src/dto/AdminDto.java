package dto;

public class AdminDto {

    private String adminId;
    private String adminName;
    private String userName;
    private String facultyId;
    private String department;
    private String contactInfo;
    private String adminPassword;

    public AdminDto() {
    }

    

    public AdminDto(String adminId, String adminName, String userName, String facultyId, String department,
            String contactInfo, String adminPassword) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.userName = userName;
        this.facultyId = facultyId;
        this.department = department;
        this.contactInfo = contactInfo;
        this.adminPassword = adminPassword;
    }



    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getDepartment() {
        return department;
    }

    public String getUserName() {
        return userName;
    }



    public void setUserName(String userName) {
        this.userName = userName;
    }



    public void setDepartment(String department) {
        this.department = department;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }



    @Override
    public String toString() {
        return "AdminDto [adminId=" + adminId + ", adminName=" + adminName + ", userName=" + userName + ", facultyId="
                + facultyId + ", department=" + department + ", contactInfo=" + contactInfo + ", adminPassword="
                + adminPassword + "]";
    }

     

    
}
