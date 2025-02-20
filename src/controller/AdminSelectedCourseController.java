package controller;

import dto.CoursesDto;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import service.custom.CoursesService;
import service.custom.impl.CoursesServiceImpl;

public class AdminSelectedCourseController {

    @FXML
    private AnchorPane selectedCourseFrame;

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

    private String courseId;

    public void initialize() throws Exception {
        EditCourseController e1 = new EditCourseController();
        courseId = e1.getcourseId();
        CoursesService coursesService = new CoursesServiceImpl();
        CoursesDto coursesDto = coursesService.search(courseId);
        lblCourseId.setText("Course Id : C" + coursesDto.getCourseId());
        txtCourseName.setText(coursesDto.getCourseTitle());
        txtCreditHours.setText(String.valueOf(coursesDto.getCreditHours()));
        txtDepartment.setText(coursesDto.getDepartment());
        txtPrerequisites.setText(coursesDto.getPrerequisites());
        txtCapacity.setText(String.valueOf(coursesDto.getCreditHours()));
        lblUpdateCourseErrorMessage.setText("Please Enter Integer values for credit hours and capacity.");

    }

    @FXML
    void btnDeleteCourseOnAction(ActionEvent event) throws Exception {
        System.out.println("Delete Course");
        CoursesService coursesService = new CoursesServiceImpl();
        String deletCourse = coursesService.Delete(courseId);
        System.out.println(deletCourse);

        if (deletCourse.equals("Success")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Course deleted Successfully!");
            alert.show();

            // Close the alert after 10 milliseconds
            PauseTransition delay = new PauseTransition(Duration.millis(3000));
            delay.setOnFinished(actionEvent -> alert.close()); // Renamed 'event' to 'actionEvent'
            delay.play();

            Label successLabel = new Label("Course deleted. please refresh the page.");
            successLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: green;");

            selectedCourseFrame.getChildren().clear();
            selectedCourseFrame.getChildren().add(successLabel);
            AnchorPane.setTopAnchor(successLabel, 50.0);
            AnchorPane.setLeftAnchor(successLabel, 50.0);

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error");
            alert.show();

            // Close the alert after 10 milliseconds
            PauseTransition delay = new PauseTransition(Duration.millis(3000));
            delay.setOnFinished(actionEvent -> alert.close()); // Renamed 'event' to 'actionEvent'
            delay.play();
        }

    }

    @FXML
    void btnUpdateCourseOnAction(ActionEvent event) {
        System.out.println("Update Course");
        String courseName = txtCourseName.getText();
        String creditHoursText = txtCreditHours.getText();
        String department = txtDepartment.getText();
        String prerequisites = txtPrerequisites.getText();
        String enrollmentCapacityText = txtCapacity.getText();

        if (courseName.equals("") || creditHoursText.equals("") || department.equals("") || prerequisites.equals("")
                || enrollmentCapacityText.equals("")) {
            lblUpdateCourseErrorMessage.setText("Please Enter course details.");
        } else {
            int creditHours = Integer.parseInt(txtCreditHours.getText());
            int enrollmentCapacity = Integer.parseInt(txtCapacity.getText());

            try {
                CoursesDto coursesDto = new CoursesDto(courseName, creditHours, department, prerequisites,
                        enrollmentCapacity);
                System.out.println(coursesDto);

                CoursesService coursesService = new CoursesServiceImpl();
                String courseSave = coursesService.save(coursesDto);

                System.out.println(courseSave);

                if (courseSave.equals("Success")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Course Updated Successfully!");
                alert.show();

                // Close the alert after 10 milliseconds
                PauseTransition delay = new PauseTransition(Duration.millis(3000));
                delay.setOnFinished(actionEvent -> alert.close()); // Renamed 'event' to 'actionEvent'
                delay.play();
                lblUpdateCourseErrorMessage.setText("");
                Label successLabel = new Label("Course Updated.");
                successLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: green;");

                selectedCourseFrame.getChildren().clear();
                selectedCourseFrame.getChildren().add(successLabel);
                AnchorPane.setTopAnchor(successLabel, 50.0);
                AnchorPane.setLeftAnchor(successLabel, 50.0);
                }else{
                    lblUpdateCourseErrorMessage.setText("Error");
                }
            } catch (Exception e) {
                lblUpdateCourseErrorMessage.setText("Unknown Error");
            }
        }
    }

}
