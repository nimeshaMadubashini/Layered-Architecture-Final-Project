package lk.ijse.library.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.ManageOtherExpenditureBO;
import lk.ijse.library.dto.ExpenditureDTO;
import lk.ijse.library.dto.Notification;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class manageOtherExpenditureformController {
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtExpenditureId;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXDatePicker txtDate;

    @FXML
    private JFXTextField txtAmount;

    @FXML
    private TableView<ExpenditureDTO> tableView;

    @FXML
    private TableColumn colExpenditureId;

    @FXML
    private TableColumn colDescription;

    @FXML
    private TableColumn colAmount;

    @FXML
    private TableColumn colDate;

    @FXML
    private TableColumn colAddBy;

    @FXML
    private TableColumn colDate1;
int myIndex;
ManageOtherExpenditureBO expenditureBO= (ManageOtherExpenditureBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.EXPENDITURE1);

public void initialize(){
    try {
        table();
    }catch (SQLException | ClassNotFoundException ex){
        ex.printStackTrace();
    }

}
    @FXML
    void amountOnKeyPress(KeyEvent event) {

    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String id = txtExpenditureId.getText();
        String desc = txtDescription.getText();
        double amount = Double.parseDouble(txtAmount.getText());
        String localDate = (txtDate.getValue() != null ? txtDate.getValue().toString() : "");
        ExpenditureDTO expenditure = new ExpenditureDTO(id, desc, amount, localDate);
        try {
            myIndex = tableView.getSelectionModel().getSelectedIndex();
            boolean isAdd = expenditureBO.saveExpenditure(expenditure);
            if (isAdd) {
                table();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String tl = "Successful!";
                String text = "Added Successful";
                Notification.showNotification(url, tl, text);
                txtExpenditureId.setText("");
                txtDescription.setText("");
                txtAmount.setText("");
                txtDate.setValue(LocalDate.now());
            } else {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String tl = "UnSuccessful";
                String text = "Added UnSuccessful";
                Notification.showNotification(url, tl, text);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.FINANCIAL,pane);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtExpenditureId.getText();
        try {
            myIndex = tableView.getSelectionModel().getSelectedIndex();
            boolean isDelete = expenditureBO.deleteExpenditure(id);
            if (isDelete) {
                table();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String tl = "Successful!";
                String text = "Delete Successful";
                Notification.showNotification(url, tl, text);
                txtExpenditureId.setText("");
                txtDescription.setText("");
                txtAmount.setText("");
                txtDate.setValue(LocalDate.now());
            } else {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String tl = "UnSuccessful";
                String text = "Delete UnSuccessful";
                Notification.showNotification(url, tl, text);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtExpenditureId.getText();
        String desc = txtDescription.getText();
        double amount = Double.parseDouble(txtAmount.getText());
        String localDate = (txtDate.getValue() != null ? txtDate.getValue().toString() : "");
        ExpenditureDTO expenditure = new ExpenditureDTO(id, desc, amount, localDate);
        try {
            myIndex = tableView.getSelectionModel().getSelectedIndex();
            boolean isUpdate = expenditureBO.updateExpenditure(expenditure);
            if (isUpdate) {
                table();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String tl = "Successful!";
                String text = "Update Successful";
                Notification.showNotification(url, tl, text);
                txtExpenditureId.setText("");
                txtDescription.setText("");
                txtAmount.setText("");
                txtDate.setValue(LocalDate.now());
            } else {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String tl = "UnSuccessful";
                String text = "Update UnSuccessful";
                Notification.showNotification(url, tl, text);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void descOnKeyPress(KeyEvent event) {

    }

    @FXML
    void idOnKeyPress(KeyEvent event) {

    }
    public void table() throws SQLException, ClassNotFoundException {
  ObservableList<ExpenditureDTO> observableList=expenditureBO.loadexpenditureData();
        for (ExpenditureDTO e:observableList) {
            tableView.getItems().add(new ExpenditureDTO(e.getExpenditureId(),e.getDescription(),e.getAmount(), e.getDate(), e.getAddBy()));
        }

        tableView.setItems(observableList);
        colExpenditureId.setCellValueFactory(new PropertyValueFactory<>("expenditureId"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colAddBy.setCellValueFactory(new PropertyValueFactory<>("addBy"));

        tableView.setRowFactory(tv -> {
        TableRow<ExpenditureDTO> myRow = new TableRow<>();
        myRow.setOnMouseClicked(event ->
        {
            if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                myIndex = tableView.getSelectionModel().getSelectedIndex();
                txtExpenditureId.setText(tableView.getItems().get(myIndex).getExpenditureId());
                txtDescription.setText(tableView.getItems().get(myIndex).getDescription());
                txtAmount.setText(String.valueOf(tableView.getItems().get(myIndex).getAmount()));
                txtDate.setValue(LocalDate.parse(tableView.getItems().get(myIndex).getDate()));

            }
        });
        return myRow;
    });
}
}