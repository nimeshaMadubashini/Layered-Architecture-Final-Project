package lk.ijse.library.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.library.bo.custom.ManageMemberFeesBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.MemberDAO;
import lk.ijse.library.dao.custom.MemberFeesDAO;
import lk.ijse.library.dto.MemberFeesDTO;
import lk.ijse.library.entity.Memberfees;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageMemberFeesBOImpl implements ManageMemberFeesBO {
    MemberFeesDAO memberFeesDAO= (MemberFeesDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.MEMBERFEES);
    MemberDAO memberDAO= (MemberDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.MEMBER);

    @Override
    public boolean saveMemberFees(MemberFeesDTO dto) throws SQLException, ClassNotFoundException {
        return memberFeesDAO.save(new Memberfees(dto.getFeesId(), dto.getMemberId(), dto.getMonth(),dto.getAmount(),
                Date.valueOf(dto.getAcceptDate()),dto.getAcceptBy()));
    }

    @Override
    public boolean updateMemberFees(MemberFeesDTO dto) throws SQLException, ClassNotFoundException {
        return memberFeesDAO.update(new Memberfees(dto.getFeesId(), dto.getMemberId(), dto.getMonth(),dto.getAmount(),
                Date.valueOf(dto.getAcceptDate()),dto.getAcceptBy()));
    }

    @Override
    public boolean DeleteMemberFees(String id) throws SQLException, ClassNotFoundException {
        return memberFeesDAO.Delete(id);
    }

    @Override
    public ArrayList<String> loadMemberIds() throws SQLException, ClassNotFoundException {
        return memberDAO.loadIds();
    }

    @Override
    public ObservableList<MemberFeesDTO> LoadMemberFessToTable() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = memberFeesDAO.loadTable();
        ObservableList<MemberFeesDTO> observableList = FXCollections.observableArrayList();
        while (resultSet.next()) {
            MemberFeesDTO memberFees = new MemberFeesDTO();
            memberFees.setFeesId(resultSet.getString(1));
            memberFees.setMemberId(resultSet.getString(2));
            memberFees.setMonth(resultSet.getString(3));
            memberFees.setAmount(resultSet.getDouble(4));
            memberFees.setAcceptDate(String.valueOf(resultSet.getString(5)));
            memberFees.setAcceptBy(resultSet.getString(6));
            observableList.add(memberFees);
        }
return observableList;
    }
}
