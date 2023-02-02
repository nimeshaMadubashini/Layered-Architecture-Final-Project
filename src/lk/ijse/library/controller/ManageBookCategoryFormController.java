package lk.ijse.library.controller;

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
import lk.ijse.library.bo.custom.ManageBookCategoryBO;
import lk.ijse.library.dto.CategoryDTO;
import lk.ijse.library.dto.Notification;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class ManageBookCategoryFormController {
    @FXML
    private AnchorPane pane;
    @FXML
    private JFXTextField txtCategoryId;

    @FXML
    private JFXTextField txtCategoryType;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private TableView<CategoryDTO> tableview;

    @FXML
    private TableColumn colCategoryId;

    @FXML
    private TableColumn colType;

    @FXML
    private TableColumn colQty;
    int myIndex;

ManageBookCategoryBO categoryBO= (ManageBookCategoryBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.CATEGORY1);


    public void initialize(){
        table();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
String categoryId=txtCategoryId.getText();
String type=txtCategoryType.getText();
        CategoryDTO category=new CategoryDTO(categoryId,type);
        try {
            boolean isAdd= categoryBO.saveCategory(category);
            myIndex = tableview.getSelectionModel().getSelectedIndex();
            if(isAdd){
                table();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String title = "Successful!";
                String text = "Added Successful";
                Notification.showNotification(url, title, text);
            }else{
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String title = "UnSuccessful";
                String text = "Added UnSuccessful";
                Notification.showNotification(url, title, text);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
       String categoryId=txtCategoryId.getText();
        try {
            myIndex = tableview.getSelectionModel().getSelectedIndex();
            boolean idDelete= categoryBO.DeleteCategory(categoryId);
            if(idDelete){
                table();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String title = "Successful!";
                String text = "Delete Successful";
                Notification.showNotification(url, title, text);
            txtCategoryType.setText("");
                txtCategoryId.setText("");

            }else{
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-select-no-64 (1).png";
                String title = "UnSuccessful";
                String text = "Delete UnSuccessful";
                Notification.showNotification(url, title, text);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String categoryId=txtCategoryId.getText();
        String type=txtCategoryType.getText();
        CategoryDTO category=new CategoryDTO(categoryId,type);
        try {
            boolean isUpdate= categoryBO.updateCategory(category);
            myIndex = tableview.getSelectionModel().getSelectedIndex();
            if(isUpdate){
                table();
                String url = "\\lk\\ijse\\library\\assest\\icons\\icons8-check-mark-48.png";
                String title = "Successful!";
                String text = "Update Successful";
                Notification.showNotification(url, title, text);
            }else{
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
    void btnackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,pane);

    }
public void table(){
    try {

        ObservableList<CategoryDTO> observableList =categoryBO.loadToTable();
        for (CategoryDTO c:observableList) {
            tableview.getItems().add(new CategoryDTO(c.getCategoryId(), c.getType(),c.getQty()));
        }


        tableview.setItems(observableList);
        colCategoryId.setCellValueFactory(new PropertyValueFactory<>("categoryId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));

    } catch (SQLException | ClassNotFoundException throwable) {
        throwable.printStackTrace();
    }
    tableview.setRowFactory(tv -> {
        TableRow<CategoryDTO> myRow = new TableRow<>();
        myRow.setOnMouseClicked(event ->
        {
            if (event.getClickCount() == 1 && (!myRow.isEmpty())) {

                myIndex = tableview.getSelectionModel().getSelectedIndex();
                txtCategoryId.setText(tableview.getItems().get(myIndex).getCategoryId());
                txtCategoryType.setText(tableview.getItems().get(myIndex).getType());
            }
        });
        return myRow;
    });
}
    @FXML
    void ctgryIdOnKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtCategoryType.requestFocus();
        }
    }

}
