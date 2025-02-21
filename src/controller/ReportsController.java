package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dto.CoursesDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import service.custom.CoursesService;
import service.custom.impl.CoursesServiceImpl;

public class ReportsController {

    @FXML
    private ListView<String> listCourses;

    @FXML
    private AnchorPane reportsFrame;

    @FXML
    private TextField txtGenarateReports;

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
        listCourses.setItems(filteredList);
    }

    private void setupSearch() {
        txtGenarateReports.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(course -> course.toLowerCase().contains(newValue.toLowerCase())

            );
        });
    }

    private void setupSelectionListener() {
        listCourses.setOnMouseClicked((MouseEvent event) -> {
            String selectedCourseTitle = listCourses.getSelectionModel().getSelectedItem();

            try {

                if (selectedCourseTitle != null) {
                    String selectedCourseId = courseMap.get(selectedCourseTitle);
                    System.out.println("Selected Course: " + selectedCourseTitle);
                    System.out.println("Course ID: " + selectedCourseId);

                    this.courseId = selectedCourseId;

                    reportsFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Admin/GenaratedReport.fxml"));
        reportsFrame.getChildren().add(node);
                }

            } catch (Exception e) {
                
            }

        });
    }

    public String getcourseId() {
        return courseId;
    }

   

}
