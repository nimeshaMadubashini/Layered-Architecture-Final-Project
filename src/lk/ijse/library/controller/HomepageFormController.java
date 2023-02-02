package lk.ijse.library.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.HomePageBO;
import lk.ijse.library.dao.custom.StaffDAO;
import lk.ijse.library.dao.custom.impl.StaffDAOImpl;
import lk.ijse.library.dto.Notification;
import lk.ijse.library.dto.StaffDTO;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomepageFormController {


    public Button btnSignUo;
    public Label lblidWarning;
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtTeleNum;

    @FXML
    private JFXTextField txtId;

    @FXML
    private Label lblIdWarning;

    @FXML
    private Label lblNameWarning;

    @FXML
    private Label lblUsernameWarning;

    @FXML
    private Label lblpPasswordWarning;

    @FXML
    private Label lblAddressWarning;

    @FXML
    private Label lblTeleNumWarning;
    private Matcher idMatcher;
    private Matcher nameMatcher;
    private Matcher userNameMatcher;
    private Matcher passWordMatcher;
    private Matcher addressMatcher;
    private Matcher teleNumMatcher;

    HomePageBO homePageBO= (HomePageBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.HOMEPAGE1);

    private void setPattern() {
        Pattern idPattern = Pattern.compile("^(S0)([0-9]{1})([0-9]{1})$");
        idMatcher = idPattern.matcher(txtId.getText());

        Pattern namePattern = Pattern.compile("^[a-zA-Z\\s]+");
        nameMatcher = namePattern.matcher(txtName.getText());

        Pattern userNamePattern = Pattern.compile("^[a-zA-Z0-9]{4,}$");
        userNameMatcher = userNamePattern.matcher(txtUserName.getText());

        Pattern passwordPattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8}$");
        passWordMatcher = passwordPattern.matcher(txtPassword.getText());

        Pattern addressPattern = Pattern.compile("^([a-zA-Z0-9\\/,\\s])+([a-zA-z\\s,])+([a-zA-z])$");
        addressMatcher = addressPattern.matcher(txtAddress.getText());

        Pattern teleNumPattern = Pattern.compile("^(074|075|072|077|071|078)([0-9]{7}$)");
        teleNumMatcher = teleNumPattern.matcher(txtTeleNum.getText());
    }

    public void initialize() {
        loadNextId();
        setPattern();
    }


    @FXML
    void signUpOnAction(ActionEvent event) {

        String staffId = txtId.getText();
        String name = txtName.getText();
        String userName = txtUserName.getText();
        String passWord = txtPassword.getText();
        String address = txtAddress.getText();
        int telephoneNumber = Integer.parseInt(txtTeleNum.getText());
        StaffDTO staff = new StaffDTO(staffId, name, userName, passWord, address, telephoneNumber);

        try {

            if (idMatcher.matches()) {
                if (nameMatcher.matches()) {
                    if (userNameMatcher.matches()) {
                        if (passWordMatcher.matches()) {
                            if (addressMatcher.matches()) {
                                if (teleNumMatcher.matches()) {
                                    boolean isSave = homePageBO.saveStaff(staff);
                                    if (isSave) {
                                        String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                                        String title = "Successful!";
                                        String text = "Account Create Successful";
                                        Notification.showNotification(url, title, text);
                                        txtName.setText("");
                                        txtId.setText("");
                                        txtPassword.setText("");
                                        txtTeleNum.setText("");
                                        txtUserName.setText("");
                                        txtAddress.setText("");
                                    } else {
                                        String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                                        String title = "UnSuccessful";
                                        String text = "Account Create UnSuccessful";
                                        Notification.showNotification(url, title, text);
                                    }
                                } else {
                                    txtTeleNum.requestFocus();
                                    txtTeleNum.setFocusColor(Paint.valueOf("Red"));
                                    lblTeleNumWarning.setText("invalid TelePhone Number");
                                }
                            } else {
                                txtAddress.requestFocus();
                                txtAddress.setFocusColor(Paint.valueOf("Red"));
                                lblAddressWarning.setText("invalid address");
                            }
                        } else {
                            txtPassword.requestFocus();
                            txtPassword.setFocusColor(Paint.valueOf("Red"));
                            lblpPasswordWarning.setText("invalid password");
                        }
                    } else {
                        txtUserName.requestFocus();
                        txtUserName.setFocusColor(Paint.valueOf("Red"));
                        lblUsernameWarning.setText("invalid user name");
                    }
                } else {
                    txtName.requestFocus();
                    txtName.setFocusColor(Paint.valueOf("Red"));
                    lblNameWarning.setText("invalid name");

                }
            } else {
                txtId.requestFocus();
                txtId.setFocusColor(Paint.valueOf("Red"));
                lblidWarning.setText("invalid staff id");

            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Home page Exception" + ex);
        }

    }

    @FXML
    void txtIdAction(KeyEvent event) {

        if (event.getCode().equals(KeyCode.ENTER)) {
            txtName.requestFocus();
        }

    }

    @FXML
    void txtNameAction(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtUserName.requestFocus();
        }
    }

    @FXML
    void txtPasswordAction(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtAddress.requestFocus();
        }
    }

    @FXML
    void txtTeleNumAction(KeyEvent event) {

    }

    @FXML
    void txtUserNameAction(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtPassword.requestFocus();
        }

    }

    @FXML
    void txtAddressAction(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtTeleNum.requestFocus();
        }

    }


    public void userNameOnAction(ActionEvent actionEvent) {
    }

    @FXML
    void txtIdOnKeyType(KeyEvent event) {
       /* lblidWarning.setText("");
        txtId.setFocusColor(Paint.valueOf("Blue"));
        Pattern idPattern=Pattern.compile("^(S0)([0-9]{1})([0-9]{1,})$");
        idMatcher=idPattern.matcher(txtId.getText());


        if(!idMatcher.matches()) {
            txtId.requestFocus();
            txtId.setFocusColor(Paint.valueOf("Red"));
            lblidWarning.setText("invalid user name");
        }*/

    }

    public void txtPasswordOnKeyTyped(KeyEvent keyEvent) {

    }

    public void txtNameOnReleased(KeyEvent keyEvent) {
        lblNameWarning.setText("");
        txtName.setFocusColor(Paint.valueOf("Blue"));
        Pattern namePattern = Pattern.compile("^[a-zA-Z\\s]+");
        nameMatcher = namePattern.matcher(txtName.getText());

        if (!nameMatcher.matches()) {
            txtName.requestFocus();
            txtName.setFocusColor(Paint.valueOf("Red"));
            lblNameWarning.setText("invalid user name");
        }
    }

    public void txtAddressOnReleased(KeyEvent keyEvent) {
        lblAddressWarning.setText("");
        txtAddress.setFocusColor(Paint.valueOf("Blue"));
        Pattern addressPattern = Pattern.compile("^([a-zA-Z0-9\\/,\\s])+([a-zA-z\\s,])+([a-zA-z])$");
        addressMatcher = addressPattern.matcher(txtAddress.getText());

        if (!addressMatcher.matches()) {
            txtAddress.requestFocus();
            txtAddress.setFocusColor(Paint.valueOf("Red"));
            lblAddressWarning.setText("invalid address");
        }
    }

    public void txtTleNumOnReleased(KeyEvent keyEvent) {
        lblTeleNumWarning.setText("");
        txtTeleNum.setFocusColor(Paint.valueOf("Blue"));
        Pattern teleNumPattern = Pattern.compile("^(074|075|072|077|071|078)([0-9]{7}$)");
        teleNumMatcher = teleNumPattern.matcher(txtTeleNum.getText());

        if (!teleNumMatcher.matches()) {
            txtTeleNum.requestFocus();
            txtTeleNum.setFocusColor(Paint.valueOf("Red"));
            lblTeleNumWarning.setText("invalid Telephone Number");
        }
    }

    public void txtUsernameOnReleased(KeyEvent keyEvent) {
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

    public void txtIdOnKeyRelease(KeyEvent keyEvent) {
        lblidWarning.setText("");
        txtId.setFocusColor(Paint.valueOf("Blue"));
        Pattern idPattern = Pattern.compile("^(S0)([0-9]{1})([0-9]{1})$");
        idMatcher = idPattern.matcher(txtId.getText());


        if (!idMatcher.matches()) {
            txtId.requestFocus();
            txtId.setFocusColor(Paint.valueOf("Red"));
            lblidWarning.setText("invalid password");
        }
    }

    public void txtIdKeyPressed(KeyEvent keyEvent) {

    }

    public void txtPasswordKeyRelease(KeyEvent keyEvent) {
        lblpPasswordWarning.setText("");
        txtPassword.setFocusColor(Paint.valueOf("Blue"));
        Pattern passwordPattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8}$");
        passWordMatcher = passwordPattern.matcher(txtPassword.getText());

        if (!passWordMatcher.matches()) {
            txtPassword.requestFocus();
            txtPassword.setFocusColor(Paint.valueOf("Red"));
            lblpPasswordWarning.setText("invalid password");
        }
    }

    private void loadNextId() {
        try {
            String orderId = homePageBO.generateNextStaffId();
            txtId.setText(orderId);
        } catch (SQLException | ClassNotFoundException | NullPointerException e) {

        }
    }

    public void btnBackOnaction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMIN,pane);
    }
}

