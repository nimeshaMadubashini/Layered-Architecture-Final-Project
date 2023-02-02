package lk.ijse.library.bo.custom;

import lk.ijse.library.dto.StaffDTO;

import java.sql.SQLException;

public interface DashBoardBO extends SuperBO {

    public  int setDataDefaultBookCount() throws SQLException, ClassNotFoundException;
    public int setPendingBookCount() throws SQLException, ClassNotFoundException;
    public  int setMemberCountData() throws SQLException, ClassNotFoundException;
    public StaffDTO fillLoginStaffName(String userName, String password) throws SQLException, ClassNotFoundException;
}
