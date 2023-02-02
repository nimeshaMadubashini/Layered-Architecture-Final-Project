package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.FrogetPasswordBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.StaffDAO;
import lk.ijse.library.dto.StaffDTO;
import lk.ijse.library.entity.Staff;

import java.sql.SQLException;

public class FrogetPasswordBOImpl implements FrogetPasswordBO {
    StaffDAO staffDAO= (StaffDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.STAFF);
    @Override
    public boolean frogetpwResetPassword(StaffDTO dto) throws SQLException, ClassNotFoundException {
        return staffDAO.resetPassword(new Staff(dto.getStaffId(), dto.getName(), dto.getUserName(), dto.getPassword(), dto.getAddress(),
                dto.getTelephoneNumber()));
    }
}
