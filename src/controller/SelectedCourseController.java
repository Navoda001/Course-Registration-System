package controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import dto.CoursesDto;
import dto.EnrollmentsDto;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import service.custom.CoursesService;
import service.custom.EnrollmentService;
import service.custom.impl.CoursesServiceImpl;
import service.custom.impl.EnrollmentServiceImpl;

public class SelectedCourseController {

    @FXML
    private AnchorPane selectCourseFrame;

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

    private  String  courseId;
    private String studentId;

    public void initialize() throws Exception {
        StudentRegisterNewCourseController reg1 = new StudentRegisterNewCourseController();
        this.courseId = reg1.getcourseId();
        StudentLoginController s1 = new StudentLoginController();
        this.studentId = s1.getId();
        CoursesService coursesService = new CoursesServiceImpl();
        CoursesDto coursesDto = coursesService.search(courseId);
        lblCourseId.setText(coursesDto.getCourseId());
        lblCourseName.setText(coursesDto.getCourseTitle());
        lblCreditHours.setText(String.valueOf(coursesDto.getCreditHours()));
        lblDepartmentName.setText(coursesDto.getDepartment());
        lblPrerequisitesDescription.setText(coursesDto.getPrerequisites());
        lblPrerequisitesErrorMessage.setText("");

    }

    @FXML
    void btnEnrollNowOnAction(ActionEvent event) throws Exception {
        System.out.println("Enroll Now button clicked");
        if (btnPrerequisitesYes.isSelected()) {
            CoursesService coursesService = new CoursesServiceImpl();
            CoursesDto coursesDto = coursesService.search(courseId);
            int enrollmentCapacity = coursesDto.getEnrollmentCapacity();

            if (enrollmentCapacity != 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(new Date());

                int month = LocalDate.now().getMonthValue();
                int semester = (month - 1) / 3 + 1;

                EnrollmentsDto enrollmentDto = new EnrollmentsDto(studentId, courseId, String.valueOf(semester), date,
                        "1");
                try {

                    System.out.println(enrollmentCapacity);

                    EnrollmentService enrollmentService = new EnrollmentServiceImpl();
                    String saveEnrollment = enrollmentService.save(enrollmentDto);
                    System.out.println(saveEnrollment);

                    if (saveEnrollment.equals("Success")) {
                        enrollmentCapacity = enrollmentCapacity - 1;

                        CoursesService coursesService2 = new CoursesServiceImpl();
                        String courseUpdate = coursesService2.saveAfterEnroll(courseId, enrollmentCapacity);
                        System.out.println(courseUpdate);

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Success");
                        alert.setHeaderText(null);
                        alert.setContentText("Enrollment Successfully!");
                        alert.show();

                        // Close the alert after 10 milliseconds
                        PauseTransition delay = new PauseTransition(Duration.millis(3000));
                        delay.setOnFinished(actionEvent -> alert.close()); // Renamed 'event' to 'actionEvent'
                        delay.play();

                        Label successLabel = new Label("Enrollment Successful!");
                        successLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: green;");

                        selectCourseFrame.getChildren().clear();
                        selectCourseFrame.getChildren().add(successLabel);
                        AnchorPane.setTopAnchor(successLabel, 50.0);
                        AnchorPane.setLeftAnchor(successLabel, 50.0);

                    } else {
                        lblPrerequisitesErrorMessage.setText("Error: Failed to save the enrollment. Please try again.");
                    }
                } catch (Exception e) {
                    lblPrerequisitesErrorMessage.setText("Already enroll this Course");
                }
            } else {
                lblPrerequisitesErrorMessage.setText(
                        "Error: You cannot enroll in this course because the enrollment capacity has been reached.");
            }

        } else if (btnPrerequisitesNo.isSelected()) {
            lblPrerequisitesErrorMessage.setText("You can't enroll in this course.");

        } else {
            System.out.println("No option selected");
        }
    }

}
