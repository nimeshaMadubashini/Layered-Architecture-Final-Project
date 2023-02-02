package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.dao.custom.IssueBookDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.IssueBookDTO;
import lk.ijse.library.entity.Issuebookdetail;
import lk.ijse.library.utill.CrudUtill;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IssueBookDAOImpl implements IssueBookDAO {
    public Issuebookdetail searchIssueBook(String bkId, String memId, String status) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM IssueBookDetail where BookId=? and memberId =? and status=?";
        ResultSet resultSet = CrudUtill.execute(sql, bkId, memId, status);
        if (resultSet.next()) {
            return new Issuebookdetail(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4),
                    resultSet.getDate(5),
                    resultSet.getString(6)
            );
        }
        return null;
    }

    @Override
    public ResultSet loadTablefindDate(String localDate1, String LocalDate2) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM IssueBookDetail where issueDate BETWEEN ? and ?";
        ResultSet resultSet = CrudUtill.execute(sql, localDate1, LocalDate2);
        return resultSet;
    }

    @Override
    public ResultSet loadAllIssueBook() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM IssueBookDetail";
        ResultSet resultSet = CrudUtill.execute(sql);
        return resultSet;
    }

    @Override
    public ResultSet loadAllDefaultList(String todayDate) throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM IssueBookDetail where dueDate<? and  status='" + "pending" + "'";
        ResultSet resultSet = CrudUtill.execute(sql, todayDate);
        return  resultSet;
    }

    @Override
    public ResultSet loadAllPendingList() throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM IssueBookDetail where status='"+"pending"+"'";
        ResultSet resultSet = CrudUtill.execute(sql);
        return resultSet;
    }


    /* public boolean updateIssueBookDetait(IssueBookDTO issueBook) throws SQLException, ClassNotFoundException {
         String sql = "INSERT INTO IssueBookDetail VALUES(?,?,?,?,?,?)";
         PreparedStatement pstm = DBConnection.getDbConnection().getConnection().prepareStatement(sql);
         pstm.setString(1, issueBook.getIssueId());
         pstm.setString(2, issueBook.getBookId());
         pstm.setString(3, issueBook.getMemberId());
         pstm.setString(4, issueBook.getIssueDate());
         pstm.setString(5, issueBook.getDueDate());
         pstm.setString(6, "pending");
         return pstm.executeUpdate() > 0;
     }*/
    public boolean updateReturnBookDetails(String status2, String status1, String memId, String bookId) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE IssueBookDetail SET status=? WHERE BookId=? and memberId=? and status=? ";
        PreparedStatement pstm = DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        pstm.setString(1, status2);
        pstm.setString(2, bookId);
        pstm.setString(3, memId);
        pstm.setString(4, status1);
        return pstm.executeUpdate() > 0;
    }
    public  String generateNextId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT issueId  FROM IssueBookDetail ORDER BY issueId DESC LIMIT 1";
        ResultSet result = CrudUtill.execute(sql);

        if (result.next()) {
            return generateID(result.getString(1));
        }
        return generateID(result.getString(null));
    }

    @Override
    public boolean save(Issuebookdetail obj) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Issuebookdetail search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }


    @Override
    public boolean update(Issuebookdetail obj) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean Delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> loadIds() throws SQLException, ClassNotFoundException {
        return null;
    }




    public   String generateID(String currentIssue) {
        if (currentIssue != null) {
            String[] split = currentIssue.split("SI");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "SI" + id;
        }
        return "001";

    }


    public int setData() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM IssueBookDetail where status='"+"pending"+"'";
        ResultSet resultSet=CrudUtill.execute(sql);
        resultSet.last();
        return resultSet.getRow();
    }

    public  int setDataDefault() throws SQLException, ClassNotFoundException {
        long dt=System.currentTimeMillis();
        Date todayDate=new Date(dt);
        String sql = "SELECT * FROM IssueBookDetail where dueDate<? and  status='"+"pending"+"'";
        ResultSet resultSet = CrudUtill.execute(sql,todayDate);
        resultSet.last();
        return resultSet.getRow();
    }


    public boolean updateIssueBookDetait(String issueId, String bookId, String memberId, String issueDate, String dueDate, String pending) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO IssueBookDetail VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm = DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        pstm.setString(1, issueId);
        pstm.setString(2, bookId);
        pstm.setString(3,memberId);
        pstm.setString(4, issueDate);
        pstm.setString(5, dueDate);
        pstm.setString(6, pending);
        return pstm.executeUpdate() > 0;

    }
}
