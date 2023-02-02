package lk.ijse.library.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.library.bo.custom.BookSearchBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.BookDAO;
import lk.ijse.library.dto.BookDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSearchBoOImpl  implements BookSearchBO {
    BookDAO bookDAO = (BookDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.BOOK);

    public ObservableList<BookDTO> loadTableBookName(String bookName) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = bookDAO.searchBookName(bookName);
        ObservableList<BookDTO> observableList = FXCollections.observableArrayList();
        while (resultSet.next()) {
            BookDTO book = new BookDTO();
            book.setBookId(resultSet.getString(1));
            book.setBookName(resultSet.getString(2));
            book.setAuthor(resultSet.getString(3));
            book.setIsbn(resultSet.getString(4));
            book.setPublisher(resultSet.getString(5));
            book.setQtyOnHand(resultSet.getInt(6));
            book.setShelfNo(resultSet.getInt(7));
            book.setNumOfPage(resultSet.getInt(8));
            book.setAddBy(resultSet.getString(9));
            book.setCategoryId(resultSet.getString(10));
            observableList.add(book);
        }
        return observableList;
    }

    public ObservableList<BookDTO> loadTableAuthorName(String authorName) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = bookDAO.searchAuthorName(authorName);
        ObservableList<BookDTO> observableList = FXCollections.observableArrayList();
        while (resultSet.next()) {
            BookDTO book = new BookDTO();
            book.setBookId(resultSet.getString(1));
            book.setBookName(resultSet.getString(2));
            book.setAuthor(resultSet.getString(3));
            book.setIsbn(resultSet.getString(4));
            book.setPublisher(resultSet.getString(5));
            book.setQtyOnHand(resultSet.getInt(6));
            book.setShelfNo(resultSet.getInt(7));
            book.setNumOfPage(resultSet.getInt(8));
            book.setAddBy(resultSet.getString(9));
            book.setCategoryId(resultSet.getString(10));
            observableList.add(book);
        }
        return observableList;
    }
}