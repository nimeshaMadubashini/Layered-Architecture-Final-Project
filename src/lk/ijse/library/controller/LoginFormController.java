package lk.ijse.library.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.LoginBO;
import lk.ijse.library.dto.Notification;
import lk.ijse.library.dto.StaffDTO;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {

    public AnchorPane pane;
    @FXML
    private JFXPasswordField txtPassWord;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private Label lblId;
    public static String userName;
    public static String passWord;
    LoginBO loginBO= (LoginBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.LOGIN1);
public  void initialize(){
    txtPassWord.requestFocus();
}
    @FXML
    void loginOnAction(ActionEvent event) {
        userName = txtUsername.getText();
        passWord = txtPassWord.getText();
        StaffDTO staff = new StaffDTO(userName, passWord);
txtPassWord.requestFocus();
        try {
            boolean isVerify = loginBO.verifyStaff(staff);
            if (isVerify) {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String title = "Login Successful";
                String text = "Hey, Login Successful";
                Notification.showNotification(url, title, text);

                Navigation.navigate(Routes.DASHBOARD, pane);

            } else if (userName.equals("")) {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String title = "ERROR";
                String text = "Please Enter Username";
                Notification.showNotification(url, title, text);
            } else if (passWord.equals("")) {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String title = "ERROR";
                String text = "Please Enter Password";
                Notification.showNotification(url, title, text);
            } else {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String title = "Login UnSuccessful";
                String text = "Incorrect Username or Password";
                Notification.showNotification(url, title, text);
            }
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println("login page Exception" + ex);
        }
    }


    @FXML
    void txtPasswordAction(KeyEvent event) {

    }

    @FXML
    void txtUserNameAction(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtPassWord.requestFocus();
        }
    }

    @FXML
    void userNameOnAction(ActionEvent event) {

    }

    public void FrogetPasswordOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.FROGETPASSWORD, pane);
    }
}
