package controller;

import java.time.LocalDate;

import dto.StudentDto;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import service.custom.StudentService;
import service.custom.impl.StudentServiceImpl;

public class EditProfileController {

    @FXML
    private Button btnChangePassword;

    @FXML
    private Button btnUpdateStudentInfo;

    @FXML
    private Label lblChangePasswordError;

    @FXML
    private Label lblUpdateErrorMessage;

    @FXML
    private DatePicker txtBirthDate;

    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    private PasswordField txtCurrentPassword;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtStudentName;

    @FXML
    private TextField txtUserName;

    @FXML
    private Button btnDeleteAccount;

    private String studentUserName;
    private String studentId;

    private StudentDto studentDto;

    public EditProfileController() {
        StudentLoginController s1 = new StudentLoginController();
        this.studentUserName = s1.getStudentUserName();
        this.studentId = s1.getId();
    }

    @FXML
    public void initialize() throws Exception {
        StudentService studentService = new StudentServiceImpl();
        studentDto = studentService.search(studentUserName);
        System.out.println(studentDto);
        txtStudentName.setText(studentDto.getStudentName());
        txtUserName.setText(studentDto.getUserName());
        txtBirthDate.setValue(LocalDate.parse(studentDto.getStudentDOB()));
        txtPhoneNumber.setText(studentDto.getContactInfo());

        lblChangePasswordError.setText("");
        lblUpdateErrorMessage.setText("");

    }

    @FXML
    void btnChangePasswordOnAction(ActionEvent event) throws Exception {
        String currentPassword = txtCurrentPassword.getText();
        String newPassword = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();

        StudentService studentService = new StudentServiceImpl();
        studentDto = studentService.search(studentUserName);

        if (!(currentPassword.equals("") || newPassword.equals("") || confirmPassword.equals(""))) {

            if (currentPassword.equals(studentDto.getStudentPassword())) {
                if (newPassword.equals(confirmPassword)) {
                    String saveStudent = studentService.updatePassword(studentDto.getStudentId(), newPassword);
                    System.out.println(saveStudent);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("Password Changed Successfully!");
                    alert.show();

                    PauseTransition delay = new PauseTransition(Duration.millis(3000));
                    delay.setOnFinished(actionEvent -> alert.close()); 
                    delay.play();
                    txtCurrentPassword.setText("");
                    txtConfirmPassword.setText("");
                    txtPassword.setText("");
                } else {
                    lblChangePasswordError.setText("Passwords do not match. Please try again.");
                }
            } else {
                lblChangePasswordError.setText("Please enter correct current password!");
            }
        } else {
            lblChangePasswordError.setText("Please enter the password");
        }
    }

    @FXML
    void btnUpdateStudentInfoOnAction(ActionEvent event) {
        System.out.println("Change Student Info");
        String studentName = txtStudentName.getText();
        String studentUserName = txtUserName.getText();
        LocalDate stdDOB = txtBirthDate.getValue();
        String studentDOB;
        studentDOB = stdDOB.toString();
        String studentContactInfo = txtPhoneNumber.getText();

        try {
            if (!(studentName.equals("") || studentUserName.equals("") || studentDOB.equals("")
                    || studentContactInfo.equals(""))) {
                StudentDto studentDto1 = new StudentDto(studentName, studentUserName, studentDOB, studentContactInfo);
                StudentService studentService2 = new StudentServiceImpl();
                String saveStudent = studentService2.updateInfo(studentDto.getStudentId(), studentDto1);
                System.out.println(saveStudent);
                if (saveStudent.equals("Success")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("Update Successfully!");
                    alert.show();

                    PauseTransition delay = new PauseTransition(Duration.millis(3000));
                    delay.setOnFinished(actionEvent -> alert.close()); 
                    delay.play();
                }
                lblUpdateErrorMessage.setText("");
            } else {
                lblUpdateErrorMessage.setText("Enter the valid values");

            }
        } catch (Exception e) {
            lblUpdateErrorMessage.setText("UserName already taken!");
        }

    }

    @FXML
    void btnDeleteAccountOnAction(ActionEvent event) throws Exception {
        System.out.println("Delete Account");
        try {
            StudentService studentService = new StudentServiceImpl();
            String deleteAccount = studentService.delete(studentId);
            System.out.println(deleteAccount);

            if (deleteAccount.equals("Success")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Account delete Successfully!  please click SignOut button");
                alert.show();

                // Close the alert after 10 milliseconds
                PauseTransition delay = new PauseTransition(Duration.millis(3000));
                delay.setOnFinished(actionEvent -> alert.close()); 
                delay.play();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Error");
                alert.show();

                // Close the alert after 10 milliseconds
                PauseTransition delay = new PauseTransition(Duration.millis(3000));
                delay.setOnFinished(actionEvent -> alert.close()); 
                delay.play();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Unknown Error");
            alert.show();

            PauseTransition delay = new PauseTransition(Duration.millis(3000));
            delay.setOnFinished(actionEvent -> alert.close()); 
            delay.play();
        }

    }
}
