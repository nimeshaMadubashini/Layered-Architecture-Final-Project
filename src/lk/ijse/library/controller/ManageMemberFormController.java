package lk.ijse.library.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.ManageMemberBO;
import lk.ijse.library.dto.MemberDTO;
import lk.ijse.library.dto.Notification;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.time.LocalDate.parse;

public class ManageMemberFormController {
    @FXML
    private AnchorPane pane;


    @FXML
    private JFXTextField txtMemberId;

    @FXML
    private JFXTextField txtMamberName;

    @FXML
    private JFXTextField txtEmail;


    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXDatePicker txtDate;

    @FXML
    private JFXTextField txtTeleNum;
    @FXML
    private Label lblMemId;

    @FXML
    private Label lblMemName;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblTeleNum;

    @FXML
    private TableView<MemberDTO> tableView;

    @FXML
    private TableColumn colMemId;

    @FXML
    private TableColumn colMemName;

    @FXML
    private TableColumn colMemEmail;

    @FXML
    private TableColumn colAddress;

    @FXML
    private TableColumn colTeleNum;

    @FXML
    private TableColumn colRegiDate;

    @FXML
    private TableColumn colRegiBy;
ManageMemberBO manageMemberBO= (ManageMemberBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.MEMBER1);

    // @FXML
    //  private JFXTextField txtStaffId;
    int myIndex;

    //static ObservableList<MemberDTO> fc= FXCollections.observableArrayList();


    private Matcher idMatcher;
    private Matcher nameMatcher;
    private Matcher emailMatcher;
    private Matcher addressMatcher;
    private Matcher teleNumMatcher;


    private void setPattern() {
        Pattern idPattern = Pattern.compile("^(M0)([0-9]{1})([0-9]{1})$");
        idMatcher = idPattern.matcher(txtMemberId.getText());

        Pattern namePattern = Pattern.compile("^[a-zA-Z\\s]+");
        nameMatcher = namePattern.matcher(txtMamberName.getText());

        Pattern emailPattern = Pattern.compile("^([a-z0-9]{2,})([@])([a-z]{2,9})([.])([a-z]{2,3})$");
        emailMatcher = emailPattern.matcher(txtEmail.getText());


        Pattern addressPattern = Pattern.compile("^([a-zA-Z0-9\\/,\\s])+([a-zA-z\\s,])+([a-zA-z])$");
        addressMatcher = addressPattern.matcher(txtAddress.getText());

        Pattern teleNumPattern = Pattern.compile("^(074|075|072|077|071|078)([0-9]{7}$)");
        teleNumMatcher = teleNumPattern.matcher(txtTeleNum.getText());
    }

    public void initialize() {

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
    void btnAddOnAction(ActionEvent event) {

        String memberId = txtMemberId.getText();
        String name = txtMamberName.getText();
        String email = txtEmail.getText();

        String address = txtAddress.getText();
        int teleNum = Integer.parseInt(txtTeleNum.getText());
        String localDate = (txtDate.getValue() != null ? txtDate.getValue().toString() : "");


        MemberDTO member = new MemberDTO(memberId, name, email, address, teleNum, localDate);
        try {
            if (idMatcher.matches()) {
                if (nameMatcher.matches()) {
                    if (emailMatcher.matches()) {
                        if (addressMatcher.matches()) {
                            if (teleNumMatcher.matches()) {
                                boolean isAdd = manageMemberBO.saveMember(member);
                                if (isAdd) {
                                    table();

                                    String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                                    String title = "Successful!";
                                    String text = "Added Successful";
                                    Notification.showNotification(url, title, text);

                                    txtMamberName.setText("");
                                    txtMemberId.setText("");
                                    txtEmail.setText("");
                                    txtTeleNum.setText("");
                                    //  txtDate.setValue(LocalDate.parse(""));
                                    txtDate.setValue(LocalDate.now());
                                    txtAddress.setText("");
                                    txtMemberId.requestFocus();
                                } else {
                                    String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                                    String title = "UnSuccessful";
                                    String text = "Added UnSuccessful";
                                    Notification.showNotification(url, title, text);
                                }
                            } else {
                                txtTeleNum.requestFocus();
                                txtTeleNum.setFocusColor(Paint.valueOf("Red"));
                                lblTeleNum.setText("invalid TelePhone Number");
                            }
                        } else {
                            txtAddress.requestFocus();
                            txtAddress.setFocusColor(Paint.valueOf("Red"));
                            lblAddress.setText("invalid address");
                        }

                    } else {
                        txtEmail.requestFocus();
                        txtEmail.setFocusColor(Paint.valueOf("Red"));
                        lblEmail.setText("invalid Email");
                    }
                } else {
                    txtMamberName.requestFocus();
                    txtMamberName.setFocusColor(Paint.valueOf("Red"));
                    lblMemName.setText("invalid name");

                }
            } else {
                txtMemberId.requestFocus();
                txtMemberId.setFocusColor(Paint.valueOf("Red"));
                lblMemId.setText("invalid staff id");

            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("manage Book" + ex);

        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtMemberId.getText();
        try {
            myIndex = tableView.getSelectionModel().getSelectedIndex();
            boolean isDelete = manageMemberBO.DeleteMember(id);
            if (isDelete) {
                table();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String title = "Successful!";
                String text = "Delete Successful";
                Notification.showNotification(url, title, text);
                txtMamberName.setText("");
                txtMemberId.setText("");
                txtEmail.setText("");
                txtTeleNum.setText("");
                txtDate.setValue(LocalDate.now());
                txtAddress.setText("");
                txtMemberId.requestFocus();
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
    void txtSearchOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String memberId = txtMemberId.getText();
        MemberDTO member = manageMemberBO.searchMember(memberId);
        if (member != null) {
            txtMamberName.setText(member.getName());
            txtEmail.setText(member.getEmail());
            txtAddress.setText(member.getAddress());
            txtDate.setValue(parse(member.getRegisterDate()));
            txtTeleNum.setText(String.valueOf(member.getTelephoneNumber()));
        }


    }

    @FXML
    void txtUpdateOnAction(ActionEvent event) {
        String memberId = txtMemberId.getText();
        String name = txtMamberName.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();
        int teleNum = Integer.parseInt(txtTeleNum.getText());
        String localDate = (txtDate.getValue() != null ? txtDate.getValue().toString() : "");

        MemberDTO member = new MemberDTO(memberId, name, email, address, teleNum, localDate);
        try {
            myIndex = tableView.getSelectionModel().getSelectedIndex();
            boolean isUpdate = manageMemberBO.updateMember(member);

            if (isUpdate) {
                table();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String title = "Successful!";
                String text = "Update Successful";
                Notification.showNotification(url, title, text);
                txtMamberName.setText("");
                txtMemberId.setText("");
                txtEmail.setText("");
                txtTeleNum.setText("");
                txtDate.setValue(LocalDate.now());
                txtAddress.setText("");
                txtMemberId.requestFocus();
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
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, pane);

    }

    @FXML
    void emailOnKeyPrsse(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtAddress.requestFocus();
        }
    }

    @FXML
    void emailOnKeyRelesae(KeyEvent event) {

        lblEmail.setText("");
        txtEmail.setFocusColor(Paint.valueOf("Blue"));
        Pattern namePattern = Pattern.compile("^([a-z0-9]{2,})([@])([a-z]{2,9})([.])([a-z]{2,3})$");
        emailMatcher = namePattern.matcher(txtEmail.getText());

        if (!emailMatcher.matches()) {
            txtEmail.requestFocus();
            txtEmail.setFocusColor(Paint.valueOf("Red"));
            lblEmail.setText("Invalid  Email");
        }
    }

    @FXML
    void idOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtMamberName.requestFocus();
        }
    }

    @FXML
    void idOnKeyRelease(KeyEvent event) {
        lblMemId.setText("");
        txtMemberId.setFocusColor(Paint.valueOf("Blue"));
        Pattern namePattern = Pattern.compile("^(M0)([0-9]{1})([0-9]{1})$");
        idMatcher = namePattern.matcher(txtMemberId.getText());

        if (!idMatcher.matches()) {
            txtMemberId.requestFocus();
            txtMemberId.setFocusColor(Paint.valueOf("Red"));
            lblMemId.setText("Invalid  Member_Id");
        }
    }

    @FXML
    void nameOkmKeyRelease(KeyEvent event) {
        lblMemName.setText("");
        txtMamberName.setFocusColor(Paint.valueOf("Blue"));
        Pattern namePattern = Pattern.compile("^[a-zA-Z\\s]+");
        nameMatcher = namePattern.matcher(txtMamberName.getText());

        if (!nameMatcher.matches()) {
            txtMamberName.requestFocus();
            txtMamberName.setFocusColor(Paint.valueOf("Red"));
            lblMemName.setText("Invalid  Name");
        }
    }

    @FXML
    void nameOnKeyPrss(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtEmail.requestFocus();
        }
    }

    @FXML
    void teleOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtDate.requestFocus();
        }
    }

    @FXML
    void teleOnKeyRelease(KeyEvent event) {
        lblTeleNum.setText("");
        txtTeleNum.setFocusColor(Paint.valueOf("Blue"));
        Pattern namePattern = Pattern.compile("^(074|075|072|077|071|078)([0-9]{7}$)");
        teleNumMatcher = namePattern.matcher(txtTeleNum.getText());

        if (!teleNumMatcher.matches()) {
            txtTeleNum.requestFocus();
            txtTeleNum.setFocusColor(Paint.valueOf("Red"));
            lblTeleNum.setText("Invalid  TelePhone Number");
        }
    }

    @FXML
    void addressOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtTeleNum.requestFocus();
        }
    }

    @FXML
    void addressOnKeyRelease(KeyEvent event) {
        lblAddress.setText("");
        txtAddress.setFocusColor(Paint.valueOf("Blue"));
        Pattern namePattern = Pattern.compile("^([a-zA-Z0-9\\/,\\s])+([a-zA-z\\s,])+([a-zA-z])$");
        addressMatcher = namePattern.matcher(txtAddress.getText());

        if (!addressMatcher.matches()) {
            txtAddress.requestFocus();
            txtAddress.setFocusColor(Paint.valueOf("Red"));
            lblAddress.setText("Invalid   Address");
        }
    }

    public void table() throws SQLException, ClassNotFoundException {
     ObservableList<MemberDTO> observableList=manageMemberBO.loadMemberDetailToTable();
        for (MemberDTO m: observableList ) {
            tableView.getItems().add(new MemberDTO(m.getMemberId(),m.getName(),m.getEmail(),m.getAddress(),m.getTelephoneNumber(),
                    m.getRegisterDate(),m.getRegisteredBy()));
        }

        tableView.setItems(observableList);
        colMemId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colMemName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colMemEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colTeleNum.setCellValueFactory(new PropertyValueFactory<>("telephoneNumber"));
        colRegiDate.setCellValueFactory(new PropertyValueFactory<>("registerDate"));
        colRegiBy.setCellValueFactory(new PropertyValueFactory<>("registeredBy"));

        tableView.setRowFactory(tv -> {
            TableRow<MemberDTO> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {

                    myIndex = tableView.getSelectionModel().getSelectedIndex();
                    txtMemberId.setText(tableView.getItems().get(myIndex).getMemberId());
                    txtMamberName.setText(tableView.getItems().get(myIndex).getName());
                    txtEmail.setText(tableView.getItems().get(myIndex).getEmail());
                    txtAddress.setText(tableView.getItems().get(myIndex).getAddress());
                    txtTeleNum.setText(String.valueOf(tableView.getItems().get(myIndex).getTelephoneNumber()));
                    txtDate.setValue(LocalDate.parse(tableView.getItems().get(myIndex).getRegisterDate()));

                }
            });
            return myRow;
        });
    }


}
