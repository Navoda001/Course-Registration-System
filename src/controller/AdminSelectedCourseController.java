package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdminSelectedCourseController {

    @FXML
    private Button btnDeleteCourse;

    @FXML
    private Button btnUpdateCourse;

    @FXML
    private Label lblCourseId;

    @FXML
    private Label lblUpdateCourseErrorMessage;

    @FXML
    private TextField txtCapacity;

    @FXML
    private TextField txtCourseName;

    @FXML
    private TextField txtCreditHours;

    @FXML
    private TextField txtDepartment;

    @FXML
    private TextField txtPrerequisites;

    @FXML
    void btnDeleteCourseOnAction(ActionEvent event) {
        System.out.println("Delete Course");
    }

    @FXML
    void btnUpdateCourseOnAction(ActionEvent event) {
        System.out.println("Update Course");
    }

}
