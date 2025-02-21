package controller;

import dto.AdminDto;
import dto.FacultyDto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class AdminDashboard {

    @FXML
    private Label lblAdminId;

    @FXML
    private Label lblAdminName;

    private static AdminDto adminDto;

    private static FacultyDto facultyDto;

    private String role;

    @FXML
    public void initialize() {

        AdminLoginController a1 = new AdminLoginController();
        role = a1.getrole();
        facultyDto = a1.geFacultyDto();
        adminDto = a1.geAdminDto();

        if (role.equals("Faculty")) {
            lblAdminName.setText(facultyDto.getFacultyName());
            lblAdminId.setText("F"+facultyDto.getFacultyId());
        }
        if(role.equals("Admin")){
            lblAdminName.setText(adminDto.getAdminName());
            lblAdminId.setText("A"+adminDto.getAdminId());
        }
    }

}
