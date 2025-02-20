package controller;

import dto.CoursesDto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import service.custom.CoursesService;
import service.custom.EnrollmentService;
import service.custom.impl.CoursesServiceImpl;
import service.custom.impl.EnrollmentServiceImpl;

public class GenaratedReportsController {


    @FXML
    private Label lblCourseEnrolment;

    @FXML
    private Label lblCourseId;

    @FXML
    private Label lblCourseName;

    @FXML
    private Label lblCourseVacancies;

    private String courseId;

    public void initialize() throws Exception{
        ReportsController r1 = new ReportsController();
        courseId = r1.getcourseId();

        CoursesService coursesService = new CoursesServiceImpl();
        CoursesDto coursesDto = coursesService.search(courseId);
        lblCourseId.setText(coursesDto.getCourseId());
        lblCourseName.setText(coursesDto.getCourseTitle());

        EnrollmentService enrollmentService = new EnrollmentServiceImpl();
        int enrollmentCount = enrollmentService.search(courseId);
        lblCourseEnrolment.setText(String.valueOf(enrollmentCount));

        lblCourseVacancies.setText(Integer.toString(coursesDto.getEnrollmentCapacity()));


    }

}
