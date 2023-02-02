package lk.ijse.library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.library.dto.MemberFeesDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageMemberFeesBO extends SuperBO {

    public  boolean saveMemberFees(MemberFeesDTO memberFees) throws SQLException, ClassNotFoundException;
    public  boolean updateMemberFees(MemberFeesDTO memberFees) throws SQLException, ClassNotFoundException;
    public  boolean DeleteMemberFees(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadMemberIds() throws SQLException, ClassNotFoundException;
    ObservableList<MemberFeesDTO> LoadMemberFessToTable()throws SQLException, ClassNotFoundException;
}

