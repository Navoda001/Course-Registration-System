package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StudentDashboardController {

    @FXML
    private Label lblStudentId;

    @FXML
    private Label lblStudentName;

    private String studentName;
    private String studentId;
    
    public StudentDashboardController(){
        StudentLoginController s1 = new StudentLoginController();
        this.studentName=s1.getStudentName();
        this.studentId=s1.getId();
    }

    @FXML
    public void initialize() {
        lblStudentName.setText(studentName);
        lblStudentId.setText(studentId);
    }
}
