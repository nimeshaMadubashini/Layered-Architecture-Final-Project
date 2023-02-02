package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.controller.LoginFormController;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.BookDAO;
import lk.ijse.library.dao.custom.StaffDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.StaffDTO;
import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Staff;
import lk.ijse.library.utill.CrudUtill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAOImpl implements BookDAO {
    StaffDAO staffDAO= (StaffDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.STAFF);
    LoginFormController login=new LoginFormController();


    public  boolean update(Book dto) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Book SET name=?,author=?,ISBN_Number=?,publisher=?,qtyOnHand=?,shelfNumber =?,numOfPage =?,bookCategory=? where BookId =? ";
        return CrudUtill.execute(sql, dto.getName(), dto.getAuthor(), dto.getISBN_Number(), dto.getPublisher(), dto.getQtyOnHand(), dto.getShelfNumber(), dto.getNumOfPage(), dto.getBookCategory(), dto.getBookId());
    }


    public  boolean Delete(String id) throws SQLException, ClassNotFoundException {
        String sql="delete from Book where BookId=?";
        return  CrudUtill.execute(sql,id);
    }

    public  ArrayList<String> loadIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT BookId   FROM Book";
        ResultSet result = CrudUtill.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }

    @Override
    public boolean save(Book obj) throws SQLException, ClassNotFoundException {
        return false;
    }

    public Book search(String id) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM Book where BookId=?";
        ResultSet resultSet= CrudUtill.execute(sql,id);
        if(resultSet.next()){
            return new Book(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getInt(6),
                    resultSet.getInt(7),
                    resultSet.getInt(8),
                    resultSet.getString(9),
                    resultSet.getString(10)
            );
        }
        return null;
    }


    public boolean updateQty(String bookId) throws SQLException, ClassNotFoundException {
        String sql="UPDATE Book Set qtyOnHand=qtyOnHand-1  where BookId =? ";
        return CrudUtill.execute(sql,bookId);
    }

    public  boolean updateAfterReturn(String bookId) throws SQLException, ClassNotFoundException {
        String sql="UPDATE Book Set qtyOnHand=qtyOnHand+1  where BookId =? ";
        return CrudUtill.execute(sql,bookId);
    }
    public  String generateNextId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT BookId  FROM Book ORDER BY BookId DESC LIMIT 1";
        ResultSet result = CrudUtill.execute(sql);

        if (result.next()) {
            return generateID(result.getString(1));
        }
        return generateID(result.getString(null));
    }

     public String generateID(String currentIssue) {
        if (currentIssue != null) {
            String[] split = currentIssue.split("B0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "B0" + id;
        }
        return "001";

    }


    public boolean save(String bookId, String bookName, String author, String isbn, String publisher, int qtyOnHand, int shelfNo, int numOfPage, String categoryId) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Book VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        pstm.setString(1, bookId);
        pstm.setString(2, bookName);
        pstm.setString(3, author);
        pstm.setString(4, isbn);
        pstm.setString(5, publisher);
        pstm.setInt(6, qtyOnHand);
        pstm.setInt(7, shelfNo);
        pstm.setInt(8, numOfPage);
        Staff staff = staffDAO.searchName(login.userName, login.passWord);
        if (staff != null) {
            pstm.setString(9, staff.getStaffId());
        }
        pstm.setString(10, categoryId);

        return pstm.executeUpdate() > 0;
    }
    public ResultSet searchBookName(String bookName) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Book where name =? ";
        ResultSet resultSet = CrudUtill.execute(sql,bookName);
        return resultSet;
    }
    public ResultSet searchAuthorName(String authorName) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Book where author=? ";
        ResultSet resultSet = CrudUtill.execute(sql,authorName);
        return resultSet;
    }

    @Override
    public ResultSet loadDataTable() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Book ";
        ResultSet resultSet = CrudUtill.execute(sql);
        return resultSet;
    }

    @Override
    public Book searchid(String id) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM book where BookId=?";
        ResultSet resultSet= CrudUtill.execute(sql,id);
      resultSet.next();
            return new Book(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(6)
            );

    }
}

