package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class StudentRegisterNewCourseController {

    @FXML
    private Button btnCourseSearch;

    @FXML
    private AnchorPane registerForm;

    @FXML
    void btnCourseSearchOnAction(ActionEvent event) throws IOException {
        System.out.println("Course Search");
        registerForm.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Student/SelectedCourse.fxml"));
        registerForm.getChildren().add(node);
    }

}
