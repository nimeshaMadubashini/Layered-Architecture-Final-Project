package lk.ijse.library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.library.dto.IssueBookDTO;

import java.sql.Date;
import java.sql.SQLException;

public interface ViewDefaulterListBO extends SuperBO {
    ObservableList<IssueBookDTO> loadDefaultListToTable(String todayDate) throws SQLException,ClassNotFoundException;
}
