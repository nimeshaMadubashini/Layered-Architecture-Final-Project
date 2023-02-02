package lk.ijse.library.dao.custom;

import lk.ijse.library.dao.CrudDAO;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.entity.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BookDAO  extends CrudDAO<Book> {
    public boolean updateQty(String bookId) throws SQLException, ClassNotFoundException ;

    public  boolean updateAfterReturn(String bookId) throws SQLException, ClassNotFoundException ;
    public boolean save(String bookId, String bookName, String author, String isbn, String publisher, int qtyOnHand, int shelfNo, int numOfPage, String categoryId) throws SQLException, ClassNotFoundException;
    public ResultSet searchBookName(String bookName) throws SQLException, ClassNotFoundException;
    public ResultSet searchAuthorName(String authorName) throws SQLException, ClassNotFoundException ;

    ResultSet loadDataTable() throws SQLException, ClassNotFoundException;
    public Book searchid(String id) throws SQLException, ClassNotFoundException;

    }
