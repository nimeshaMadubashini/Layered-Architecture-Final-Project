package lk.ijse.library.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.BookSearchBO;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class BookSearchFormController {
    @FXML
    private AnchorPane pane;
    @FXML
    private JFXTextField txtAuthorName;

    @FXML
    private JFXTextField txtBookName;
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
    BookSearchBO bookSearchBO = (BookSearchBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.SEARCH);

    public void initialize() {
        try {
            table();
            table1();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnAuthorlOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        table1();
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, pane);
    }

    @FXML
    void btnSearchBookOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        table();
    }

    public void table() throws SQLException, ClassNotFoundException {
        String bookName = txtBookName.getText();
        ObservableList<BookDTO> observableList = bookSearchBO.loadTableBookName(bookName);
        for (BookDTO b : observableList) {
            tableView.getItems().add(new BookDTO(b.getBookId(), b.getBookName(), b.getAuthor(), b.getIsbn(), b.getPublisher(),
                    b.getQtyOnHand(), b.getShelfNo(), b.getNumOfPage(), b.getAddBy(), b.getCategoryId()));
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
    }

    public void table1() throws SQLException, ClassNotFoundException {
        String author = txtAuthorName.getText();
        ObservableList<BookDTO> observableList = bookSearchBO.loadTableAuthorName(author);
        for (BookDTO b : observableList) {
            tableView.getItems().add(new BookDTO(b.getBookId(), b.getBookName(), b.getAuthor(), b.getIsbn(), b.getPublisher(),
                    b.getQtyOnHand(), b.getShelfNo(), b.getNumOfPage(), b.getAddBy(), b.getCategoryId()));
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
        }
    }
}