package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class StudentRegisterNewCourseController {

    @FXML
    private Button btnCourseSearch;

    @FXML
    private AnchorPane registerForm;

    @FXML
    void btnCourseSearchOnAction(ActionEvent event) {
        System.out.println("Course Search");
    }

}
