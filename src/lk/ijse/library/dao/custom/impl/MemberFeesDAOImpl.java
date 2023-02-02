package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.controller.LoginFormController;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.MemberFeesDAO;
import lk.ijse.library.dao.custom.StaffDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.MemberFeesDTO;
import lk.ijse.library.dto.StaffDTO;
import lk.ijse.library.entity.Memberfees;
import lk.ijse.library.entity.Staff;
import lk.ijse.library.utill.CrudUtill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberFeesDAOImpl implements MemberFeesDAO {
    StaffDAO staffDAO=(StaffDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.STAFF);

    public boolean save(Memberfees memberFees) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO MemberFees VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm = DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        pstm.setString(1, memberFees.getFeesId());
        pstm.setString(2, memberFees.getMemberId());
        pstm.setString(3, memberFees.getMonth());
        pstm.setDouble(4, memberFees.getAmount());
        pstm.setDate(5, memberFees.getAcceptDate());
        Staff staff = staffDAO.searchName(LoginFormController.userName, LoginFormController.passWord);
        if (staff != null) {
            pstm.setString(6, staff.getStaffId());
        }
        int k = pstm.executeUpdate();
        if (k > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Memberfees search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    public boolean update(Memberfees memberFees) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE MemberFees SET  memberId=?,month=?,amount=?,acceptDate=? WHERE feesId =?";
        return CrudUtill.execute(sql, memberFees.getMemberId(), memberFees.getMonth(), memberFees.getAmount(),
                memberFees.getAcceptDate(), memberFees.getFeesId());
    }

    public boolean Delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "delete from MemberFees where feesId=?";
        return CrudUtill.execute(sql, id);
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


    public  boolean checkPayment( String memId) throws SQLException, ClassNotFoundException {
        String Sql="SELECT month FROM MemberFees WHERE memberId=? ";
        ResultSet resultSet= CrudUtill.execute(Sql,memId);
        return resultSet.next();
    }

    @Override
    public ResultSet loadTable() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM MemberFees";
        ResultSet resultSet = CrudUtill.execute(sql);
        return resultSet;
    }
}
