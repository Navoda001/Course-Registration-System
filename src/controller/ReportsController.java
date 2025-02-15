package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ReportsController {

    @FXML
    private Button btnCourseSearch;

    @FXML
    private ListView<?> listCourses;

    @FXML
    private AnchorPane reportsFrame;

    @FXML
    private TextField txtGenarateReports;

    @FXML
    void btnCourseSearchOnAction(ActionEvent event) throws IOException {
        System.out.println("Search Course");
        reportsFrame.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Admin/GenaratedReport.fxml"));
        reportsFrame.getChildren().add(node);
    }

}
