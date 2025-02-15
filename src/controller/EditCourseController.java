package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ListView;

public class EditCourseController {

    @FXML
    private Button btnCourseSearch;

    @FXML
    private AnchorPane editCourseFrame;

     @FXML
    private ListView<?> listEditCourse;

    @FXML
    private TextField txtEditCourse;

    @FXML
    void btnCourseSearchOnAction(ActionEvent event) throws IOException {
        System.out.println("Search Course");
        editCourseFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Admin/SelectedCourse.fxml"));
        editCourseFrame.getChildren().add(node);
    }

}
