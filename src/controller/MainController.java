package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
        System.out.println("Customer Button clicked");
         Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AdminLogin.fxml"))));
        stage.show();
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
