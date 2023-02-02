package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;

public class VeiweBookSupplyDetailFormController {
    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> colIssueId;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colMemberId;

    @FXML
    private TableColumn<?, ?> colIssuDate;

    @FXML
    private TableColumn<?, ?> colDueDate;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colStatus1;

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.BOOKSUPPLYDETAILS,pane);

    }
}

