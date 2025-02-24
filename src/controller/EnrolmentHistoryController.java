package controller;

import java.io.IOException;
import java.util.ArrayList;

import dto.EnrollmentsDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import service.custom.EnrollmentService;
import service.custom.impl.EnrollmentServiceImpl;

public class EnrolmentHistoryController {

    @FXML
    private AnchorPane EnrolmentFrame;

    @FXML
    private Button btnRefreshButton;

    @FXML
    private TableColumn<EnrollmentsDto, String> tableCourseId;

    @FXML
    private TableColumn<EnrollmentsDto, String> tableEnrolmentDate;

    @FXML
    private TableView<EnrollmentsDto> tableEnrolmentHistory;

    @FXML
    private TableColumn<EnrollmentsDto, String> tableSemester;

    @FXML
    private TableColumn<EnrollmentsDto, String> tableAcademicYear;

    private String studentId;
    private static String courseID;

    public void initialize() throws Exception {
        StudentLoginController s1 = new StudentLoginController();
        this.studentId = s1.getId();
        Label successLabel = new Label("Select an Enrollment to Edit.");
        successLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: green;");

        EnrolmentFrame.getChildren().clear();
        EnrolmentFrame.getChildren().add(successLabel);
        AnchorPane.setTopAnchor(successLabel, 50.0);
        AnchorPane.setLeftAnchor(successLabel, 50.0);
        getAllCustomer();

        tableCourseId.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        tableEnrolmentDate.setCellValueFactory(new PropertyValueFactory<>("enrollmentDate"));
        tableSemester.setCellValueFactory(new PropertyValueFactory<>("semester"));
        tableAcademicYear.setCellValueFactory(new PropertyValueFactory<>("academicYear"));

        tableEnrolmentHistory.getSelectionModel().selectedItemProperty()
                .addListener((obs, oldSelection, newSelection) -> {
                    System.out.println("Table Row Click");
                    System.out.println("oldSelection : " + oldSelection);
                    System.out.println("=============");
                    System.out.println("newSelection : " + newSelection);

                    if (newSelection != null) {
                        courseID = newSelection.getCourseId();
                        System.out.println("Selected Course ID: " + courseID);

                        EnrolmentFrame.getChildren().clear();

                        try {
                            Parent node = FXMLLoader
                                    .load(getClass().getResource("../view/Student/EditEnrollment.fxml"));
                            EnrolmentFrame.getChildren().add(node);

                        } catch (IOException e) {
                            System.err.println("Error loading FXML: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }
                });

    }

    public void reloadTable() throws Exception {
        initialize();
        System.out.println("refreshed");
    }

    public void getAllCustomer() throws Exception {
        EnrollmentService enrollmentService = new EnrollmentServiceImpl();
        ArrayList<EnrollmentsDto> all = enrollmentService.getAll(studentId);
        System.out.println(all);
        ObservableList<EnrollmentsDto> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.addAll(all);
        tableEnrolmentHistory.setItems((ObservableList) observableArrayList);

    }

    public String getCourseId() {
        return courseID;
    }

    @FXML
    void btnRefreshButtonOnAction(ActionEvent event) throws Exception {
        System.out.println("Refresh table");
        reloadTable();
    }

}
