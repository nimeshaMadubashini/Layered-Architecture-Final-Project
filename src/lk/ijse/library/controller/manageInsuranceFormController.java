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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.ManageInsuranceBO;
import lk.ijse.library.dto.InsuranceDTO;
import lk.ijse.library.dto.Notification;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class manageInsuranceFormController {
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtInsuranceId;

    @FXML
    private JFXTextField txtIsuranceType;

    @FXML
    private JFXTextField txtAnualPaymenr;

    @FXML
    private JFXTextField txtStatus;

    @FXML
    private JFXTextField txtAcceptBy;

    @FXML
    private JFXDatePicker txtPaydate;

    @FXML
    private JFXDatePicker txtRenewDate;

    @FXML
    private TableView<InsuranceDTO> tableView;

    @FXML
    private TableColumn colInsuranceId;

    @FXML
    private TableColumn colInsuranceType;

    @FXML
    private TableColumn colPayDate;

    @FXML
    private TableColumn colRenewDate;

    @FXML
    private TableColumn colAnalPaymentt;

    @FXML
    private TableColumn colStatus;

    @FXML
    private TableColumn colAcceptBy;
    int myIndex;
    ManageInsuranceBO insuranceBO= (ManageInsuranceBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.INSURENCE1);

public void initialize(){
    try {
        table();
    } catch (SQLException | ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
    if(LocalDate.now().equals(txtRenewDate)){
        String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
        String tl = "Reminder!";
        String text = "Renew  Insurance";
        Notification.showNotification(url, tl, text);
    }
}
    @FXML
    void btnAddOnAction(ActionEvent event) {
String id=txtInsuranceId.getText();
String type=txtIsuranceType.getText();
        String payDate = (txtPaydate.getValue() != null ? txtPaydate.getValue().toString() : "");
        String renewDate = (txtRenewDate.getValue() != null ? txtRenewDate.getValue().toString() : "");
        double amount= Double.parseDouble(txtAnualPaymenr.getText());
        InsuranceDTO insurance=new InsuranceDTO(id,type,payDate,renewDate,amount);
        try {
            myIndex = tableView.getSelectionModel().getSelectedIndex();
            boolean isSave= insuranceBO.saveInsurance(insurance);
            if (isSave) {
                table();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String tl = "Successful!";
                String text = "Insurence payment Added Successful";
                Notification.showNotification(url, tl, text);
                txtInsuranceId.setText("");
                txtIsuranceType.setText("");
                txtPaydate.setValue(LocalDate.now());
                txtRenewDate.setValue(txtPaydate.getValue().plusYears(1));
                txtAnualPaymenr.setText("");
                txtInsuranceId.requestFocus();
            } else {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String tl = "UnSuccessful";
                String text =  "Insurence payment Update UnSuccessful";
                Notification.showNotification(url, tl, text);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.FINANCIAL,pane);

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id=txtInsuranceId.getText();
        try {
            myIndex = tableView.getSelectionModel().getSelectedIndex();
            boolean isDelete= insuranceBO.DeleteInsurance(id);
            if (isDelete) {
                table();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String tl = "Successful!";
                String text = "Insurence payment Delete Successful";
                Notification.showNotification(url, tl, text);
                txtInsuranceId.setText("");
                txtIsuranceType.setText("");
                txtPaydate.setValue(LocalDate.now());
                txtRenewDate.setValue(txtPaydate.getValue().plusYears(1));
                txtAnualPaymenr.setText("");
                txtInsuranceId.requestFocus();
            } else {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String tl = "UnSuccessful";
                String text =  "Insurence payment Delete UnSuccessful";
                Notification.showNotification(url, tl, text);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }



    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id=txtInsuranceId.getText();
        String type=txtIsuranceType.getText();
        String payDate = (txtPaydate.getValue() != null ? txtPaydate.getValue().toString() : "");
        String renewDate = (txtRenewDate.getValue() != null ? txtRenewDate.getValue().toString() : "");
        double amount= Double.parseDouble(txtAnualPaymenr.getText());
        InsuranceDTO insurance=new InsuranceDTO(id,type,payDate,renewDate,amount);
        try {

            myIndex = tableView.getSelectionModel().getSelectedIndex();
            boolean isUpdate= insuranceBO.updateInsurance(insurance);
            if (isUpdate) {
                table();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String tl = "Successful!";
                String text = "Insurence payment Update Successful";
                Notification.showNotification(url, tl, text);
                txtInsuranceId.setText("");
                txtIsuranceType.setText("");
                txtPaydate.setValue(LocalDate.now());
                txtRenewDate.setValue(txtPaydate.getValue().plusYears(1));
                txtAnualPaymenr.setText("");
                txtInsuranceId.requestFocus();
            } else {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String tl = "UnSuccessful";
                String text =  "Insurence payment Update UnSuccessful";
                Notification.showNotification(url, tl, text);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void idOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtIsuranceType.requestFocus();
        }
    }

    @FXML
    void pydateOnKeypress(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER)){
            txtRenewDate.setValue(txtPaydate.getValue().plusYears(1));
            txtRenewDate.requestFocus();
        }
    }

    @FXML
    void renewDateOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtAnualPaymenr.requestFocus();
        }
    }

    @FXML
    void typeOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtPaydate.requestFocus();
        }
    }
    public void table() throws SQLException, ClassNotFoundException {
    ObservableList<InsuranceDTO> observableList=insuranceBO.LoadAllToInsuranceTable();
        for (InsuranceDTO i:observableList) {
            tableView.getItems().add(new InsuranceDTO(i.getInsurenceId(),i.getInsurenceType(),i.getPayDate(),i.getRenewDate(),
                    i.getAnualPayment(),i.getAcceptBy()));
        }

        tableView.setItems(observableList);
        colInsuranceId.setCellValueFactory(new PropertyValueFactory<>("insurenceId"));
        colInsuranceType.setCellValueFactory(new PropertyValueFactory<>("insurenceType"));
        colPayDate.setCellValueFactory(new PropertyValueFactory<>("payDate"));
        colRenewDate.setCellValueFactory(new PropertyValueFactory<>("renewDate"));
        colAnalPaymentt.setCellValueFactory(new PropertyValueFactory<>("anualPayment"));
        colAcceptBy.setCellValueFactory(new PropertyValueFactory<>("acceptBy"));

        tableView.setRowFactory(tv -> {
            TableRow<InsuranceDTO> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = tableView.getSelectionModel().getSelectedIndex();
                    txtInsuranceId.setText(tableView.getItems().get(myIndex).getInsurenceId());
                    txtIsuranceType.setText(tableView.getItems().get(myIndex).getInsurenceType());
                    txtPaydate.setValue(LocalDate.parse(tableView.getItems().get(myIndex).getPayDate()));
                    txtRenewDate.setValue(LocalDate.parse(tableView.getItems().get(myIndex).getRenewDate()));
                    txtAnualPaymenr.setText(String.valueOf(tableView.getItems().get(myIndex).getAnualPayment()));

                }
            });
            return myRow;
        });
    }

}
