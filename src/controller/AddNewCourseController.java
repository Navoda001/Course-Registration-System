package controller;

import dto.CoursesDto;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import service.custom.CoursesService;
import service.custom.impl.CoursesServiceImpl;

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

    public void initialize() {
        lblAddCourseErrorMessage.setText("");
    }

    @FXML
    void btnNewCourseAddOnAction(ActionEvent event) throws Exception {
        System.out.println("Add New Course");
        String courseName = txtCourseName.getText();
        String creditHoursText = txtCreditHours.getText();
        String department = txtDepartment.getText();
        String prerequisites = txtPrerequisites.getText();
        String enrollmentCapacityText = txtCapacity.getText();

        if (courseName.equals("") || creditHoursText.equals("") || department.equals("") || prerequisites.equals("")
                || enrollmentCapacityText.equals("")) {
            lblAddCourseErrorMessage.setText("Please Enter course details.");
        } else {
            int creditHours = Integer.parseInt(txtCreditHours.getText());
            int enrollmentCapacity = Integer.parseInt(txtCapacity.getText());

            CoursesDto coursesDto = new CoursesDto(courseName, creditHours, department, prerequisites,
                    enrollmentCapacity);
            System.out.println(coursesDto);

            CoursesService coursesService = new CoursesServiceImpl();
            String courseSave = coursesService.save(coursesDto);

            System.out.println(courseSave);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Course Saved Successfully!");
            alert.show();

            // Close the alert after 10 milliseconds
            PauseTransition delay = new PauseTransition(Duration.millis(3000));
            delay.setOnFinished(actionEvent -> alert.close()); // Renamed 'event' to 'actionEvent'
            delay.play();
            lblAddCourseErrorMessage.setText("");
        }
    }

}
