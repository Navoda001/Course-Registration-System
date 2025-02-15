package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AdminDashboard {

    @FXML
    private Label lblAdminId;

    @FXML
    private Label lblAdminName;

    @FXML
    public void initialize() {
        lblAdminName.setText("John Doe");
        lblAdminId.setText("123456");
    }

}
