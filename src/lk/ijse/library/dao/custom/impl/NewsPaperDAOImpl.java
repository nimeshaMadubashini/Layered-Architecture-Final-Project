package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.controller.LoginFormController;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.NewsPaperDAO;
import lk.ijse.library.dao.custom.StaffDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.NewsPaperDTO;
import lk.ijse.library.dto.StaffDTO;
import lk.ijse.library.entity.Newspaper;
import lk.ijse.library.entity.Staff;
import lk.ijse.library.utill.CrudUtill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NewsPaperDAOImpl implements NewsPaperDAO {
    StaffDAO staffDAO=(StaffDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.STAFF);

    public  boolean save(Newspaper newsPaper) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO NewsPaper VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm= DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        pstm.setString(1, newsPaper.getNewsPaperId());
        pstm.setString(2,newsPaper.getTitle());
        pstm.setInt(3,newsPaper.getQty());
        pstm.setDate(4,newsPaper.getDate());
        Staff staff = staffDAO.searchName(LoginFormController.userName, LoginFormController.passWord);
        if (staff != null) {
            pstm.setString(5,staff.getStaffId());
        }
        pstm.setString(6,newsPaper.getSupplyBy());
        int k=pstm.executeUpdate();
        if(k>0) {
            return true;
        }
        return false;
    }

    @Override
    public Newspaper search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    public  boolean update(Newspaper newsPaper) throws SQLException, ClassNotFoundException {
        String sql="UPDATE NewsPaper SET title =?,qty=?,date=?,supplyBy=? WHERE newsPaperId=?";
        return CrudUtill.execute(sql,newsPaper.getTitle(),newsPaper.getQty(),newsPaper.getDate(),newsPaper.getSupplyBy(),newsPaper.getNewsPaperId());
    }
    public  boolean Delete(String id) throws SQLException, ClassNotFoundException {
        String sql="delete from NewsPaper where newsPaperId=?";
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
    public ResultSet loadnewspaper() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM NewsPaper";
        ResultSet resultSet = CrudUtill.execute(sql);
        return resultSet;
    }
}
