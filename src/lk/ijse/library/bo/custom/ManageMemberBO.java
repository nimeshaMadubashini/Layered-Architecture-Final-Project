package lk.ijse.library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.library.dto.MemberDTO;

import java.sql.SQLException;

public interface ManageMemberBO extends SuperBO {
    public  boolean saveMember(MemberDTO member) throws SQLException, ClassNotFoundException;

    public MemberDTO searchMember(String id) throws SQLException, ClassNotFoundException;


    public  boolean updateMember(MemberDTO member) throws SQLException, ClassNotFoundException;

    public  boolean DeleteMember(String id) throws SQLException, ClassNotFoundException;
    ObservableList<MemberDTO> loadMemberDetailToTable() throws SQLException, ClassNotFoundException;
}
