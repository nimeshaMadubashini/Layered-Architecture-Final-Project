package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.DashBoardBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.IssueBookDAO;
import lk.ijse.library.dao.custom.MemberDAO;
import lk.ijse.library.dao.custom.StaffDAO;
import lk.ijse.library.dto.StaffDTO;
import lk.ijse.library.entity.Staff;

import java.sql.SQLException;

public class DashBoardBOImpl implements DashBoardBO {
    IssueBookDAO issueBookDAO= (IssueBookDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.ISSUEBOOK);
    StaffDAO staffDAO= (StaffDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.STAFF);
    MemberDAO memberDAO= (MemberDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.MEMBER);


    @Override
    public int setDataDefaultBookCount() throws SQLException, ClassNotFoundException {
        return issueBookDAO.setDataDefault();
    }

    @Override
    public int setPendingBookCount() throws SQLException, ClassNotFoundException {
        return issueBookDAO.setData();
    }

    @Override
    public int setMemberCountData() throws SQLException, ClassNotFoundException {
        return memberDAO.setData();
    }

    @Override
    public StaffDTO fillLoginStaffName(String userName, String password) throws SQLException, ClassNotFoundException {
        Staff enty= staffDAO.searchName(userName, password);
        return new StaffDTO(enty.getStaffId(),enty.getName(),enty.getUserName(),enty.getPassword(),enty.getAddress(),
                enty.getTelephoneNumber());
    }
}
