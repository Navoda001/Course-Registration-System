package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
        System.out.println("Admin/Faculty Button clicked");
        //  Stage stage = new Stage();
        // stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/Logins/AdminLogin.fxml"))));
        // stage.show();
        mainPage.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Logins/AdminLogin.fxml"));
        mainPage.getChildren().add(node);
    }

    @FXML
    void btnStudentLogin(ActionEvent event) throws IOException {
            System.out.println("Student Login");
            // Stage stage = new Stage();
            // stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/Logins/StudentLogin.fxml"))));
            // stage.show();
            mainPage.getChildren().clear();
            Parent node2 = FXMLLoader.load(getClass().getResource("../view/Logins/StudentLogin.fxml"));
            mainPage.getChildren().add(node2);
    }

    @FXML
    void btnStudentSignup(ActionEvent event)  throws IOException {
        // Stage stage = new Stage();
        // stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/Signup/StudentSignup.fxml"))));
        // stage.show();
            mainPage.getChildren().clear();
            Parent node3 = FXMLLoader.load(getClass().getResource("../view/Signup/StudentSignup.fxml"));
            mainPage.getChildren().add(node3);

    }

}
