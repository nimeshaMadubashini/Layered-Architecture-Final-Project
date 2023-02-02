package lk.ijse.library.dao.custom;

import lk.ijse.library.dao.CrudDAO;
import lk.ijse.library.dto.NewsPaperDTO;
import lk.ijse.library.entity.Newspaper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface NewsPaperDAO extends CrudDAO<Newspaper> {
    ResultSet loadnewspaper()throws SQLException,ClassNotFoundException;
}
