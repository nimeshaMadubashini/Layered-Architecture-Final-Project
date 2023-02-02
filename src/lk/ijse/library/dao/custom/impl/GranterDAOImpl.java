package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.controller.LoginFormController;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.GranterDAO;
import lk.ijse.library.dao.custom.StaffDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.GranterDTO;
import lk.ijse.library.dto.StaffDTO;
import lk.ijse.library.entity.Granter;
import lk.ijse.library.entity.Staff;
import lk.ijse.library.utill.CrudUtill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GranterDAOImpl implements GranterDAO {
    StaffDAO staffDAO=(StaffDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.STAFF);

    public  boolean save(Granter granter) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO Granter VALUES(?,?,?,?,?)";
        PreparedStatement pstm= DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        pstm.setString(1, granter.getGranterId());
        pstm.setString(2,granter.getName());
        pstm.setString(3,granter.getAddress());
        pstm.setInt(4, granter.getTelephoneNumber());
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

    public  boolean update(Granter granter) throws SQLException, ClassNotFoundException {
        String sql="UPDATE Granter SET name=?,address=?,telephoneNumber=? WHERE granterId =?";
        return CrudUtill.execute(sql,granter.getName(),granter.getAddress(),granter.getTelephoneNumber(),granter.getGranterId());
    }
    public  boolean Delete(String id) throws SQLException, ClassNotFoundException {
        String sql="delete from Granter where granterId=?";
        return  CrudUtill.execute(sql,id);
    }

    public  ArrayList<String> loadIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT granterId  FROM Granter";
        ResultSet result = CrudUtill.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }


    public Granter search(String grId) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM Granter where granterId =?";
        ResultSet resultSet= CrudUtill.execute(sql,grId);
        if(resultSet.next()){
            return new Granter(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5)

            );
        }

        return null;
    }
    public  String generateNextId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT granterId  FROM granter ORDER BY granterId DESC LIMIT 1";
        ResultSet result = CrudUtill.execute(sql);

        if (result.next()) {
            return generateID(result.getString(1));
        }
        return generateID(result.getString(null));
    }

    public   String generateID(String currentIssue) {
        if (currentIssue != null) {
            String[] split = currentIssue.split("G00");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "G00" + id;
        }
        return "001";

    }

    @Override
    public ResultSet loadAllToTable() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Granter";
        ResultSet resultSet = CrudUtill.execute(sql);
        return resultSet;
    }
}
