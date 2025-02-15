package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class StudentLoginController {

    @FXML
    private AnchorPane StudentLoginPage;

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
    private Label lblStudentLoginErrorMessage;

    @FXML
    void btnBackToMainOnAction(ActionEvent event) throws IOException{
        System.out.println("BACK TO MAIN");
        StudentLoginPage.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
        StudentLoginPage.getChildren().add(node);
    }

    @FXML
    void btnUserLoginOnAction(ActionEvent event) throws IOException {
        System.out.println("STUDENT LOGIN");
        StudentLoginPage.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/StudentNavBar.fxml"));
        StudentLoginPage.getChildren().add(node);
    }

    @FXML
    void lblSignupOnAction(MouseEvent event) throws IOException {
        System.out.println("Signup");
        StudentLoginPage.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Signup/StudentSignup.fxml"));
        StudentLoginPage.getChildren().add(node);
    }

}
