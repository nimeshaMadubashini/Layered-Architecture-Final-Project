package lk.ijse.library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.library.dto.IssueBookDTO;

import java.sql.SQLException;

public interface VeiwIssueBookBO extends SuperBO{
    ObservableList<IssueBookDTO> loadAllPendingListToTable()throws  SQLException,ClassNotFoundException;
}
