package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StudentDashboardController {

    @FXML
    private Label lblStudentId;

    @FXML
    private Label lblStudentName;

    @FXML
    public void initialize() {
        lblStudentName.setText("John Doe");
        lblStudentId.setText("123456");
    }

}
