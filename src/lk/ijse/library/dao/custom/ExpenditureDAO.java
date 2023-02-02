package lk.ijse.library.dao.custom;

import lk.ijse.library.dao.CrudDAO;
import lk.ijse.library.dto.ExpenditureDTO;
import lk.ijse.library.entity.Expenditure;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ExpenditureDAO extends CrudDAO<Expenditure> {
    ResultSet loadData()throws SQLException,ClassNotFoundException;
}
