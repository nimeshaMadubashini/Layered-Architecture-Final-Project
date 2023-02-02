package lk.ijse.library.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.BookReturnBO;
import lk.ijse.library.dto.IssueBookDTO;
import lk.ijse.library.dto.Notification;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class BookReturnFormController {
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtFine;

    @FXML
    private Label lblfind;

    @FXML
    private JFXTextField txtBookDetlId;

    @FXML
    private JFXTextField txtMemberDetalId;

    @FXML
    private JFXTextField txtIssueDate;

    @FXML
    private JFXTextField txtDueDate;

    @FXML
    private JFXTextField txtBookId;

    @FXML
    private JFXTextField txtMemberId;

    @FXML
    private Label lblRs;
    @FXML
    private Label lblfine;
    BookReturnBO bookReturnBO= (BookReturnBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.RETURN);
    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, pane);
    }
    @FXML
    void txtBookIdOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtMemberId.requestFocus();
        }
    }

    @FXML
    void txtMemberIsOnKeyPress(KeyEvent event) {

    }
    @FXML
    void btnFindOnAction(ActionEvent event) {
        String bookId = txtBookId.getText();
        String memId = txtMemberId.getText();
        String status = "pending";
        try {
            IssueBookDTO issueBook = bookReturnBO.search(bookId, memId, status);
            if (issueBook != null) {
                txtBookDetlId.setText(issueBook.getBookId());
                txtMemberDetalId.setText(issueBook.getMemberId());
                txtIssueDate.setText(issueBook.getIssueDate());
                txtDueDate.setText(issueBook.getDueDate());
                lblfind.setText("");
                try {
                    LocalDate date = LocalDate.parse(txtDueDate.getText());
                    LocalDate end = LocalDate.now();
                    long daysBetween = DAYS.between(date, end);
                    double fine = 2;
                    System.out.println(date);
                      System.out.println(daysBetween * fine);
                    txtFine.setText(String.valueOf(daysBetween * fine));
                    if (daysBetween > 0) {
                        lblfine.setVisible(true);
                        lblRs.setVisible(true);
                        txtFine.setVisible(true);
                    } else {
                        lblfine.setVisible(false);
                        lblRs.setVisible(false);
                        txtFine.setVisible(false);
                    }
                }catch (DateTimeException i){

                }

              //  System.out.println(daysBetween);

            } else {
                lblfind.setText("No Result Find");
            }
        } catch (SQLException | ClassNotFoundException | DateTimeException ignored) {
ignored.printStackTrace();
        }

    }

    @FXML
    void returnBookOnAction(ActionEvent event) {
        String bookId = txtBookId.getText();
        String memId = txtMemberId.getText();
        String status1 = "pending";
        String status2 = "return";

        try {
            boolean isReturn=bookReturnBO.returnBook(status2,status1,memId,bookId);
            if(isReturn){
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String title = "Successful!";
                String text = "BookDTO Return Successful";
                Notification.showNotification(url, title, text);
            }else {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String title = "UnSuccessful";
                String text = "BookDTO Return UnSuccessful";
                Notification.showNotification(url, title, text);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        }

    }

