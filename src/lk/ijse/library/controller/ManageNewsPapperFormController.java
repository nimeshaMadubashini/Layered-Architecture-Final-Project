package lk.ijse.library.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.ManageNewsPaperBO;
import lk.ijse.library.dto.NewsPaperDTO;
import lk.ijse.library.dto.Notification;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManageNewsPapperFormController {
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtNewspprId;

    @FXML
    private JFXTextField txtnwspprName;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXTextField txtAcceotBy;

    @FXML
    private JFXTextField txtSuuplyBy;

    @FXML
    private JFXDatePicker txtDatePicker;
    @FXML
    private JFXComboBox cmbSupplyId;

    @FXML
    private TableView<NewsPaperDTO> tableView;

    @FXML
    private TableColumn ColNewsPaperId;

    @FXML
    private TableColumn colTitle;

    @FXML
    private TableColumn colQty;

    @FXML
    private TableColumn colDate;

    @FXML
    private TableColumn colAcceptBy;

    @FXML
    private TableColumn colSupplyBy;
    ManageNewsPaperBO newsPaperBO= (ManageNewsPaperBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.NEWSPAPER1);

    int myIndex;
public void initialize(){
    loadGranterIds();
    try {
        table();
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}
    @FXML
    void btnAddOnAction(ActionEvent event) {
String id=txtNewspprId.getText();
String title=txtnwspprName.getText();
        int qty= Integer.parseInt(txtQty.getText());
        String localDate = (txtDatePicker.getValue() != null ? txtDatePicker.getValue().toString() : "");
        String granterId= String.valueOf(cmbSupplyId.getValue());
        NewsPaperDTO newsPaper=new NewsPaperDTO(id,title,qty,localDate,granterId);
try {
    myIndex = tableView.getSelectionModel().getSelectedIndex();
    boolean isAdd = newsPaperBO.saveNewsPaper(newsPaper);
    if (isAdd) {
        table();
        String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
        String tl = "Successful!";
        String text = "Added Successful";
        Notification.showNotification(url, tl, text);
        txtNewspprId.setText("");
        txtnwspprName.setText("");
        txtDatePicker.setValue(LocalDate.now());
        txtQty.setText("");
        cmbSupplyId.setValue("");
        txtNewspprId.requestFocus();
    } else {
        String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
        String tl = "UnSuccessful";
        String text = "Added UnSuccessful";
        Notification.showNotification(url, tl, text);
    }
}catch (SQLException | ClassNotFoundException ex){
    ex.printStackTrace();

}
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,pane);

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id=txtNewspprId.getText();
        try {
            myIndex = tableView.getSelectionModel().getSelectedIndex();
            boolean isDelete = newsPaperBO.DeleteNewsPaper(id);
            if (isDelete) {
                table();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String title = "Successful!";
                String text = "Delete Successful";
                Notification.showNotification(url, title, text);
                txtNewspprId.setText("");
                txtnwspprName.setText("");
                txtDatePicker.setValue(LocalDate.now());
                txtQty.setText("");
                cmbSupplyId.setValue("");
                txtNewspprId.requestFocus();
            } else {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String title = "UnSuccessful";
                String text = "Delete UnSuccessful";
                Notification.showNotification(url, title, text);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("student page" + ex);
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id=txtNewspprId.getText();
        String title=txtnwspprName.getText();
        int qty= Integer.parseInt(txtQty.getText());
        String localDate = (txtDatePicker.getValue() != null ? txtDatePicker.getValue().toString() : "");
        String granterId= String.valueOf(cmbSupplyId.getValue());
        NewsPaperDTO newsPaper=new NewsPaperDTO(id,title,qty,localDate,granterId);
        try {
            myIndex = tableView.getSelectionModel().getSelectedIndex();
            boolean isUpdate=newsPaperBO.updateNewsPaper(newsPaper);
            if(isUpdate){
                table();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String tl = "Successful!";
                String text = "Update Successful";
                Notification.showNotification(url, tl, text);
                txtNewspprId.setText("");
                txtnwspprName.setText("");
                txtDatePicker.setValue(LocalDate.now());
                txtQty.setText("");
                cmbSupplyId.setValue("");
                txtNewspprId.requestFocus();
            } else {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String tl = "UnSuccessful";
                String text = "Update UnSuccessful";
                Notification.showNotification(url, tl, text);

            }
        } catch (SQLException |ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    @FXML
    void dateOnKeyPrss(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            cmbSupplyId.requestFocus();
        }
    }

    @FXML
    void idOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtnwspprName.requestFocus();
        }
    }

    @FXML
    void nameOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtQty.requestFocus();
        }
    }

    @FXML
    void qtyOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtDatePicker.requestFocus();
        }
    }
    private void loadGranterIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = newsPaperBO.loadGranterIds();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbSupplyId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void table() throws SQLException, ClassNotFoundException {
    ObservableList<NewsPaperDTO> observableList=newsPaperBO.loadNewsPaperToTable();
        for (NewsPaperDTO n:observableList) {
            tableView.getItems().add(new NewsPaperDTO(n.getNewsPaperId(),n.getTitle(),n.getQty(),
                    n.getDate(),n.getAcceptBy(),n.getSupplyBy()));
        }
        tableView.setItems(observableList);
        ColNewsPaperId.setCellValueFactory(new PropertyValueFactory<>("newsPaperId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colAcceptBy.setCellValueFactory(new PropertyValueFactory<>("acceptBy"));
        colSupplyBy.setCellValueFactory(new PropertyValueFactory<>("supplyBy"));

        tableView.setRowFactory(tv -> {
            TableRow<NewsPaperDTO> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = tableView.getSelectionModel().getSelectedIndex();
                    txtNewspprId.setText(tableView.getItems().get(myIndex).getNewsPaperId());
                    txtnwspprName.setText(tableView.getItems().get(myIndex).getTitle());
                    txtQty.setText(String.valueOf(tableView.getItems().get(myIndex).getQty()));
                    txtDatePicker.setValue(LocalDate.parse(tableView.getItems().get(myIndex).getDate()));
                    cmbSupplyId.setValue(tableView.getItems().get(myIndex).getSupplyBy());
                }
            });
            return myRow;
        });
    }

}
