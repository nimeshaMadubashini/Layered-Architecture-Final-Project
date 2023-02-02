package lk.ijse.library.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.BookIssueBO;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.IssueBookDTO;
import lk.ijse.library.dto.MemberDTO;
import lk.ijse.library.dto.Notification;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookIssueFormController {
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtTeleNum;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtmemName;

    @FXML
    private JFXTextField txtMenId;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXTextField txtAuthor;

    @FXML
    private JFXTextField txtbkName;

    @FXML
    private JFXTextField txtbkId;

    @FXML
    private JFXTextField txtBookId;

    @FXML
    private JFXTextField txtMemberId;

    @FXML
    private JFXDatePicker txtissueDate;

    @FXML
    private JFXDatePicker txtdueDate;

    @FXML
    private JFXTextField txtIssueId;
    @FXML
    private JFXComboBox cmbBookId;

    @FXML
    private JFXComboBox cmbMmberId;

    BookIssueBO bookIssueBO= (BookIssueBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.ISSUE);

    public void initialize(){
        loadMemberId();
        loadBookId();

        try {
            loadNextIssueId();
            search();
            searchMem();
        } catch (SQLException | ClassNotFoundException ignored) {
        }
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,pane);
    }

    @FXML
    void btnIssueBokOnAction(ActionEvent event) {
        String issueId=txtIssueId.getText();
        String bookId= String.valueOf(cmbBookId.getValue());
        String memId= String.valueOf(cmbMmberId.getValue());
        String issueDate= String.valueOf(txtissueDate.getValue());
        String duedate= String.valueOf(txtdueDate.getValue());

        IssueBookDTO issueBook=new IssueBookDTO(issueId,bookId,memId,issueDate,duedate);
        try {
            String.valueOf((LocalDate.now().getMonth()));
            boolean isPay= bookIssueBO.checkMemberPayment(memId);
            System.out.println(isPay);
            if(!isPay){
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String tl = "Can Not Issue BookDTO";
                String text = " MemberFeesDTO Not Complete ";
                Notification.showNotification(url, tl, text);
            }else if (isPay) {
                boolean isIssueBook = bookIssueBO.issueBook(issueBook);
                if (isIssueBook) {
loadNextIssueId();
                    String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                    String title = "Successful!";
                    String text = "BookDTO Issue Successful";
                    Notification.showNotification(url, title, text);
                    txtIssueId.setText("");
                    cmbBookId.setValue("");
                    cmbMmberId.setValue("");
                    txtissueDate.setValue(LocalDate.now());
                    txtdueDate.setValue(LocalDate.now().plusDays(14));
                    txtbkId.setText("");
                    txtbkName.setText("");
                    txtAddress.setText("");
                    txtAuthor.setText("");
                    txtMenId.setText("");
                    txtmemName.setText("");
                    txtQty.setText("");
                    txtTeleNum.setText("");
                    txtIssueId.requestFocus();
                } else {
                    String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                    String title = "UnSuccessful";
                    String text = "BookDTO Issue UnSuccessful";
                    Notification.showNotification(url, title, text);

                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    @FXML
    void memIdOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            checkPayment();
            try {
                searchMem();
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
          txtissueDate.requestFocus();
        }
    }
    private void loadMemberId() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = bookIssueBO.loadMemberIds();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbMmberId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadBookId() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = bookIssueBO.loadBookIds();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbBookId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadNextIssueId() {
        try {
            String orderId = bookIssueBO.generateNextId();
            txtIssueId.setText(orderId);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void issueDateOnKeyPress(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            String issueDate= String.valueOf(txtissueDate.getValue());
            txtdueDate.setValue(txtissueDate.getValue().plusDays(14));
            //LocalDate date= LocalDate.ofEpochDay(14);
          //  txtdueDate.setValue(LocalDate.parse(issueD+date));
            txtdueDate.requestFocus();
        }
    }

    public void issuOnKeyPress(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            cmbBookId.requestFocus();
        }
    }

    public void bookIdOnKeyPress(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            try {
                search();
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            cmbMmberId.requestFocus();
        }
    }

    public void checkPayment(){
        String memId= String.valueOf(cmbMmberId.getValue());
        try {
            String.valueOf((LocalDate.now().getMonth()));
            boolean isPay= bookIssueBO.checkMemberPayment(memId);
            System.out.println(isPay);
            if(!isPay){
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String tl = "Can Not Issue BookDTO";
                String text = " MemberFeesDTO Not Complete ";
                Notification.showNotification(url, tl, text);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public void search() throws SQLException, ClassNotFoundException {
        String id = String.valueOf(cmbBookId.getValue());
     BookDTO book =  bookIssueBO.bookSearch(id);

        if (book != null) {
            txtbkId.setText(book.getBookId());
            txtbkName.setText(book.getBookName());
            txtAuthor.setText(book.getAuthor());
            txtQty.setText(String.valueOf(book.getQtyOnHand()));
        }
    }
    public void searchMem() throws SQLException, ClassNotFoundException {
        String id = String.valueOf(cmbMmberId.getValue());
        MemberDTO member = bookIssueBO.searchMember(id);
        if (member != null) {
            txtMenId.setText(member.getMemberId());
            txtmemName.setText(member.getName());
            txtTeleNum.setText(String.valueOf(member.getTelephoneNumber()));
            txtAddress.setText(member.getAddress());
        }
    }
}


