package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EditEnrolmentController {

    @FXML
    private Button btnDrop;

    @FXML
    private Label lblCourseId;

    @FXML
    private Label lblCourseName;

    @FXML
    private Label lblErrorMessage;

    @FXML
    void btnDropOnAction(ActionEvent event) {
        System.out.println("Drop button clicked");
    }

}
