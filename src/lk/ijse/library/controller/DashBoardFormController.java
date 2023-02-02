package lk.ijse.library.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.DashBoardBO;
import lk.ijse.library.dto.StaffDTO;
import lk.ijse.library.utill.CrudUtill;
import lk.ijse.library.utill.Navigation;
import lk.ijse.library.utill.Routes;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DashBoardFormController  {
    public JFXTextField txtDateTime;
    @FXML
    private AnchorPane pane;
    @FXML
    private JFXTextField txtlibrarian;
    @FXML
    private Label lblMember;
    @FXML
    private Label lblBookId;

    @FXML
    private Label lblIssueBook;

    @FXML
    private Label lblDefaulterList;
    @FXML
    private PieChart pieChart;
    Stage stage;



DashBoardBO dashBoardBO= (DashBoardBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.DASHBOARD1);
    public void initialize() {
        setDataToCart();
        try {
            setData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            setPieChart();
            StaffDTO staff = dashBoardBO.fillLoginStaffName(LoginFormController.userName, LoginFormController.passWord);
            if (staff != null) {
                txtlibrarian.setText(staff.getName());
                txtlibrarian.setEditable(false);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                txtDateTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd       HH:mm:ss")));
            }
        };
        timer.start();

    }

    @FXML
    void bookIssueOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.BOOKISSUE, pane);

    }

    @FXML
    void bookReturnOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.BOOKRETURN, pane);

    }

    @FXML
    void financialOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.FINANCIAL, pane);
    }

    @FXML
    void homePageOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.HOMEPAGE, pane);
    }

    @FXML
    void manageBookOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.BOOK, pane);
    }

    @FXML
    void manageGranterOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.GRANTER, pane);
    }

    @FXML
    void manageMemberOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.MEMBER, pane);
    }

    @FXML
    void manageNewspprOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.NEWSPAPPER, pane);
    }

    @FXML
    void sendEmailOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.EMAIL, pane);
    }

    @FXML
    void viewAllRecordOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.VIEWRECORD, pane);
    }

    public void manageBookCategoryOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CATEGORY, pane);
    }
    @FXML
    void viewDefaulterOnAction(ActionEvent event) throws IOException {
Navigation.navigate(Routes.VIEWDEFAULTERLIST,pane);
    }
    @FXML
    void veiwIssieBookRecordOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.VIEWISSUEBOOKRECD,pane);
    }
    @FXML
    void btnLogOutOnAction(ActionEvent event) {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to save before exiting ? :");

        if(alert.showAndWait().get()== ButtonType.OK){
            stage = (Stage) pane.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void btnmanageBookSublyDetailOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.BOOKSUPPLYDETAILS, pane);
    }

    @FXML
    void btnReportOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.REPORT, pane);
    }

    @FXML
    void SearchBookOnAction(ActionEvent event) throws IOException {
Navigation.navigate(Routes.BOOKSEARCH,pane);
    }
    public void setDataToCart(){
        try {
            lblMember.setText(String.valueOf(dashBoardBO.setMemberCountData()));
           // lblBookId.setText(String.valueOf(BookModel.setData()));
            lblIssueBook.setText(String.valueOf(dashBoardBO.setPendingBookCount()));
            lblDefaulterList.setText(String.valueOf(dashBoardBO.setDataDefaultBookCount()));
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
    public void setPieChart() throws SQLException, ClassNotFoundException {
        ArrayList<String> p=new ArrayList<String>();
        ArrayList<Double> c=new ArrayList<>();
        String sql="SELECT BookId ,count(*) as issueCount from IssueBookDetail group by BookId";
        ResultSet resultSet = CrudUtill.execute(sql);
        ObservableList<PieChart.Data> pieChartdata=FXCollections.observableArrayList();
                while(resultSet.next()){
                    pieChartdata.add(new PieChart.Data(resultSet.getString("BookId"),resultSet.getDouble("issueCount")));
                    p.add(resultSet.getString("BookId"));
                    c.add(resultSet.getDouble("issueCount"));
        }
pieChart.setData(pieChartdata);
                pieChart.setVisible(true);

    }
    public void setData() throws SQLException, ClassNotFoundException {
        String sql = "select sum(qtyOnHand)from Book ";
        ResultSet resultSet = CrudUtill.execute(sql);
        // resultSet.last();
        if (resultSet.next()) {
            String sum=resultSet.getString("sum(qtyOnHand)");
            lblBookId.setText(sum);
        }
    }
}
