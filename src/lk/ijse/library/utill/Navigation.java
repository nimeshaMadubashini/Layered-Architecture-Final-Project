package lk.ijse.library.utill;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;
public static void navigate(Routes routes, AnchorPane pane) throws IOException {
    Navigation.pane = pane;
    Navigation.pane.getChildren().clear();
    Stage window = (Stage) Navigation.pane.getScene().getWindow();

    switch (routes) {
        case HOMEPAGE:
            window.setTitle("Home Page Form");
            initUI("HomepageForm.fxml");
            break;
        case LOGIN:
            window.setTitle("Home Page Form");
            initUI("LoginForm.fxml");
            break;
        case DASHBOARD:
            window.setTitle("DashBoard Form");
            initUI("DashBoardForm.fxml");
            break;
        case FROGETPASSWORD:
            window.setTitle("FrogetPassword Form");
            initUI("FrogetPasswordForm.fxml");
            break;
        case MEMBER:
            window.setTitle("Manage Member Form");
            initUI("ManageMemberForm.fxml");
            break;
        case BOOK:
            window.setTitle("Manage Book Form");
            initUI("ManageBookForm.fxml");
            break;
        case BOOKISSUE:
            window.setTitle("Manage BookIssue Form");
            initUI("BookIssueForm.fxml");
            break;

        case BOOKRETURN:
            window.setTitle("Manage BookReturn Form");
            initUI("BookReturnForm.fxml");
            break;
        case VIEWRECORD:
            window.setTitle("Book Issue Record Form");
            initUI("VeiwAllRecordForm.fxml");
            break;
        case GRANTER:
            window.setTitle("Manage Granter Form");
            initUI("ManageGranterForm.fxml");
            break;
        case FINANCIAL:
            window.setTitle("Financial Form");
            initUI("FinancialForm.fxml");
            break;
        case NEWSPAPPER:
            window.setTitle("Manage NewsPaper Form");
            initUI("ManageNewsPapperForm.fxml");
            break;
        case EMAIL:
            window.setTitle("Send Email Form");
            initUI("ManageSendEmailForm.fxml");
            break;
        case CATEGORY:
            window.setTitle("Manage Book category Form");
            initUI("ManageBookCategoryForm.fxml");
            break;
        case INSURANCE:
            window.setTitle("Manage Insurance Form");
            initUI("manageInsuranceForm.fxml");
            break;
        case MEMEBERFEES:
            window.setTitle("Manage member Fees Form");
            initUI("ManageMembeFeesForm.fxml");
            break;
        case EXPENDITURE:
            window.setTitle("Manage other Expenditure Form");
            initUI("manageOtherExpenditureform.fxml");
            break;
        case REPORT:
            window.setTitle("Manage Report Form");
            initUI("manageReportForm.fxml");
            break;
        case BOOKSUPPLYRECORD:
            window.setTitle("Veiw Book Supply Details Form");
            initUI("VeiweBookSupplyDetailForm.fxml");
            break;
        case BOOKSUPPLYDETAILS:
            window.setTitle("Book Supply Details Form");
            initUI("bookSuplyDetailsForm.fxml");
            break;

        case ADMIN:
            window.setTitle("Home Page Form");
            initUI("adminForm.fxml");
            break;
        case ADMILOGIN:
            window.setTitle("Admin Login Page Form");
            initUI("adminLoginForm.fxml");
            break;
        case MEMBERVIEW:
            window.setTitle("Member Table view Page Form");
            initUI("memberViewForm.fxml");
            break;
        case VIEWISSUEBOOKRECD:
            window.setTitle(" view issue Book Record Page Form");
            initUI("viewIssueBookForm.fxml");
            break;
        case VIEWDEFAULTERLIST:
            window.setTitle(" view Defaulter List Record Page Form");
            initUI("viewDefaulterListForm.fxml");
            break;
        case BOOKSEARCH:
            window.setTitle(" Search Book Form");
            initUI("BookSearchForm.fxml");
            break;
        default:
            new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
    }
}
    public static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/library/view/" + location)));
    }
}

