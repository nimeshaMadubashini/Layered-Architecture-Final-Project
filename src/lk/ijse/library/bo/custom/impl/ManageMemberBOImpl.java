package lk.ijse.library.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.library.bo.custom.ManageMemberBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.MemberDAO;
import lk.ijse.library.dto.MemberDTO;
import lk.ijse.library.entity.Member;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageMemberBOImpl implements ManageMemberBO {
    MemberDAO memberDAO= (MemberDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.MEMBER);
    @Override
    public boolean saveMember(MemberDTO dto) throws SQLException, ClassNotFoundException {
        return memberDAO.save(new Member(dto.getMemberId(), dto.getName(), dto.getEmail(), dto.getAddress(),dto.getTelephoneNumber(),
               Date.valueOf(dto.getRegisterDate()) , dto.getRegisteredBy()));
    }

    @Override
    public MemberDTO searchMember(String id) throws SQLException, ClassNotFoundException {
        Member enty= memberDAO.search(id);
        return new  MemberDTO(enty.getMemberId(), enty.getName(), enty.getEmail(), enty.getAddress(), enty.getTelephoneNumber(),
              String.valueOf(enty.getRegisterDate()) , enty.getRegisteredBy() );
    }

    @Override
    public boolean updateMember(MemberDTO dto) throws SQLException, ClassNotFoundException {
        return memberDAO.update(new Member(dto.getMemberId(), dto.getName(), dto.getEmail(), dto.getAddress(),dto.getTelephoneNumber(),
                Date.valueOf(dto.getRegisterDate()) , dto.getRegisteredBy()));
    }

    @Override
    public boolean DeleteMember(String id) throws SQLException, ClassNotFoundException {
        return memberDAO.Delete(id);
    }

    @Override
    public ObservableList<MemberDTO> loadMemberDetailToTable() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = memberDAO.loadTable();
        ObservableList<MemberDTO> observableList = FXCollections.observableArrayList();
        while (resultSet.next()) {
            MemberDTO member = new MemberDTO();
            member.setMemberId(resultSet.getString("memberId"));
            member.setName(resultSet.getString("name"));
            member.setEmail(resultSet.getString("email"));
            member.setAddress(resultSet.getString("address"));
            member.setTelephoneNumber(resultSet.getInt("telephoneNumber"));
            member.setRegisterDate(resultSet.getString("registerDate"));
            member.setRegisteredBy(resultSet.getString("registeredBy"));
            observableList.add(member);
    }
        return observableList;
}
    }