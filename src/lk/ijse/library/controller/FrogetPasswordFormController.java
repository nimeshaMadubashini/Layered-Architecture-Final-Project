package lk.ijse.library.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.FrogetPasswordBO;
import lk.ijse.library.dto.Notification;
import lk.ijse.library.dto.StaffDTO;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrogetPasswordFormController {
    @FXML
    private AnchorPane pane;
    public JFXTextField txtUserName;
    public Label lblUsernameWarning;
    @FXML
    private JFXPasswordField txtConfirmPassWord;

    @FXML
    private JFXPasswordField txtnewPassWord1;
    @FXML
    private Label lblId;

    @FXML
    private JFXTextField txtId;

    @FXML
    private Label lblIdWarning;

    @FXML
    private Label lblPassWordWarning;

    @FXML
    private Label lblConfirmPasswrdWrning;

    @FXML
    private Label lblPassWordWarning1;
    private Matcher idMatcher;
    private Matcher userNameMatcher;
    private Matcher passWordMatcher;
    private Matcher confirmpswMatcher;
    FrogetPasswordBO frogetPasswordBO= (FrogetPasswordBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.FROGETPASSWORD1);

    private void setPattern() {
        Pattern idPattern = Pattern.compile("^(S0)([0-9]{1})([0-9]{1})$");
        idMatcher = idPattern.matcher(txtId.getText());

        Pattern userNamePattern = Pattern.compile("^[a-zA-Z0-9]{4,}$");
        userNameMatcher = userNamePattern.matcher(txtUserName.getText());

        Pattern passwordPattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8}$");
        passWordMatcher = passwordPattern.matcher(txtConfirmPassWord.getText());

        Pattern conpasswordPattern = Pattern.compile(txtnewPassWord1.getText());
        confirmpswMatcher = conpasswordPattern.matcher(txtConfirmPassWord.getText());
    }

    public void initialize() {
        setPattern();
    }

    @FXML
    void resetOnAction(ActionEvent event) {
        String staffid = txtId.getText();
        String userName = txtUserName.getText();
        String nwPassword = txtnewPassWord1.getText();
        String confirmpassword = txtConfirmPassWord.getText();
        StaffDTO staff = new StaffDTO(staffid, userName, confirmpassword);


        try {
            if (idMatcher.matches()) {
                if (userNameMatcher.matches()) {
                    if (passWordMatcher.matches()) {
                        if (confirmpassword.equals(nwPassword) && confirmpswMatcher.matches()) {
                            boolean isUpdate = frogetPasswordBO.frogetpwResetPassword(staff);
                            if (isUpdate) {
                                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                                String title = "Successful!";
                                String text = "Reset Password  Successful";
                                Notification.showNotification(url, title, text);
                                Navigation.navigate(Routes.LOGIN, pane);
                            } else {
                                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                                String title = "UnSuccessful";
                                String text = "Reset Password UnSuccessful";
                                Notification.showNotification(url, title, text);
                            }
                        } else {
                            txtConfirmPassWord.requestFocus();
                            txtConfirmPassWord.setFocusColor(Paint.valueOf("red"));
                            lblConfirmPasswrdWrning.setText("Not Match password");

                        }

                    } else {
                        txtnewPassWord1.requestFocus();
                        txtnewPassWord1.setFocusColor(Paint.valueOf("Red"));
                        lblPassWordWarning1.setText("invalid password");
                    }
                } else {
                    txtUserName.requestFocus();
                    txtUserName.setFocusColor(Paint.valueOf("Red"));
                    lblUsernameWarning.setText("invalid user name");
                }
            } else {
                txtId.requestFocus();
                txtId.setFocusColor(Paint.valueOf("Red"));
                lblPassWordWarning1.setText("invalid staff id");

            }
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println("forgetPassword page" + ex);

        }
    }


    @FXML
    void txtIdAction(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtUserName.requestFocus();
        }
    }
    @FXML
    void btnbackOnAction(ActionEvent event) throws IOException {
Navigation.navigate(Routes.LOGIN,pane);
    }
    @FXML
    void txtIdReleased(KeyEvent event) {
        lblIdWarning.setText("");
        txtId.setFocusColor(Paint.valueOf("Blue"));
        Pattern idPattern = Pattern.compile("^(S0)([0-9]{1})([0-9]{1})$");
        idMatcher = idPattern.matcher(txtId.getText());


        if (!idMatcher.matches()) {
            txtId.requestFocus();
            txtId.setFocusColor(Paint.valueOf("Red"));
            lblIdWarning.setText("invalid password ");
        }

    }

    @FXML
    void txtUsernameKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtnewPassWord1.requestFocus();
        }

    }

    @FXML
    void txtNewPasswordKeyRelased(KeyEvent event) {
        lblPassWordWarning.setText("");
        txtnewPassWord1.setFocusColor(Paint.valueOf("Blue"));
        Pattern passwordPattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8}$");
        passWordMatcher = passwordPattern.matcher(txtnewPassWord1.getText());

        if (!passWordMatcher.matches()) {
            txtnewPassWord1.requestFocus();
            txtnewPassWord1.setFocusColor(Paint.valueOf("Red"));
            lblPassWordWarning.setText("invalid password");
        }
    }

    @FXML
    void txtPasswordKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtConfirmPassWord.requestFocus();
        }
    }


    @FXML
    void txtUsernameKeyRelased(KeyEvent event) {
        lblUsernameWarning.setText("");
        txtUserName.setFocusColor(Paint.valueOf("Blue"));
        Pattern userNamePattern = Pattern.compile("^[a-zA-Z0-9]{4,}$");
        userNameMatcher = userNamePattern.matcher(txtUserName.getText());


        if (!userNameMatcher.matches()) {
            txtUserName.requestFocus();
            txtUserName.setFocusColor(Paint.valueOf("Red"));
            lblUsernameWarning.setText("invalid user name");
        }

    }

    @FXML
    void txtConpasswrdKeyReleased(KeyEvent event) {
        lblConfirmPasswrdWrning.setText("");
        txtConfirmPassWord.setFocusColor(Paint.valueOf("Blue"));
        Pattern conpasswordPattern = Pattern.compile(txtnewPassWord1.getText());
        confirmpswMatcher = conpasswordPattern.matcher(txtConfirmPassWord.getText());

        if (!confirmpswMatcher.matches()) {
            txtConfirmPassWord.requestFocus();
            txtConfirmPassWord.setFocusColor(Paint.valueOf("Red"));
            lblConfirmPasswrdWrning.setText("Not Match Password");
        }
    }

    public void btnLogin(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }
}
