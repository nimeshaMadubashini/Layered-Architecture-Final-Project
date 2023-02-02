package lk.ijse.library.bo.custom;

import lk.ijse.library.dto.StaffDTO;

import java.sql.SQLException;

public interface FrogetPasswordBO extends SuperBO {
    public  boolean frogetpwResetPassword(StaffDTO staff) throws SQLException, ClassNotFoundException;
}
