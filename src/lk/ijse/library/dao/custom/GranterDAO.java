package lk.ijse.library.dao.custom;

import lk.ijse.library.dao.CrudDAO;
import lk.ijse.library.dto.GranterDTO;
import lk.ijse.library.entity.Granter;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface GranterDAO extends CrudDAO<Granter> {
    ResultSet loadAllToTable () throws SQLException,ClassNotFoundException;
}
