package lk.ijse.library.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.ViewDefaulterListBO;
import lk.ijse.library.dto.IssueBookDTO;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ViewDefaulterListFormController {
    @FXML
    private AnchorPane pane;
    @FXML
    private JFXTextField txtTimeNow;

    @FXML
    private JFXTextField txtTimeNow1;

    @FXML
    private TableView tableView;

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
    ViewDefaulterListBO defaulterListBO= (ViewDefaulterListBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.VEIWDEFAULTLIST1);
    public void initialize()
    {
        try {
            table();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                txtTimeNow.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                txtTimeNow1.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            }
        };
        timer.start();
    }
    @FXML
    void btnBackOnaction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,pane);

    }
    public void table() throws SQLException, ClassNotFoundException {
        long dt=System.currentTimeMillis();
        Date todayDate=new Date(dt);
        ObservableList<IssueBookDTO> observableList=defaulterListBO.loadDefaultListToTable(String.valueOf(todayDate));
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
}

