package lk.ijse.library.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.ManageSendEmailBO;
import lk.ijse.library.dto.Notification;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class ManageSendEmailFormController {
    @FXML
    private AnchorPane pane;



    @FXML
    private JFXTextField txtSendFrom;

    @FXML
    private JFXTextField txtSubject;

    @FXML
    private JFXTextArea txtText;
    @FXML
    private JFXComboBox txtSendTo;
    ManageSendEmailBO sendEmailBO= (ManageSendEmailBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.EMAIL1);
    public void initialize(){
        loadEmail();
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,pane);
    }
    @FXML
    void txtSubjectOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtText.requestFocus();
        }

    }

    @FXML
    void txtfromOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtSubject.requestFocus();
        }

    }

    @FXML
    void txttoOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtSendFrom.requestFocus();
        }


    }
    private void loadEmail() {
        try {
            ObservableList<String> od=FXCollections.observableArrayList();
            ArrayList<String> idList = sendEmailBO.loadEmailTOSend();

            for (String id : idList) {
                od.add(id);
            }
            txtSendTo.setItems(od);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void btnSendOnAction(ActionEvent event) {
        String sendTo= String.valueOf(txtSendTo.getValue());
        String sendFrom=txtSendFrom.getText();
        String fromEmailPassWord="xhzggklvlltlxlno";
        String subject=txtSubject.getText();
        //  String massage=txtAText.getText();
        try{

            Properties properties=new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host","smtp.gmail.com");
            properties.put("mail.smtp.port","25");

            Session session=Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(sendFrom, fromEmailPassWord);
                }
            });
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(sendFrom));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));
            message.setSubject(subject);
            message.setText(txtText.getText());
            Transport.send(message);
            String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
            String title = "Successful!";
            String text = "Email send Successful";
            Notification.showNotification(url, title, text);

        }catch(Exception e){
            System.out.println("Ex"+e);
        }
        loadEmail();
        txtSendTo.setValue("");
        txtSendFrom.setText("");
        txtSubject.setText("");
        txtText.setText("");
    }


}
