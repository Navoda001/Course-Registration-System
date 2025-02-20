package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dto.CoursesDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import service.custom.CoursesService;
import service.custom.impl.CoursesServiceImpl;
import javafx.scene.control.ListView;

public class EditCourseController {


    @FXML
    private AnchorPane editCourseFrame;

    @FXML
    private Button btnRefresh;

    @FXML
    private ListView<String> listEditCourse;

    @FXML
    private TextField txtEditCourse;

    private ObservableList<String> courseList = FXCollections.observableArrayList();
    private FilteredList<String> filteredList;
    private Map<String, String> courseMap = new HashMap<>();

    private static String courseId;

     

    public void initialize() throws Exception {
        loadCourses();
        setupSearch();
        setupSelectionListener();
    }

    private void loadCourses() throws Exception {
        CoursesService coursesService = new CoursesServiceImpl();
        ArrayList<CoursesDto> courses = new ArrayList<>();
        courses = coursesService.getAll();

        for (CoursesDto course : courses) {
            String courseTitle = course.getCourseTitle();
            String courseId = course.getCourseId();

            courseList.add(courseTitle);
            courseMap.put(courseTitle, courseId);
        }

        filteredList = new FilteredList<>(courseList, s -> true);
        listEditCourse.setItems(filteredList);
    }

    private void setupSearch() {
        txtEditCourse.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(course -> course.toLowerCase().contains(newValue.toLowerCase())

            );
        });
    }

    private void setupSelectionListener() {
        listEditCourse.setOnMouseClicked((MouseEvent event) -> {
            String selectedCourseTitle = listEditCourse.getSelectionModel().getSelectedItem();

            try {

                if (selectedCourseTitle != null) {
                    String selectedCourseId = courseMap.get(selectedCourseTitle);
                    System.out.println("Selected Course: " + selectedCourseTitle);
                    System.out.println("Course ID: " + selectedCourseId);

                    this.courseId = selectedCourseId;

                    editCourseFrame.getChildren().clear();
                    Parent node = FXMLLoader.load(getClass().getResource("../view/Admin/SelectedCourse.fxml"));
                    editCourseFrame.getChildren().add(node);
                }

            } catch (Exception e) {
                
            }

        });
    }

    public String getcourseId() {
        return courseId;
    }

    @FXML
    void btnRefreshOnAction(ActionEvent event) throws Exception {
        initialize();
    }
}
