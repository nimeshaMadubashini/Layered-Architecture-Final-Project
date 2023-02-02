package lk.ijse.library.dao.custom;

import lk.ijse.library.dao.CrudDAO;
import lk.ijse.library.dto.MemberDTO;
import lk.ijse.library.entity.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MemberDAO extends CrudDAO<Member> {

    public ArrayList<String> loadEmail() throws SQLException, ClassNotFoundException;
    public  int setData() throws SQLException, ClassNotFoundException;

    ResultSet loadTable() throws SQLException, ClassNotFoundException;
}
