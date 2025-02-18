package controller;

import java.io.IOException;

import dto.StudentDto;
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

    private String StudentName;
    private String studentId;

    public StudentNavBarController() {
        StudentLoginController s1 = new StudentLoginController();
        this.StudentName = s1.getStudentName();
        this.studentId = s1.getId();
    }

    @FXML
    public void initialize() throws IOException {

        lblStudentId.setText(studentId);
        lblStudentName.setText(StudentName);

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

    public AnchorPane getframe() {
        return mainFrame;
    }

    @FXML
    void btnSignOutOnAction(ActionEvent event) throws IOException {
        System.out.println("Sign Out");

        mainFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
        mainFrame.getChildren().add(node);
    }
}
