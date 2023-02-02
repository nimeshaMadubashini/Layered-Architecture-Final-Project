package lk.ijse.library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.library.dto.IssueBookDTO;

import java.sql.SQLException;

public interface ViewAllRecordBO extends SuperBO{
    ObservableList<IssueBookDTO> loadDataSearchingDate(String localDate1, String localDate2)throws SQLException,ClassNotFoundException;
    ObservableList<IssueBookDTO> loadAllIssueBookDetailToTable()throws SQLException,ClassNotFoundException;

}
