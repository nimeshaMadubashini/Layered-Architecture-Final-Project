package lk.ijse.library.dao.custom;

import lk.ijse.library.dao.CrudDAO;
import lk.ijse.library.dto.InsuranceDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface InsuranceDAO extends CrudDAO<InsuranceDTO> {

    ResultSet loadAllDataToTable() throws SQLException,ClassNotFoundException;
}
