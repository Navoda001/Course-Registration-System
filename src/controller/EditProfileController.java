package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class EditProfileController {

    @FXML
    private Button btnChangePassword;

    @FXML
    private Button btnUpdateStudentInfo;

    @FXML
    private Label lblChangePasswordError;

    @FXML
    private Label lblUpdateErrorMessage;

    @FXML
    private DatePicker txtBirthDate;

    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    private PasswordField txtCurrentPassword;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtStudentName;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnChangePasswordOnAction(ActionEvent event) {
        System.out.println("Change Password");
    }

    @FXML
    void btnUpdateStudentInfoOnAction(ActionEvent event) {
        System.out.println("Change Student Info");
    }

}
