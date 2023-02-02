package lk.ijse.library.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.BookSupplyDetailBO;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.BookSupplyDetailsDTO;
import lk.ijse.library.dto.GranterDTO;
import lk.ijse.library.dto.Notification;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookSuplyDetailsFormController {
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtGranterId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtTeleNum;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXTextField txtAuthor;

    @FXML
    private JFXTextField txtbkName;

    @FXML
    private JFXTextField txtbkId;
    @FXML
    private JFXTextField txtBookQty;


    @FXML
    private JFXTextField txtBookId;

    @FXML
    private JFXTextField txtSuuplyId;

    @FXML
    private JFXTextField txtUnitPrice;

    @FXML
    private JFXTextField txtTotal;

    @FXML
    private JFXComboBox cmbBookId;
    @FXML
    private JFXComboBox cmbGrId;

    @FXML
    private JFXDatePicker txtDate;
    @FXML
    private JFXComboBox cmbSupplyId;
    BookSupplyDetailBO bookSupplyDetailBO= (BookSupplyDetailBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.BOOKSUPPLYDETAIL1);


    public void initialize() {


        try {
            loadBookId();
            loadSupplyId();
            loadGranterIds();
            loadNexId();
        }catch (NullPointerException i){

        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String supplyId = txtSuuplyId.getText();
        String bookId = String.valueOf(cmbBookId.getValue());
        String granterId = String.valueOf(cmbGrId.getValue());
        int supplyQty = Integer.parseInt(txtBookQty.getText());
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        double total = Double.parseDouble(txtTotal.getText());
        txtTotal.setText(String.valueOf(supplyQty * unitPrice));
        String supplyDate = (txtDate.getValue() != null ? txtDate.getValue().toString() : "");
        BookSupplyDetailsDTO bookSupplyDetails = new BookSupplyDetailsDTO(supplyId, bookId, granterId, supplyQty, unitPrice, total, supplyDate);
        try {
            boolean isAdd = bookSupplyDetailBO.saveBookSupplyDetail(bookSupplyDetails);
            if (isAdd) {
                loadBookId();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String title = "Successful!";
                String text = "BookDTO Supply Detail added Successful";
                Notification.showNotification(url, title, text);
                loadSupplyId();
                txtSuuplyId.setText("");
                cmbBookId.setValue("");
                cmbGrId.setValue("");
                txtBookQty.setText("");
                txtUnitPrice.setText("");
                txtTotal.setText("");
                txtDate.setValue(LocalDate.now());
                txtbkId.setText("");
                txtbkName.setText("");
                txtAuthor.setText("");
                txtQty.setText("");
                txtGranterId.setText("");
                txtName.setText("");
                txtAddress.setText("");
                txtTeleNum.setText("");
                txtSuuplyId.requestFocus();
            } else {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String title = "UnSuccessful";
                String text = "BookDTO Supply Detail addes UnSuccessful";
                Notification.showNotification(url, title, text);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            ;
        }

    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, pane);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String supplyId = txtSuuplyId.getText();
        try {
            boolean isDelete = bookSupplyDetailBO.DeleteBookSupplyDetail(supplyId);
            if (isDelete) {
                loadSupplyId();
                loadNexId();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String title = "Successful!";
                String text = "BookDTO Supply Detail Delete Successful";
                Notification.showNotification(url, title, text);
                txtSuuplyId.setText("");
                cmbBookId.setValue("");
                cmbGrId.setValue("");
                txtBookQty.setText("");
                txtUnitPrice.setText("");
                txtTotal.setText("");
                txtDate.setValue(LocalDate.now());
                txtbkId.setText("");
                txtbkName.setText("");
                txtAuthor.setText("");
                txtQty.setText("");
                txtGranterId.setText("");
                txtName.setText("");
                txtAddress.setText("");
                txtTeleNum.setText("");
                txtSuuplyId.requestFocus();
            } else {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String title = "UnSuccessful";
                String text = "BookDTO Supply Detail Delete UnSuccessful";
                Notification.showNotification(url, title, text);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("student page" + ex);
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String supplyIdCmb = String.valueOf(cmbSupplyId.getValue());
        try {
            BookSupplyDetailsDTO bookSupplyDetails = bookSupplyDetailBO.searchBookSupplyDetail(supplyIdCmb);
            if (bookSupplyDetails != null) {
                txtSuuplyId.setText(bookSupplyDetails.getSupplyId());
                cmbBookId.setValue(bookSupplyDetails.getBookId());
                search();
                cmbGrId.setValue(bookSupplyDetails.getGranterId());
                searchGranter();
                txtBookQty.setText(String.valueOf(bookSupplyDetails.getSupplyQty()));
                txtUnitPrice.setText(String.valueOf(bookSupplyDetails.getUnitPrice()));
                txtTotal.setText(String.valueOf(bookSupplyDetails.getTotal()));
                txtDate.setValue(LocalDate.parse(bookSupplyDetails.getSupplyDate()));

            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String supplyId = txtSuuplyId.getText();
        String bookId = String.valueOf(cmbBookId.getValue());
        String granterId = String.valueOf(cmbGrId.getValue());
        int supplyQty = Integer.parseInt(txtBookQty.getText());
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        double total = Double.parseDouble(txtTotal.getText());
        txtTotal.setText(String.valueOf(supplyQty * unitPrice));
        String supplyDate = (txtDate.getValue() != null ? txtDate.getValue().toString() : "");
        BookSupplyDetailsDTO bookSupplyDetails = new BookSupplyDetailsDTO(supplyId, bookId, granterId, supplyQty, unitPrice, total, supplyDate);
        try {
            boolean isUpdate = bookSupplyDetailBO.
            updateBookSupplyDetail(bookSupplyDetails);
            if (isUpdate) {
                loadNexId();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String title = "Successful!";
                String text = "BookDTO Supply Detail Update Successful";
                Notification.showNotification(url, title, text);
                txtSuuplyId.setText("");
                cmbBookId.setValue("");
                cmbGrId.setValue("");
                txtBookQty.setText("");
                txtUnitPrice.setText("");
                txtTotal.setText("");
                txtDate.setValue(LocalDate.now());
                txtbkId.setText("");
                txtbkName.setText("");
                txtAuthor.setText("");
                txtQty.setText("");
                txtGranterId.setText("");
                txtName.setText("");
                txtAddress.setText("");
                txtTeleNum.setText("");
                txtSuuplyId.requestFocus();
            } else {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String title = "UnSuccessful";
                String text = "BookDTO Supply Detail Update UnSuccessful";
                Notification.showNotification(url, title, text);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            ;
        }

    }


    @FXML
    void unitPriceOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            int supplyQty = Integer.parseInt(txtBookQty.getText());
            double unitPrice = Double.parseDouble(txtUnitPrice.getText());
            txtDate.requestFocus();
            txtTotal.setText(String.valueOf(supplyQty * unitPrice));
        }

    }

    @FXML
    void granterPressed(MouseEvent event) {
        try {
            searchGranter();
        }catch (NullPointerException ex){

        }

    }

    @FXML
    void move(MouseEvent event) {
        try {
            searchGranter();
        }catch (NullPointerException ex){

        }

    }

    @FXML
    void bookIdMouseMove(MouseEvent event) {
        try {
            search();
        } catch (SQLException throwables) {

        } catch (ClassNotFoundException | NullPointerException e) {

        }
    }

    @FXML
    void bookIdOnMosePress(MouseEvent event) {
        try {
            search();
        } catch (SQLException throwables) {


        } catch (ClassNotFoundException | NullPointerException e) {

        }
    }

    @FXML
    void sQtyKyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtUnitPrice.requestFocus();
        }
    }

    @FXML
    void spIdKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            cmbBookId.requestFocus();
        }
    }


    @FXML
    void grtIdKeyPress(KeyEvent event) {
        try {
            if (event.getCode().equals(KeyCode.ENTER)) {
                searchGranter();
                txtBookQty.requestFocus();
            }
        }catch (NullPointerException e){

        }

    }

    @FXML
    void bookIdKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            try {
                search();
            } catch (SQLException | ClassNotFoundException | NullPointerException throwables) {

            }
            cmbGrId.requestFocus();
        }
    }


    private void loadBookId() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = bookSupplyDetailBO.loadBookIds();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbBookId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException | NullPointerException e) {

        }
    }

    private void loadGranterIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = bookSupplyDetailBO.loadGranterIds();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbGrId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException | NullPointerException e) {


        }
    }

    private void loadSupplyId() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = bookSupplyDetailBO.loadBookSupplyDetailIds();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbSupplyId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException | NullPointerException e) {

        }
    }

    public void search() throws SQLException, ClassNotFoundException,NullPointerException {
        String id = String.valueOf(cmbBookId.getValue());
        BookDTO book = bookSupplyDetailBO.searchBook(id);
        if (book != null) {
            txtbkId.setText(book.getBookId());
            txtbkName.setText(book.getBookName());
            txtAuthor.setText(book.getAuthor());
            txtQty.setText(String.valueOf(book.getQtyOnHand()));
        }
    }

    public void searchGranter() {
        String grId = String.valueOf(cmbGrId.getValue());
        try {
            GranterDTO granter = bookSupplyDetailBO.searchGranter(grId);
            if (granter != null) {
                txtGranterId.setText(granter.getGranterId());
                txtName.setText(granter.getName());
                txtAddress.setText(granter.getAddress());
                txtTeleNum.setText(String.valueOf(granter.getTelephoneNumber()));
            }

        } catch (SQLException | ClassNotFoundException | NullPointerException ex) {

        }
    }
    private void loadNexId() {
        try {
            String orderId = bookSupplyDetailBO.generateNextBookSupplyId();
            txtSuuplyId.setText(orderId);
        } catch (SQLException | ClassNotFoundException | NullPointerException e) {

        }
    }
}

