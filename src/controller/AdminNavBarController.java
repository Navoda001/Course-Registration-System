package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
