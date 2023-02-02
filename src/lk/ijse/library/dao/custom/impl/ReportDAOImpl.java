package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.controller.LoginFormController;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.ReportDAO;
import lk.ijse.library.dao.custom.StaffDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.ReportDTO;
import lk.ijse.library.entity.Report;
import lk.ijse.library.entity.Staff;
import lk.ijse.library.utill.CrudUtill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportDAOImpl implements ReportDAO {
    StaffDAO staffDAO=(StaffDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.STAFF);

    public  boolean save(Report report) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO report VALUES(?,?,?)";
        PreparedStatement pstm= DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        pstm.setString(1,report.getReportNum());
        pstm.setDate(2, report.getStartDate());
        Staff staff= staffDAO.searchName(LoginFormController.userName,LoginFormController.passWord);
        if(staff!= null){
            pstm.setString(3,staff.getStaffId());
        }
        int k= pstm.executeUpdate();
        if(k>0){
            return true;
        }
        return false;
    }

    @Override
    public Report search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Report obj) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean Delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> loadIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    public  String generateNextId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT reportNum  FROM report ORDER BY reportNum DESC LIMIT 1";
        ResultSet result = CrudUtill.execute(sql);

        if (result.next()) {
            return generateID(result.getString(1));
        }
        return generateID(result.getString(null));
    }



    public   String generateID(String currentIssue) {
        if (currentIssue != null) {
            String[] split = currentIssue.split("R0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "R0" + id;
        }
        return "001";

    }

    @Override
    public ResultSet laodDataReport() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM report";
        ResultSet resultSet = CrudUtill.execute(sql);
        return resultSet;
    }
}
