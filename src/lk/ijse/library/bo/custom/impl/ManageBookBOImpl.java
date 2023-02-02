package lk.ijse.library.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.library.bo.custom.ManageBookBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.CategoryDAO;
import lk.ijse.library.dao.custom.impl.BookDAOImpl;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.entity.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageBookBOImpl implements ManageBookBO {
    CategoryDAO categoryDAO = (CategoryDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.CATEGORY);

    BookDAOImpl bookDAO = (BookDAOImpl) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.BOOK);

    public boolean saveBook(BookDTO book) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getDbConnection().getConnection().setAutoCommit(false);

            boolean isAdded = bookDAO.save(book.getBookId(), book.getBookName(), book.getAuthor(), book.getIsbn(),
                    book.getPublisher(), book.getQtyOnHand(), book.getShelfNo(), book.getNumOfPage(), book.getCategoryId());
            if (isAdded) {
                boolean updated = categoryDAO.updateQty(book.getQtyOnHand(), book.getCategoryId());
                if (updated) {
                    DBConnection.getDbConnection().getConnection().commit();
                    return true;
                }
            }
            DBConnection.getDbConnection().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getDbConnection().getConnection().setAutoCommit(true);
        }

    }

    @Override
    public boolean deleteBook(String id) throws SQLException, ClassNotFoundException {
        return bookDAO.Delete(id);
    }

    @Override
    public boolean updateBook(BookDTO dto) throws SQLException, ClassNotFoundException {
        return bookDAO.update(new Book(dto.getBookId(),dto.getBookName(),dto.getAuthor(),dto.getIsbn(),dto.getPublisher(),dto.getQtyOnHand(),dto.getShelfNo(),
                dto.getNumOfPage(),dto.getCategoryId()));
    }

    @Override
    public String generateNextBookId() throws SQLException, ClassNotFoundException {
        return bookDAO.generateNextId();
    }

    @Override
    public ArrayList<String> loadBookIds() throws SQLException, ClassNotFoundException {
        return categoryDAO.loadIds();
    }

    @Override
    public ObservableList<BookDTO> loadToTable() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = bookDAO.loadDataTable();
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
