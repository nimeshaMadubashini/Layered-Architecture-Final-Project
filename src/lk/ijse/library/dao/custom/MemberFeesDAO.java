package lk.ijse.library.dao.custom;

import lk.ijse.library.dao.CrudDAO;
import lk.ijse.library.dto.MemberFeesDTO;
import lk.ijse.library.entity.Memberfees;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MemberFeesDAO extends CrudDAO<Memberfees> {
    public  boolean checkPayment( String memId) throws SQLException, ClassNotFoundException;

    ResultSet loadTable()throws SQLException, ClassNotFoundException;
}
