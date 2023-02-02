package lk.ijse.library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.library.dto.BookDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageBookBO extends SuperBO {
    public  boolean saveBook(BookDTO book) throws SQLException, ClassNotFoundException ;


    public  boolean deleteBook(String id) throws SQLException, ClassNotFoundException;

    public  boolean updateBook(BookDTO book) throws SQLException, ClassNotFoundException;

    public  String generateNextBookId() throws SQLException, ClassNotFoundException;

    public ArrayList<String> loadBookIds() throws SQLException, ClassNotFoundException;

    ObservableList<BookDTO> loadToTable() throws SQLException, ClassNotFoundException;
}
