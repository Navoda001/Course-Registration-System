package controller;

import java.io.IOException;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import service.custom.CoursesService;
import service.custom.impl.CoursesServiceImpl;

public class StudentRegisterNewCourseController {

    @FXML
    private Button btnCourseSearch;

    @FXML
    private ListView<String> listCourses; // ListView contains course titles

    @FXML
    private AnchorPane registerForm;

    @FXML
    private TextField txtSearchCourses;

    private ObservableList<String> courseList = FXCollections.observableArrayList();
    private FilteredList<String> filteredList;
    private Map<String, String> courseMap = new HashMap<>(); // Map to store Course Title → Course ID

    private static String courseId;

    private CoursesService coursesService = new CoursesServiceImpl();

    public void initialize() throws Exception {
        loadCourses(); // Load courses from the database
        setupSearch(); // Enable search functionality
        setupSelectionListener(); // Handle course selection
    }

    private void loadCourses() throws Exception {
        ArrayList<CoursesDto> courses = coursesService.getAll(); // Fetch courses

        for (CoursesDto course : courses) {
            String courseTitle = course.getCourseTitle();
            String courseId = course.getCourseId();

            courseList.add(courseTitle); // Populate ListView with course titles
            courseMap.put(courseTitle, courseId); // Store Course Title → Course ID mapping
        }

        filteredList = new FilteredList<>(courseList, s -> true);
        listCourses.setItems(filteredList);
    }

    private void setupSearch() {
        txtSearchCourses.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(course -> course.toLowerCase().contains(newValue.toLowerCase()) // Real-time
                                                                                                      // filtering
            );
        });
    }

    private void setupSelectionListener()  {
        listCourses.setOnMouseClicked((MouseEvent event) -> {
            String selectedCourseTitle = listCourses.getSelectionModel().getSelectedItem();


            try {

                if (selectedCourseTitle != null) {
                    String selectedCourseId = courseMap.get(selectedCourseTitle); // Get Course ID from Map
                    System.out.println("Selected Course: " + selectedCourseTitle);
                    System.out.println("Course ID: " + selectedCourseId);
    
                    this.courseId = selectedCourseId;
    
                    
                    registerForm.getChildren().clear();
                    Parent node = FXMLLoader.load(getClass().getResource("../view/Student/SelectedCourse.fxml"));
                    registerForm.getChildren().add(node);
                    // You can store the selected course ID for further use
                }
                
            } catch (Exception e) {
                    
            }
            
        });
    }

    public String getcourseId() {
        return courseId;
    }

}
