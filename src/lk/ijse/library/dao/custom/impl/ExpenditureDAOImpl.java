package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.controller.LoginFormController;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.ExpenditureDAO;
import lk.ijse.library.dao.custom.StaffDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.ExpenditureDTO;
import lk.ijse.library.dto.StaffDTO;
import lk.ijse.library.entity.Expenditure;
import lk.ijse.library.entity.Staff;
import lk.ijse.library.utill.CrudUtill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExpenditureDAOImpl implements ExpenditureDAO {
    StaffDAO staffDAO=(StaffDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.STAFF);

    public boolean save(Expenditure expenditure) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO Expenditure VALUES(?,?,?,?,?)";
        PreparedStatement pstm= DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        pstm.setString(1,expenditure.getExpenditureId());
        pstm.setString(2,expenditure.getDescription());
        pstm.setDouble(3,expenditure.getAmount());
        pstm.setDate(4, expenditure.getDate());
        Staff staff = staffDAO.searchName(LoginFormController.userName, LoginFormController.passWord);
        if (staff != null) {
            pstm.setString(5,staff.getStaffId());
        }
        int k=pstm.executeUpdate();
        if(k>0) {
            return true;
        }
        return false;
    }

    @Override
    public Expenditure search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    public  boolean update(Expenditure expenditure) throws SQLException, ClassNotFoundException {
        String sql="UPDATE Expenditure SET description  =?,amount =?,Date=? WHERE expenditureId=?";
        return CrudUtill.execute(sql,expenditure.getDescription(),expenditure.getAmount(),expenditure.getDate(),expenditure.getExpenditureId());
    }
    public  boolean Delete(String id) throws SQLException, ClassNotFoundException {
        String sql="delete from Expenditure where expenditureId=?";
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
    public ResultSet loadData() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Expenditure";
        ResultSet resultSet = CrudUtill.execute(sql);
        return resultSet;
    }
}
