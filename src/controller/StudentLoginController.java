package controller;

import java.io.IOException;

import dto.StudentDto;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import service.custom.StudentService;
import service.custom.impl.StudentServiceImpl;

public class StudentLoginController {

    @FXML
    private AnchorPane StudentLoginPage;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblSignUp;

    @FXML
    private PasswordField txtHiddenPassword;

    @FXML
    private TextField txtUsername;

    public static String studentUserName;
    public static String studentId;

    @FXML
    private Label lblStudentLoginErrorMessage;

    public void initialize() throws IOException {
        lblStudentLoginErrorMessage.setText("");
    }

    @FXML
    void btnBackToMainOnAction(ActionEvent event) throws IOException {
        System.out.println("BACK TO MAIN");
        StudentLoginPage.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
        StudentLoginPage.getChildren().add(node);
    }

    @FXML
    void btnUserLoginOnAction(ActionEvent event) throws Exception {
        System.out.println("STUDENT LOGIN");

        String userName = txtUsername.getText();
        String studentPassword = txtHiddenPassword.getText();

        try {
            if (userName.equals("") || studentPassword.equals("")) {
                lblStudentLoginErrorMessage.setText("Please Enter  the Credentials");
            } else {
                StudentService studentService = new StudentServiceImpl();
                StudentDto studentDto = studentService.search(userName);

                if (studentDto == null) {
                    lblStudentLoginErrorMessage.setText("UserName Not Found");
                } else if (studentDto.getStudentPassword().equals(studentPassword)) {

                    this.studentUserName = studentDto.getStudentName();
                    this.studentId = studentDto.getStudentId();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("LogIn Successful!");
                    alert.show();

                    PauseTransition delay = new PauseTransition(Duration.millis(3000));
                    delay.setOnFinished(actionEvent -> alert.close());
                    delay.play();

                    StudentLoginPage.getChildren().clear();
                    Parent node = FXMLLoader.load(getClass().getResource("../view/StudentNavBar.fxml"));
                    StudentLoginPage.getChildren().add(node);

                } else {
                    lblStudentLoginErrorMessage.setText("Incorrect Password!");
                }
            }

        } catch (Exception e) {
            lblStudentLoginErrorMessage.setText("Unknown Error");
        }

    }

    public String getUserName() {
        return studentUserName;

    }

    public String getId() {
        return studentId;

    }

    @FXML
    void lblSignupOnAction(MouseEvent event) throws IOException {
        System.out.println("Signup");
        StudentLoginPage.getChildren().clear();
        Parent node = FXMLLoader.load(getClass().getResource("../view/Signup/StudentSignup.fxml"));
        StudentLoginPage.getChildren().add(node);
    }

}
