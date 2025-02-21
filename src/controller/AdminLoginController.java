package controller;

import java.io.IOException;

import dto.AdminDto;
import dto.FacultyDto;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import service.custom.AdminService;
import service.custom.FacultyService;
import service.custom.impl.AdminServiceImpl;
import service.custom.impl.FacultyServiceImpl;

public class AdminLoginController {

    @FXML
    private AnchorPane adminLoginPage;

    @FXML
    private ToggleGroup Category;

    @FXML
    private RadioButton btnAdmin;

    @FXML
    private Button btnBack;

    @FXML
    private RadioButton btnFaculty;

    @FXML
    private Button btnLogin;

    @FXML
    private Rectangle checkShowPassword;

    @FXML
    private PasswordField txtHiddenPassword;

    @FXML
    private Label lblAdminLoginErrorMessage;

    @FXML
    private TextField txtUsername;

    private static FacultyDto passFacultyDto;

    private static String role;

    private FacultyDto facultyDto;

    private AdminDto adminDto;

    private static AdminDto passAdminDto;

    

    public void initialize() {
        lblAdminLoginErrorMessage.setText("");
    }

    @FXML
    void btnBackToMainOnAction(ActionEvent event) throws IOException {
        System.out.println("Back to main menu");
        adminLoginPage.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
        adminLoginPage.getChildren().add(node);
    }

    @FXML
    void btnUserLoginOnAction(ActionEvent event) throws Exception {
        System.out.println("login ");

        String userName = txtUsername.getText();
        String password = txtHiddenPassword.getText();

        try {
            if (btnFaculty.isSelected()) {
                if (userName.equals("") || password.equals("")) {
                    lblAdminLoginErrorMessage.setText("Please Enter  the Credentials.");
                } else {
                    FacultyService f1 = new FacultyServiceImpl();
                    this.facultyDto = f1.search(userName);
                    passFacultyDto = facultyDto;

                    if (facultyDto == null) {
                        lblAdminLoginErrorMessage.setText("UserName not found!");
                    } else if (password.equals(facultyDto.getFacultyPassword())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Success");
                        alert.setHeaderText(null);
                        alert.setContentText("LogIn Successfully!");
                        alert.show();

                        PauseTransition delay = new PauseTransition(Duration.millis(3000));
                        delay.setOnFinished(actionEvent -> alert.close());
                        delay.play();

                        AdminLoginController.role="Faculty";

                        adminLoginPage.getChildren().clear();
                        Parent node = FXMLLoader.load(getClass().getResource("../view/AdminNavbar.fxml"));
                        adminLoginPage.getChildren().add(node);
                    }
                }
            } else if (btnAdmin.isSelected()) {
                if (userName.equals("") || password.equals("")) {
                    lblAdminLoginErrorMessage.setText("Please Enter  the Credentials.");
                } else {
                    AdminService f1 = new AdminServiceImpl();
                    this.adminDto = f1.search(userName);
                    passAdminDto = adminDto;

                    if (adminDto == null) {
                        lblAdminLoginErrorMessage.setText("UserName not found!");
                    } else if (password.equals(adminDto.getAdminPassword())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Success");
                        alert.setHeaderText(null);
                        alert.setContentText("LogIn Successfully!");
                        alert.show();

                        PauseTransition delay = new PauseTransition(Duration.millis(3000));
                        delay.setOnFinished(actionEvent -> alert.close());
                        delay.play();

                        AdminLoginController.role="Admin";

                        adminLoginPage.getChildren().clear();
                        Parent node = FXMLLoader.load(getClass().getResource("../view/AdminNavbar.fxml"));
                        adminLoginPage.getChildren().add(node);
                    }
                }

            } else {
                System.out.println("No option selected");
                lblAdminLoginErrorMessage
                        .setText("Login Failed: Please choose your role (e.g.Faculty, Admin) to proceed.");
            }

        } catch (Exception e) {
            lblAdminLoginErrorMessage.setText("Unknown Error");
        }

    }

    public FacultyDto geFacultyDto() {
        return passFacultyDto;
    }

    public String getrole(){
        return role;
    }

    public AdminDto geAdminDto(){
        return passAdminDto;
    }
}
