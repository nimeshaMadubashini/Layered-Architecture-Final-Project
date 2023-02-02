package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.dao.custom.StaffDAO;
import lk.ijse.library.dto.StaffDTO;
import lk.ijse.library.entity.Staff;
import lk.ijse.library.utill.CrudUtill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StaffDAOImpl implements StaffDAO {
    public  boolean save(Staff staff) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO staff VALUES(?,?,?,?,?,?)";
        return CrudUtill.execute(sql,staff.getStaffId(),staff.getName(),staff.getUserName(),staff.getPassword(),staff.getAddress(),staff.getTelephoneNumber());
    }

    @Override
    public Staff search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Staff obj) throws SQLException, ClassNotFoundException {
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

    public  boolean verify(Staff staff) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM staff WHERE userName=? and  password=?";
        ResultSet resultSet=CrudUtill.execute(sql,staff.getUserName(),staff.getPassword());
        return resultSet.next();
    }


    public  boolean resetPassword(Staff staff) throws SQLException, ClassNotFoundException {
        String sql="UPDATE staff SET password=? WHERE staffId=? and userName =?";
        return CrudUtill.execute(sql,staff.getPassword(),staff.getStaffId(),staff.getUserName());
    }

    public Staff searchName(String userName, String password) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM staff where userName=? and  password=?";
        ResultSet resultSet= CrudUtill.execute(sql,userName,password);
        if(resultSet.next()){
            return new Staff(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getInt(6)
            );
        }
        return null;
    }

    public String generateNextId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT staffId   FROM Staff ORDER BY staffId  DESC LIMIT 1";
        ResultSet result = CrudUtill.execute(sql);

        if (result.next()) {
            return generateID(result.getString(1));
        }
        return generateID(result.getString(null));
    }

    public   String generateID(String currentIssue) {
        if (currentIssue != null) {
            String[] split = currentIssue.split("S00");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "S00" + id;
        }
        return "001";

    }
}
