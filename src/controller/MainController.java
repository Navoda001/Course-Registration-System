package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
    void btnAdminLoginOnAction(ActionEvent event) throws IOException {
        System.out.println("Admin/Faculty Button clicked");
        mainPage.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Logins/AdminLogin.fxml"));
        mainPage.getChildren().add(node);
    }

    @FXML
    void btnStudentLogin(ActionEvent event) throws IOException {
            System.out.println("Student Login");
            mainPage.getChildren().clear();
            Parent node2 = FXMLLoader.load(getClass().getResource("../view/Logins/StudentLogin.fxml"));
            mainPage.getChildren().add(node2);
    }

    @FXML
    void btnStudentSignup(ActionEvent event)  throws IOException {
            mainPage.getChildren().clear();
            Parent node3 = FXMLLoader.load(getClass().getResource("../view/Signup/StudentSignup.fxml"));
            mainPage.getChildren().add(node3);

    }

}
