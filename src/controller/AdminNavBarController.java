package controller;

import java.io.IOException;

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
    private Label lblStudentId;

    @FXML
    private Label lblStudentName;

    @FXML
    private Label lblrolle;

    @FXML
    public void initialize() throws IOException {
        lblStudentName.setText("John Doe");
        lblStudentId.setText("123456");

        AdminFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Admin/Dashboard.fxml"));
        AdminFrame.getChildren().add(node);
    }


    @FXML
    void btnAddNewCourseOnAction(ActionEvent event) {
        System.out.println("Add New Course");   
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {
        System.out.println("Dashboard");
    }

    @FXML
    void btnEditCourseOnAction(ActionEvent event) {
        System.out.println("Edit Course");
    }

    @FXML
    void btnReportsOnAction(ActionEvent event) {
        System.out.println("Reports");
    }

    @FXML
    void btnSignOutOnAction(ActionEvent event) {
        System.out.println("Sign Out");
    }

}
