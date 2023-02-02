package lk.ijse.library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.library.dto.BookDTO;

import java.sql.SQLException;

public interface BookSearchBO extends SuperBO{
    public ObservableList<BookDTO> loadTableBookName(String bookName)throws SQLException, ClassNotFoundException;

    public ObservableList<BookDTO> loadTableAuthorName(String authorName) throws SQLException, ClassNotFoundException;
}
