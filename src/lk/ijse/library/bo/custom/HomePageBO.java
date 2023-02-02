package lk.ijse.library.bo.custom;

import lk.ijse.library.dto.StaffDTO;

import java.sql.SQLException;

public interface HomePageBO extends SuperBO {
    public boolean saveStaff(StaffDTO dto)throws SQLException,ClassNotFoundException;

    public String generateNextStaffId() throws SQLException, ClassNotFoundException ;

    }
