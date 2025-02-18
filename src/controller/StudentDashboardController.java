package controller;

import java.nio.channels.Pipe.SourceChannel;

import dto.StudentDto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StudentDashboardController {

    @FXML
    private Label lblStudentId;

    @FXML
    private Label lblStudentName;

    private String studentUserName;
    private String studentId;
    
    public StudentDashboardController(){
        StudentLoginController s1 = new StudentLoginController();
        this.studentUserName=s1.getUserName();
        this.studentId=s1.getId();
    }

    @FXML
    public void initialize() {
        lblStudentName.setText(studentUserName);
        lblStudentId.setText(studentId);
    }
}
