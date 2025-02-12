package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class StudentLoginController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblSignUp;

    @FXML
    private PasswordField txtHiddenPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void btnBackToMainOnAction(ActionEvent event) {
        System.out.println("BACK TO MAIN");
    }

    @FXML
    void btnUserLoginOnAction(ActionEvent event) {
        System.out.println("STUDENT LOGIN");
    }

    @FXML
    void lblSignupOnAction(MouseEvent event) {
        System.out.println("Signup");
    }

}
