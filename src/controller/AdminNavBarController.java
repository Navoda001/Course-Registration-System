package controller;

import java.io.IOException;

import dto.AdminDto;
import dto.FacultyDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class AdminNavBarController {

    @FXML
    private AnchorPane AdminFrame;

    @FXML
    private Button btnAddNewCourse;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnEditCourse;

    @FXML
    private Button btnReports;

    @FXML
    private Button btnSignOut;

    @FXML
    private Label lblAdminId;

    @FXML
    private Label lblAdminName;

    @FXML
    private Label lblContactInfo;

    @FXML
    private Label lblrolle;

    @FXML
    private AnchorPane mainFrame;

    private static AdminDto adminDto;

    private static FacultyDto facultyDto;

    private String role;

    @FXML
    public void initialize() throws IOException {

        AdminLoginController a1 = new AdminLoginController();
        role = a1.getrole();
        facultyDto = a1.geFacultyDto();
        adminDto = a1.geAdminDto();

        lblrolle.setText(role);

System.out.println(facultyDto);
System.out.println(adminDto);


        if (role.equals("Faculty")) {
            lblAdminName.setText(facultyDto.getFacultyName());
            lblAdminId.setText("F"+facultyDto.getFacultyId());
            lblContactInfo.setText(facultyDto.getContactInfo());
        }
        if(role.equals("Admin")){
            lblAdminName.setText(adminDto.getAdminName());
            lblAdminId.setText("A"+adminDto.getAdminId());
            lblContactInfo.setText(adminDto.getContactInfo());
        }

        AdminFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Admin/Dashboard.fxml"));
        AdminFrame.getChildren().add(node);

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        System.out.println("Dashboard");
        AdminFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Admin/Dashboard.fxml"));
        AdminFrame.getChildren().add(node);
    }

    @FXML
    void btnAddNewCourseOnAction(ActionEvent event) throws IOException {
        System.out.println("Add New Course");
        AdminFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Admin/AddNewCourse.fxml"));
        AdminFrame.getChildren().add(node);
    }

    @FXML
    void btnEditCourseOnAction(ActionEvent event) throws IOException {
        System.out.println("Edit Course");
        AdminFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Admin/EditCourse.fxml"));
        AdminFrame.getChildren().add(node);
    }

    @FXML
    void btnReportsOnAction(ActionEvent event) throws IOException {
        System.out.println("Reports");
        AdminFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Admin/Reports.fxml"));
        AdminFrame.getChildren().add(node);
    }

    @FXML
    void btnSignOutOnAction(ActionEvent event) throws IOException {
        System.out.println("Sign Out");
        mainFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
        mainFrame.getChildren().add(node);
    }

}
