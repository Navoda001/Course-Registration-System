package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class AdminLoginController {

    @FXML
    private AnchorPane adminLoginPage;

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
    void btnBackToMainOnAction(ActionEvent event) throws IOException {
    System.out.println("Back to main menu");
    adminLoginPage.getChildren().clear();
    Parent node = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
    adminLoginPage.getChildren().add(node);
    }

    @FXML
    void btnUserLoginOnAction(ActionEvent event) {
        System.out.println("login ");
        
    }

}
