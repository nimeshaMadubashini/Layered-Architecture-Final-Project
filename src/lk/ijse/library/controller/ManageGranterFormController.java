package lk.ijse.library.controller;

import com.jfoenix.controls.JFXTextField;
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
import lk.ijse.library.bo.custom.ManageGranterBO;
import lk.ijse.library.dto.GranterDTO;
import lk.ijse.library.dto.Notification;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManageGranterFormController {
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtGranterId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtAcddBy;

    @FXML
    private JFXTextField txtTeleNum;

    @FXML
    private TableView<GranterDTO> tableView;

    @FXML
    private TableColumn colGranterId;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colAddress;

    @FXML
    private TableColumn colTeleNum;

    @FXML
    private TableColumn colAddBy;
    @FXML
    private Label lbIdWarning;

    @FXML
    private Label lbNameWarning;

    @FXML
    private Label lbAddressWarning;

    @FXML
    private Label lblTeleNumWarning;
int myIndex;

    private Matcher idMatcher;
    private Matcher nameMatcher;
    private Matcher addressMatcher;
    private Matcher teleNumMatcher;

ManageGranterBO granterBO= (ManageGranterBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.GRANTER1);
    private void setPattern() {
        Pattern idPattern = Pattern.compile("^(G0)([0-9]{1})([0-9]{1})$");
        idMatcher = idPattern.matcher(txtGranterId.getText());

        Pattern namePattern = Pattern.compile("^[a-zA-Z\\s]+");
        nameMatcher = namePattern.matcher(txtName.getText());


        Pattern addressPattern = Pattern.compile("^([a-zA-Z0-9\\/,\\s])+([a-zA-z\\s,])+([a-zA-z])$");
        addressMatcher = addressPattern.matcher(txtAddress.getText());

        Pattern teleNumPattern = Pattern.compile("^(074|075|072|077|071|078)([0-9]{7}$)");
        teleNumMatcher = teleNumPattern.matcher(txtTeleNum.getText());
    }

    public void initialize() {


        try {
            setPattern();
            loadNexId();
            table();
        } catch (SQLException | NullPointerException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void btnAddOnAction(ActionEvent event) {
        String name = txtName.getText();
        String id = txtGranterId.getText();
        String address = txtAddress.getText();
        int tele = Integer.parseInt(txtTeleNum.getText());
        GranterDTO granter = new GranterDTO(id, name, address, tele);
        try {
            if (idMatcher.matches()) {
                if (nameMatcher.matches()) {
                    if (addressMatcher.matches()) {
                        if (teleNumMatcher.matches()) {
                            myIndex = tableView.getSelectionModel().getSelectedIndex();
                            boolean isSave = granterBO.saveGranter(granter);
                            if (isSave) {
                                table();
                                loadNexId();
                                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                                String title = "Successful!";
                                String text = "Add Granter Successful";
                                Notification.showNotification(url, title, text);
                                txtName.setText("");
                                txtGranterId.setText("");
                                txtTeleNum.setText("");
                                txtAddress.setText("");
                                txtGranterId.requestFocus();
                            } else {
                                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                                String title = "UnSuccessful";
                                String text = "Add Granter UnSuccessful";
                                Notification.showNotification(url, title, text);
                            }
                        } else {
                            txtTeleNum.requestFocus();
                            txtTeleNum.setFocusColor(Paint.valueOf("Red"));
                            lblTeleNumWarning.setText("invalid TelePhone Number");
                        }
                    } else {
                        txtAddress.requestFocus();
                        txtAddress.setFocusColor(Paint.valueOf("Red"));
                        lbAddressWarning.setText("invalid address");
                    }

                } else {
                    txtName.requestFocus();
                    txtName.setFocusColor(Paint.valueOf("Red"));
                    lbNameWarning.setText("invalid name");

                }
            } else {
                txtGranterId.requestFocus();
                txtGranterId.setFocusColor(Paint.valueOf("Red"));
                lbIdWarning.setText("invalid Granter id");

            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Home page Exception" + ex);
        }
    }


    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,pane);

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id=txtGranterId.getText();
        try {
            myIndex = tableView.getSelectionModel().getSelectedIndex();
            boolean isDelete = granterBO.DeleteGranter(id);
            if (isDelete) {
                table();
                loadNexId();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String title = "Successful!";
                String text = "Delete Successful";
                Notification.showNotification(url, title, text);
                txtGranterId.setText("");
                txtName.setText("");
                txtTeleNum.setText("");
                txtAddress.setText("");
                txtGranterId.requestFocus();
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
        String name = txtName.getText();
        String id = txtGranterId.getText();
        String address = txtAddress.getText();
        int tele = Integer.parseInt(txtTeleNum.getText());
        GranterDTO granter = new GranterDTO(id, name, address, tele);
        try {
            myIndex = tableView.getSelectionModel().getSelectedIndex();
            boolean isUpdate = granterBO.updateGranter(granter);

            if (isUpdate) {
                table();
                loadNexId();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String title = "Successful!";
                String text = "Update Successful";
                Notification.showNotification(url, title, text);
                txtGranterId.setText("");
                txtName.setText("");
                txtTeleNum.setText("");
                txtAddress.setText("");
                txtGranterId.requestFocus();
            } else {
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String title = "UnSuccessful";
                String text = "Update UnSuccessful";
                Notification.showNotification(url, title, text);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void idOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtName.requestFocus();
        }
    }
    @FXML
    void idOnKeyReleased(KeyEvent event) {
        lbIdWarning.setText("");
        txtGranterId.setFocusColor(Paint.valueOf("Blue"));
        Pattern namePattern = Pattern.compile("^(G0)([0-9]{1})([0-9]{1})$");
        idMatcher = namePattern.matcher(txtGranterId.getText());

        if (!idMatcher.matches()) {
            txtGranterId.requestFocus();
            txtGranterId.setFocusColor(Paint.valueOf("Red"));
            lbIdWarning.setText("invalid Id");
        }
    }

    @FXML
    void nameOnkeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtAddress.requestFocus();
        }
    }

    @FXML
    void nameOnkeyRelease(KeyEvent event) {
        lbNameWarning.setText("");
        txtName.setFocusColor(Paint.valueOf("Blue"));
        Pattern namePattern = Pattern.compile("^[a-zA-Z\\s]+");
        nameMatcher = namePattern.matcher(txtName.getText());

        if (!nameMatcher.matches()) {
            txtName.requestFocus();
            txtName.setFocusColor(Paint.valueOf("Red"));
            lbNameWarning.setText("invalid Name");
        }
    }
    @FXML
    void addOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtTeleNum.requestFocus();
        }
    }

    @FXML
    void addOnKeyRelese(KeyEvent event) {
        lbAddressWarning.setText("");
        txtAddress.setFocusColor(Paint.valueOf("Blue"));
        Pattern addressPattern = Pattern.compile("^([a-zA-Z0-9\\/,\\s])+([a-zA-z\\s,])+([a-zA-z])$");
        addressMatcher = addressPattern.matcher(txtAddress.getText());

        if (!addressMatcher.matches()) {
            txtAddress.requestFocus();
            txtAddress.setFocusColor(Paint.valueOf("Red"));
            lbAddressWarning.setText("invalid address");
        }
    }

    @FXML
    void teleOnKeyPress(KeyEvent event) {

    }

    @FXML
    void teleOnKeyRelease(KeyEvent event) {
        lblTeleNumWarning.setText("");
        txtTeleNum.setFocusColor(Paint.valueOf("Blue"));
        Pattern teleNumPattern = Pattern.compile("^(074|075|072|077|071|078)([0-9]{7}$)");
        teleNumMatcher = teleNumPattern.matcher(txtTeleNum.getText());

        if (!teleNumMatcher.matches()) {
            txtTeleNum.requestFocus();
            txtTeleNum.setFocusColor(Paint.valueOf("Red"));
            lblTeleNumWarning.setText("invalid Telephone Number");
        }
    }
    public void table() throws SQLException, ClassNotFoundException {
        ObservableList<GranterDTO> observableList=granterBO.loadToTabbel();
        for (GranterDTO g:observableList)
        tableView.getItems().add(new GranterDTO(g.getGranterId(),g.getName(),g.getAddress(),g.getTelephoneNumber(),
                g.getAddBy()));
        {

        }


        tableView.setItems(observableList);
        colGranterId.setCellValueFactory(new PropertyValueFactory<>("granterId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colTeleNum.setCellValueFactory(new PropertyValueFactory<>("telephoneNumber"));
        colAddBy.setCellValueFactory(new PropertyValueFactory<>("addBy"));

        tableView.setRowFactory(tv -> {
            TableRow<GranterDTO> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = tableView.getSelectionModel().getSelectedIndex();
                    txtGranterId.setText(tableView.getItems().get(myIndex).getGranterId());
                    txtName.setText(tableView.getItems().get(myIndex).getName());
                    txtAddress.setText(tableView.getItems().get(myIndex).getAddress());
                    txtTeleNum.setText(String.valueOf(tableView.getItems().get(myIndex).getTelephoneNumber()));
                }
            });
            return myRow;
        });
    }
    private void loadNexId() {
        try {
            String orderId = granterBO.generateNextGranterId();
            txtGranterId.setText(orderId);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
