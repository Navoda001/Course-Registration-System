package controller;

import java.io.IOException;
import java.time.LocalDate;


import dto.StudentDto;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import service.custom.StudentService;
import service.custom.impl.StudentServiceImpl;

import javafx.util.Duration;
public class StudentSignupController {

    @FXML
    private AnchorPane studentSignupPage;

    @FXML
    private DatePicker txtBirthDate;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnSignup;

    @FXML
    private Label lblLogin;

    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    private TextField txtDateOfBirth;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtStudentName;

    @FXML
    private TextField txtUserName;

    @FXML
    private Label lblStudentSignupErrorMessage;

    public void initialize() throws IOException {
        lblStudentSignupErrorMessage.setText("");
    }

    @FXML
    void btnStudentSignup(ActionEvent event) throws IOException {
        // System.out.println("Student Signup");

        String studentName = txtStudentName.getText();
        String userName = txtUserName.getText();
        LocalDate stdDOB = txtBirthDate.getValue();
        String contactInfo = txtPhoneNumber.getText();
        String studentPassword = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();
        String studentDOB;
        studentDOB = stdDOB.toString();

        try {
            StudentDto studentDto = new StudentDto(studentName, userName, studentDOB, contactInfo, studentPassword);
            System.out.println(studentDto);
            // String saveStudent = StudentService.save(studentDto);

            if (studentName.equals("") || userName.equals("") || studentDOB.equals("") || contactInfo.equals("")
                    || studentPassword.equals("")
                    || confirmPassword.equals("")) {
                lblStudentSignupErrorMessage.setText("Please fill in all the required fields.");
            } else {
                if (!studentPassword.equals(confirmPassword)) {
                    lblStudentSignupErrorMessage.setText("Passwords do not match. Please try again.");
                } else {
                    StudentService studentService = new StudentServiceImpl();
                    String saveStudent = studentService.save(studentDto);
                    System.out.println(saveStudent);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("Signup Successful!");
                    alert.show();

                    // Close the alert after 10 milliseconds
                    PauseTransition delay = new PauseTransition(Duration.millis(3000));
                    delay.setOnFinished(actionEvent -> alert.close()); // Renamed 'event' to 'actionEvent'
                    delay.play();

                    studentSignupPage.getChildren().clear();
                    Parent node = FXMLLoader.load(getClass().getResource("../view/Logins/StudentLogin.fxml"));
                    studentSignupPage.getChildren().add(node);
                }
            }

        } catch (Exception e) {
            lblStudentSignupErrorMessage.setText("Username already taken. Please choose another.");

        }

    }

    @FXML
    void btnBackToMainOnAction(ActionEvent event) throws IOException {
        System.out.println("BACK TO MAIN");
        studentSignupPage.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
        studentSignupPage.getChildren().add(node);
    }

    @FXML
    void lblLoginOnAction(MouseEvent event) throws IOException {
        System.out.println("login");

        studentSignupPage.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Logins/StudentLogin.fxml"));
        studentSignupPage.getChildren().add(node);
    }

}
