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
    private AnchorPane mainFrame;

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
    private Button btnSignOut;

    @FXML
    public void initialize() throws IOException {
        lblStudentName.setText("John Doe");
        lblStudentId.setText("123456");

        studentFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Student/Dashboard.fxml"));
        studentFrame.getChildren().add(node);
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        System.out.println("Dashboard");
        studentFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Student/Dashboard.fxml"));
        studentFrame.getChildren().add(node);
    }

    @FXML
    void btnRegisterNewCourseOnAction(ActionEvent event) throws IOException {
        System.out.println("Register New Course");
        studentFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Student/RegisterNewCourse.fxml"));
        studentFrame.getChildren().add(node);
    }

    @FXML
    void btnEnrolmentsHistoryOnAction(ActionEvent event) throws IOException {
        System.out.println("Enrolments History");
        studentFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Student/EnrolmentHistory.fxml"));
        studentFrame.getChildren().add(node);
    }

    @FXML
    void btnAcademicRecordOnAction(ActionEvent event) throws IOException {
        System.out.println("Academic Record");
        studentFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Student/AcademicRecord.fxml"));
        studentFrame.getChildren().add(node);
    }

    @FXML
    void btnEditAccountInfoOnAction(ActionEvent event) throws IOException {
        System.out.println("Edit Account Info");
        studentFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Student/EditProfile.fxml"));
        studentFrame.getChildren().add(node);
    }

    @FXML
    void btnSignOutOnAction(ActionEvent event) throws IOException {
        System.out.println("Sign Out");
        mainFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
        mainFrame.getChildren().add(node);
    }
}
