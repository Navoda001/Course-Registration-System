package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class EnrolmentHistoryController {

    @FXML
    private AnchorPane EnrolmentFrame;

    @FXML
    private TableColumn<?, ?> tableCourseId;

    @FXML
    private TableColumn<?, ?> tableEnrolmentDate;

    @FXML
    private TableView<?> tableEnrolmentHistory;

    @FXML
    private TableColumn<?, ?> tableSemester;


    @FXML
    void selectCourseOnAction(MouseEvent event) throws IOException {
        System.out.println("Select table");
        EnrolmentFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Student/EditEnrollment.fxml"));
        EnrolmentFrame.getChildren().add(node);
    }
}
