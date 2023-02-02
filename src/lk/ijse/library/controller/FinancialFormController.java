package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;

public class FinancialFormController {
    @FXML
    private AnchorPane pane;
    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,pane);

    }

    @FXML
    void btnInsurenceOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.INSURANCE,pane);

    }

    @FXML
    void btnMemberFeesOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.MEMEBERFEES,pane);

    }

    @FXML
    void btnOtherExpenditureOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.EXPENDITURE,pane);
    }
}
