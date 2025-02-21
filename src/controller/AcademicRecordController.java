package controller;

import java.util.ArrayList;

import dto.AcademicRecordDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.custom.AcademicRecordService;
import service.custom.impl.AcademicRecordServiceImpl;

public class AcademicRecordController {

    @FXML
    private TableColumn<AcademicRecordDto, String>columnCourseId;

    @FXML
    private TableColumn<AcademicRecordDto, String> columnGrade;

    @FXML
    private TableColumn<AcademicRecordDto, String> columnSemester;

    @FXML
    private TableView<AcademicRecordDto> tableAcademicRecord;

    private String studentId;


    public void initialize() throws Exception {
        StudentLoginController s1 = new StudentLoginController();
        this.studentId = s1.getId();

        getAllCustomer();

        columnCourseId.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        columnSemester.setCellValueFactory(new PropertyValueFactory<>("semester"));
        columnGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
    }

     public void getAllCustomer() throws Exception {
        AcademicRecordService academicRecordService = new AcademicRecordServiceImpl();
        ArrayList<AcademicRecordDto> all = academicRecordService.getAll(studentId);
        System.out.println(all);
        ObservableList<AcademicRecordDto> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.addAll(all);
        tableAcademicRecord.setItems((ObservableList) observableArrayList);

    }


}
