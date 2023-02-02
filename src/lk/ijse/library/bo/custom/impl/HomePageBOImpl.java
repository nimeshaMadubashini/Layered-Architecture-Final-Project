package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.HomePageBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.StaffDAO;
import lk.ijse.library.dao.custom.impl.StaffDAOImpl;
import lk.ijse.library.dto.StaffDTO;
import lk.ijse.library.entity.Staff;

import java.sql.SQLException;

public class HomePageBOImpl implements HomePageBO {
    StaffDAO staffDAO= (StaffDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.STAFF);


    @Override
    public boolean saveStaff(StaffDTO dto) throws SQLException, ClassNotFoundException {
        return staffDAO.save(new Staff(dto.getStaffId(), dto.getName(), dto.getUserName(), dto.getPassword(),
                dto.getAddress(), dto.getTelephoneNumber()));
    }

    @Override
    public String generateNextStaffId() throws SQLException, ClassNotFoundException {
        return staffDAO.generateNextId();
    }
}
