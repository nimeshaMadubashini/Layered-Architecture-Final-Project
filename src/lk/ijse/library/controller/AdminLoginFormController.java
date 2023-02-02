package lk.ijse.library.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.dto.Notification;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;


import java.io.IOException;

public class AdminLoginFormController {
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private Button btnLogin;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {

        String username = txtUsername.getText();
        String password = txtPassword.getText();
        if (username.equals("admin") && (password.equals("admin200"))) {
            String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
            String title = "Login Successful";
            String text = "Hey,Admin LoginSuccessful";
            Notification.showNotification(url, title, text);

          /*  Image image=new Image("\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png");
            Notifications notifications=Notifications.create();
            notifications .title("Login Successful");
            notifications  .text("Hey,Admin login Successful!");
            notifications    .graphic(new ImageView(image));
            notifications  .hideAfter(Duration.seconds(3));
            notifications    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();*/
            Navigation.navigate(Routes.HOMEPAGE, pane);
        } else {
            /*Image image=new Image("\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png");
            Notifications notifications=Notifications.create();
            notifications .title("Login UnSuccessful");
            notifications  .text("Incorrect Username or Password");
            notifications    .graphic(new ImageView(image));
            notifications  .hideAfter(Duration.seconds(3));
            notifications    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();*/
            String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
            String title = "Login UnSuccessful";
            String text = "Incorrect Username or Password";
            Notification.showNotification(url, title, text);
        }

    }

    @FXML
    void txtPasswordKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            btnLogin.requestFocus();
        }

    }

    @FXML
    void txtUsernameKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtPassword.requestFocus();
        }
    }

}

