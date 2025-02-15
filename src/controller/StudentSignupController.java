package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    void btnStudentSignup(ActionEvent event) {
        System.out.println("Student Signup");
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
