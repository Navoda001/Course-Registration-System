package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class StudentNavBarController {

    @FXML
    private Button btnAcademicRecord;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnEditAccountInfo;

    @FXML
    private Button btnEnrolmentsHistory;

    @FXML
    private Button btnRegisterNewCourse;

    @FXML
    private Label lblStudentId;

    @FXML
    private Label lblStudentName;

    @FXML
    private AnchorPane studentFrame;

    @FXML
    public void initialize() throws IOException {
        lblStudentName.setText("John Doe");
        lblStudentId.setText("123456");

        studentFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Student/Dashboard.fxml"));
        studentFrame.getChildren().add(node);
    }

    @FXML
    void btnAcademicRecordOnAction(ActionEvent event) {
        System.out.println("Academic Record");
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        System.out.println("Dashboard");
        studentFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Student/Dashboard.fxml"));
        studentFrame.getChildren().add(node);
    }

    @FXML
    void btnEditAccountInfoOnAction(ActionEvent event) {
        System.out.println("Edit Account Info");
    }

    @FXML
    void btnEnrolmentsHistoryOnAction(ActionEvent event) {
        System.out.println("Enrolments History");
    }

    @FXML
    void btnRegisterNewCourseOnAction(ActionEvent event) throws IOException {
        System.out.println("Register New Course");
        studentFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Student/RegisterNewCourse.fxml"));
        studentFrame.getChildren().add(node);
    }

}
