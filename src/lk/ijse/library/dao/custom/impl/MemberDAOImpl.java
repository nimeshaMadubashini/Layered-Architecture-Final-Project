package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.controller.LoginFormController;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.MemberDAO;
import lk.ijse.library.dao.custom.StaffDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.MemberDTO;
import lk.ijse.library.dto.StaffDTO;
import lk.ijse.library.entity.Member;
import lk.ijse.library.entity.Staff;
import lk.ijse.library.utill.CrudUtill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAOImpl implements MemberDAO {
    StaffDAO staffDAO=(StaffDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.STAFF);

    public  boolean save(Member member) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO member VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pstm= DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        pstm.setString(1, member.getMemberId());
        pstm.setString(2,member.getName());
        pstm.setString(3,member.getEmail());
        pstm.setString(4,member.getAddress());
        pstm.setInt(5, member.getTelephoneNumber());
        pstm.setString(6, String.valueOf(member.getRegisterDate()));
        Staff staff = staffDAO.searchName(LoginFormController.userName, LoginFormController.passWord);
        if (staff != null) {
            pstm.setString(7,staff.getStaffId());
        }
        int k=pstm.executeUpdate();
        if(k>0) {
            return true;
        }
        return false;

    }
    public Member search(String id) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM member WHERE memberId=? ";
        ResultSet resultSet= CrudUtill.execute(sql,id);
        if(resultSet.next()){
            return new Member(
                    resultSet.getString("memberId"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("address"),
                    resultSet.getInt("telephoneNumber"),
                    resultSet.getDate("registerDate"),
                    resultSet.getString("registeredBy")
            );
        }
        return null;
    }

    public  boolean update(Member member) throws SQLException, ClassNotFoundException {
        String sql="UPDATE member SET name=?,email=?,address=?,telephoneNumber=?,registerDate=? WHERE memberId=?";
        return CrudUtill.execute(sql,member.getName(),member.getEmail(),member.getAddress(),member.getTelephoneNumber(),member.getRegisterDate(),member.getMemberId());
    }
    public  boolean Delete(String id) throws SQLException, ClassNotFoundException {
        String sql="delete from member where memberId=?";
        return  CrudUtill.execute(sql,id);
    }


    public  ArrayList<String> loadIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT memberId  FROM Member";
        ResultSet result = CrudUtill.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateID(String currentIssue) {
        return null;
    }

    public  int setData() throws SQLException, ClassNotFoundException {
        String sql="select * from Member ";
        ResultSet resultSet=CrudUtill.execute(sql);
        resultSet.last();
        return resultSet.getRow();
    }

    @Override
    public ResultSet loadTable() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM member";
        ResultSet resultSet = CrudUtill.execute(sql);
        return resultSet;
    }


    public  ArrayList<String> loadEmail() throws SQLException, ClassNotFoundException {
        String sql = "SELECT email  FROM member";
        ResultSet result = CrudUtill.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }
}
