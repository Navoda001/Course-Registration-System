package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainController {

    @FXML
    private Button btnAdminLogin;

    @FXML
    private Button btnStudentLogin;

    @FXML
    private Button btnStudentSignup;

    @FXML
    private AnchorPane mainPage;

    @FXML
    void btnAdminLoginOnAction(ActionEvent event) {
        System.out.println("Admin Login");
    }

    @FXML
    void btnStudentLogin(ActionEvent event) {
            System.out.println("Student Login");
    }

    @FXML
    void btnStudentSignup(ActionEvent event) {
        System.out.println("Student Signup");
    }

}
