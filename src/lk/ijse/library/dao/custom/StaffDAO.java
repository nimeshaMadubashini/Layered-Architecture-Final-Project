package lk.ijse.library.dao.custom;

import lk.ijse.library.dao.CrudDAO;
import lk.ijse.library.dto.StaffDTO;
import lk.ijse.library.entity.Staff;

import java.sql.SQLException;

public interface StaffDAO extends CrudDAO<Staff> {
    public  boolean verify(Staff staff) throws SQLException, ClassNotFoundException;

    public  boolean resetPassword(Staff staff) throws SQLException, ClassNotFoundException;

    public Staff searchName(String userName, String password) throws SQLException, ClassNotFoundException;
}
