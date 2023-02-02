package lk.ijse.library.bo.custom;

import lk.ijse.library.dto.StaffDTO;

import java.sql.SQLException;

public interface LoginBO extends SuperBO {
    public  boolean verifyStaff(StaffDTO staff) throws SQLException, ClassNotFoundException;
}

