package controller;

import dto.CoursesDto;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import service.custom.CoursesService;
import service.custom.EnrollmentService;
import service.custom.impl.CoursesServiceImpl;
import service.custom.impl.EnrollmentServiceImpl;

public class EditEnrolmentController {

    @FXML
    private AnchorPane editEnrollmentFrame;

    @FXML
    private Button btnDrop;

    @FXML
    private Label lblCourseId;

    @FXML
    private Label lblCourseName;

    @FXML
    private Label lblErrorMessage;

    private String courseId;
    private String studentId;

    public EditEnrolmentController() {
        EnrolmentHistoryController e1 = new EnrolmentHistoryController();
        courseId = e1.getCourseId();
        StudentLoginController s1 = new StudentLoginController();
        studentId = s1.getId();
        System.out.println(courseId);
    }

    public void initialize() throws Exception {
        CoursesService coursesService = new CoursesServiceImpl();
        CoursesDto coursesDto = coursesService.search(courseId);

        lblCourseId.setText(courseId);
        lblCourseName.setText(coursesDto.getCourseTitle());
        lblErrorMessage.setText("");
    }

    @FXML
    void btnDropOnAction(ActionEvent event) throws Exception {
        System.out.println("Drop button clicked");
        EnrollmentService enrollmentService = new EnrollmentServiceImpl();
        String delete = enrollmentService.Delete(studentId, courseId);
        System.out.println(delete);
        if (delete.equals("Success")) {

            CoursesService coursesService = new CoursesServiceImpl();
            CoursesDto coursesDto = coursesService.search(courseId);
            int enrollmentCapacity = coursesDto.getEnrollmentCapacity();
            enrollmentCapacity = enrollmentCapacity + 1;
            CoursesService coursesService2 = new CoursesServiceImpl();
            String courseUpdate = coursesService2.saveAfterEnroll(courseId, enrollmentCapacity);
            System.out.println(courseUpdate);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Enrollment delete Successfully!");
            alert.show();

            // Close the alert after 10 milliseconds
            PauseTransition delay = new PauseTransition(Duration.millis(3000));
            delay.setOnFinished(actionEvent -> alert.close()); // Renamed 'event' to 'actionEvent'
            delay.play();

            Label successLabel = new Label("Enrollment removed!! Please refresh the page ");
            successLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: green;");

            editEnrollmentFrame.getChildren().clear();
            editEnrollmentFrame.getChildren().add(successLabel);
            AnchorPane.setTopAnchor(successLabel, 50.0);
            AnchorPane.setLeftAnchor(successLabel, 50.0);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Enrollment delete Error!");
            alert.show();

            // Close the alert after 10 milliseconds
            PauseTransition delay = new PauseTransition(Duration.millis(3000));
            delay.setOnFinished(actionEvent -> alert.close()); // Renamed 'event' to 'actionEvent'
            delay.play();
        }

    }

}
