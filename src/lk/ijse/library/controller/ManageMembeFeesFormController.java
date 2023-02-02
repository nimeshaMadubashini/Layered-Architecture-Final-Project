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
import lk.ijse.library.bo.custom.ManageMemberFeesBO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.MemberFeesDTO;
import lk.ijse.library.dto.Notification;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class ManageMembeFeesFormController {
    @FXML
    private AnchorPane pane;
    @FXML
    private JFXTextField txtFeesId;

    @FXML
    private JFXTextField txtMonth;

    @FXML
    private JFXDatePicker txtpayDate;

    @FXML
    private JFXTextField txtAmount;

    @FXML
    private JFXComboBox cmbMemberID;

    @FXML
    private TableView<MemberFeesDTO> tableView;

    @FXML
    private TableColumn colFeesId;

    @FXML
    private TableColumn colMemberId;

    @FXML
    private TableColumn colMonth;

    @FXML
    private TableColumn colAmounth;

    @FXML
    private TableColumn colAcceptDate;

    @FXML
    private TableColumn<?, ?> colAcceptBy;
    ManageMemberFeesBO memberFeesBO= (ManageMemberFeesBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.MEMBERFEES1);

public void initialize(){
    loadMemberId();
    try {
        table();
    } catch (SQLException | ClassNotFoundException ex) {
        ex.printStackTrace();
    }
    }

int myIndex;
    @FXML
    void amountOnKeyPess(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtpayDate.setValue(LocalDate.now());
            txtpayDate.requestFocus();
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
String feesId=txtFeesId.getText();
String memId= String.valueOf(cmbMemberID.getValue());
String month=txtMonth.getText();
txtMonth.setText(String.valueOf(LocalDate.now().getMonthValue()));
double amount= Double.parseDouble(txtAmount.getText());
String localDate = (txtpayDate.getValue() != null ? txtpayDate.getValue().toString() : "");
        MemberFeesDTO memberFees=new MemberFeesDTO(feesId,memId,month,amount,localDate);
        try {
            myIndex = tableView.getSelectionModel().getSelectedIndex();
            boolean isAdd = memberFeesBO.saveMemberFees(memberFees);
            if (isAdd) {
                table();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String tl = "Successful!";
                String text = "Payment  Successful";
                Notification.showNotification(url, tl, text);
                txtFeesId.setText("");
                cmbMemberID.setValue("");
                txtpayDate.setValue(LocalDate.now());
                txtMonth.setText("");
                txtAmount.setText("");
                txtFeesId.requestFocus();
            } else {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String tl = "UnSuccessful";
                String text = "Payment UnSuccessful";
                Notification.showNotification(url, tl, text);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();

        }



    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.FINANCIAL,pane);

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id=txtFeesId.getText();
        try {
            myIndex = tableView.getSelectionModel().getSelectedIndex();
            boolean isDelete = memberFeesBO.DeleteMemberFees(id);
            if (isDelete) {
                table();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String title = "Successful!";
                String text = "Delete Successful";
                Notification.showNotification(url, title, text);
                txtFeesId.setText("");
                cmbMemberID.setValue("");
                txtpayDate.setValue(LocalDate.now());
                txtMonth.setText("");
                txtAmount.setText("");
                txtFeesId.requestFocus();
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
        String feesId=txtFeesId.getText();
        String memId= String.valueOf(cmbMemberID.getValue());
        String month=txtMonth.getText();
        txtMonth.setText(String.valueOf(LocalDate.now().getMonthValue()));
        double amount= Double.parseDouble(txtAmount.getText());
        String localDate = (txtpayDate.getValue() != null ? txtpayDate.getValue().toString() : "");
        MemberFeesDTO memberFees=new MemberFeesDTO(feesId,memId,month,amount,localDate);
        try {
            myIndex = tableView.getSelectionModel().getSelectedIndex();
            boolean isUpdate=memberFeesBO.updateMemberFees(memberFees);
            if(isUpdate){
                table();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String tl = "Successful!";
                String text = "Update Successful";
                Notification.showNotification(url, tl, text);
                txtFeesId.setText("");
                cmbMemberID.setValue("");
                txtpayDate.setValue(LocalDate.now());
                txtMonth.setText("");
                txtAmount.setText("");
                txtFeesId.requestFocus();
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
    void feesIdOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            cmbMemberID.requestFocus();
        }
    }

    @FXML
    void memIdOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtMonth.setText(String.valueOf(LocalDate.now().getMonth()));
            txtMonth.requestFocus();
        }
    }

    @FXML
    void monthOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtAmount.requestFocus();
        }
    }

    private void loadMemberId() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = memberFeesBO.loadMemberIds();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbMemberID.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void table() throws SQLException, ClassNotFoundException {
  ObservableList<MemberFeesDTO> observableList=memberFeesBO.LoadMemberFessToTable();
        for (MemberFeesDTO m: observableList) {
            tableView.getItems().add(new MemberFeesDTO(m.getFeesId(),m.getMemberId(),m.getMonth(),
                    m.getAmount(),m.getAcceptDate(),m.getAcceptBy()));
        }

        tableView.setItems(observableList);
        colFeesId.setCellValueFactory(new PropertyValueFactory<>("feesId"));
        colMemberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colMonth.setCellValueFactory(new PropertyValueFactory<>("month"));
        colAmounth.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colAcceptDate.setCellValueFactory(new PropertyValueFactory<>("acceptDate"));
        colAcceptBy.setCellValueFactory(new PropertyValueFactory<>("acceptBy"));

        tableView.setRowFactory(tv -> {
            TableRow<MemberFeesDTO> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = tableView.getSelectionModel().getSelectedIndex();
                    txtFeesId.setText(tableView.getItems().get(myIndex).getFeesId());
                    cmbMemberID.setValue(tableView.getItems().get(myIndex).getMemberId());
                    txtMonth.setText(String.valueOf(tableView.getItems().get(myIndex).getMonth()));
                    txtAmount.setText(String.valueOf(tableView.getItems().get(myIndex).getAmount()));
                    txtpayDate.setValue(LocalDate.parse(tableView.getItems().get(myIndex).getAcceptDate()));

                }
            });
            return myRow;
        });
    }

    public void btnBillOnAction(ActionEvent actionEvent) {
        InputStream resource = this.getClass().getResourceAsStream("/lk/ijse/library/report/Bill.jrxml");

          HashMap<String, Object> hm = new HashMap<>();
            //    System.out.println(id);
           hm.put("fId", txtFeesId.getText());

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hm, DBConnection.getDbConnection().getConnection());

            //                  JasperPrintManager.printReport(jasperPrint,true);

            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException | SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
