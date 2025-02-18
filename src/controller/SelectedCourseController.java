package controller;

import dao.custom.CoursesDao;
import dto.CoursesDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import service.custom.CoursesService;
import service.custom.StudentService;
import service.custom.impl.CoursesServiceImpl;
import service.custom.impl.StudentServiceImpl;

public class SelectedCourseController {

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

    private String courseId;

    public void initialize() throws Exception{
        StudentRegisterNewCourseController reg1 = new StudentRegisterNewCourseController();
        this.courseId = reg1.getcourseId();
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
    void btnEnrollNowOnAction(ActionEvent event) {
        System.out.println("Enroll Now button clicked");
    }

}
