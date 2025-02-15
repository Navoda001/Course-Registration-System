package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddNewCourseController {

    @FXML
    private Button btnNewCourseAdd;

    @FXML
    private Label lblAddCourseErrorMessage;

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
    void btnNewCourseAddOnAction(ActionEvent event) {
        System.out.println("Add New Course");
    }

}
