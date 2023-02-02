package lk.ijse.library.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.ManageReportBO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.Notification;
import lk.ijse.library.dto.ReportDTO;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;

public class ManageReportFormCntroller {
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtRegiNum;

    @FXML
    private JFXTextField txtGetBy;

    @FXML
    private JFXComboBox<?> comCategory;

    @FXML
    private JFXDatePicker txtIssueDate;

    @FXML
    private JFXDatePicker txtDueDate;

    @FXML
    private Button txtGenerateReport;

    @FXML
    private JFXRadioButton rtbnPdf;

    @FXML
    private JFXRadioButton rbtnWord;

    @FXML
    private TableView tableView;

    @FXML
    private TableColumn colRegiNum;

    @FXML
    private TableColumn colCategory;

    @FXML
    private TableColumn colStartDate;

    @FXML
    private TableColumn colDueDate;

    @FXML
    private TableColumn colGeyBy;

    @FXML
    private TableColumn colDocumentType;
    ManageReportBO reportBO= (ManageReportBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.REPORT1);

public void initialize() throws SQLException, ClassNotFoundException {
    table();
    loadNextId();
}
    @FXML
    void btnAddOnAction(ActionEvent event) {
        String reportNum = txtRegiNum.getText();

    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, pane);

    }

    @FXML
    void txtreoprtOnkeypress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtIssueDate.requestFocus();
        }
    }

    @FXML
    void generateReportOnAction(ActionEvent event) {
        String id = txtRegiNum.getText();
        String localDate = (txtIssueDate.getValue() != null ? txtIssueDate.getValue().toString() : "");
        ReportDTO report = new ReportDTO(id, localDate);
        try {
            InputStream resource = this.getClass().getResourceAsStream("/lk/ijse/library/report/Book2.jrxml");


            try {
                JasperReport jasperReport = JasperCompileManager.compileReport(resource);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getDbConnection().getConnection());

                //                  JasperPrintManager.printReport(jasperPrint,true);

                JasperViewer.viewReport(jasperPrint, false);

            } catch (JRException | SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            boolean isAdd = reportBO.saveReport(report);
            if (isAdd) {
                table();
                loadNextId();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String tl = "Successful!";
                String text = "Added Successful";
                Notification.showNotification(url, tl, text);


                txtRegiNum.setText("");
                txtIssueDate.setValue(LocalDate.now());
            } else {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String tl = "UnSuccessful";
                String text = "Added UnSuccessful";
                Notification.showNotification(url, tl, text);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            ;
        }
    }
    public void table() throws SQLException, ClassNotFoundException {
      ObservableList<ReportDTO> observableList=reportBO.loadReportData();
        for (ReportDTO r:observableList) {
          tableView.getItems().add(new ReportDTO(r.getReportNum(),r.getStartDate(),r.getGetBy()));
        }


        tableView.setItems(observableList);
        colRegiNum.setCellValueFactory(new PropertyValueFactory<>("reportNum"));
        colStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        colGeyBy.setCellValueFactory(new PropertyValueFactory<>("getBy"));

    }
    private void loadNextId() {
        try {
            String id = reportBO.generateNextReportId();
            txtRegiNum.setText(id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
