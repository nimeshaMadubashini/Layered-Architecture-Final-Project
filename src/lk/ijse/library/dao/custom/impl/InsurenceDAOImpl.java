package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.controller.LoginFormController;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.InsuranceDAO;
import lk.ijse.library.dao.custom.StaffDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.InsuranceDTO;
import lk.ijse.library.dto.StaffDTO;
import lk.ijse.library.entity.Staff;
import lk.ijse.library.utill.CrudUtill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsurenceDAOImpl implements InsuranceDAO {
    StaffDAO staffDAO=(StaffDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.STAFF);

    public  boolean save(InsuranceDTO insurence) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO Insurence VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm= DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        pstm.setString(1, insurence.getInsurenceId());
        pstm.setString(2,insurence.getInsurenceType());
        pstm.setString(3,insurence.getPayDate());
        pstm.setString(4,insurence.getRenewDate());
        pstm.setDouble(5,insurence.getAnualPayment());
        Staff staff = staffDAO.searchName(LoginFormController.userName, LoginFormController.passWord);
        if (staff != null) {
            pstm.setString(6,staff.getStaffId());
        }

        int k=pstm.executeUpdate();
        if(k>0) {
            return true;
        }
        return false;
    }

    @Override
    public InsuranceDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    public  boolean update(InsuranceDTO insurance) throws SQLException, ClassNotFoundException {
        String sql="UPDATE Insurence SET insurenceType  =?,payDate =?,renewDate =?,anualPayment =? WHERE insurenceId =?";
        return CrudUtill.execute(sql,insurance.getInsurenceType(),insurance.getPayDate(),insurance.getRenewDate(),insurance.getAnualPayment(),insurance.getInsurenceId());
    }
    public  boolean Delete(String id) throws SQLException, ClassNotFoundException {
        String sql="delete from Insurence where insurenceId=?";
        return  CrudUtill.execute(sql,id);
    }

    @Override
    public ArrayList<String> loadIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateID(String currentIssue) {
        return null;
    }

    @Override
    public ResultSet loadAllDataToTable() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Insurence";
        ResultSet resultSet = CrudUtill.execute(sql);
        return resultSet ;
    }
}
