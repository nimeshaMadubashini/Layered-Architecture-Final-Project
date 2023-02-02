package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;

public class AdminFormController {
    @FXML
    private AnchorPane pane;

    @FXML
    void btnAdminOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ADMILOGIN,pane);
    }

    @FXML
    void btnLibrarianOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);

    }


}
