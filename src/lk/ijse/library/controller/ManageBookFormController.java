package lk.ijse.library.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.ManageBookBO;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.Notification;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManageBookFormController {


    public AnchorPane pane;


    @FXML
    private JFXTextField txtBookId;

    @FXML
    private JFXTextField txtAuthor;

    @FXML
    private JFXTextField txtBookName;

    @FXML
    private JFXTextField txtNumOfPage;

    @FXML
    private JFXTextField txtShelfNo;


    @FXML
    private JFXTextField txtIsbn;

    @FXML
    private JFXTextField txtPublisher;

    @FXML
    private JFXTextField txtQtyOnHand;

    @FXML
    private Label lblBookId;

    @FXML
    private Label lblBookName;

    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblIsbn;

    @FXML
    private Label lblPublisher;

    @FXML
    private Label lblQtyOnHand;

    @FXML
    private Label lblShelNo;

    @FXML
    private Label lblNumOfPage;

    @FXML
    private Label lblCatgry;

    @FXML
    private TableView<BookDTO> tableView;

    @FXML
    private TableColumn cokBookId;

    @FXML
    private TableColumn colBookName;

    @FXML
    private TableColumn colAuthor;

    @FXML
    private TableColumn colISBN;

    @FXML
    private TableColumn colPublisher;

    @FXML
    private TableColumn colQtyOnhand;

    @FXML
    private TableColumn colShelfNo;

    @FXML
    private TableColumn colNumOfPage1;

    @FXML
    private TableColumn colAddBy;

    @FXML
    private TableColumn colCategoryId;
    @FXML
    private JFXComboBox txtCategoryId;

    ManageBookBO bookBO= (ManageBookBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.MANAGEBOOK1);
    int myIndex;

public void initialize(){
loadNexId();
loadCategory();
setPattern();
    try {
        table();

    } catch (SQLException throwables) {
        throwables.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}
    @FXML
    void authorOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtIsbn.requestFocus();
        }
    }

    @FXML
    void authorOnKeyRelease(KeyEvent event){
        lblAuthor.setText("");
        txtAuthor.setFocusColor(Paint.valueOf("Blue"));
        Pattern authorNamepattern = Pattern.compile("^[a-zA-Z\\s]+");
        authornameMatcher = authorNamepattern.matcher(txtAuthor.getText());

        if (!authornameMatcher.matches()) {
            txtAuthor.requestFocus();
            txtAuthor.setFocusColor(Paint.valueOf("Red"));
            lblAuthor.setText("Invalid  Author Name");
        }
    }
    private Matcher shelfNumMatcher;
    private Matcher nameMatcher;
    private Matcher authornameMatcher;
    private Matcher isbnMatcher;
    private Matcher pageNumMatcher;
    private Matcher qtyMatcher;
private Matcher pubnameMatcher;

    private void setPattern() {

        Pattern booknamePattern = Pattern.compile("^[a-zA-Z\\s]+");
        nameMatcher = booknamePattern.matcher(txtBookName.getText());

Pattern authorNamepattern = Pattern.compile("^[a-zA-Z\\s]+");
        authornameMatcher = authorNamepattern.matcher(txtAuthor.getText());

        Pattern publishePattern = Pattern.compile("^[a-zA-Z\\s]+");
        pubnameMatcher = publishePattern.matcher(txtPublisher.getText());

        Pattern isbnPattern = Pattern.compile("^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$");
        isbnMatcher = isbnPattern.matcher(txtIsbn.getText());

        Pattern qty = Pattern.compile("^[0-9]+");
        qtyMatcher = qty.matcher(txtQtyOnHand.getText());

          Pattern ShelfNum = Pattern.compile("^[0-9]+");
        shelfNumMatcher = ShelfNum.matcher(txtShelfNo.getText());

          Pattern numOFPage = Pattern.compile("^[0-9]+");
       pageNumMatcher = numOFPage.matcher(txtNumOfPage.getText());
    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
String bookId=txtBookId.getText();
String bookName=txtBookName.getText();
String author=txtAuthor.getText();
String isbn=txtIsbn.getText();
String publisher=txtPublisher.getText();
int qtyOnHand= Integer.parseInt(txtQtyOnHand.getText());
int shelfNo= Integer.parseInt(txtShelfNo.getText());
int  numOfPage= Integer.parseInt(txtNumOfPage.getText());
String categoryId= String.valueOf(txtCategoryId.getValue());
        BookDTO book=new BookDTO(bookId,bookName,author,isbn,publisher,qtyOnHand,shelfNo,numOfPage,categoryId);
       try{
           if (nameMatcher.matches()) {
               if (authornameMatcher.matches()) {
                   if (isbnMatcher.matches()) {
                   if (pubnameMatcher.matches()) {
                       if (qtyMatcher.matches()) {
                           if (shelfNumMatcher.matches()) {
                               if (pageNumMatcher.matches()) {
           boolean isAdd=bookBO.saveBook(book);
           myIndex = tableView.getSelectionModel().getSelectedIndex();
           if(isAdd){
               table();
               loadNexId();
               String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
               String title = "Successful!";
               String text = "Book Added Successful";
               Notification.showNotification(url, title, text);
               txtBookId.setText("");
               txtBookName.setText("");
               txtAuthor.setText("");
               txtIsbn.setText("");
               txtAuthor.setText("");
               txtCategoryId.setValue("");
               txtNumOfPage.setText("");
               txtQtyOnHand.setText("");
               txtShelfNo.setText("");
               txtBookId.requestFocus();

           }else {
               String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
               String title = "UnSuccessful";
               String text = "Book Added UnSuccessful";
               Notification.showNotification(url, title, text);
           }
                               } else {
                                   txtNumOfPage.requestFocus();
                                   txtNumOfPage.setFocusColor(Paint.valueOf("Red"));
                                   lblNumOfPage.setText("Invalid  Number");
                               }
                               } else {
                                   txtShelfNo.requestFocus();
                                   txtShelfNo.setFocusColor(Paint.valueOf("Red"));
                                   lblShelNo.setText("Invalid  Number");
                               }
                           } else {
                               txtQtyOnHand.requestFocus();
                               txtQtyOnHand.setFocusColor(Paint.valueOf("Red"));
                               lblQtyOnHand.setText("Invalid  Number");
                           }
                       } else {
                       txtPublisher.requestFocus();
                       txtPublisher.setFocusColor(Paint.valueOf("Red"));
                       lblPublisher.setText("Invalid Name");
                       }

                   } else {
                       txtIsbn.requestFocus();
                       txtIsbn.setFocusColor(Paint.valueOf("Red"));
                       lblIsbn.setText("Invalid ISBN num");

                   }
               } else {
                   txtAuthor.requestFocus();
                   txtAuthor.setFocusColor(Paint.valueOf("Red"));
                   lblPublisher.setText("Invalid Publisher");

               }

           } else {
               txtBookName.requestFocus();
               txtBookName.setFocusColor(Paint.valueOf("Red"));
               lblBookName.setText("Invalid Book Name");

           }

       } catch (SQLException | ClassNotFoundException e) {
           System.out.println(e);;
        }
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,pane);

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        String bookId=txtBookId.getText();
        try {
            myIndex = tableView.getSelectionModel().getSelectedIndex();
            boolean idDelete=bookBO.deleteBook(bookId);
            if(idDelete){
                table();
                loadNexId();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String title = "Successful!";
                String text = "Delete Successful";
                Notification.showNotification(url, title, text);
                txtBookId.setText("");
                txtBookName.setText("");
                txtAuthor.setText("");
                txtIsbn.setText("");
                txtAuthor.setText("");
                txtCategoryId.setValue("");
                txtNumOfPage.setText("");
                txtQtyOnHand.setText("");
                txtShelfNo.setText("");
                txtBookId.requestFocus();
            }else{
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String title = "UnSuccessful";
                String text = "Delete UnSuccessful";
                Notification.showNotification(url, title, text);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        String bookId=txtBookId.getText();
        String bookName=txtBookName.getText();
        String author=txtAuthor.getText();
        String isbn=txtIsbn.getText();
        String publisher=txtPublisher.getText();
        int qtyOnHand= Integer.parseInt(txtQtyOnHand.getText());
        int shelfNo= Integer.parseInt(txtShelfNo.getText());
        int  numOfPage= Integer.parseInt(txtNumOfPage.getText());
        String categoryId= String.valueOf(txtCategoryId.getValue());
        BookDTO book=new BookDTO(bookId,bookName,author,isbn,publisher,qtyOnHand,shelfNo,numOfPage,categoryId);
        try {
            myIndex = tableView.getSelectionModel().getSelectedIndex();
            boolean isUpdate=bookBO.updateBook(book);
            if(isUpdate){
                table();
                loadNexId();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String title = "Successful!";
                String text = "Book Updated Successful";
                Notification.showNotification(url, title, text);
                txtBookId.setText("");
                txtBookName.setText("");
                txtAuthor.setText("");
                txtIsbn.setText("");
                txtAuthor.setText("");
                txtCategoryId.setValue("");
                txtNumOfPage.setText("");
                txtQtyOnHand.setText("");
                txtShelfNo.setText("");
                txtBookId.requestFocus();
            }else {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String title = "UnSuccessful";
                String text = "Book Updated UnSuccessful";
                Notification.showNotification(url, title, text);
            }
        }catch (SQLException | ClassNotFoundException exception){
            System.out.println(exception);
        }

    }



    @FXML
    void isbnOnKeyPrsse(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtPublisher.requestFocus();
        }

    }

    @FXML
    void isbnOnKeyRelease(KeyEvent event) {
        lblIsbn.setText("");
        txtIsbn.setFocusColor(Paint.valueOf("Blue"));
        Pattern isbnPattern = Pattern.compile("^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$");
        isbnMatcher = isbnPattern.matcher(txtIsbn.getText());

        if (!isbnMatcher.matches()) {
            txtIsbn.requestFocus();
            txtIsbn.setFocusColor(Paint.valueOf("Red"));
            lblIsbn.setText("Invalid  ISBN number");
        }
    }

    @FXML
    void memIdOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtBookName.requestFocus();
        }
    }

    @FXML
    void memIdOnKeyRelesed(KeyEvent event) {

    }

    @FXML
    void nameOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtAuthor.requestFocus();
        }
    }

    @FXML
    void nameOnKeyRelese(KeyEvent event) {
        lblBookName.setText("");
        txtBookName.setFocusColor(Paint.valueOf("Blue"));
        Pattern booknamePattern = Pattern.compile("^[a-zA-Z\\s]+");
        nameMatcher = booknamePattern.matcher(txtBookName.getText());

        if (!nameMatcher.matches()) {
            txtBookName.requestFocus();
            txtBookName.setFocusColor(Paint.valueOf("Red"));
            lblBookName.setText("Invalid Book Name");

        }
    }

    @FXML
    void pageOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtCategoryId.requestFocus();
        }
    }

    @FXML
    void pageOnKeyRelese(KeyEvent event) {
        lblNumOfPage.setText("");
        txtNumOfPage.setFocusColor(Paint.valueOf("Blue"));
        Pattern numOFPage = Pattern.compile("^[0-9]+");
        pageNumMatcher = numOFPage.matcher(txtNumOfPage.getText());

        if (!pageNumMatcher.matches()) {
            txtNumOfPage.requestFocus();
            txtNumOfPage.setFocusColor(Paint.valueOf("Red"));
            lblNumOfPage.setText("Invalid  Number");

        }

    }

    @FXML
    void publisherOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtQtyOnHand.requestFocus();
        }
    }

    @FXML
    void publisherOnKeyRelease(KeyEvent event) {
        lblPublisher.setText("");
        txtPublisher.setFocusColor(Paint.valueOf("Blue"));
        Pattern publishePattern = Pattern.compile("^[a-zA-Z\\s]+");
        pubnameMatcher = publishePattern.matcher(txtPublisher.getText());

        if (!pubnameMatcher.matches()) {
            txtPublisher.requestFocus();
            txtPublisher.setFocusColor(Paint.valueOf("Red"));
            lblPublisher.setText("Invalid Name");
        }
    }

    @FXML
    void qtuOnKeyPrss(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtShelfNo.requestFocus();
        }
    }

    @FXML
    void qtyOnKeyrelese(KeyEvent event) {
        lblQtyOnHand.setText("");
        txtQtyOnHand.setFocusColor(Paint.valueOf("Blue"));
        Pattern qty = Pattern.compile("^[0-9]+");
        qtyMatcher = qty.matcher(txtQtyOnHand.getText());

        if (!qtyMatcher.matches()){
            txtQtyOnHand.requestFocus();
            txtQtyOnHand.setFocusColor(Paint.valueOf("Red"));
            lblQtyOnHand.setText("Invalid  Number");
        }
    }

    @FXML
    void shelfIdOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtNumOfPage.requestFocus();
        }
    }

    @FXML
    void shelfIdOnKeyRelese(KeyEvent event) {
        lblShelNo.setText("");
        txtShelfNo.setFocusColor(Paint.valueOf("Blue"));
        Pattern ShelfNum = Pattern.compile("^[0-9]+");
        shelfNumMatcher =ShelfNum.matcher(txtQtyOnHand.getText());

        if (!shelfNumMatcher.matches()){

            txtShelfNo.requestFocus();
            txtShelfNo.setFocusColor(Paint.valueOf("Red"));
            lblShelNo.setText("Invalid  Number");
        }
    }
    private void loadCategory(){
        try {
            ObservableList<String> ob = FXCollections.observableArrayList();
            ArrayList<String> idList = bookBO.loadBookIds();

            for (String id : idList) {
                ob.add(id);
            }
            txtCategoryId.setItems(ob);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
public void table() throws SQLException, ClassNotFoundException {
ObservableList<BookDTO> observableList= bookBO.loadToTable();
    for (BookDTO b:observableList)
        tableView.getItems().add(new BookDTO(b.getBookId(), b.getBookName(), b.getAuthor(), b.getIsbn(), b.getPublisher(),
                b.getQtyOnHand(), b.getShelfNo(), b.getNumOfPage(), b.getAddBy(), b.getCategoryId())); {

    }

            tableView.setItems(observableList);
          cokBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
          colBookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
          colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
          colISBN.setCellValueFactory(new PropertyValueFactory<>("isbn"));
          colPublisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
          colQtyOnhand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
          colShelfNo.setCellValueFactory(new PropertyValueFactory<>("shelfNo"));
          colNumOfPage1.setCellValueFactory(new PropertyValueFactory<>("numOfPage"));
          colAddBy.setCellValueFactory(new PropertyValueFactory<>("addBy"));
          colCategoryId.setCellValueFactory(new PropertyValueFactory<>("categoryId"));
    tableView.setRowFactory(tv -> {
        TableRow<BookDTO> myRow = new TableRow<>();
        myRow.setOnMouseClicked(event ->
        {
            if (event.getClickCount() == 1 && (!myRow.isEmpty())) {

                myIndex = tableView.getSelectionModel().getSelectedIndex();
                txtBookId.setText(tableView.getItems().get(myIndex).getBookId());
                txtBookName.setText(tableView.getItems().get(myIndex).getBookName());
                txtAuthor.setText(tableView.getItems().get(myIndex).getAuthor());
                txtIsbn.setText(tableView.getItems().get(myIndex).getIsbn());
                txtPublisher.setText(tableView.getItems().get(myIndex).getPublisher());
                txtQtyOnHand.setText(String.valueOf(tableView.getItems().get(myIndex).getQtyOnHand()));
                txtShelfNo.setText(String.valueOf(tableView.getItems().get(myIndex).getShelfNo()));
                txtNumOfPage.setText(String.valueOf(tableView.getItems().get(myIndex).getNumOfPage()));
                txtCategoryId.setValue(tableView.getItems().get(myIndex).getCategoryId());


            }
        });
        return myRow;
    });

}
    private void loadNexId() {
        try {
            String orderId = bookBO.generateNextBookId();
            txtBookId.setText(orderId);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
