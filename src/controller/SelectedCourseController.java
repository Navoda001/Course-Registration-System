package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class SelectedCourseController {

    @FXML
    private Button btnEnrollNow;

    @FXML
    private RadioButton btnPrerequisitesNo;

    @FXML
    private RadioButton btnPrerequisitesYes;

    @FXML
    private Label lblCourseId;

    @FXML
    private Label lblCourseName;

    @FXML
    private Label lblCreditHours;

    @FXML
    private Label lblDepartmentName;

    @FXML
    private Label lblPrerequisitesDescription;

    @FXML
    private Label lblPrerequisitesErrorMessage;

    @FXML
    private ToggleGroup prerequisites;

    @FXML
    void btnEnrollNowOnAction(ActionEvent event) {
        System.out.println("Enroll Now button clicked");
    }

}
