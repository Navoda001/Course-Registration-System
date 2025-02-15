package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AcademicRecordController {

    @FXML
    private TableColumn<?, ?> columnCourseId;

    @FXML
    private TableColumn<?, ?> columnGrade;

    @FXML
    private TableColumn<?, ?> columnSemester;

    @FXML
    private TableView<?> tableAcademicRecord;

}
