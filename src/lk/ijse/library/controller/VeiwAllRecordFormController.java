package lk.ijse.library.controller;

import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.ViewAllRecordBO;
import lk.ijse.library.dto.IssueBookDTO;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class VeiwAllRecordFormController {
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXDatePicker txtissueDate;

    @FXML
    private JFXDatePicker txtdueDate;

    @FXML
    private TableView<IssueBookDTO> tableView;

    @FXML
    private TableColumn colIssueId;

    @FXML
    private TableColumn colBookId;

    @FXML
    private TableColumn colMemberId;

    @FXML
    private TableColumn colIssuDate;

    @FXML
    private TableColumn colDueDate;

    @FXML
    private TableColumn colStatus;
    ViewAllRecordBO allRecordBO= (ViewAllRecordBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.VEIWALLRECORD1);
    @FXML
    void btnAllOnAction(ActionEvent event) {
        try {
            table();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void btnSearchOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String localDate = (txtissueDate.getValue() != null ? txtissueDate.getValue().toString() : "");
        String localDate2 = (txtdueDate.getValue() != null ? txtdueDate.getValue().toString() : "");

        ObservableList<IssueBookDTO> observableList = allRecordBO.loadDataSearchingDate(localDate,localDate2);
        for (IssueBookDTO i:observableList) {
         tableView.getItems().add(new IssueBookDTO(i.getIssueId(),i.getBookId(),i.getMemberId(),i.getIssueDate(),
                 i.getDueDate(),i.getStatus()));
        }

        tableView.setItems(observableList);
        colIssueId.setCellValueFactory(new PropertyValueFactory<>("issueId"));
        colBookId.setCellValueFactory(new PropertyValueFactory<>("BookId"));
        colMemberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colIssuDate.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }


    public void initialize(){
        try {
            table();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,pane);
    }
    @FXML
    void issueDateOnKeyPress(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER)){
            txtdueDate.requestFocus();
        }
    }

    public void table() throws SQLException, ClassNotFoundException {
       ObservableList<IssueBookDTO> observableList=allRecordBO.loadAllIssueBookDetailToTable();
        for (IssueBookDTO is:observableList) {
            tableView.getItems().add(new IssueBookDTO(is.getIssueId(),is.getBookId(),is.getMemberId(),is.getIssueDate(),
                    is.getDueDate(),is.getStatus()));
        }
        tableView.setItems(observableList);
        colIssueId.setCellValueFactory(new PropertyValueFactory<>("issueId"));
        colBookId.setCellValueFactory(new PropertyValueFactory<>("BookId"));
        colMemberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colIssuDate.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }
}
