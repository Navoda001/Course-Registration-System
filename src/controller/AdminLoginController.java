package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Rectangle;

public class AdminLoginController {

    @FXML
    private ToggleGroup Category;

    @FXML
    private RadioButton btnAdmin;

    @FXML
    private Button btnBack;

    @FXML
    private RadioButton btnFaculty;

    @FXML
    private Button btnLogin;

    @FXML
    private Rectangle checkShowPassword;

    @FXML
    private PasswordField txtHiddenPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void btnBackToMainOnAction(ActionEvent event) {
    System.out.println("Back to main menu");
    }

    @FXML
    void btnUserLoginOnAction(ActionEvent event) {
        System.out.println("login ");
    }

}
